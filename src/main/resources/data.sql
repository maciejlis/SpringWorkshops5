INSERT INTO address (id,street, city, country) VALUES
(3, 'Koszykowa 86', 'Warszawa', 'Polska'),
(4, 'R. Gen. Garcia Rosado 25 3º', 'Lizbona', 'Portugalia');

INSERT INTO person (id, name, lastname, birthdate, gender, address_id) VALUES
(3, 'Jan', 'Kowalski', '1995-11-10', 'MALE', 3),
(4, 'Anna', 'Nowak', '1997-01-23', 'FEMALE', 4);
