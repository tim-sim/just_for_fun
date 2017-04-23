CREATE TABLE users (
    id UUID PRIMARY KEY,
    login VARCHAR(256) NOT NULL UNIQUE,
    password VARCHAR(256) NOT NULL,
    name JSONB,
    address JSONB,
    email VARCHAR(256),
    active BOOLEAN
);

CREATE INDEX users_login_idx ON users (login);