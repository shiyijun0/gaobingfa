package cn.bdqn.gaobingfa.config;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;

public class MyFilter implements Filter { //
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println(servletRequest.getParameter("name")+"***dfg的方法*********");
        HttpServletRequest hrequest = (HttpServletRequest)servletRequest;
        HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper((HttpServletResponse) servletResponse);
        if(hrequest.getRequestURI().indexOf("/b") != -1 ||
                hrequest.getRequestURI().indexOf("/c") != -1 ||
                hrequest.getRequestURI().indexOf("/d") != -1 ||
                hrequest.getRequestURI().indexOf("/login") != -1
                ) {
            filterChain.doFilter(servletRequest, servletResponse);
        }else {
           // wrapper.sendRedirect("/login");
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

}
