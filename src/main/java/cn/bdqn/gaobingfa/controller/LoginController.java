package cn.bdqn.gaobingfa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@RequestMapping("/login")
@Controller
public class LoginController {

    private class use{
        private String name;
        private  String pwd;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPwd() {
            return pwd;
        }

        public void setPwd(String pwd) {
            this.pwd = pwd;
        }
    }

    // 登录操作
    @RequestMapping("")
    public Object login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 1.得到用户名与密码
        String username = request.getParameter("name");
        String password = request.getParameter("pwd");
        String name="syj";
        String pwd="123";
        // 2.调用service中登录方法
       // UserServiceImpl service = new UserServiceImpl();
        use user=new use();
        user.name=name;
        user.setPwd(pwd);
        try {
           // User user = service.login(username, password);

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
              //  response.sendRedirect(request.getContextPath() + "/index.jsp");
                return request.getParameterMap();
            } else {
                request.setAttribute("login.message", "用户名或密码错误");
               // request.getRequestDispatcher("/page.jsp").forward(request,response);
                return request.getParameter("login.message");
            }

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("login.message", e.getMessage());
           // request.getRequestDispatcher("/page.jsp").forward(request, response);
            return request.getParameter("login.message");
        }

       // return user;
    }
}
