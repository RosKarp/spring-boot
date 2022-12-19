DROP TABLE products IF EXISTS;
CREATE TABLE IF NOT EXISTS products (id bigserial, title VARCHAR(255), price INTEGER, PRIMARY KEY(id));
INSERT INTO products (title, price) VALUES ('Bread', 10), ('Juice', 23), ('Milk', 18);
