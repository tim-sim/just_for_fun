CREATE TABLE users (
    id UUID PRIMARY KEY,
    login VARCHAR(256) NOT NULL UNIQUE,
    password VARCHAR(256) NOT NULL,
    person JSONB,
    address JSONB,
    active BOOLEAN DEFAULT true
);

CREATE INDEX users_login_idx ON users (login);

CREATE TABLE roles (
    id UUID PRIMARY KEY,
    name TEXT
);

CREATE TABLE user_role_links (
    user_id UUID REFERENCES users,
    role_id UUID REFERENCES roles
);

CREATE TABLE orders (
    id UUID PRIMARY KEY,
    user_id UUID REFERENCES users,
    code TEXT,
    amount NUMERIC(50,2),
    created_date TIMESTAMP DEFAULT NOW()
);

CREATE TABLE products (
    id UUID PRIMARY KEY,
    title TEXT,
    price NUMERIC(10,2),
    info JSONB
);

CREATE TABLE order_product_links (
    order_id UUID REFERENCES orders,
    product_id UUID REFERENCES products
)