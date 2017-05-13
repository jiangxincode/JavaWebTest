create table CUSTOMERS (
	ID bigint not null primary key,
	NAME varchar(15) not null,
	EMAIL varchar(128) not null,
	PASSWORD varchar(8) not null,
	PHONE int,
	ADDRESS varchar(255),
	SEX char(1),
	IS_MARRIED bit,
	DESCRIPTION text,
	IMAGE blob,
	BIRTHDAY data,
	REGISTERED_TIME timestamp
);