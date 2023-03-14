package com.example.assignment6;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@org.springframework.stereotype.Controller
public class Controller {


    @Autowired
    UserManager userManager;

    @RequestMapping("/login")
    String toLogin() {
        return "login";
    }

    @RequestMapping("/renew")
    String toRenew() {
        return "renew";
    }


    /**
     * Hàm này chir nhận param "Action"
     * Nếu "acction == ..." thì gọi các hàm khác thực thi
     * @param req
     * @param resp
     * @throws IOException
     * @throws ServletException
     */
    @PostMapping("/controller")
    public void toController(@RequestParam("action") String action, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        switch (action) {
            case "login" -> loginCheck(req, resp);
            case "firstTime" -> updateProtection(req, resp);
        }
    }

    public void loginCheck(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String result = userManager.check(req.getParameter("userid"), req.getParameter("password"));
        req.setAttribute("result", result);
        req.getRequestDispatcher("/login").forward(req, resp);
    }

    /**
     * Get 3 question và 3 answer. Nếu không chọn question thì bỏ qua. Tối thiểu phải chọn 1, không thì báo lỗi.
     * Get & check password cũ, nếu sai thì báo lỗi.
     * Đúng thì cập nhật câu question, answer, password.
     * Thông báo thành công hoặc lỗi.
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void updateProtection(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String result = userManager.check(req.getParameter("userid"), req.getParameter("password"));
        req.setAttribute("result", result);
        req.getRequestDispatcher("/login").forward(req, resp);
    }
}
