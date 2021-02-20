--------------------------
BEGIN;

INSERT INTO usr_users(usr_id, usr_name, usr_email, usr_password, rol_id, usr_avatar_link)
VALUES (gen_random_uuid(), 'Ademir da Silva', 'adm@email.com', '123456',
        (SELECT rol_id from rol_roles WHERE rol_name = 'ADMIN'),
        'https://orkutudo.com/imagens/grandes/o-adm-esta-dormindo-2017-09-27.jpg')
RETURNING *;

INSERT INTO adm_admins(adm_id)
VALUES ((SELECT usr_id from usr_users where usr_name = 'Ademir da Silva'))
RETURNING *;

COMMIT;
--------------------------
BEGIN;

INSERT INTO usr_users(usr_id, usr_name, usr_email, usr_password, rol_id, usr_avatar_link)
VALUES (gen_random_uuid(), 'Arthur Benozzati', 'arthur@email.com', 'admin123',
        (SELECT rol_id from rol_roles WHERE rol_name = 'ADMIN'),
        'https://i.pinimg.com/736x/33/88/49/338849a7f2e6f7d6c492fdf3beec4271.jpg')
RETURNING *;

INSERT INTO adm_admins(adm_id)
VALUES ((SELECT usr_id from usr_users where usr_name = 'Arthur Benozzati'))
RETURNING *;

COMMIT;
--------------------------
--------------------------
BEGIN;

INSERT INTO usr_users(usr_id, usr_name, usr_email, usr_password, rol_id, usr_avatar_link)
VALUES (gen_random_uuid(), 'Fausto Silva', 'fausto@email.com', 'SenhaF0rte',
        (SELECT rol_id from rol_roles WHERE rol_name = 'ADMIN'),
        'https://cdn.mensagenscomamor.com/content/images/m000532523.jpg?v=1')
RETURNING *;

INSERT INTO adm_admins(adm_id)
VALUES ((SELECT usr_id from usr_users where usr_name = 'Fausto Silva'))
RETURNING *;

COMMIT;
--------------------------
