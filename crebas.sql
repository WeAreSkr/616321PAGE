/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/9/13 11:51:57                           */
/*==============================================================*/


drop table if exists COMMENTS;

drop table if exists ClassMate;

drop table if exists EVENT;

drop table if exists IMAGES;

drop table if exists PAGE;

/*==============================================================*/
/* Table: COMMENTS                                              */
/*==============================================================*/
create table COMMENTS
(
   COMM_ID              bigint not null,
   STU_NMB              numeric(8,0),
   PAGE_ID              bigint,
   MSG                  varchar(1024),
   primary key (COMM_ID)
);

/*==============================================================*/
/* Table: ClassMate                                             */
/*==============================================================*/
create table ClassMate
(
   STU_NMB              numeric(8,0) not null,
   PAGE_ID              bigint not null,
   NAME                 varchar(6),
   NICKNAME             varchar(12),
   PWD                  varchar(16),
   DSC                  varchar(1024),
   AUTHORITY            int,
   HEAD_IMG             varchar(1024),
   primary key (STU_NMB)
);

/*==============================================================*/
/* Table: EVENT                                                 */
/*==============================================================*/
create table EVENT
(
   CODE                 int not null,
   TITLE                varchar(1024),
   CONTENT              bigint,
   IMGAGES_PATH         varchar(1024),
   EDITOR               varchar(12),
   DT                   bigint,
   STU_NMB              numeric(8,0),
   ISPASS               int,
   primary key (CODE)
);

/*==============================================================*/
/* Table: IMAGES                                                */
/*==============================================================*/
create table IMAGES
(
   PIC_PATH             varchar(1024) not null,
   DSC                  varchar(1024),
   GRO                  int,
   DT                   bigint,
   primary key (PIC_PATH)
);

/*==============================================================*/
/* Table: PAGE                                                  */
/*==============================================================*/
create table PAGE
(
   PAGE_ID              bigint not null,
   MODEl                int,
   DSC                  varchar(1024),
   BIRTHDAY             bigint,
   primary key (PAGE_ID)
);

alter table COMMENTS add constraint FK_include foreign key (PAGE_ID)
      references PAGE (PAGE_ID) on delete restrict on update restrict;

alter table COMMENTS add constraint FK_send foreign key (STU_NMB)
      references ClassMate (STU_NMB) on delete restrict on update restrict;

alter table ClassMate add constraint FK_ship2 foreign key (PAGE_ID)
      references PAGE (PAGE_ID) on delete restrict on update restrict;

alter table EVENT add constraint FK_add foreign key (STU_NMB)
      references ClassMate (STU_NMB) on delete restrict on update restrict;

