create type postingstatus as enum ('DRAFT', 'PUBLISHED', 'ARCHIVED');

create table if not exists postings
(
    id      bigserial,
    title   text,
    content text,
    status  postingstatus not null default 'DRAFT',
    primary key (id)
);

insert into postings (title, content, status) values ('First Post', 'This is my first post', 'DRAFT');