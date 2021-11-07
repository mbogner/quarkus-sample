create sequence person_id_seq start 1 increment 1;

create table persons
(
    id     bigint not null default nextval('person_id_seq')
        constraint persons_pkey primary key,
    birth  date not null,
    name   varchar(255) not null,
    status varchar(32) not null
);

alter table persons
    owner to sample;

