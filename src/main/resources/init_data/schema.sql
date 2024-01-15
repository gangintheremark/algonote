DROP TABLE IF EXIST member;
CREATE TABLE `member`(
   id NOT NULL PRIMARY KEY auto_increment,
   email VARCHAR(30) NOT NULL
   member_id VARCHAR(30) NOT NULL,
   nickname VARCHAR(30) NOT NULL,
   password VARCHAR(20) NOT NULL
);

DROP TABLE IF EXIST problem;
CREATE TABLE `problem` (
	problemNum INT AUTO_INCREMENT,
	userid VARCHAR(20),
	title VARCHAR(50) NOT NULL,
	code VARCHAR(30000),
	solved VARCHAR(20) NOT NULL,
	language VARCHAR(10) NOT NULL,
	problemSite VARCHAR(20) NOT NULL,
	difficulty VARCHAR(20) NOT NULL,
	PRIMARY KEY (problemNum),
	FOREIGN KEY (userid) REFERENCES member(userid)
);