package com.example.assignment6;

import org.junit.After;
import org.junit.Before;
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

    @Autowired
    UserManager userManager;

    @Autowired
    UserDAO userDAO;

    private final User user = new User("1234567890123456", "Abcd1234", "What is your favorite color?", "Blue", "What is your pet's name?", "Max");

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
    void checkOverWrongTime() {

        String actual = userManager.check("1234567890123456", "Abcd1233");
        String expected = "Password chưa đúng.\n" +
                "Số lần thử còn: 2";
        Assertions.assertEquals(expected, actual);

        actual = userManager.check("1234567890123456", "Abcd1233");
        expected = "Password chưa đúng.\n" +
                "Số lần thử còn: 1";
        Assertions.assertEquals(expected, actual);

        actual = userManager.check("1234567890123456", "Abcd1233");
        expected = "Password chưa đúng.\n" +
                "Số lần thử còn: 0";
        Assertions.assertEquals(expected, actual);

        actual = userManager.check("1234567890123456", "Abcd1233");
        expected = "Tài khoản của bạn đã bị khóa.\n" +
                "Vui lòng liên lạc Call Center.";;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @Rollback(value = true)
    void checkWrongSyntax() {

        String actual = userManager.check("123", "123");
        String expected = "Vui lòng kiểm tra lại cú pháp.\n" +
                "+ User ID bao gồm 16 kí tự số.\n" +
                "+ Password bao gồm 8 kí tự chữ và số.\n";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @Rollback
    void checkNull() {
        String actual = userManager.check("1234567890123453", "Abcd1224");
        String expected = "User ID không tồn tại.\n" +
                "Vui lòng thử lại sau.";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @Rollback(value = true)
    void checkWrongDatabase() {

        String actual = userManager.check(user.getUserId(), "Abcd1224");
        String expected = "Password chưa đúng.\n" +
                "Số lần thử còn: 2";
        Assertions.assertEquals(expected, actual);

    }

    @Test
    @Rollback(value = true)
    void checkLogged() {

        String actual = userManager.check(user.getUserId(), user.getPassword());
        String expected = "Đăng nhập thành công";
        Assertions.assertEquals(expected, actual);
    }
}