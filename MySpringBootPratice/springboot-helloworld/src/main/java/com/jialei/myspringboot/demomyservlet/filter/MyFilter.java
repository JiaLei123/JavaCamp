package com.jialei.myspringboot.demomyservlet.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 *
 * @author jialei
 * @version : MyFilter.java, v 0.1 2019年10月27日 16:07 jialei Exp $
 */
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("MyFilter process");
    }

    @Override
    public void destroy() {

    }
}