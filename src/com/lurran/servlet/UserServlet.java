package com.lurran.servlet;

import com.google.gson.Gson;
import com.lurran.pojos.Apply;
import com.lurran.pojos.User;
import com.lurran.service.ApplyService;
import com.lurran.service.UserService;
import com.lurran.service.serviceImpl.ApplyServiceImpl;
import com.lurran.service.serviceImpl.UserServiceImpl;
import com.lurran.util.WebUtils;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2021/6/18 6:52 下午
 */
public class UserServlet extends BaseServlet{
    ApplyService applyService=new ApplyServiceImpl();
    UserService userService=new UserServiceImpl();
    /**
     * 用户注册
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("注册");
        User user = WebUtils.copyParamToBean(request.getParameterMap(), new User());
        if (userService.existsUsername(user.getUsername())){
            System.out.println("用户名不可用");
            Map<String,String> map=new HashMap<>();
            map.put("msg","用户名不可用");
            map.put("username",user.getUsername());
            Gson gson=new Gson();
            String s = gson.toJson(map);
            response.getWriter().write(s);
            request.getRequestDispatcher("/register.html").forward(request,response);
        }else {
            userService.registUser(user);
            System.out.println("用户名可用");
            Gson gson = new Gson();
            String s = gson.toJson(user);
            response.getWriter().write(s);
            request.getRequestDispatcher("/login.html").forward(request,response);
        }
    }

    /**
     * 用户登陆
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = WebUtils.copyParamToBean(request.getParameterMap(), new User());
        User user1 = userService.login(user);
        if (user1!=null & user1.getUsername()!=null){
            System.out.println("登陆成功");
            request.getSession().setAttribute("user",user);
            request.getRequestDispatcher("/apply.html").forward(request,response);
        }else {
            Map<String,String> map=new HashMap<>();
            map.put("msg","用户名或密码错误！");
            map.put("username",user.getUsername());
            Gson gson=new Gson();
            String s = gson.toJson(map);
            response.getWriter().write(s);
            System.out.println("用户名或密码错误，登陆失败");
            request.getRequestDispatcher("/login.html").forward(request,response);
        }
    }

    /**
     * 用户报名
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void apply(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Apply apply = WebUtils.copyParamToBean(request.getParameterMap(), new Apply());
        applyService.saveApply(apply);
        Gson gson = new Gson();
        String json = gson.toJson(apply);
        response.getWriter().write(json);
        request.getRequestDispatcher("/index.html").forward(request,response);
    }
    /**
     * 用户注册
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void uploadPhoto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、先判断是否为多段数据
        if(ServletFileUpload.isMultipartContent(request)){
            //创建FileItemFactory实现类，
            FileItemFactory fileItemFactory=new DiskFileItemFactory();
            //创建用于解析上传数据的工具类servletFileUpload
            ServletFileUpload servletFileUpload=new ServletFileUpload(fileItemFactory);
            List<FileItem> list = null;
            try {
                list = servletFileUpload.parseRequest(request);
                for (FileItem fileItem : list) {
                    if(fileItem.isFormField()){
                        //普通表单项
                        System.out.println("表单项的name值"+fileItem.getFieldName());
                        //UTF-8解决乱码问题
                        System.out.println("表单项的vlaue值"+fileItem.getString("UTF-8"));
                    }else {
                        //上传文件
                        System.out.println("表单项的name值"+fileItem.getFieldName());
                        System.out.println("上传的文件名"+fileItem.getName());
                        fileItem.write(new File("/Users/lurran/IdeaProjects/volunteer/web/open-resource"+fileItem.getName()));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 退出登陆
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
        response.sendRedirect(request.getContextPath());
    }

    /**
     * 修改用户信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
