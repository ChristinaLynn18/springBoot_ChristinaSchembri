-- BEF creating tables used by jdbcTemplate in h2 db
CREATE TABLE IF NOT exists employee
(
--	id int auto_increment          PRIMARY KEY,   -- NOTE ilker equivalent to below line. NOTE ilker if id is not provided in insert, an auto generated value from a sequence will be used
--	id int auto_increment NOT NULL PRIMARY KEY,   -- NOTE ilker equivalent to below line
	id int IDENTITY NOT NULL PRIMARY KEY,		  -- NOTE ilker h2 will create a "SYSTEM_SEQUENCE" for this
	-- NOTE ilker below 2 lines is equivalent to above 1
--	id int IDENTITY NOT NULL,
--	PRIMARY KEY(id),
	first_name varchar(12) NOT NULL,
	last_name varchar(12) NOT null
);
-- EOF creating tables used by jdbcTemplate in h2 db

-- BEF creating tables used by jpa in h2 db
-- NOTE ilker important note. Insert lines in data.sql will fail and app not start if jpa table is not created in schema.sql below.
--      Turns out jpa schema creation along with schema.sql, then using data.sql will not work. data.sql gets executed after schema.sql, but before jpa updates schema
--      So below without below lines data.sql insert into JPA table will throw exception when table that jpa would have created is not created in schema.sql 1st below
-- NOTE ilker assuming below line is set to default value of none or update in application.properties file
-- spring.jpa.hibernate.ddl-auto=none
    CREATE TABLE IF NOT EXISTS staff (
       id bigint not null,
        first_name varchar(255),
        last_name varchar(255),
        primary key (id)
    )
-- EOF creating tables used by jpa in h2 db