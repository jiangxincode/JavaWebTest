CREATE TABLE log (
    id         	varchar(64) NOT NULL,
    session_id 	varchar(64) NOT NULL,
    ip         	varchar(64) NULL,
    page       	varchar(200) NULL,
    access_time	timestamp NULL,
    stay_time  	mediumtext NULL,
    PRIMARY KEY(id)
)
ENGINE = InnoDB
AUTO_INCREMENT = 0

;

CREATE INDEX log_index
    ON log(session_id, ip)
;