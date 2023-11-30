drop schema if exists Manager cascade;
create schema if not exists Manager;

create table Manager.Info (
                            Id SERIAL PRIMARY KEY,
                            Email varchar(50) NOT NULL,
                            Password varchar(50) NOT NULL,
                            Site varchar(50)
);