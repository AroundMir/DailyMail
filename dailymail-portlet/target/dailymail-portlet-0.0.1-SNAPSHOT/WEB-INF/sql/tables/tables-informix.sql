create table article (
	articleId int8 not null primary key,
	authorId int8,
	name varchar(75),
	text_ varchar(75),
	date_ datetime YEAR TO FRACTION,
	status varchar(75),
	editorComment varchar(75)
)
extent size 16 next size 16
lock mode row;

create table dailymail_Articles_Reviews (
	articleId int8 not null,
	reviewId int8 not null,
	primary key (articleId, reviewId)
)
extent size 16 next size 16
lock mode row;

create table review (
	reviewId int8 not null primary key,
	reviewerId int8,
	imgUrl varchar(75),
	name varchar(75),
	text_ varchar(75),
	date_ datetime YEAR TO FRACTION
)
extent size 16 next size 16
lock mode row;
