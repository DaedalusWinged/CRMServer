CREATE TABLE Contacts (
ID int IDENTITY(1,1) PRIMARY KEY,
ReferenceNo int(9) IDENTITY(100000000,1) not null,
LastName nvarchar(50) NOT NULL,
FirstName nvarchar(50),
Address nvarchar(255),
StreetNo int,
PostalCode int,
City nvarchar(255),
PrefectureID int FOREIGN KEY REFERENCES Prefectures(ID),
CountryID int FOREIGN KEY REFERENCES Countries(ID),
PhoneType1ID int FOREIGN KEY REFERENCES PhoneTypes(ID),
PhoneType2ID int FOREIGN KEY REFERENCES PhoneTypes(ID),
PhoneType3ID int FOREIGN KEY REFERENCES PhoneTypes(ID),
PhoneType4ID int FOREIGN KEY REFERENCES PhoneTypes(ID),
PhoneType5ID int FOREIGN KEY REFERENCES PhoneTypes(ID),
Phone1 nvarchar(10),
Phone2 nvarchar(10),
Phone3 nvarchar(10),
Phone4 nvarchar(10),
Phone5 nvarchar(10),
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
FathersName nvarchar(50),
SpouceName carchar(50),
MaritalStatus smallint,
BirthDate datetime,
isActive smallint,
ActivationDate datetime not null default getdate(),
DeactivationDate datetime,
Sex smallint,
Email1 nvarchar(100),
Email2 nvarchar(100),
WebSite nvarchar(255),
Notes nvarchar(255),
ContactImage image);

create table Prefectures (
ID int IDENTITY(1,1) PRIMARY KEY,
Description nvarchar(50) not null,
CountryID int foreign key References Countries(ID) not null);

create table Countries (
ID int IDENTITY(1,1) PRIMARY KEY,
Description nvarchar(50) not null);

create table PhoneTypes (
ID int IDENTITY(1,1) PRIMARY KEY,
Description nvarchar(20) not null);

create table Professions (
ID int IDENTITY(1,1) PRIMARY KEY,
Description nvarchar(50) not null);

create table TaxOffices (
ID int IDENTITY(1,1) PRIMARY KEY,
Code int not null,
Description nvarchar(50) not null);

create table Users (
ID int IDENTITY(1,1) Primary key,
Username nvarchar(50) not null unique,
Password nvarchar(255) not null unique,
ContactID int Foreign key references Contacts(ID) not null);

create table Activities (
ID int IDENTITY(1,1) PRIMARY KEY,
ReferenceNo int IDENTITY(311000000,1) not null,
ActivityTypeID int Foreign key REFERENCES ActivityTypes(ID) not null,
SubjectID int Foreign key References ActivitySubjects(ID) not null,
Description nvarchar(100),
Notes nvarchar(255),
OwnerID int foreign key references Users(ID) not null,
CreatorID int foreign key references Users(ID) not null,
ContactID int Foreign Key References Contacts(ID) not null,
StartDate datetime not null default getdate(),
EndDate datetime);

create table ActivityTypes (
ID int IDENTITY(1,1) PRIMARY KEY,
Description nvarchar(50) not null);

create table ActivitySubjects (
ID int IDENTITY(1,1) PRIMARY KEY,
Description nvarchar(255) not null,
ActivityTypeID int Foreign key references ActivityTypes(ID) not null);

create table ActivityHistory (
ID int IDENTITY(1,1) PRIMARY KEY,
ActivityID int foreign key references Activities(ID) not null;
OwnerTimeStamp datetime not null default getdate(),
OwnerID int foreign key references Activities(OwnerID) not null);

create table ContactActivityHistory (
ID int IDENTITY(1,1) PRIMARY KEY,
ContactID int foreign key references Contacts(ID) not null,
ActivityID int foreign key references Activities(ID) not null);