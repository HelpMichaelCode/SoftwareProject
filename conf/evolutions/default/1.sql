# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table category (
  id                            bigint auto_increment not null,
  name                          varchar(255),
  constraint pk_category primary key (id)
);

create table employee (
  id                            bigint auto_increment not null,
  fname                         varchar(255),
  lname                         varchar(255),
  category_id                   bigint,
  constraint pk_employee primary key (id)
);

create table item_on_sale (
  id                            bigint auto_increment not null,
  name                          varchar(255),
  description                   varchar(255),
  stock                         integer not null,
  price                         double not null,
  category_id                   bigint,
  constraint pk_item_on_sale primary key (id)
);

alter table employee add constraint fk_employee_category_id foreign key (category_id) references category (id) on delete restrict on update restrict;
create index ix_employee_category_id on employee (category_id);

alter table item_on_sale add constraint fk_item_on_sale_category_id foreign key (category_id) references category (id) on delete restrict on update restrict;
create index ix_item_on_sale_category_id on item_on_sale (category_id);


# --- !Downs

alter table employee drop constraint if exists fk_employee_category_id;
drop index if exists ix_employee_category_id;

alter table item_on_sale drop constraint if exists fk_item_on_sale_category_id;
drop index if exists ix_item_on_sale_category_id;

drop table if exists category;

drop table if exists employee;

drop table if exists item_on_sale;

