/* Populate tablas */
INSERT INTO characters (image, name, age, weight, history) VALUES('url1', 'Mickey', '20', '40.5', 'historia uno');
INSERT INTO characters (image, name, age, weight, history) VALUES('url2', 'Minnie', '19', '30.5','historia dos');
INSERT INTO characters (image, name, age, weight, history) VALUES('url2', 'Pluto', '10', '20.0','historia tres');
INSERT INTO characters (image, name, age, weight, history) VALUES('url4', 'Donald', '15', '15.8','historia cuatro');
INSERT INTO movies (image, name, create_at, score) VALUES('url1', 'las aventuras de mickey', '2015-01-02', '5');
INSERT INTO movies (image, name, create_at, score) VALUES('url2', 'la casa de minnie', '2018-10-10', '4');
INSERT INTO movies (image, name, create_at, score) VALUES('url3', 'donald y sus amigos', '2020-01-09', '3');
INSERT INTO movies (image, name, create_at, score) VALUES('url4', 'pluto espacial', '2022-05-01', '2');
INSERT INTO genres (name, image) VALUES('Comedia', 'url1');
INSERT INTO genres (name, image) VALUES('Romantica', 'url2');
INSERT INTO genres (name, image) VALUES('Aventura', 'url3');