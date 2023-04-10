package com.example.assignment6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDAO {

	/**
	 * Tạo đối tượng jdbcTemplate 1 lần duy nhất bằng @Autowired.
	 */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Hàm insert đối tượng user vào DB.
     * @param user
     */
    public void insertUser(User user) {
        String sql = "INSERT INTO user_manager.users (userid, "
        		+ "password, question1, answer1, question2, answer2, "
        		+ "question3, answer3, time) "
        		+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, user.getUserId(), 
        		user.getPassword(), user.getQuestion1(), 
        		user.getAnswer1(),user.getQuestion2(), 
        		user.getAnswer2(), user.getQuestion3(), 
        		user.getAnswer3(), user.getTime());
    }

    /**
     * Hàm update đối tượng user vào DB.
     * @param user
     */
    public void updateUser(User user) {
        String sql = "UPDATE user_manager.users SET password = ?, "
        		+ "question1 = ?, answer1 = ?, question2 = ?,"
        		+ " answer2 = ?, question3 = ?, answer3 = ?,"
        		+ "time = ? WHERE userid = ?";
        jdbcTemplate.update(sql, user.getPassword(), 
        		user.getQuestion1(), user.getAnswer1(),
                user.getQuestion2(), user.getAnswer2(), 
                user.getQuestion3(), user.getAnswer3(),
                user.getTime(), user.getUserId());
    }

    /**
     * Hàm check user đã tồn tại hay chưa.
     * @param userid
     * @param password
     * @return count
     */
    public boolean checkUser(String userid, String password) {
        String sql = "SELECT COUNT(*) "
        		+ "FROM user_manager.users "
        		+ "WHERE userid = ? AND password = ?";
        int count = jdbcTemplate.queryForObject(sql, 
        		new Object[]{userid, password}, Integer.class);
        return count > 0;
    }

    /**
     * Hàm delete đối tượng khỏi DB.
     * @param id
     */
    public void deleteUser(int id) {
        String sql = "DELETE FROM users WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    /**
     * Hàm delete tất cả đối tượng khỏi DB.
     */
    public void deleteAll() {
        String sql = "DELETE FROM users WHERE id > 0";
        jdbcTemplate.update(sql);
    }

    /**
     * Hàm get tất cả đối tượng thành list.
     * @return userList
     */
    public List<User> getAll() {
        String sql = "SELECT * FROM users";
        List<User> userList = jdbcTemplate.query(sql, new UserMapper());
        return userList;
    }

    /**
     * Hàm get đối tượng từ DB.
     * @param userid
     * @return user
     */
    public User getUser(String userid) {
        String sql = "SELECT * FROM users WHERE userid = " + userid;
        List<User> userList = jdbcTemplate.query(sql, new UserMapper());
        if (userList.size() > 0) {
            return userList.get(0);
        }
        return null;
    }

    private static final class UserMapper implements RowMapper<User> {
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUserId(rs.getString("userid"));
            user.setPassword(rs.getString("password"));
            user.setQuestion1(rs.getString("question1"));
            user.setAnswer1(rs.getString("answer1"));
            user.setQuestion2(rs.getString("question2"));
            user.setAnswer2(rs.getString("answer2"));
            user.setQuestion3(rs.getString("question3"));
            user.setAnswer3(rs.getString("answer3"));
            user.setTime(rs.getInt("time"));
            return user;
        }
    }
}
