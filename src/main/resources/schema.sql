-- BEF creating tables used by jdbcTemplate in h2 db
DROP TABLE IF exists cat;
CREATE TABLE IF NOT exists cat
(
	id int IDENTITY NOT NULL PRIMARY KEY,
	name varchar(12) NOT NULL,
	type varchar(12) NOT null
);
-- EOF creating tables used by jdbcTemplate in h2 db

-- BEF creating tables used by jpa in h2 db
    CREATE TABLE IF NOT EXISTS dog (
       id int not null,
        name varchar(255),
        type varchar(255),
        primary key (id)
    )
-- EOF creating tables used by jpa in h2 db