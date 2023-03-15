package com.example.assignment6;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@org.springframework.stereotype.Controller
public class Controller {


    @Autowired
    UserManager userManager;

    @RequestMapping("/login")
    String toLogin() {
        return "login";
    }

    @RequestMapping("/first-time")
    String toRenew() {
        return "first-time";
    }


    @PostMapping("/loginCheck")
    public void loginCheck(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String result = userManager.check(req.getParameter("userid"), req.getParameter("password"));

        if (result.equals("Đăng nhập thành công")) {
            req.getRequestDispatcher("/first-time").forward(req, resp);
        } else {
            req.setAttribute("result", result);
            req.getRequestDispatcher("/login").forward(req, resp);
        }
    }


    /**
     * Check ít nhất 1 câu hỏi không null, câu trả lời của câu hỏi đó phải không null.
     * Mật khẩu cũ phải đúng.
     * Mật khẩu mới phải trùng nhau.
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @PostMapping("/updateProtection")
    public void updateProtection(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/login");
    }
}
