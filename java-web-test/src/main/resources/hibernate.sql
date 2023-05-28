create
    database if not exists helloj2ee;

use helllj2ee;

drop
    table
        if exists messages;

create
    table
        if not exists MESSAGES(
            MESSAGE_ID integer AUTO_INCREMENT,
            MESSAGE_TEXT varchar(20),
            MESSAGE_TITLE varchar(20),
            sentTime date,
            status varchar(20), primary key(MESSAGE_ID)
        );

drop
    table
        if exists user;


create
    table
        if not exists user(
            id integer AUTO_INCREMENT,
            username varchar(20) not null,
            password varchar(20),
            realName varchar(20),
            email varchar(20),
            age integer,
            birthday date,
            gender integer,
            status varchar(20), primary key(id)
        );

create
    table
        if not exists person(
            pid integer AUTO_INCREMENT,
            name varchar(20) not null,
            age varchar(20),
            primary key(pid)
        );

create
    table
        if not exists address(
            aid integer AUTO_INCREMENT,
            name varchar(20) not null,
            zipcode varchar(20),
            address varchar(20),
            person varchar(20) references person (pid),
            primary key(aid)
        );

commit;

select * from messages;