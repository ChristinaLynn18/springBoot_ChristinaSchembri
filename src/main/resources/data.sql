-- BEF initialize (insert) tables used by jdbcTemplate in h2 db
-- "avrupa yakasi" karakterleri
INSERT INTO employee(id, first_name, last_name) VALUES(1,'asli', 'sutcuoglu');
INSERT INTO employee(first_name, last_name)     VALUES('burhan', 'altintop');	-- NOTE ilker auto_increment is smart, it will realize above insert using 1, so it will continue id with 2
INSERT INTO employee(first_name, last_name)     VALUES('cem', 'onaran');
INSERT INTO employee(first_name, last_name)     VALUES('volkan', 'sutcuoglu');
-- EOF initialize (insert) tables used by jdbcTemplate in h2 db

-- BEF initialize (insert) tables used by jpa in h2 db
-- NOTE ilker important note. Below lines will fail and app not start if jpa table is not created in schema.sql.
--      Turns out jpa schema creation along with schema.sql, then using data.sql will not work. data.sql gets executed after schema.sql, but before jpa updates schema
--      So below lines will throw exception if table that jpa would have created is not created in schema.sql 1st
-- "yasak elma" karakterleri + ilker
INSERT INTO staff(id, first_name, last_name) VALUES(1000, 'ilker', 'kiris');	-- NOTE ilker, @GeneratedValue inserts generated id value in hibernate layer using a "HIBERNATE_SEQUENCE". But it is not part of table via auto_increment, so have to provide id value in data.sql insert statements
INSERT INTO staff(id, first_name, last_name) VALUES(1001, 'halit', 'argun');
INSERT INTO staff(id, first_name, last_name) VALUES(1002, 'ender', 'argun');
INSERT INTO staff(id, first_name, last_name) VALUES(1003, 'yildiz', 'yilmaz');
INSERT INTO staff(id, first_name, last_name) VALUES(1004, 'zeynep', 'yilmaz');
INSERT INTO staff(id, first_name, last_name) VALUES(1005, 'alihan', 'tasdemir');
-- EOF initialize (insert) tables used by jpa in h2 db

