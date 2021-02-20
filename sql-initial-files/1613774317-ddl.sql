CREATE TABLE rol_roles
(
    rol_id   uuid primary key,
    rol_name varchar(255) not null,
    constraint rol_rol_name_uk unique (rol_name)
);

CREATE TABLE usr_users
(
    usr_id          uuid primary key,
    rol_id          uuid         not null,
    usr_name        varchar(255) not null,
    usr_email       varchar(255) not null,
    usr_password    varchar(255) not null,
    usr_avatar_link text,
    constraint usr_user_email_uk unique (usr_email),
    constraint usr_rol_fk foreign key (rol_id) references rol_roles (rol_id)
);

CREATE TABLE adm_admins
(
    adm_id uuid primary key,
    constraint adm_usr_fk foreign key (adm_id) references usr_users (usr_id)
);

CREATE TABLE com_companies
(
    com_id   uuid primary key,
    com_cnpj varchar(255) not null,
    com_name varchar(255) not null,
    constraint com_contractor_cnpj_uk unique (com_cnpj),
    constraint com_usr_fk foreign key (com_id) references usr_users (usr_id)
);

CREATE TABLE fre_freelancers
(
    fre_id             uuid primary key,
    fre_bio            text,
    fre_price_per_hour decimal(5, 2) not null,
    constraint fre_usr_fk foreign key (fre_id) references usr_users (usr_id)
);

CREATE TABLE res_resumes
(
    res_id                      uuid primary key,
    fre_id                      uuid not null,
    res_linkedin_link           text,
    res_professional_experience text,
    res_academic_experience     text,
    res_skills                  text,
    constraint res_resume_fre_id_uk unique (fre_id),
    constraint res_fre_fk foreign key (fre_id) references fre_freelancers (fre_id)
);

CREATE TABLE job_jobs
(
    job_id          uuid primary key,
    com_id          uuid not null,
    job_title       text not null,
    job_description text,
    job_is_open     boolean default true,
    constraint job_com_fk foreign key (com_id) references com_companies (com_id)
);

CREATE TABLE jap_job_applications
(
    job_id uuid not null,
    fre_id uuid not null,
    constraint jap_pk primary key (job_id, fre_id),
    constraint jap_job_fk foreign key (job_id) references job_jobs (job_id),
    constraint jap_fre_fk foreign key (fre_id) references fre_freelancers (fre_id)
);
