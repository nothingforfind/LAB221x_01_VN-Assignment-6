package com.example.assignment6;

public class User {

	/**
	 * Thuộc tính id.
	 */
    private int id;
    
    /**
     * Thuộc tính userId.
     */
    private String userId;
    
    /**
     * Thuộc tính password.
     */
    private String password;
    
    /**
     * Thuộc tính question1 tương ứng câu hỏi 1.
     */
    private String question1;
    
    /**
     * Thuộc tính answer1 tương ứng câu trả lời 1.
     */
    private String answer1;
    
    /**
     * Thuộc tính question2 tương ứng câu hỏi 2.
     */
    private String question2;
    
    /**
     * Thuộc tính answer2 tương ứng câu trả lời 2.
     */
    private String answer2;
    
    /**
     * Thuộc tính question3 tương ứng câu hỏi 3.
     */
    private String question3;
    
    /**
     * Thuộc tính answer3 tương ứng câu trả lời 3.
     */
    private String answer3;
    
    /**
     * Thuộc tính time tương ứng số lần đã đăng nhập không hợp lệ.
     */
    private int time;

    /**
     * Hàm khởi tạo đối tượng với 0 thuộc tính.
     */
    public User() {}


    /**
     * Hàm khởi tạo đối tượng với đầy đủ thuộc tính.
     * Dành cho truy vấn từ database và gán vào list.
     * @param idInDB
     * @param idOfUser
     * @param pw
     * @param q1
     * @param a1
     * @param q2
     * @param a2
     * @param q3
     * @param a3
     * @param wrongTime
     */
    public User(int idInDB, String idOfUser, String pw, 
    		String q1, String a1, 
    		String q2, String a2, 
    		String q3, String a3, int wrongTime) {
        this.id = idInDB;
        this.userId = idOfUser;
        this.password = pw;
        this.question1 = q1;
        this.answer1 = a1;
        this.question2 = a2;
        this.answer2 = a2;
        this.question3 = q3;
        this.answer3 = a3;
        this.time = wrongTime;
    }

    /**
     * Hàm khởi tạo đối tượng dành cho cập nhật lại đối tượng.
     * @param idOfUser
     * @param pw
     * @param q1
     * @param a1
     * @param q2
     * @param a2
     * @param q3
     * @param a3
     * @param wrongTime
     */
    public User(String idOfUser, String pw, 
    		String q1, String a1, 
    		String q2, String a2, 
    		String q3, String a3, int wrongTime) {
        this.userId = idOfUser;
        this.password = pw;
        this.question1 = q1;
        this.answer1 = a1;
        this.question2 = a2;
        this.answer2 = a2;
        this.question3 = q3;
        this.answer3 = a3;
        this.time = wrongTime;
    }

    /**
     * Hàm cập nhật lại câu hỏi.
     * @param idOfUser
     * @param pw
     * @param q1
     * @param a1
     * @param q2
     * @param a2
     * @param q3
     * @param a3
     */
    public User(String idOfUser, String pw, 
    		String q1, String a1, 
    		String q2, String a2, 
    		String q3, String a3) {
        this.userId = idOfUser;
        this.password = pw;
        this.question1 = q1;
        this.answer1 = a1;
        this.question2 = q2;
        this.answer2 = a2;
        this.question3 = q3;
        this.answer3 = a3;
    }

    /**
     * Get id từ đối tượng.
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Set id cho đối tượng.
     * @param idOfDB
     */
    public void setId(int idOfDB) {
        this.id = idOfDB;
    }

    /**
     * Get userId từ đối tượng.
     * @return userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Set userId cho đối tượng.
     * @param idOfUser
     */
    public void setUserId(String idOfUser) {
        this.userId = idOfUser;
    }

    /**
     * Get password từ đối tượng.
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set password cho đối tượng.
     * @param pw
     */
    public void setPassword(String pw) {
        this.password = pw;
    }

    /**
     * Get câu hỏi 1 từ đối tượng.
     * @return question1
     */
    public String getQuestion1() {
        return question1;
    }

    /**
     * Set câu hỏi 1 cho đối tượng.
     * @param q1
     */
    public void setQuestion1(String q1) {
        this.question1 = q1;
    }

    /**
     * Get câu trả lời 1 từ đối tượng.
     * @return answer1
     */
    public String getAnswer1() {
        return answer1;
    }

    /**
     * Set câu trả lời 1 cho đối tượng.
     * @param a1
     */
    public void setAnswer1(String a1) {
        this.answer1 = a1;
    }

    /**
     * Get câu hỏi 2 từ đối tượng.
     * @return question2
     */
    public String getQuestion2() {
        return question2;
    }

    /**
     * Set câu hỏi 1 cho đối tượng.
     * @param q2
     */
    public void setQuestion2(String q2) {
        this.question2 = q2;
    }

    /**
     * Get câu trả lời 2 từ đối tượng.
     * @return answer2
     */
    public String getAnswer2() {
        return answer2;
    }

    /**
     * Set câu trả lời 2 cho đối tượng.
     * @param a2
     */
    public void setAnswer2(String a2) {
        this.answer2 = a2;
    }

    /**
     * Get câu hỏi 3 từ đối tượng.
     * @return question3
     */
    public String getQuestion3() {
        return question3;
    }

    /**
     * Set câu hỏi 3 cho đối tượng.
     * @param q3
     */
    public void setQuestion3(String q3) {
        this.question3 = q3;
    }

    /**
     * Get câu trả lời 3 từ đối tượng.
     * @return anser3
     */
    public String getAnswer3() {
        return answer3;
    }

    /**
     * Set câu trả lời 3 cho đối tượng.
     * @param a3
     */
    public void setAnswer3(String a3) {
        this.answer3 = a3;
    }

    /**
     * Get số lần đăng nhập không hợp lệ.
     * @return time
     */
    public int getTime() {
        return time;
    }

    /**
     * Set số lần đăng nhập không hợp lệ.
     * @param wrongTime
     */
    public void setTime(int wrongTime) {
        this.time = wrongTime;
    }
}
