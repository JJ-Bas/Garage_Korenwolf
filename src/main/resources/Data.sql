-- rollen toevoegen
INSERT INTO roles(name)
VALUES ('ROLE_USER'), ('ROLE_ADMIN'), ('ROLE_MECHANIC')
    ON CONFLICT DO NOTHING;

-- Gebruikers toevoegen
INSERT INTO users(username, password)
VALUES ('admin', '$2a$12$w.W0Y.Y/13FEndUm9Agya.6gzCwIXpG3OSxVfdYuyaMlkHP.VABaK')
    ON CONFLICT DO NOTHING;
INSERT INTO users(username, password)
VALUES ('mechanic', '$2a$12$w.W0Y.Y/13FEndUm9Agya.6gzCwIXpG3OSxVfdYuyaMlkHP.VABaK')
ON CONFLICT DO NOTHING;

-- rol toevoegen aan gebruiker
INSERT INTO user_roles(user_name, name) VALUES ('admin', 'ROLE_ADMIN') ON CONFLICT DO NOTHING;
INSERT INTO user_roles(user_name, name) VALUES ('mechanic', 'ROLE_MECHANIC') ON CONFLICT DO NOTHING;
-- personen toevoegen aan Peron
INSERT INTO persons (id, first_name, last_name, date_of_birth, street_name, house_number, postal_code, telephone_number, email)
VALUES
    (1, 'John', 'Doe', '1990-05-15', 'Maple Street', '12A', '12345', 316123456, 'john.doe@example.com')ON CONFLICT DO NOTHING;

INSERT INTO persons (id, first_name, last_name, date_of_birth, street_name, house_number, postal_code, telephone_number, email)
VALUES
    (2, 'Jane', 'Smith', '1985-11-03', 'Oak Avenue', '45B', '54321', 316987654, 'jane.smith@example.com')ON CONFLICT DO NOTHING;

-- Maintenance_job bonnen
INSERT INTO maintenance_job (id, description) VALUES (1, 'Basic Maintenance');
INSERT INTO maintenance_job (id, description) VALUES (2, 'Advanced Maintenance');

-- Parts Job_items
INSERT INTO job_item (id, name, description, price_exclusive_tax, tax_percentage, maintenance_job_id)
VALUES (1, 'Oil Filter', 'High-performance oil filter', 15.00, 21.0, 1);

INSERT INTO job_item (id, name, description, price_exclusive_tax, tax_percentage, maintenance_job_id)
VALUES (2, 'Air Filter', 'Standard air filter', 12.50, 21.0, 1);

INSERT INTO job_item (id, name, description, price_exclusive_tax, tax_percentage, maintenance_job_id)
VALUES (3, 'Spark Plug', 'Premium spark plug', 9.75, 21.0, 2);

-- Parts
INSERT INTO part (id, items_in_stock, brand, category)
VALUES (1, 100, 'Bosch', 'Engine');

INSERT INTO part (id, items_in_stock, brand, category)
VALUES (2, 200, 'MANN', 'Air');

INSERT INTO part (id, items_in_stock, brand, category)
VALUES (3, 150, 'NGK', 'Ignition');

-- WorkPerformed (job_Item)
INSERT INTO job_item (id, name, description, price_exclusive_tax, tax_percentage, maintenance_job_id)
VALUES (4, 'Brake Pad Replacement', 'Front brake pads replaced', 60.00, 21.0, 1);

INSERT INTO job_item (id, name, description, price_exclusive_tax, tax_percentage, maintenance_job_id)
VALUES (5, 'Oil Change', 'Full oil and filter change', 45.00, 21.0, 2);

INSERT INTO job_item (id, name, description, price_exclusive_tax, tax_percentage, maintenance_job_id)
VALUES (6, 'Tire Rotation', 'All four tires rotated', 25.00, 21.0, 2);

-- WorkPerformed
INSERT INTO work_performed (id, work_time_in_minutes, notes, warranty)
VALUES (4, 60, 'Customer requested quick check', true);

INSERT INTO work_performed (id, work_time_in_minutes, notes, warranty)
VALUES (5, 30, 'Oil slightly over minimum', false);

INSERT INTO work_performed (id, work_time_in_minutes, notes, warranty)
VALUES (6, 20, 'All tires in good condition', false);

-- Reset sequence to avoid conflict with inserted IDs
-- anders levert het een probleem op met /parts POST: create new part
SELECT setval('job_item_seq', (SELECT MAX(id) FROM job_item));