-- rollen toevoegen
INSERT INTO roles(rolename)
VALUES ('ROLE_USER'), ('ROLE_ADMIN'), ('ROLE_MECHANIC')
    ON CONFLICT DO NOTHING;

-- Gebruikers toevoegen
INSERT INTO users(username, password)
VALUES ('admin', '{bcrypt}$2a$10$Lem4O2zrhs61O19BQYcbQe.9FRP4ymcrCMB9aqkQbCdx8mwUbHXFO') -- voorbeeld bcrypt hash voor 'admin123'
    ON CONFLICT DO NOTHING;

-- rol toevoegen aan gebruiker
INSERT INTO user_roles(user_name, role_name) VALUES ('admin', 'ROLE_ADMIN') ON CONFLICT DO NOTHING;