# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table address (
  id                            bigint auto_increment not null,
  address                       varchar(255),
  constraint pk_address primary key (id)
);

create table department (
  id                            bigint auto_increment not null,
  name                          varchar(255),
  constraint pk_department primary key (id)
);

create table employee (
  id                            bigint auto_increment not null,
  fname                         varchar(255),
  lname                         varchar(255),
  department_id                 bigint,
  address_id                    bigint,
  constraint uq_employee_address_id unique (address_id),
  constraint pk_employee primary key (id)
);

alter table employee add constraint fk_employee_department_id foreign key (department_id) references department (id) on delete restrict on update restrict;
create index ix_employee_department_id on employee (department_id);

alter table employee add constraint fk_employee_address_id foreign key (address_id) references address (id) on delete restrict on update restrict;


# --- !Downs

alter table employee drop constraint if exists fk_employee_department_id;
drop index if exists ix_employee_department_id;

alter table employee drop constraint if exists fk_employee_address_id;

drop table if exists address;

drop table if exists department;

drop table if exists employee;

