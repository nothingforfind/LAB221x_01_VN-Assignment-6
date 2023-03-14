package com.example.assignment6;

import org.junit.jupiter.api.Assertions;
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
class UserDAOTest {

    @Autowired
    UserDAO userDAO;

    @Test
    @Rollback(value = true)
    void insertUser() {

        int firstSize = userDAO.getAll().size();
        Assertions.assertEquals(firstSize, userDAO.getAll().size());

        User user4 = new User("2468101214161820", "Klmn3456", "What is your favorite sports team?", "Lakers", "What is your favorite hobby?", "Playing guitar");
        User user5 = new User("1357911131517191", "Tuvw7890", "What is your favorite place to visit?", "Paris", "What is your favorite music genre?", "Rock");
        User user6 = new User("1111111111111111", "Abcd1234", "What is your mother's maiden name?", "Johnson", "What is your favorite color?", "Green");
        userDAO.insertUser(user4);
        userDAO.insertUser(user5);
        userDAO.insertUser(user6);
        Assertions.assertEquals(firstSize+3, userDAO.getAll().size());
    }

    @Test
    @Rollback(value = true)
    void updateUser() {

        User user7 = new User("2222222222222222", "Pqrs5678", "What is your favorite book?", "1984", "What is your favorite food?", "Sushi");
        userDAO.insertUser(user7);

        user7.setPassword("Done123");
        userDAO.updateUser(user7);
        Assertions.assertEquals(user7.getPassword(), userDAO.getUser(user7.getUserId()).getPassword());
    }

    @Test
    @Rollback(value = true)
    void checkUser() {

        User user8 = new User("3333333333333333", "Ghij9012", "What is your favorite movie?", "The Shawshank Redemption", "What is your favorite sports team?", "Manchester United");
        userDAO.insertUser(user8);
        Assertions.assertTrue(userDAO.checkUser(user8.getUserId(), user8.getPassword()));
        Assertions.assertFalse(userDAO.checkUser(user8.getUserId(), user8.getPassword()+1));

        User user9 = new User("1234567890123456", "Abcd1234", "What is your favorite color?", "Blue", "What is your pet's name?", "Max", true, 2);
        userDAO.insertUser(user9);
        Assertions.assertTrue(userDAO.checkUser(user9.getUserId(), user9.getPassword()));
        Assertions.assertFalse(userDAO.checkUser(user9.getUserId(), user9.getPassword()+1));

        Assertions.assertEquals(2, userDAO.getUser(user9.getUserId()).getTime());
    }

    @Test
    @Rollback(value = true)
    void deleteUser() {

        User user9 = new User("4444444444444444", "Klmn3456", "What is your favorite hobby?", "Photography", "What is your favorite place to visit?", "New York City");
        userDAO.insertUser(user9);
        User user = userDAO.getUser(user9.getUserId());
        Assertions.assertNotNull(user);

        userDAO.deleteUser(user.getId());
        user = userDAO.getUser(user9.getUserId());
        Assertions.assertNull(user);
    }

    @Test
    @Rollback(value = true)
    void deleteAll() {

        User user3 = new User("4567890123456789", "Ghij9012", "What is your favorite food?", "Pizza", "What is your favorite book?", "To Kill a Mockingbird");
        userDAO.insertUser(user3);
        Assertions.assertNotEquals(0, userDAO.getAll().size());

        userDAO.deleteAll();
        Assertions.assertEquals(0, userDAO.getAll().size());
    }

    @Test
    @Rollback(value = true)
    void getAll() {

        int firstSize = userDAO.getAll().size();
        Assertions.assertEquals(firstSize, userDAO.getAll().size());

        User user1 = new User("1234567890123456", "Abcd1234", "What is your favorite color?", "Blue", "What is your pet's name?", "Max");
        User user2 = new User("9876543210123456", "Pqrs5678", "What is your mother's maiden name?", "Smith", "What is your favorite movie?", "The Godfather");
        userDAO.insertUser(user1);
        userDAO.insertUser(user2);
        Assertions.assertEquals(firstSize+2, userDAO.getAll().size());
    }
}