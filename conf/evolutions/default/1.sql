CREATE TABLE CHINESE(
   chinese_id INT NOT NULL,
   sign CHAR(100) NOT NULL,
   prononciation CHAR(100) NOT NULL,
   PRIMARY KEY (chinese_id)
);

CREATE TABLE ENGLISH(
   english_id INT NOT NULL,
   word CHAR(100) NOT NULL,
   chinese_id INT NOT NULL,
   PRIMARY KEY (english_id),
   FOREIGN KEY (chinese_id) REFERENCES CHINESE (chinese_id)
);

CREATE SEQUENCE chinese_seq START 1;
CREATE SEQUENCE english_seq START 1;