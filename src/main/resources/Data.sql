-- rollen toevoegen
INSERT INTO roles(rolename)
VALUES ('ROLE_USER'), ('ROLE_ADMIN'), ('ROLE_MECHANIC')
    ON CONFLICT DO NOTHING;

-- Gebruikers toevoegen
INSERT INTO users(username, password)
VALUES ('admin', '$2a$12$w.W0Y.Y/13FEndUm9Agya.6gzCwIXpG3OSxVfdYuyaMlkHP.VABaK')
    ON CONFLICT DO NOTHING;

-- rol toevoegen aan gebruiker
INSERT INTO user_roles(user_name, role_name) VALUES ('admin', 'ROLE_ADMIN') ON CONFLICT DO NOTHING;