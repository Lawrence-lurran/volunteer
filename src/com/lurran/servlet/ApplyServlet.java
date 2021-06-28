package com.lurran.servlet;

import com.google.gson.Gson;
import com.lurran.pojos.Apply;
import com.lurran.service.ApplyService;
import com.lurran.service.serviceImpl.ApplyServiceImpl;
import com.lurran.util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2021/6/18 6:53 下午
 */
public class ApplyServlet extends BaseServlet{
    ApplyService applyService=new ApplyServiceImpl();
    protected void submit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("提交表单");
        System.out.println(request.getParameter("name"));
        Apply apply = WebUtils.copyParamToBean(request.getParameterMap(), new Apply());
        applyService.saveApply(apply);
        Gson gson = new Gson();
        String json = gson.toJson(apply);
        response.getWriter().write(json);
        request.getRequestDispatcher("index.html").forward(request,response);

    }
}
