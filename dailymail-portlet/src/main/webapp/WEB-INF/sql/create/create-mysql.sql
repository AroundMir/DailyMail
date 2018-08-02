drop database if exists lportal;
create database lportal character set utf8;
use lportal;

create table article (
	articleId bigint not null primary key,
	authorId bigint,
	name varchar(75) null,
	text_ varchar(75) null,
	date_ datetime null,
	status varchar(75) null,
	editorComment varchar(75) null
) engine InnoDB;

create table dailymail_Articles_Reviews (
	articleId bigint not null,
	reviewId bigint not null,
	primary key (articleId, reviewId)
) engine InnoDB;

create table review (
	reviewId bigint not null primary key,
	reviewerId bigint,
	imgUrl varchar(75) null,
	name varchar(75) null,
	text_ varchar(75) null,
	date_ datetime null
) engine InnoDB;


create index IX_7CE58ED8 on dailymail_Article_Reviews (articleId);
create index IX_37CE4FCB on dailymail_Article_Reviews (id_);

create index IX_79FC5C73 on dailymail_Articles_Reviews (articleId);
create index IX_CB0A2DA6 on dailymail_Articles_Reviews (id_);
create index IX_788CCE35 on dailymail_Articles_Reviews (reviewId);

create index IX_7D1A6C43 on review (articleId);


