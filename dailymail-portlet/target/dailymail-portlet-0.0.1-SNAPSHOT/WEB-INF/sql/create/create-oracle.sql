drop user &1 cascade;
create user &1 identified by &2;
grant connect,resource to &1;
connect &1/&2;
set define off;

create table article (
	articleId number(30,0) not null primary key,
	authorId number(30,0),
	name VARCHAR2(75 CHAR) null,
	text_ VARCHAR2(75 CHAR) null,
	date_ timestamp null,
	status VARCHAR2(75 CHAR) null,
	editorComment VARCHAR2(75 CHAR) null
);

create table dailymail_Articles_Reviews (
	articleId number(30,0) not null,
	reviewId number(30,0) not null,
	primary key (articleId, reviewId)
);

create table review (
	reviewId number(30,0) not null primary key,
	reviewerId number(30,0),
	imgUrl VARCHAR2(75 CHAR) null,
	name VARCHAR2(75 CHAR) null,
	text_ VARCHAR2(75 CHAR) null,
	date_ timestamp null
);


create index IX_7CE58ED8 on dailymail_Article_Reviews (articleId);
create index IX_37CE4FCB on dailymail_Article_Reviews (id_);

create index IX_79FC5C73 on dailymail_Articles_Reviews (articleId);
create index IX_CB0A2DA6 on dailymail_Articles_Reviews (id_);
create index IX_788CCE35 on dailymail_Articles_Reviews (reviewId);

create index IX_7D1A6C43 on review (articleId);



quit