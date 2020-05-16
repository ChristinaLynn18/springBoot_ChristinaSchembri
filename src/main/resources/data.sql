-- BEF initialize (insert) tables used by jdbcTemplate in h2 db
INSERT INTO cat(id, name, type) VALUES(1,'white', 'van');
INSERT INTO cat(name, type) VALUES('brown', 'mixed');		-- don't have to use id because of auto-increment
INSERT INTO cat(name, type) VALUES('black', 'tekir');
-- EOF initialize (insert) tables used by jdbcTemplate in h2 db

