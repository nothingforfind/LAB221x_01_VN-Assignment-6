package com.example.assignment6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserManager {


	/**
	 * Khởi tạo userDAO 1 lần duy nhất với @Autowired.
	 */
    @Autowired
    private UserDAO userDAO;
    
    /**
     * Đối tượng user được sử dụng nhiều lần từ các hàm dưới đây.
     */
    private User user;

    /**
     * Số lần đăng nhập không hợp lệ tối đa.
     */
     final int maxLockTime = 3;
    
    /**
     * Check lỗi từ form đăng nhập và trả về theo các tình huống.
     * @param userid
     * @param password
     * @return string
     */
    public String checkAccount(String userid, String password) {

        if (userid.isEmpty() || password.isEmpty()) {
            return "User ID và password không được để trống.";
        }

        if (checkWrongSyntax(userid, password)) {
            return "User ID là 16 kí tự số.\n" +
                    "Password bao gồm 8 kí tự chữ và số.\n";
        }

        user = userDAO.getUser(userid);
        if (user == null){
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

            if (user.getTime() == maxLockTime) {
                return "Password chưa đúng.\n" +
                        "Tài khoản của bạn đã bị khóa.\n" +
                        "Vui lòng liên lạc Call Center.";
            }

            return "Password chưa đúng.\n" +
                    "Số lần thử còn: " + (maxLockTime - user.getTime());
        }

        user.setTime(0);
        userDAO.updateUser(user);
        return "Đăng nhập thành công";
    }

    /**
     * Check syntax trả về true/false.
     * @param userid
     * @param password
     * @return boolean
     */
    private boolean checkWrongSyntax(String userid, String password) {

        String regexUserid = "^\\d{16}$";
        String regexPassword = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8}$";

        return !userid.matches(regexUserid) && !password.matches(regexPassword);
    }

    /**
     * Trả về tình trạng đã lock hay chưa.
     * Hơn 2 lần thì đã lock.
     * @return boolean
     */
    private boolean checkLock() {
        return user.getTime() > 2;
    }

    /**
     * Check password với DB.
     * @param password
     * @return booelan
     */
    private boolean checkWrongPassword(String password) {
        return !user.getPassword().equals(password);
    }

    /**
     * Nếu các câu hỏi chưa cập nhật thì là lần đầu tiên đăng nhập.
     * @param userid
     * @return boolean
     */
    public boolean checkFirstTime(String userid) {
        user = userDAO.getUser(userid);
        return user.getQuestion1() == null || 
        		user.getQuestion2() == null || 
        		user.getQuestion3() == null;
    }

    /**
     * Check form đã được điền đầy đủ chưa.
     * Trả về lỗi.
     * @param userid
     * @param question1
     * @param question2
     * @param question3
     * @param answer1
     * @param answer2
     * @param answer3
     * @param oldPassword
     * @param newPassword1
     * @param newPassword2
     * @return String
     */
    public String checkForm(String userid, String question1, 
    		String question2, String question3, 
    		String answer1, String answer2, String answer3,
    		String oldPassword, String newPassword1, String newPassword2) {

        user = userDAO.getUser(userid);

        if (question1.equals("emty") && 
        		question2.equals("emty") && question3.equals("emty")) {
            return "Vui lòng chọn & trả lời ít nhất 1 câu hỏi";
        }

        if (oldPassword.isEmpty() || 
        		newPassword1.isEmpty() || newPassword2.isEmpty()) {
            return "Vui lòng điền đủ 3 trường password.";
        }

        if (!user.getPassword().equals(oldPassword)) {
            return "Password cũ không đúng";
        }

        if (oldPassword.equals(newPassword1)) {
            return "Password mới không được trùng với password cũ";
        }

        if (!newPassword1.equals(newPassword2)) {
            return "Password mới không trùng nhau.";
        }

        user.setPassword(newPassword1);
        user.setQuestion1(question1);
        user.setQuestion2(question2);
        user.setQuestion3(question3);
        user.setAnswer1(answer1);
        user.setAnswer2(answer2);
        user.setAnswer3(answer3);
        userDAO.updateUser(user);
        return "Cập nhật thông tin thành công.";
    }
}
