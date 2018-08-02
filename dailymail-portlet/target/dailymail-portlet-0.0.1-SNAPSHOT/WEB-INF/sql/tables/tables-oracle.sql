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
