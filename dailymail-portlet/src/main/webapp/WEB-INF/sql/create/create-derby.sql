drop database lportal;
create database lportal;
connect to lportal;
create table article (
	articleId bigint not null primary key,
	authorId bigint,
	name varchar(75),
	text_ varchar(75),
	date_ timestamp,
	status varchar(75),
	editorComment varchar(75)
);

create table dailymail_Articles_Reviews (
	articleId bigint not null,
	reviewId bigint not null,
	primary key (articleId, reviewId)
);

create table review (
	reviewId bigint not null primary key,
	reviewerId bigint,
	imgUrl varchar(75),
	name varchar(75),
	text_ varchar(75),
	date_ timestamp
);


create index IX_7CE58ED8 on dailymail_Article_Reviews (articleId);
create index IX_37CE4FCB on dailymail_Article_Reviews (id_);

create index IX_79FC5C73 on dailymail_Articles_Reviews (articleId);
create index IX_CB0A2DA6 on dailymail_Articles_Reviews (id_);
create index IX_788CCE35 on dailymail_Articles_Reviews (reviewId);

create index IX_7D1A6C43 on review (articleId);


