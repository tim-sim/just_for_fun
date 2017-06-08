INSERT INTO users (id, login, password, person, address) VALUES
('ca1913ff-2326-479c-adce-b2617547833d', 'atos', 'atos', '{ "first_name": "aaa1", "last_name": "bbb1" }', '{ "city": "Paris" }'),
('09b1eb6e-6e20-447c-82f2-df9be7925677', 'portos', 'portos', '{ "first_name": "aaa2", "last_name": "bbb2" }', '{ "city": "Paris" }'),
('f74f6bc4-981c-4a8b-b246-ec6e7fe1e964', 'aramis', 'aramis', '{ "first_name": "aaa3", "last_name": "bbb3" }', '{ "city": "Paris" }');

INSERT INTO roles (id, name) VALUES
('c85165f2-ed3e-488e-bebf-333daa69de7f', 'basic'),
('4b03189d-0ee6-4bc3-94d2-b83e2a541ea1', 'user'),
('1f7436a8-fa82-4da6-8a97-36ba7bf8b3ac', 'admin');

INSERT INTO user_role_links (user_id, role_id) VALUES
('ca1913ff-2326-479c-adce-b2617547833d', 'c85165f2-ed3e-488e-bebf-333daa69de7f'),
('09b1eb6e-6e20-447c-82f2-df9be7925677', 'c85165f2-ed3e-488e-bebf-333daa69de7f'),
('f74f6bc4-981c-4a8b-b246-ec6e7fe1e964', 'c85165f2-ed3e-488e-bebf-333daa69de7f'),
('ca1913ff-2326-479c-adce-b2617547833d', '4b03189d-0ee6-4bc3-94d2-b83e2a541ea1'),
('09b1eb6e-6e20-447c-82f2-df9be7925677', '4b03189d-0ee6-4bc3-94d2-b83e2a541ea1'),
('f74f6bc4-981c-4a8b-b246-ec6e7fe1e964', '1f7436a8-fa82-4da6-8a97-36ba7bf8b3ac');

INSERT INTO products (id, title, price) VALUES
('69df9908-f67d-4153-bbdd-015e1d9e13e1', 'hat', 9.99),
('fde57ce8-17f7-4b07-9596-b11d3bc33b35', 'boots', 19.99),
('7cb77682-c8e1-4502-8661-f58d4a7e7245', 'sword', 29.99);

INSERT INTO orders (id, user_id, code) VALUES
('0b90ace9-4fcf-4f29-a79d-497a000f5d1f', 'ca1913ff-2326-479c-adce-b2617547833d', 'order20170303_001'),
('953bfc77-0beb-4026-b09c-e77b7357f36b', '09b1eb6e-6e20-447c-82f2-df9be7925677', 'order20170303_002'),
('6e41bdb7-11ec-47fa-b415-57dca3088cae', '09b1eb6e-6e20-447c-82f2-df9be7925677', 'order20170303_003');

INSERT INTO order_product_links (order_id, product_id) VALUES
('0b90ace9-4fcf-4f29-a79d-497a000f5d1f', '69df9908-f67d-4153-bbdd-015e1d9e13e1'),
('0b90ace9-4fcf-4f29-a79d-497a000f5d1f', 'fde57ce8-17f7-4b07-9596-b11d3bc33b35'),
('953bfc77-0beb-4026-b09c-e77b7357f36b', '69df9908-f67d-4153-bbdd-015e1d9e13e1'),
('953bfc77-0beb-4026-b09c-e77b7357f36b', '7cb77682-c8e1-4502-8661-f58d4a7e7245'),
('6e41bdb7-11ec-47fa-b415-57dca3088cae', 'fde57ce8-17f7-4b07-9596-b11d3bc33b35');