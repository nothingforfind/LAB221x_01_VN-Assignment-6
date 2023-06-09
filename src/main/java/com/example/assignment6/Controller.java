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

	/**
	 * Sử dụng @Autowired để khởi tạo userManager.
	 */
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
     * Hàm check thông tin đăng nhập và điều hướng cho phù hợp.
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @PostMapping("/loginCheck")
    public void loginCheck(HttpServletRequest req, HttpServletResponse resp) 
    		throws ServletException, IOException {

    	String result;
    	String userid = req.getParameter("userid");
    	String password = req.getParameter("password");
        result = userManager.checkAccount(userid, password);
        String login = req.getParameter("login");

        System.out.println(login);

        if (login == null) {
            resp.sendRedirect("/login");
        } else {
            if (result.equals("Đăng nhập thành công") 
            		&& userManager.checkFirstTime(userid)) {
                req.getSession().setAttribute("loggedAccount", userid);
                req.getRequestDispatcher("/first-time").forward(req, resp);
            } else if (result.equals("Đăng nhập thành công") 
            		&& !userManager.checkFirstTime(userid)) {
                req.getSession().setAttribute("loggedAccount", userid);
                req.getRequestDispatcher("/home").forward(req, resp);
            } else {
                req.setAttribute("result", result);
                req.getRequestDispatcher("/login").forward(req, resp);
            }
        }
    }

    /**
     * Hàm cập nhật thông tin cá nhân user và chuyển tiếp đến trang kế.
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @PostMapping("/updateProtection")
    public void updateInfo(HttpServletRequest req, HttpServletResponse resp) 
    		throws ServletException, IOException {
    	
        String result = userManager.checkForm(
        		(String) req.getSession().getAttribute("loggedAccount"),
                req.getParameter("question1"), req.getParameter("question2"), 
                req.getParameter("question3"), req.getParameter("answer1"), 
                req.getParameter("answer2"), req.getParameter("answer3"),
                req.getParameter("oldPassword"), 
                req.getParameter("newPassword1"),
                req.getParameter("newPassword2"));

        String submit = req.getParameter("submit");
        String cancel = req.getParameter("cancel");

        if (submit != null) {
            if (result.equals("Cập nhật thông tin thành công.")) {
                req.getRequestDispatcher("/home").forward(req, resp);
            } else {
                req.setAttribute("result", result);
                req.getRequestDispatcher("/first-time").forward(req, resp);
            }
        } else if (cancel != null) {
            resp.sendRedirect("/login");
        } else {
            resp.sendRedirect("/first-time");
        }
    }
}
