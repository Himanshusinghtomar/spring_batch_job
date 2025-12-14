create table if not exists products(
product_id int primary key,
title varchar(100),
description varchar(100),
price varchar(20),
discount varchar(20),
discounted_price varchar(20)
);