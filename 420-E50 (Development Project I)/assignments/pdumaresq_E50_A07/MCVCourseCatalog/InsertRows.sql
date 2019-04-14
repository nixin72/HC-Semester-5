USE [pdumaresqCourseCatalog]
GO

INSERT INTO [dbo].[Teachers] (
	[FirstName], [LastName]
) VALUES (
	'Richard','Chan'
) GO

INSERT INTO [dbo].[Teachers] (
	[FirstName], [LastName]
) VALUES (
	'Christopher','Fox'
) GO

INSERT INTO [dbo].[Teachers] (
	[FirstName], [LastName]
) VALUES (
	'Ronald', 'Patterson'
) GO








INSERT INTO [dbo].Courses (
	[Name], [TeacherID]
) VALUES (
	'Development Project I', (
		SELECT ID 
		FROM [dbo].Teachers 
		WHERE LastName = 'Chan' 
		AND FirstName = 'Richard'
	)
) GO

INSERT INTO [dbo].Courses (
	[Name], [TeacherID]
) VALUES (
	'Systems III', (
		SELECT ID 
		FROM [dbo].Teachers 
		WHERE LastName = 'Fox' 
		AND FirstName = 'Christopher'
	)
) GO

INSERT INTO [dbo].Courses (
	[Name], [TeacherID]
) VALUES (
	'Programming V', (
		SELECT ID 
		FROM [dbo].Teachers 
		WHERE LastName = 'Patterson' 
		AND FirstName = 'Ronald'
	)
) GO