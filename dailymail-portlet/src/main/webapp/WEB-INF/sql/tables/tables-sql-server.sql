create table article (
	articleId bigint not null primary key,
	authorId bigint,
	name nvarchar(75) null,
	text_ nvarchar(75) null,
	date_ datetime null,
	status nvarchar(75) null,
	editorComment nvarchar(75) null
);

create table dailymail_Articles_Reviews (
	articleId bigint not null,
	reviewId bigint not null,
	primary key (articleId, reviewId)
);

create table review (
	reviewId bigint not null primary key,
	reviewerId bigint,
	imgUrl nvarchar(75) null,
	name nvarchar(75) null,
	text_ nvarchar(75) null,
	date_ datetime null
);
