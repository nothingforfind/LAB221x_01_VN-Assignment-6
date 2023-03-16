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

    @RequestMapping("/home")
    String toHome() {
        return "home";
    }

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @PostMapping("/loginCheck")
    public void loginCheck(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String result = userManager.checkAccount(req.getParameter("userid"), req.getParameter("password"));

        if (result.equals("Đăng nhập thành công") && userManager.checkFirstTime(req.getParameter("userid"))) {
            req.getSession().setAttribute("loggedAccount", req.getParameter("userid"));
            req.getRequestDispatcher("/first-time").forward(req, resp);
        } else if (result.equals("Đăng nhập thành công") && !userManager.checkFirstTime(req.getParameter("userid"))) {
            req.getSession().setAttribute("loggedAccount", req.getParameter("userid"));
            req.getRequestDispatcher("/home").forward(req, resp);
        } else {
            req.setAttribute("result", result);
            req.getRequestDispatcher("/login").forward(req, resp);
        }
    }

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @PostMapping("/updateProtection")
    public void updateProtection(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String result = userManager.checkForm((String) req.getSession().getAttribute("loggedAccount"),
                req.getParameter("question1"), req.getParameter("question2"), req.getParameter("question3"),
                req.getParameter("answer1"), req.getParameter("answer2"), req.getParameter("answer3"),
                req.getParameter("oldPassword"), req.getParameter("newPassword1"), req.getParameter("newPassword2"));

        if (result.equals("Cập nhật thông tin thành công.")) {
            req.getRequestDispatcher("/home").forward(req, resp);
        } else {
            req.setAttribute("result", result);
            req.getRequestDispatcher("/first-time").forward(req, resp);
        }
    }
}