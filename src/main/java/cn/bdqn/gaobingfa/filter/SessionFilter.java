package cn.bdqn.gaobingfa.filter;


import cn.bdqn.gaobingfa.Util.CookieUtils;
import cn.bdqn.gaobingfa.entity.LockMapper;
import cn.bdqn.gaobingfa.service.LockMapperService;
import cn.bdqn.gaobingfa.service.LockMapperServiceImpl;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

//@WebFilter(filterName = "sessionFilter",urlPatterns = {"/*"})
public class SessionFilter implements javax.servlet.Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 1.强转
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        // 2.操作

        // 2.1判断当前用户是否登录
        Object user = req.getSession().getAttribute("user");
        if (user == null || user!=null) { // user为null说明用户没有登录，可以进行自动登录操作
            // 2.2 得到访问的资源路径
            String uri = req.getRequestURI();
            String contextPath = req.getContextPath();
            String path = uri.substring(contextPath.length());
            if ("/login".equalsIgnoreCase(path)) {
                // 符合条件的是可以进行自动登录操作的.

                // 2.3 得到cookie，从cookie中获取username,password
                Cookie cookie = CookieUtils.findCookieByName(req.getCookies(),
                        "autologin");

              /*  Map<String, List<String>> map = connection.getHeaderFields();
                for (String key : map.keySet()) {
                    System.out.println(key + "--->" + map.get(key));
                }
                HttpSession session = request.getSession();

                List<String> cookie=map.get("Set-Cookie");*/


               /* String regex=name+"=(.*?);";

                Pattern pattern = Pattern.compile(regex);
                Matcher matcher =pattern.matcher(set);
                if(matcher.find()){
                    return matcher.group();
                }*/

              /*  request.getSession().invalidate(); // 销毁session

                Cookie cookie = new Cookie("autologin", "");
                cookie.setMaxAge(0);
                cookie.setPath("/");

                response.addCookie(cookie);*/

                if (cookie != null) {
                    // 说明有用户名与密码，可以进行自动登录
                    String username = URLDecoder.decode(cookie.getValue()
                            .split("%itcast%")[0], "utf-8");
                    String password = cookie.getValue().split("%itcast%")[1];

                    // 2.4调用UserService方法进行登录操作.
                    LockMapperService service = new LockMapperServiceImpl();
                    try {
                        LockMapper existUser = service.find(1);

                        if (existUser != null) {
                            // 可以进行登录操作
                            req.getSession().setAttribute("user", existUser);
                            resp.sendRedirect(req.getContextPath() + "/login");
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }

        }
        // 3.放行
        filterChain.doFilter(req, resp);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }


   /* // 登录操作
    public void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 1.得到用户名与密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 2.调用service中登录方法
        UserServiceImpl service = new UserServiceImpl();
        try {
            User user = service.login(username, password);

            if (user != null) {

                // 用户如果登录成功，判断是否勾选了记住用户名.
                String saveUsername = request.getParameter("remember");

                if ("on".equals(saveUsername)) {
                    // 记住用户名
                    Cookie cookie = new Cookie("saveusername",
                            URLEncoder.encode(username, "utf-8")); // 存储utf-8码
                    cookie.setMaxAge(7 * 24 * 60 * 60); // 可以记住7天
                    cookie.setPath("/");
                    response.addCookie(cookie);
                } else {
                    Cookie cookie = new Cookie("saveusername",
                            URLEncoder.encode(username, "utf-8")); // 存储utf-8码
                    cookie.setMaxAge(0);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                }

                // 自动登录
                String autologin = request.getParameter("autologin");

                if ("on".equals(autologin)) {
                    // 勾选了自动登录，就将用户名与密码存储到cookie中.
                    Cookie cookie = new Cookie("autologin", URLEncoder.encode(
                            username, "utf-8") + "%itcast%" + password);
                    cookie.setMaxAge(7 * 24 * 60 * 60);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                } else {
                    Cookie cookie = new Cookie("autologin", URLEncoder.encode(
                            username, "utf-8") + "%itcast%" + password);
                    cookie.setMaxAge(0);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                }

                // 登录成功后，将用户存储到session中.
                request.getSession().invalidate();
                request.getSession().setAttribute("user", user);
                response.sendRedirect(request.getContextPath() + "/index.jsp");
                return;
            } else {
                request.setAttribute("login.message", "用户名或密码错误");
                request.getRequestDispatcher("/page.jsp").forward(request,
                        response);
                return;
            }

        } catch (LoginException e) {
            e.printStackTrace();
            request.setAttribute("login.message", e.getMessage());
            request.getRequestDispatcher("/page.jsp")
                    .forward(request, response);
            return;
        }
    }*/

}
