USE GROCERY_SHOP;
CREATE TABLE GROCERY_SHOP.user_details (
  user_id int NOT NULL PRIMARY KEY AUTO_INCREMENT ,
  first_name varchar(30) NOT NULL,
  last_name varchar(30) NOT NULL,
  email_id varchar(100) NOT NULL UNIQUE,
  password varchar(30) NOT NULL ,
  address_line1 varchar(50) NOT NULL,
  address_line2  varchar(50) DEFAULT NULL,
  city varchar(20) NOT NULL,
  state varchar(20) NOT NULL,
  country varchar(20) NOT NULL,
  zipcode varchar(10) NOT NULL,
  phone varchar(20) DEFAULT NULL
 );

commit;

USE GROCERY_SHOP;
CREATE TABLE GROCERY_SHOP.items(
item_id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
item_name varchar(30) NOT NULL,
item_image_url  varchar(100),
item_price decimal(8,2) UNSIGNED NOT NULL,
item_avail TINYINT NOT NULL DEFAULT 1
);
commit;

USE GROCERY_SHOP;
CREATE TABLE GROCERY_SHOP.order_items(
order_id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
item_id int NOT NULL ,
quantity_ordered SMALLINT UNSIGNED  NOT NULL,
FOREIGN KEY (item_id)  REFERENCES items (item_id)
);
commit;



USE GROCERY_SHOP;
CREATE TABLE user_orders(
user_id int NOT NULL,
order_id int NOT NULL,
order_total_price decimal(9,2) UNSIGNED NOT NULL,
order_status varchar(10) NOT NULL,
FOREIGN KEY (user_id)  REFERENCES user_details (user_id));
commit;


USE GROCERY_SHOP;
alter table items
add item_category varchar(30);
commit;


USE GROCERY_SHOP;
alter table order_items
add total_price decimal(8,2);
commit;



ALTER TABLE order_items ADD PRIMARY KEY(order_id,item_id);

ALTER TABLE order_items ADD Column total_price decimal(8,2) NOT NULL;


INSERT INTO GROCERY_SHOP.items(item_id,item_name,item_image_url,item_price,item_avail,item_category)
VALUES('1','Milk','','2.82','1','FreshFoods');
INSERT INTO GROCERY_SHOP.items(item_id,item_name,item_image_url,item_price,item_avail,item_category)
VALUES('2','Yogurt','','4.98','1','FreshFoods');
INSERT INTO GROCERY_SHOP.items(item_id,item_name,item_image_url,item_price,item_avail,item_category)
VALUES('3','Banana','','0.59','1','FreshFoods');
INSERT INTO GROCERY_SHOP.items(item_id,item_name,item_image_url,item_price,item_avail,item_category)
VALUES('4','Strawberries','','1.98','1','FreshFoods');
INSERT INTO GROCERY_SHOP.items(item_id,item_name,item_image_url,item_price,item_avail,item_category)
VALUES('5','Apple','','2.47','1','FreshFoods');
INSERT INTO GROCERY_SHOP.items(item_id,item_name,item_image_url,item_price,item_avail,item_category)
VALUES('6','Cauliflower','','2.97','1','FreshFoods');
INSERT INTO GROCERY_SHOP.items(item_id,item_name,item_image_url,item_price,item_avail,item_category)
VALUES('7','Carrots','','1.78','1','FreshFoods');
INSERT INTO GROCERY_SHOP.items(item_id,item_name,item_image_url,item_price,item_avail,item_category)
VALUES('8','Mushrooms','','1.94','1','FreshFoods');

INSERT INTO GROCERY_SHOP.items(item_id,item_name,item_image_url,item_price,item_avail,item_category)
VALUES('9','Coca cola','','4.58','1','Drinks');
INSERT INTO GROCERY_SHOP.items(item_id,item_name,item_image_url,item_price,item_avail,item_category)
VALUES('10','Crush Orange Soda','','2.50','1','Drinks');
INSERT INTO GROCERY_SHOP.items(item_id,item_name,item_image_url,item_price,item_avail,item_category)
VALUES('11','Dr Pepper Cherry Soda','','1.00','1','Drinks');
INSERT INTO GROCERY_SHOP.items(item_id,item_name,item_image_url,item_price,item_avail,item_category)
VALUES('12','Fanta','','4.18','1','Drinks');
INSERT INTO GROCERY_SHOP.items(item_id,item_name,item_image_url,item_price,item_avail,item_category)
VALUES('13','Pineapple Fruit Juice','','2.78','1','Drinks');
INSERT INTO GROCERY_SHOP.items(item_id,item_name,item_image_url,item_price,item_avail,item_category)
VALUES('14','Orange Fruit Juice','','2.84','1','Drinks');
INSERT INTO GROCERY_SHOP.items(item_id,item_name,item_image_url,item_price,item_avail,item_category)
VALUES('15','Grape Fruit Juice','','3.98','1','Drinks');


