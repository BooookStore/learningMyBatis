USE `library`;

CREATE TABLE `LIBRARY`
(
    `id`   INT PRIMARY KEY,
    `name` VARCHAR(256) NOT NULL
);

CREATE TABLE `BOOK`
(
    `id`         INT PRIMARY KEY,
    `title`      VARCHAR(256) NOT NULL,
    `isbn`       VARCHAR(256) NOT NULL,
    `library_id` INT NOT NULL,
    FOREIGN KEY (library_id) REFERENCES `LIBRARY` (id)
);
