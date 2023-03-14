package com.example.assignment6;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@org.springframework.stereotype.Controller
public class Controller {


    @Autowired
    UserManager userManager;

    @RequestMapping("/login")
    String toLogin() {
        return "login";
    }

    @PostMapping("/controller")
    public void toController(@RequestParam("userid") String userid, @RequestParam("password") String password,
                                     HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String result = userManager.check(userid, password);
        req.setAttribute("result", result);
        req.getRequestDispatcher("/login").forward(req, resp);
    }
}
