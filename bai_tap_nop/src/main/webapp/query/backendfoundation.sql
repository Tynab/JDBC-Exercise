-- create

CREATE DATABASE IF NOT EXISTS backendfoundation;

USE backendfoundation;

CREATE TABLE IF NOT EXISTS user(
    username CHAR(50) NOT NULL,
    password CHAR(50),
    PRIMARY KEY(username)
);

-- add values

INSERT INTO user(username) VALUES("admin");

-- update values

UPDATE
    user
SET
    password = MD5("admin")
WHERE
    username = "admin";

-- view

SELECT * FROM user;