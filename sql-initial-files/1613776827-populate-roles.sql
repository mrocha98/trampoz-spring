BEGIN;

INSERT INTO rol_roles (rol_id, rol_name)
VALUES (gen_random_uuid(), 'ADMIN'),
       (gen_random_uuid(), 'FREELANCER'),
       (gen_random_uuid(), 'CONTRACTOR')
RETURNING *;

COMMIT;
