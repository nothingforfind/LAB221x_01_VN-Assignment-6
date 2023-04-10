package com.example.assignment6;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Transactional
class UserManagerTest {

	/**
	 * Khởi tạo đối tượng userManager 1 lần duy nhất bằng @Autowired.
	 */
    @Autowired
    UserManager userManager;

    /**
	 * Khởi tạo đối tượng userDAO 1 lần duy nhất bằng @Autowired.
	 */
    @Autowired
    UserDAO userDAO;

    /**
     * Khởi tạo đối tượng cố định cho các hàm test bên dưới.
     */
    private final User user = new User("1234567890123456", "Abcd1234", 
    		"What is your favorite color?", "Blue", 
    		"What is your pet's name?", "Max", 
    		"How are you today?", "Better than!");

    @BeforeEach
    public void setUp() {
        userDAO.insertUser(user);
    }

    @AfterEach
    public void tearDown(){
        userDAO.deleteAll();
    }

    @Test
    @Rollback(value = true)
    void checkEmtyInput() {

        String actual = userManager.checkAccount("", "");
        String expected = "User ID và password không được để trống.";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @Rollback(value = true)
    void checkOverWrongTime() {
    	
    	String userID = "1234567890123456";
    	String password = "Abcd1233";

        String actual = userManager.checkAccount(userID, password);
        String expected = "Password chưa đúng.\n" +
                "Số lần thử còn: 2";
        Assertions.assertEquals(expected, actual);

        actual = userManager.checkAccount(userID, password);
        expected = "Password chưa đúng.\n" +
                "Số lần thử còn: 1";
        Assertions.assertEquals(expected, actual);

        actual = userManager.checkAccount(userID, password);
        expected = "Password chưa đúng.\n" +
                "Tài khoản của bạn đã bị khóa.\n" +
                "Vui lòng liên lạc Call Center.";
        Assertions.assertEquals(expected, actual);

        actual = userManager.checkAccount(userID, password);
        expected = "Tài khoản của bạn đã bị khóa.\n" +
                "Vui lòng liên lạc Call Center.";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @Rollback(value = true)
    void checkWrongSyntax() {

        String actual = userManager.checkAccount("123", "123");
        String expected = "User ID là 16 kí tự số.\n" +
                "Password bao gồm 8 kí tự chữ và số.\n";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @Rollback
    void checkNull() {
    	String userID = "1234567890123453";
    	String password = "Abcd1224";
        String actual = userManager.checkAccount(userID, password);
        String expected = "User ID không tồn tại.\n" +
                "Vui lòng thử lại sau.";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @Rollback(value = true)
    void checkWrongDatabase() {

        String actual = userManager.checkAccount(user.getUserId(), "Abcd1224");
        String expected = "Password chưa đúng.\n" +
                "Số lần thử còn: 2";
        Assertions.assertEquals(expected, actual);

    }

    @Test
    @Rollback(value = true)
    void checkLogged() {

    	String userID = user.getUserId();
    	String password = user.getPassword();
        String actual = userManager.checkAccount(userID, password);
        String expected = "Đăng nhập thành công";
        Assertions.assertEquals(expected, actual);
    }
}
