-- BEF initialize (insert) tables used by jdbcTemplate in h2 db
INSERT INTO cat(id, name, type) VALUES(1,'white', 'van');
INSERT INTO cat(name, type) VALUES('brown', 'mixed');		-- don't have to use id because of auto-increment
INSERT INTO cat(name, type) VALUES('black', 'tekir');
-- EOF initialize (insert) tables used by jdbcTemplate in h2 db

-- BEF initialize (insert) tables used by jpa in h2 db
INSERT INTO dog(id, name, type) VALUES(1000, 'white', 'maltiese');
INSERT INTO dog(id, name, type) VALUES(1001, 'yellow', 'chihuahua');
INSERT INTO dog(id, name, type) VALUES(1002, 'black', 'germanShepherd');
INSERT INTO dog(id, name, type) VALUES(1003, 'brown', 'yorki');
INSERT INTO dog(id, name, type) VALUES(1004, 'milky', 'kangal');
-- EOF initialize (insert) tables used by jpa in h2 db
