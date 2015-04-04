USE CRM_UAT

IF NOT EXISTS (SELECT * FROM sys.tables
WHERE name = N'Professions' AND type = 'U')
  BEGIN
    create table Professions (
      ID int IDENTITY(1,1) PRIMARY KEY,
      Description nvarchar(50) not null);
  END;

IF NOT EXISTS (SELECT * FROM sys.tables
WHERE name = N'TaxOffices' AND type = 'U')
  BEGIN
    create table TaxOffices (
      ID int IDENTITY(1,1) PRIMARY KEY,
      Code int not null,
      Description nvarchar(50) not null);
  END;

IF NOT EXISTS (SELECT * FROM sys.tables
WHERE name = N'Contacts' AND type = 'U')
  BEGIN
    CREATE TABLE Contacts (
      ID int IDENTITY(1000000,1) PRIMARY KEY,
      LastName nvarchar(50) NOT NULL,
      FirstName nvarchar(50),
      isPerson smallint,
      isAccount smallint,
      isCustomer smallint,
      isLead smallint,
      isSupplier smallint,
      isCompetitor smallint,
      isPartner smallint,
      isEmployee smallint,
      ProfessionID int FOREIGN KEY REFERENCES Professions(ID),
      TIN int,
      TaxOfficeID int FOREIGN KEY REFERENCES TaxOffices(ID),
      MaritalStatus smallint,
      BirthDate datetime,
      isActive smallint,
      ActivationDate datetime not null default getdate(),
      DeactivationDate datetime,
      Sex smallint,
      Notes nvarchar(255));
  END;

IF NOT EXISTS (SELECT * FROM sys.tables
WHERE name = N'RelativeContacts' AND type = 'U')
  BEGIN
    create table RelativeContacts (
      ID int identity (1,1) primary key,
      ParentContactID int foreign key references Contacts(ID) not null,
      ChildContactID int foreign key references Contacts(ID) not null);
  END;

IF NOT EXISTS (SELECT * FROM sys.tables
WHERE name = N'Countries' AND type = 'U')
  BEGIN
    create table Countries (
      ID int IDENTITY(1,1) PRIMARY KEY,
      Description nvarchar(50) not null);
  END;

IF NOT EXISTS (SELECT * FROM sys.tables
WHERE name = N'Prefectures' AND type = 'U')
  BEGIN
    create table Prefectures (
      ID int IDENTITY(1,1) PRIMARY KEY,
      Description nvarchar(50) not null,
      CountryID int foreign key References Countries(ID) not null);
  END;

IF NOT EXISTS (SELECT * FROM sys.tables
WHERE name = N'ContactAddresses' AND type = 'U')
  BEGIN
    create table ContactAddresses (
      ID int identity(1,1) primary KEY,
      ContactID int foreign key references Contacts(ID) not null,
      Address nvarchar(255),
      StreetNo int,
      PostalCode int,
      City nvarchar(255),
      PrefectureID int FOREIGN KEY REFERENCES Prefectures(ID),
      CountryID int FOREIGN KEY REFERENCES Countries(ID));
  END;

IF NOT EXISTS (SELECT * FROM sys.tables
WHERE name = N'PhoneTypes' AND type = 'U')
  BEGIN
    create table PhoneTypes (
      ID int IDENTITY(1,1) PRIMARY KEY,
      Description nvarchar(20) not null);
  END;

IF NOT EXISTS (SELECT * FROM sys.tables
WHERE name = N'ContactPhones' AND type = 'U')
  BEGIN
    create table ContactPhones (
      ID int identity(1,1) primary key,
      ContactID int foreign key references Contacts(ID) not null,
      PhoneTypeID int FOREIGN KEY REFERENCES PhoneTypes(ID),
      Phone nvarchar(10));
  END;

IF NOT EXISTS (SELECT * FROM sys.tables
WHERE name = N'ContactEmails' AND type = 'U')
  BEGIN
    create table ContactEmails (
      ID int identity(1,1) primary key,
      ContactID int foreign key references Contacts(ID) not null,
      Email nvarchar(100));
  END;

IF NOT EXISTS (SELECT * FROM sys.tables
WHERE name = N'ContactWebSites' AND type = 'U')
  BEGIN
    create table ContactWebSites (
      ID int identity(1,1) primary key,
      ContactID int foreign key references Contacts(ID) not null,
      WebSite nvarchar(255));
  END;

IF NOT EXISTS (SELECT * FROM sys.tables
WHERE name = N'Users' AND type = 'U')
  BEGIN
    create table Users (
      ID int IDENTITY(1,1) Primary key,
      Username nvarchar(50) not null unique,
      Password nvarchar(255) not null unique,
      ContactID int Foreign key references Contacts(ID) not null);
  END;

IF NOT EXISTS (SELECT * FROM sys.tables
WHERE name = N'ActivityTypes' AND type = 'U')
  BEGIN
    create table ActivityTypes (
      ID int IDENTITY(1,1) PRIMARY KEY,
      Description nvarchar(50) not null);
  END;

IF NOT EXISTS (SELECT * FROM sys.tables
WHERE name = N'ActivitySubjects' AND type = 'U')
  BEGIN
    create table ActivitySubjects (
      ID int IDENTITY(1,1) PRIMARY KEY,
      Description nvarchar(255) not null,
      ActivityTypeID int Foreign key references ActivityTypes(ID) not null);
  END;

IF NOT EXISTS (SELECT * FROM sys.tables
WHERE name = N'Activities' AND type = 'U')
  BEGIN
    create table Activities (
      ID int IDENTITY(1,1) PRIMARY KEY,
      ActivityTypeID int Foreign key REFERENCES ActivityTypes(ID) not null,
      SubjectID int Foreign key References ActivitySubjects(ID) not null,
      Description nvarchar(100),
      Notes nvarchar(255),
      OwnerID int foreign key references Users(ID) not null,
      CreatorID int foreign key references Users(ID) not null,
      ContactID int Foreign Key References Contacts(ID) not null,
      StartDate datetime not null default getdate(),
      EndDate datetime);
  END;

IF NOT EXISTS (SELECT * FROM sys.tables
WHERE name = N'ActivityHistory' AND type = 'U')
  BEGIN
    create table ActivityHistory (
      ID int IDENTITY(1,1) PRIMARY KEY,
      ActivityID int foreign key references Activities(ID) not null,
      OwnerTimeStamp datetime not null default getdate(),
      OwnerID int foreign key references Users(ID) not null);
  END;

IF NOT EXISTS (SELECT * FROM sys.tables
WHERE name = N'ContactActivityHistory' AND type = 'U')
  BEGIN
    create table ContactActivityHistory (
      ID int IDENTITY(1,1) PRIMARY KEY,
      ContactID int foreign key references Contacts(ID) not null,
      ActivityID int foreign key references Activities(ID) not null);
  END;