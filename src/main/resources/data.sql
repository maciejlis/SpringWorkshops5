INSERT INTO address (id,street, city, country) VALUES
(3, 'Koszykowa 86', 'Warszawa', 'Polska'),
(4, 'R. Gen. Garcia Rosado 25 3º', 'Lizbona', 'Portugalia');

INSERT INTO person (id, name, lastname, birthdate, gender, address_id) VALUES
(3, 'Jan', 'Kowalski', '1995-11-10', 'MALE', 3),
(4, 'Anna', 'Nowak', '1997-01-23', 'FEMALE', 4);

INSERT INTO users (id, username, password)
values (1, 'user',
        '$2a$11$Orsn1F3rifcZhO7mqJnJXuYeRIKZ/8u58Ns4js6Nr5HpDJ4zpgfki'
        );
