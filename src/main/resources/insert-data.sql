use quick_looker;

insert into users(username, password, enabled, first_name, last_name, email) values
    ('user1', 'password', true, 'Alex', 'Ivanov', 'aivanov@mail.com'),
    ('user2', 'password', true, 'Michael', 'Jackson', 'mjackson@mail.com');
    
insert into authorities(username, authority) values
	('user1', 'ROLE_USER'),
    ('user2', 'ROLE_USER');
    
insert into posts(id, title, body, date, author) values
(1, 'Hello', 'Hello World!', CURRENT_TIMESTAMP, 'user1'),
(2, 'Again Hello', 'Again Hello World!', CURRENT_TIMESTAMP, 'user2');

