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
