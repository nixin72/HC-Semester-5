
-- --------------------------------------------------
-- Entity Designer DDL Script for SQL Server 2005, 2008, 2012 and Azure
-- --------------------------------------------------
-- Date Created: 09/28/2017 13:09:15
-- Generated from EDMX file: H:\Semester 5\Development Project\assignments\pdumaresq_E50_A07\MCVCourseCatalog\MCVCourseCatalog\Models\CourseCatalog.edmx
-- --------------------------------------------------

SET QUOTED_IDENTIFIER OFF;
GO
USE [pdumaresqCourseCatalog];
GO
IF SCHEMA_ID(N'dbo') IS NULL EXECUTE(N'CREATE SCHEMA [dbo]');
GO

-- --------------------------------------------------
-- Dropping existing FOREIGN KEY constraints
-- --------------------------------------------------


-- --------------------------------------------------
-- Dropping existing tables
-- --------------------------------------------------


-- --------------------------------------------------
-- Creating all tables
-- --------------------------------------------------

-- Creating table 'Students'
CREATE TABLE [dbo].[Students] (
    [ID] int IDENTITY(1,1) NOT NULL,
    [FirstName] nvarchar(max)  NOT NULL,
    [LastName] nvarchar(max)  NOT NULL,
    [DateOfBirth] datetime  NOT NULL
);
GO

-- Creating table 'StudentAddresses'
CREATE TABLE [dbo].[StudentAddresses] (
    [ID] int IDENTITY(1,1) NOT NULL,
    [StreetAddress] nvarchar(max)  NOT NULL,
    [City] nvarchar(max)  NOT NULL,
    [State] nvarchar(max)  NOT NULL,
    [PostalCode] nvarchar(max)  NOT NULL,
    [Student_ID] int  NOT NULL
);
GO

-- Creating table 'Teachers'
CREATE TABLE [dbo].[Teachers] (
    [ID] int IDENTITY(1,1) NOT NULL,
    [FirstName] nvarchar(max)  NOT NULL,
    [LastName] nvarchar(max)  NOT NULL
);
GO

-- Creating table 'Courses'
CREATE TABLE [dbo].[Courses] (
    [ID] int IDENTITY(1,1) NOT NULL,
    [Name] nvarchar(max)  NOT NULL,
    [TeacherID] int  NOT NULL
);
GO

-- Creating table 'CourseStudent'
CREATE TABLE [dbo].[CourseStudent] (
    [Courses_ID] int  NOT NULL,
    [Students_ID] int  NOT NULL
);
GO

-- --------------------------------------------------
-- Creating all PRIMARY KEY constraints
-- --------------------------------------------------

-- Creating primary key on [ID] in table 'Students'
ALTER TABLE [dbo].[Students]
ADD CONSTRAINT [PK_Students]
    PRIMARY KEY CLUSTERED ([ID] ASC);
GO

-- Creating primary key on [ID] in table 'StudentAddresses'
ALTER TABLE [dbo].[StudentAddresses]
ADD CONSTRAINT [PK_StudentAddresses]
    PRIMARY KEY CLUSTERED ([ID] ASC);
GO

-- Creating primary key on [ID] in table 'Teachers'
ALTER TABLE [dbo].[Teachers]
ADD CONSTRAINT [PK_Teachers]
    PRIMARY KEY CLUSTERED ([ID] ASC);
GO

-- Creating primary key on [ID] in table 'Courses'
ALTER TABLE [dbo].[Courses]
ADD CONSTRAINT [PK_Courses]
    PRIMARY KEY CLUSTERED ([ID] ASC);
GO

-- Creating primary key on [Courses_ID], [Students_ID] in table 'CourseStudent'
ALTER TABLE [dbo].[CourseStudent]
ADD CONSTRAINT [PK_CourseStudent]
    PRIMARY KEY CLUSTERED ([Courses_ID], [Students_ID] ASC);
GO

-- --------------------------------------------------
-- Creating all FOREIGN KEY constraints
-- --------------------------------------------------

-- Creating foreign key on [Student_ID] in table 'StudentAddresses'
ALTER TABLE [dbo].[StudentAddresses]
ADD CONSTRAINT [FK_StudentStudentAddress]
    FOREIGN KEY ([Student_ID])
    REFERENCES [dbo].[Students]
        ([ID])
    ON DELETE NO ACTION ON UPDATE NO ACTION;
GO

-- Creating non-clustered index for FOREIGN KEY 'FK_StudentStudentAddress'
CREATE INDEX [IX_FK_StudentStudentAddress]
ON [dbo].[StudentAddresses]
    ([Student_ID]);
GO

-- Creating foreign key on [TeacherID] in table 'Courses'
ALTER TABLE [dbo].[Courses]
ADD CONSTRAINT [FK_TeacherCourse]
    FOREIGN KEY ([TeacherID])
    REFERENCES [dbo].[Teachers]
        ([ID])
    ON DELETE NO ACTION ON UPDATE NO ACTION;
GO

-- Creating non-clustered index for FOREIGN KEY 'FK_TeacherCourse'
CREATE INDEX [IX_FK_TeacherCourse]
ON [dbo].[Courses]
    ([TeacherID]);
GO

-- Creating foreign key on [Courses_ID] in table 'CourseStudent'
ALTER TABLE [dbo].[CourseStudent]
ADD CONSTRAINT [FK_CourseStudent_Course]
    FOREIGN KEY ([Courses_ID])
    REFERENCES [dbo].[Courses]
        ([ID])
    ON DELETE NO ACTION ON UPDATE NO ACTION;
GO

-- Creating foreign key on [Students_ID] in table 'CourseStudent'
ALTER TABLE [dbo].[CourseStudent]
ADD CONSTRAINT [FK_CourseStudent_Student]
    FOREIGN KEY ([Students_ID])
    REFERENCES [dbo].[Students]
        ([ID])
    ON DELETE NO ACTION ON UPDATE NO ACTION;
GO

-- Creating non-clustered index for FOREIGN KEY 'FK_CourseStudent_Student'
CREATE INDEX [IX_FK_CourseStudent_Student]
ON [dbo].[CourseStudent]
    ([Students_ID]);
GO

-- --------------------------------------------------
-- Script has ended
-- --------------------------------------------------