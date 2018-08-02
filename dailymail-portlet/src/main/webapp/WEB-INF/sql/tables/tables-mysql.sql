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
