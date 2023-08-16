create database blog;

use blog;

create table blog (
	id int primary key auto_increment,
    title varchar(200),
    content varchar(500),
    author varchar(100)
);


insert into blog value 
(1, "nguyen oc cho", "danh tft roll ngu", "bui huu hai"),
(2, "may con ga", "chuyen la may con ga danh ngu", "nguyen hong nguyen"),
(3, "chu be dan", "cau chuyen ve chu be dan", "le cong hoang thien"),
(4, "alo alo", "lai la 1 cau chuyen khac", "nguyen dinh thoi");