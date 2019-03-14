# --- Sample dataset
 
# --- !Ups
 
delete from item_on_sale;
 
insert into category (id,name) values ( 1,'Computing' );
insert into category (id,name) values ( 2,'Operating System' );
insert into category (id,name) values ( 3,'Web Development' );
insert into category (id,name) values ( 4,'Networking' );

 
insert into employee (id,category_id, fname, lname) values ( 1,1,'James','Smith');
insert into employee (id,category_id, fname, lname) values ( 2,2,'Michael','Garcia');
insert into employee (id,category_id, fname, lname) values ( 3,3,'Robert','Dpwney');
insert into employee (id,category_id, fname, lname) values ( 4,4,'Maria','Elle');
insert into employee (id,category_id, fname, lname) values ( 5,1,'David ','Coolock');
insert into employee (id,category_id, fname, lname) values ( 6,2,'Taylor','O Connor');
insert into employee (id,category_id, fname, lname) values ( 7,3,'Clark','Kent');
insert into employee (id,category_id, fname, lname) values ( 8,4,'William','Jeffery');
insert into employee (id,category_id, fname, lname) values ( 9,1,'Thomas','Hammilton');
insert into employee (id,category_id, fname, lname) values ( 10,2,'Fred','Clause');

