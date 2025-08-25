create table "roles" (
    id bigserial,
    name varchar(50) unique not null,
    description text not null,

    primary key (id)
);