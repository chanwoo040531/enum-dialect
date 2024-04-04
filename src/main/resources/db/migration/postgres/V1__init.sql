create type posting_status as enum ('DRAFT', 'PUBLISHED', 'ARCHIVED');

create table if not exists postings
(
    id      bigint,
    title   text,
    content text,
    status  posting_status not null default 'DRAFT',
    primary key (id)
);