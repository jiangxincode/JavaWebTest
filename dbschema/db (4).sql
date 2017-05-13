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


create table CATEGORIES (
	ID bigint not null,
	NAME varchar(5),
	CATERGORY_ID bigint,
	primary key(ID)
);

alter table CATEGORIES add index IDX_CATEGORY_ID(CATEGORY_ID),
add constraint FK_CATEGORY_ID foreign key(CATEGORY_ID) references CATEGORIES(ID);