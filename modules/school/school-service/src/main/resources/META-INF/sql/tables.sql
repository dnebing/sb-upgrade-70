create table SCH_Course (
	courseId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	courseCode VARCHAR(75) null,
	name VARCHAR(400) null,
	description STRING null,
	level INTEGER,
	department VARCHAR(75) null,
	prereqs STRING null
);