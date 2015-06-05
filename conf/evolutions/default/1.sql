# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table APPLICANTS (
  id                        integer not null,
  name                      varchar(255),
  date_interview            timestamp,
  date_addition             timestamp not null,
  constraint pk_APPLICANTS primary key (id))
;

create table category (
  id                        bigint not null,
  title                     varchar(255),
  constraint pk_category primary key (id))
;

create table contact (
  id                        integer not null,
  type_contact_id           integer,
  owner_id                  integer,
  value                     varchar(255),
  constraint pk_contact primary key (id))
;

create table job (
  id                        bigint not null,
  title                     varchar(255),
  category_id               bigint,
  constraint pk_job primary key (id))
;

create table rating (
  id                        integer not null,
  skill_id                  integer,
  owner_id                  integer,
  value                     varchar(50) not null,
  constraint pk_rating primary key (id))
;

create table skill (
  id                        integer not null,
  name                      varchar(50) not null,
  constraint pk_skill primary key (id))
;

create table type_contact (
  id                        integer not null,
  name                      varchar(255),
  constraint pk_type_contact primary key (id))
;

create sequence APPLICANTS_seq;

create sequence category_seq;

create sequence contact_seq;

create sequence job_seq;

create sequence rating_seq;

create sequence skill_seq;

create sequence type_contact_seq;

alter table contact add constraint fk_contact_typeContact_1 foreign key (type_contact_id) references type_contact (id) on delete restrict on update restrict;
create index ix_contact_typeContact_1 on contact (type_contact_id);
alter table contact add constraint fk_contact_owner_2 foreign key (owner_id) references APPLICANTS (id) on delete restrict on update restrict;
create index ix_contact_owner_2 on contact (owner_id);
alter table job add constraint fk_job_category_3 foreign key (category_id) references category (id) on delete restrict on update restrict;
create index ix_job_category_3 on job (category_id);
alter table rating add constraint fk_rating_skill_4 foreign key (skill_id) references skill (id) on delete restrict on update restrict;
create index ix_rating_skill_4 on rating (skill_id);
alter table rating add constraint fk_rating_owner_5 foreign key (owner_id) references APPLICANTS (id) on delete restrict on update restrict;
create index ix_rating_owner_5 on rating (owner_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists APPLICANTS;

drop table if exists category;

drop table if exists contact;

drop table if exists job;

drop table if exists rating;

drop table if exists skill;

drop table if exists type_contact;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists APPLICANTS_seq;

drop sequence if exists category_seq;

drop sequence if exists contact_seq;

drop sequence if exists job_seq;

drop sequence if exists rating_seq;

drop sequence if exists skill_seq;

drop sequence if exists type_contact_seq;

