CREATE TABLE category(
id BIGINT auto_increment PRIMARY KEY ,
name VARCHAR(20) UNIQUE NOT NULL
);

CREATE TABLE product(
id BIGINT auto_increment PRIMARY KEY ,
name VARCHAR(32),
category_id INTEGER NOT NULL REFERENCES category (id)
);

CREATE TABLE quantity(
id BIGINT auto_increment PRIMARY KEY ,
quantity INTEGER NOT NULL ,
product_id INTEGER NOT NULL REFERENCES product (id)
);

CREATE TABLE orders(
id  BIGINT auto_increment PRIMARY KEY,
date DATE NOT NULL
);

CREATE TABLE orders_product
(
    id         BIGINT auto_increment PRIMARY KEY,
    order_id    BIGINT NOT NULL REFERENCES orders (id),
    product_id BIGINT NOT NULL REFERENCES product (id)
);