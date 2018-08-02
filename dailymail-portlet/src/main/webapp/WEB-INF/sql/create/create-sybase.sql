use master
exec sp_dboption 'lportal', 'allow nulls by default' , true
go

exec sp_dboption 'lportal', 'select into/bulkcopy/pllsort' , true
go

use lportal

create table article (
	articleId decimal(20,0) not null primary key,
	authorId decimal(20,0),
	name varchar(75) null,
	text_ varchar(75) null,
	date_ datetime null,
	status varchar(75) null,
	editorComment varchar(75) null
)
go

create table dailymail_Articles_Reviews (
	articleId decimal(20,0) not null,
	reviewId decimal(20,0) not null,
	primary key (articleId, reviewId)
)
go

create table review (
	reviewId decimal(20,0) not null primary key,
	reviewerId decimal(20,0),
	imgUrl varchar(75) null,
	name varchar(75) null,
	text_ varchar(75) null,
	date_ datetime null
)
go




