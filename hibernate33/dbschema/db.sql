create table CUSTOMERS(
	ID bigint not null,
	NAME varchar(15),
	primary key(ID)
);

create table ORDERS(
	ID bigint not null,
	ORDER_NUMBER varchar(15),
	CUSTOMER_ID bigint not null,
	primary key(ID)
);

alter table ORDERS add index IDX_CUSTOMER_ID(CUSTOMER_ID),
add constraint FK_CUSTOMER_ID foreign key(CUSTOMER_ID) references CUSTOMERS(ID);