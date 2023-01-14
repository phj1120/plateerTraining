CREATE DATABASE apidb;

CREATE USER 'apiuser'@'localhost' IDENTIFIED BY 'apiuser';

CREATE USER 'apiuser'@'%' IDENTIFIED BY 'apiuser';

GRANT ALL PRIVILEGES ON apidb.* TO 'apiuser'@'localhost';

GRANT ALL PRIVILEGES ON apidb.* TO 'apiuser'@'%';

