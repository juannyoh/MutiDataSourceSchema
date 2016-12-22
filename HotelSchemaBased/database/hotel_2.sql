CREATE DATABASE hotel_2 DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
use hotel_2

drop table if exists guest;

create table guest
(
id int not null auto_increment,
name varchar(30) not null,
telephone varchar(30) not null,
address varchar(255) not null,
email varchar(50) not null,
create_time timestamp,
CONSTRAINT PK_customer PRIMARY KEY  (id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8;

create unique index guest_email on guest
(
   email
);

/*!40101 SET NAMES utf8 */;
insert into guest(id, name, telephone, address, email) values (1, 'Anton', '33355566', '上海南京路8号', 'anton@gmail.com');
insert into guest(id, name, telephone, address, email) values (2, 'Gus', '33355566', '北京大道3号', 'gus@yahoo.com');