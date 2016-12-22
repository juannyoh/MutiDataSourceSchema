CREATE DATABASE hotel_1 DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
use hotel_1

drop table if exists guest;

create table guest
(
id int not null auto_increment,
name varchar(30) not null,
telephone varchar(30) not null,
address varchar(255) not null,
email varchar(50) not null,
CONSTRAINT PK_customer PRIMARY KEY  (id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8;

create unique index guest_email on guest
(
   email
);


/*!40101 SET NAMES utf8 */;
insert into guest(id, name, telephone, address, email) values (1, 'Victor', '56008888', '上海科苑路399号', 'vic@gmail.com');
insert into guest(id, name, telephone, address, email) values (2, 'Jacky', '66668822', '上海金科路28号', 'jacky@sina.com');
