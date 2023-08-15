create database product_manager;

use product_manager;

create table products (
	id int primary key auto_increment,
    name varchar(200),
    quantity int,
    price int
);

select * from products;

insert into products value 
(1, "iphone", 12, 200),
(2, "imac", 11, 500),
(3, "macbook", 14, 100),
(4, "macpro", 13, 400),
(5, "ipod", 10, 300);

insert into products (name, quantity, price) value ("iphone", 10, 200);