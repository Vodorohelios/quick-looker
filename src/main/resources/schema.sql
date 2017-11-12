-- create schema if not exists quick_looker;

create schema if not exists quick_looker;

use quick_looker;

create table users(
	username varchar(50) not null primary key,
	password varchar(50) not null,
	enabled boolean not null,
	first_name varchar(50) not null,
	last_name varchar(50) not null,
	email varchar(50) not null
);

create table authorities (
	username varchar(50) not null,
	authority varchar(50) not null,
	constraint fk_authorities_users foreign key(username) references users(username)
);

create table posts(
	id int(20) NOT NULL primary key auto_increment,
	title varchar(50) not null,
	body LONGTEXT not null,
	date timestamp not null,
    author varchar(50) not null,
    constraint fk_posts_users foreign key(author) references users(username)
);
