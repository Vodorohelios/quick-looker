use quick_looker;

insert into users(username, password, enabled, first_name, last_name, email) values
    ('user', 'password', true, 'Alex', 'Ivanov', 'aivanov@mail.com'),
    ('other_user', 'password', true, 'Michael', 'Jackson', 'mjackson@mail.com');
    
insert into authorities(username, authority) values
	('user', 'ROLE_USER'),
    ('other_user', 'ROLE_USER');
    
insert into posts(id, title, body, date) values
(1, 'Hello', 'Hello World!', CURRENT_TIMESTAMP),
(2, 'Again Hello', 'Again Hello World!', CURRENT_TIMESTAMP);

