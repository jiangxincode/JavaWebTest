DROP
    DATABASE IF EXISTS JavaWebTest;

CREATE
    DATABASE IF NOT EXISTS JavaWebTest DEFAULT CHARACTER SET utf8;

USE
    JavaWebTest;

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
	
