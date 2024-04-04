create table if not exists postings
(
    id      bigint auto_increment,
    title   text,
    content text,
    status  enum ('DRAFT', 'PUBLISHED', 'ARCHIVED') not null default 'DRAFT',
    primary key (id)
);
