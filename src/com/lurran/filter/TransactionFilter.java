package com.lurran.filter;

import com.lurran.util.JDBCUtils;
import javax.servlet.*;
import java.io.IOException;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2021/6/14 4:58 下午
 */
public class TransactionFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            chain.doFilter(request,response);
            JDBCUtils.commitAndClose();
        } catch (Exception e) {
            JDBCUtils.rollbackAndClose();
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
