database sysmaster;
drop database lportal;
create database lportal WITH LOG;

create procedure 'lportal'.isnull(test_string varchar)
returning boolean;
IF test_string IS NULL THEN
	RETURN 't';
ELSE
	RETURN 'f';
END IF
end procedure;


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


create index IX_7CE58ED8 on dailymail_Article_Reviews (articleId);
create index IX_37CE4FCB on dailymail_Article_Reviews (id_);

create index IX_79FC5C73 on dailymail_Articles_Reviews (articleId);
create index IX_CB0A2DA6 on dailymail_Articles_Reviews (id_);
create index IX_788CCE35 on dailymail_Articles_Reviews (reviewId);

create index IX_7D1A6C43 on review (articleId);


