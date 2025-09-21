DROP DATABASE IF EXISTS JavaWebTest;

CREATE DATABASE IF NOT EXISTS JavaWebTest DEFAULT CHARACTER SET utf8;

USE JavaWebTest;

CREATE TABLE worker
(
    id     INT         NOT NULL AUTO_INCREMENT,
    name   VARCHAR(20) NOT NULL,
    gender VARCHAR(10) DEFAULT NULL,
    age    INT(3)      DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE book
(
    id              INT          NOT NULL AUTO_INCREMENT,
    bookName        VARCHAR(200) NOT NULL,
    author          VARCHAR(100) DEFAULT NULL,
    price           FLOAT        DEFAULT NULL,
    publicationDate DATETIME     DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE log
(
    id          varchar(64)  NOT NULL,
    session_id  varchar(64)  NOT NULL,
    ip          varchar(64)  NULL,
    page        varchar(200) NULL,
    access_time timestamp    NULL,
    stay_time   mediumtext   NULL,
    PRIMARY KEY (id)
) ENGINE = InnoDB
  AUTO_INCREMENT = 0
;

CREATE INDEX log_index
    ON log (session_id, ip)
;


drop
    table
    if exists messages;

create
    table
    if not exists MESSAGES
(
    MESSAGE_ID    integer AUTO_INCREMENT,
    MESSAGE_TEXT  varchar(20),
    MESSAGE_TITLE varchar(20),
    sentTime      date,
    status        varchar(20),
    primary key (MESSAGE_ID)
);

/*drop
    table
    if exists user;


create
    table
    if not exists user
(
    id       integer AUTO_INCREMENT,
    username varchar(20) not null,
    password varchar(20),
    realName varchar(20),
    email    varchar(20),
    age      integer,
    birthday date,
    gender   integer,
    status   varchar(20),
    primary key (id)
);

create
    table
    if not exists person
(
    pid  integer AUTO_INCREMENT,
    name varchar(20) not null,
    age  varchar(20),
    primary key (pid)
);

create
    table
    if not exists address
(
    aid     integer AUTO_INCREMENT,
    name    varchar(20) not null,
    zipcode varchar(20),
    address varchar(20),
    person  varchar(20) references person (pid),
    primary key (aid)
);*/

commit;
	
