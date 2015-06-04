# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table APPLICANTS (
  id                        integer auto_increment not null,
  date_interview            datetime,
  date_addition             datetime not null,
  constraint pk_APPLICANTS primary key (id))
;

create table category (
  id                        bigint auto_increment not null,
  title                     varchar(255),
  constraint pk_category primary key (id))
;

create table contact (
  ID_CONTACT                integer(4) auto_increment not null,
  type_contact_id           integer,
  owner_id                  integer,
  value                     varchar(255),
  constraint pk_contact primary key (ID_CONTACT))
;

create table job (
  id                        bigint auto_increment not null,
  title                     varchar(255),
  category_id               bigint,
  constraint pk_job primary key (id))
;

create table rating (
  id                        integer auto_increment not null,
  skill_id                  integer,
  owner_id                  integer,
  value                     varchar(50) not null,
  constraint pk_rating primary key (id))
;

create table skill (
  id                        integer auto_increment not null,
  name                      varchar(50) not null,
  constraint pk_skill primary key (id))
;

create table type_contact (
  id                        integer auto_increment not null,
  name                      varchar(255),
  constraint pk_type_contact primary key (id))
;

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

SET FOREIGN_KEY_CHECKS=0;

drop table APPLICANTS;

drop table category;

drop table contact;

drop table job;

drop table rating;

drop table skill;

drop table type_contact;

SET FOREIGN_KEY_CHECKS=1;

