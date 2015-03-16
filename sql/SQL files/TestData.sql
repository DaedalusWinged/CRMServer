insert into Countries (Description)
values ('Greece'),('Elladistan'),('Kourdistan');

insert into Prefectures (Description, CountryID)
values ('Attikh', 1), ('Argolida', 1), ('Achaia', 1);

insert into PhoneTypes (Description)
values ('Home'), ('Mobile'), ('Work'), ('Fax');

insert into Professions (Description)
values ('Freelancer'), ('Dimosio 4 ever'), ('Idiotikos malakas');

insert into TaxOffices (Code, Description)
values (1010, 'Athinwn'), (1011, 'Axarnwn'), (1012, 'Naupliou'), (1013, 'Argous');

insert into ActivityTypes (Description)
values ('Call'), ('E-mail'), ('Fax'), ('Mail');

insert into ActivitySubjects (Description, ActivityTypeID)
values ('Inbound Call', 1), ('Outbound Call', 1);

insert into Contacts (Lastname, Firstname, Address, City, CountryID, PrefectureID, PhoneType1ID, Phone1, isPerson, isCustomer, ProfessionID, isActive)
values ('Tarifas', 'Mitsos', 'Taksitzidwn 12', 'Piatsa', 1, 1, 1, '210905487234', 1, 1, 2, 1);