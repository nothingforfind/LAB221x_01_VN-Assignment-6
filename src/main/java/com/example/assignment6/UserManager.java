package com.example.assignment6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserManager {

    @Autowired
    private UserDAO userDAO;
    private User user;

    public String check(String userid, String password) {

        if (checkWrongSyntax(userid, password)) {
            return "Vui lòng kiểm tra lại cú pháp.\n" +
                    "+ User ID bao gồm 16 kí tự số.\n" +
                    "+ Password bao gồm 8 kí tự chữ và số.\n";
        }

        user = userDAO.getUser(userid);

        if (checkNull()) {
            return "User ID không tồn tại.\n" +
                    "Vui lòng thử lại sau.";
        }

        if (checkLock()) {
            return "Tài khoản của bạn đã bị khóa.\n" +
                    "Vui lòng liên lạc Call Center.";
        }

        if (checkWrongPassword(password)) {
            user.setTime(user.getTime() + 1);
            userDAO.updateUser(user);
            return "Password chưa đúng.\n" +
                    "Số lần thử còn: " + (3 - user.getTime());
        }

        return "Đăng nhập thành công";
    }

    private boolean checkWrongSyntax(String userid, String password) {

        String regex_userid = "^\\d{16}$";
        String regex_password = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8}$";

        return !userid.matches(regex_userid) && !password.matches(regex_password);
    }

    private boolean checkNull() {
        return user == null;
    }

    private boolean checkLock() {
        return user.getTime() >= 3;
    }

    private boolean checkWrongPassword(String password) {
        return !user.getPassword().equals(password);
    }
}