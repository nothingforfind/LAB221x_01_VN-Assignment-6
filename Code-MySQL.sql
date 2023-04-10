INSERT INTO users (userid, password, question1, answer1, question2, answer2, question3, answer3, time)
VALUES 
('1234567890123456', 'Abcd1234', 'Vợ/chồng bạn tên là gì?', 'Anna', 'Mẹ/bố bạn tên là gì?', 'John', 'Quốc gia nào bạn muốn đến nhất?', 'Nhật Bản', 0),
('2345678901234567', 'Abcd1234', 'Thú nuôi của bạn tên gì?', 'Mèo', 'Mẹ/bố bạn tên là gì?', 'Linda', 'Món ăn gì bạn chưa từng ăn?', 'Sushi', 1),
('3456789012345678', 'Abcd1234', 'Mẹ/bố bạn tên là gì?', 'Steve', 'Con trai/con gái bạn tên là gì?', 'Nathan', 'Môn thể thao nào bạn muốn theo đuổi?', 'Bóng rổ', 1),
('4567890123456789', 'Abcd1234', 'Con trai/con gái bạn tên là gì?', 'Hannah', 'Mùa nào bạn thích nhất?', 'Mùa thu', 'Mơ ước của bạn là gì?', 'Đi du lịch quanh thế giới', 0),
('5678901234567890', 'Abcd1234', 'Thú nuôi của bạn tên gì?', 'Chó', 'Mẹ/bố bạn tên là gì?', 'Adam', 'Quốc gia nào bạn muốn đến nhất?', 'Hàn Quốc', 0),
('6789012345678901', 'Abcd1234', 'Vợ/chồng bạn tên là gì?', 'Michael', 'Thú nuôi của bạn tên gì?', 'Cún', 'Môn thể thao nào bạn muốn theo đuổi?', 'Bơi lội', 3),
('7890123456789012', 'Abcd1234', 'Mẹ/bố bạn tên là gì?', 'Kate', 'Con trai/con gái bạn tên là gì?', 'David', 'Món ăn gì bạn chưa từng ăn?', 'Cá nướng', 0),
('8901234567890123', 'Abcd1234', 'Mùa nào bạn thích nhất?', 'Mùa đông', 'Quốc gia nào bạn muốn đến nhất?', 'Mỹ', 'Mơ ước của bạn là gì?', 'Tìm được công việc ổn định', 1);

INSERT INTO users (userid, password)
VALUES 
('7234567890123456', 'Abcd1234');

INSERT INTO users (userid, password)
VALUES 
('8234567890123456', 'Abcd1234');

SELECT * FROM users;

DELETE FROM users WHERE id < 100;

ALTER TABLE users AUTO_INCREMENT = 1;

ALTER TABLE users ADD question3 varchar(255), ADD answer3 varchar(255);