INSERT INTO GROCERY_SHOP.items(item_id,item_name,item_image_url,item_price,item_avail,item_category)
VALUES('16','Honey Buns','','1.48','1','Snacks');
INSERT INTO GROCERY_SHOP.items(item_id,item_name,item_image_url,item_price,item_avail,item_category)
VALUES('17','Chocolate Cup Cakes','','2.50','1','Snacks');
INSERT INTO GROCERY_SHOP.items(item_id,item_name,item_image_url,item_price,item_avail,item_category)
VALUES('18','Snack Bars','','2.78','1','Snacks');
INSERT INTO GROCERY_SHOP.items(item_id,item_name,item_image_url,item_price,item_avail,item_category)
VALUES('19','K Strawberry Bars','','2.99','1','Snacks');
INSERT INTO GROCERY_SHOP.items(item_id,item_name,item_image_url,item_price,item_avail,item_category)
VALUES('20','cookies','','1.98','1','Snacks');
INSERT INTO GROCERY_SHOP.items(item_id,item_name,item_image_url,item_price,item_avail,item_category)
VALUES('21','Potato Chips','','2.33','1','Snacks');



INSERT INTO GROCERY_SHOP.items(item_id,item_name,item_image_url,item_price,item_avail,item_category)
VALUES('22','Body Wash','','3.97','1','Beauty');
INSERT INTO GROCERY_SHOP.items(item_id,item_name,item_image_url,item_price,item_avail,item_category)
VALUES('23','Soap','','0.97','1','Beauty');
INSERT INTO GROCERY_SHOP.items(item_id,item_name,item_image_url,item_price,item_avail,item_category)
VALUES('24','Hand Sanitizer','','1.97','1','Beauty');
INSERT INTO GROCERY_SHOP.items(item_id,item_name,item_image_url,item_price,item_avail,item_category)
VALUES('25','Moisturizing Lotion','','13.97','1','Beauty');
INSERT INTO GROCERY_SHOP.items(item_id,item_name,item_image_url,item_price,item_avail,item_category)
VALUES('26','Aveeno Body Wash','','5.86','1','Beauty');
INSERT INTO GROCERY_SHOP.items(item_id,item_name,item_image_url,item_price,item_avail,item_category)
VALUES('27','Deodorant','','2.27','1','Beauty');
INSERT INTO GROCERY_SHOP.items(item_id,item_name,item_image_url,item_price,item_avail,item_category)
VALUES('28','Hair Spray','','3.74','1','Beauty');


update items set item_image_url = "/GROCERYPORTAL/images/milk.jpg" where item_id = 1;
commit;
update items set item_image_url = "/GROCERYPORTAL/images/Yogurt.jpg" where item_id = 2;
commit;
update items set item_image_url = "/GROCERYPORTAL/images/Banana.jpg" where item_id = 3;
commit;
update items set item_image_url = "/GROCERYPORTAL/images/Strawberries.jpg" where item_id = 4;
commit;
update items set item_image_url = "/GROCERYPORTAL/images/Apple.jpg" where item_id = 5;
commit;
update items set item_image_url = "/GROCERYPORTAL/images/Cauliflower.jpg" where item_id = 6;
commit;
update items set item_image_url = "/GROCERYPORTAL/images/Carrots.jpg" where item_id = 7;
commit;
update items set item_image_url = "/GROCERYPORTAL/images/Mushrooms.jpg" where item_id = 8;
commit;



update items set item_image_url = "/GROCERYPORTAL/images/Coca-cola.jpg" where item_id = 9;
commit;
update items set item_image_url = "/GROCERYPORTAL/images/CrushOrangeSoda.jpg" where item_id = 10;
commit;
update items set item_image_url = "/GROCERYPORTAL/images/DrPepperCherrySoda.jpg" where item_id = 11;
commit;
update items set item_image_url = "/GROCERYPORTAL/images/Fanta.jpg" where item_id = 12;
commit;
update items set item_image_url = "/GROCERYPORTAL/images/PineappleJuice.jpg" where item_id = 13;
commit;
update items set item_image_url = "/GROCERYPORTAL/images/OrangeJuice.jpg" where item_id = 14;
commit;
update items set item_image_url = "/GROCERYPORTAL/images/GrapeJuice.jpg" where item_id = 15;
commit;



update items set item_image_url = "/GROCERYPORTAL/images/HoneyBuns.jpg" where item_id = 16;
commit;
update items set item_image_url = "/GROCERYPORTAL/images/ChocolateCupCakes.jpg" where item_id = 17;
commit;
update items set item_image_url = "/GROCERYPORTAL/images/SnackBars.jpg" where item_id = 18;
commit;
update items set item_image_url = "/GROCERYPORTAL/images/K_StrawberryBars.jpg" where item_id = 19;
commit;
update items set item_image_url = "/GROCERYPORTAL/images/Cookies.jpg" where item_id = 20;
commit;
update items set item_image_url = "/GROCERYPORTAL/images/PotatoChips.jpg" where item_id = 21;
commit;


update items set item_image_url = "/GROCERYPORTAL/images/BodyWash.jpg" where item_id = 22;
commit;
update items set item_image_url = "/GROCERYPORTAL/images/Soap.jpg" where item_id = 23;
commit;
update items set item_image_url = "/GROCERYPORTAL/images/HandSanitizer.jpg" where item_id = 24;
commit;
update items set item_image_url = "/GROCERYPORTAL/images/MoisturizingLotion.jpg" where item_id = 25;
commit;
update items set item_image_url = "/GROCERYPORTAL/images/AveenoBodyWash.jpg" where item_id = 26;
commit;
update items set item_image_url = "/GROCERYPORTAL/images/Deodrant.jpg" where item_id = 27;
commit;
update items set item_image_url = "/GROCERYPORTAL/images/HairSpray.jpg" where item_id = 28;
commit;
