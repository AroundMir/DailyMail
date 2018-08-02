create database 'lportal.gdb' page_size 8192 user 'sysdba' password 'masterkey';
connect 'lportal.gdb' user 'sysdba' password 'masterkey';
create table article (articleId int64 not null primary key,authorId int64,name varchar(75),text_ varchar(75),date_ timestamp,status varchar(75),editorComment varchar(75));
create table dailymail_Articles_Reviews (articleId int64 not null,reviewId int64 not null,primary key (articleId, reviewId));
create table review (reviewId int64 not null primary key,reviewerId int64,imgUrl varchar(75),name varchar(75),text_ varchar(75),date_ timestamp);
