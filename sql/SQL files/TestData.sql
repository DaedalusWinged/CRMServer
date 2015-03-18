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

insert into ContactAddresses (ContactID, Address, StreetNo, PostalCode, City, PrefectureID, CountryID)
    values (1000000, 'Taksitzidwn', 11, 12345, 'Athina', 1, 1),
      (1000001, 'Gatiwn', 2, 23456, 'Nafplio', 2, 1),
      (1000002, 'Gatiwn', 3, 23456, 'Nafplio', 2, 1);

insert into ContactPhones(ContactID, PhoneTypeID, Phone)
    values (100000, 1, 2101234567);

insert into Contacts (Lastname, Firstname, isPerson, isCustomer, ProfessionID, isActive)
  values ('Tarifas', 'Mitsos', 1, 1, 2, 1),
    ('Tsirkoulakis', 'Tsirkos', 1, 0, 1, 1),
    ('Giakovakis', 'Giakovas', 1, 1, 1, 0);