sudo -u postgres psql
create database swingydb;
create user swingbyyesmine with encrypted password 'mypass';
grant all privileges on database swingydb to swingbyyesmine;
\c swingydb
CREATE TABLE IF NOT EXISTS heroes (
                      id serial,
                      hero_name VARCHAR ( 10 ) NOT NULL,
                      hero_class VARCHAR ( 50 ) NOT NULL,
                      xp int NOT NULL,
                      artefact VARCHAR ( 50 ) NOT NULL,
                    constraint Heroes_pkey primary key (id)
);
