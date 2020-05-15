-- BEF initialize (insert) tables used by jdbcTemplate in h2 db
INSERT INTO cat(id, name, type) VALUES(1,'white', 'van');
INSERT INTO cat(name, type) VALUES('brown', 'mixed');		-- don't have to use type because of auto-increment
INSERT INTO cat(name, type) VALUES('black', 'tekir');
-- EOF initialize (insert) tables used by jdbcTemplate in h2 db

-- BEF initialize (insert) tables used by jpa in h2 db
INSERT INTO staff(id, first_name, last_name) VALUES(1000, 'ilker', 'kiris');
INSERT INTO staff(id, first_name, last_name) VALUES(1001, 'halit', 'argun');
INSERT INTO staff(id, first_name, last_name) VALUES(1002, 'ender', 'argun');
INSERT INTO staff(id, first_name, last_name) VALUES(1003, 'yildiz', 'yilmaz');
INSERT INTO staff(id, first_name, last_name) VALUES(1004, 'zeynep', 'yilmaz');
INSERT INTO staff(id, first_name, last_name) VALUES(1005, 'alihan', 'tasdemir');
-- EOF initialize (insert) tables used by jpa in h2 db

