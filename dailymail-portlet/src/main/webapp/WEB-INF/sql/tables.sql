create table article (
	articleId LONG not null primary key,
	authorId LONG,
	name VARCHAR(75) null,
	text_ VARCHAR(75) null,
	date_ DATE null,
	status VARCHAR(75) null,
	editorComment VARCHAR(75) null
);

create table dailymail_Articles_Reviews (
	articleId LONG not null,
	reviewId LONG not null,
	primary key (articleId, reviewId)
);

create table review (
	reviewId LONG not null primary key,
	reviewerId LONG,
	imgUrl VARCHAR(75) null,
	name VARCHAR(75) null,
	text_ VARCHAR(75) null,
	date_ DATE null
);