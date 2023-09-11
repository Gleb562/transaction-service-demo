CREATE SCHEMA IF NOT EXISTS mbicycledemo;
USE mbicycledemo;

CREATE TABLE transaction_info
(
    id               bigint(20) NOT NULL UNIQUE,
    timestamp        bigint(20) NOT NULL,
    type             varchar(255) NOT NULL,
    actor            varchar(255) NOT NULL,
    transaction_data varchar(255) DEFAULT NULL,
    PRIMARY KEY (id)
);

INSERT INTO mbicycledemo.transaction_info
VALUES (1, 1694424794953, 'ACCOUNT', 'BALANCE SERVICE', '{"StringProperty": "StringValue"}');
INSERT INTO mbicycledemo.transaction_info
VALUES (2, 1694424794954, 'ACCOUNT', 'BALANCE SERVICE', '{"StringProperty": "StringValue"}');
INSERT INTO mbicycledemo.transaction_info
VALUES (3, 1694424794960, 'INVOICE', 'BALANCE SERVICE', '{"StringProperty": "StringValue"}');

