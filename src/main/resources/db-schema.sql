-- ==========================================
create table event
(
	id int not null primary key auto_increment, 
	name varchar(30) not null,
	owner varchar(20) not null,
	attendees varchar(300),
	start_time varchar(10),
	end_time varchar(10),
	description varchar(50),
	conference_room_id int not null,
	location_id int not null,
	created_user_id int not null,
	start_date timestamp not null,
	end_date timestamp,
	last_occurrence timestamp,
	recurrence_type varchar not null,
	excluded_dates varchar(500),
	is_active boolean
);

-- ========================================= 
create table location
(
	id int not null primary key auto_increment,
	name varchar(100) not null
);

-- ==========================================
create table conference_room
(
	id int not null auto_increment,
	name varchar(10) not null unique,
	capacity int,
	description varchar(100),
	location_id int not null
);

-- ==========================================
create table user
(
	id int not null auto_increment,
	first_name varchar(30) not null,
	last_name varchar(30) not null,
	email varchar(70) not null,
	username varchar(50) not null,
	password varchar(50) not null,
	role varchar(10) not null
);

-- ==========================================
create table recurrence
(
	id int not null auto_increment,
	name varchar(20) not null,
	recurrence_type varchar(5) not null,
	description varchar(50)
);

-- =========================================
create table alternative_conference_room
(
	id int not null auto_increment,
	eventId int not null,
	booking_date varchar(20) not null,
	alternative_roomId int not null,
	location_id not null
)

-- =======Relations======
alter table conference_room add primary key (id, location_id);
alter table event add foreign key(created_user_id) references user (id);
alter table event add foreign key(location_id) references location (id);
alter table event add foreign key(conference_room_id) references conference_room (id);
