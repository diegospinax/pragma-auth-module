CREATE TABLE "users"(
    id BIGSERIAL,
    name varchar(255) NOT NULL,
    lastname varchar(255) NOT NULL,
    date_birth date NOT NULL,
    address text NOT NULL,
    phone_number varchar(10) NOT NULL CHECK (phone_number ~ '^[0-9]{10}$'),
    email text NOT NULL UNIQUE,
    salary numeric(10, 2) NOT NULL CHECK ( salary > 0.00 AND salary < 15000000.00),
    id_role bigint not null,

    primary key(id),
    constraint fk_users_role foreign key (id_role) references roles(id)
);