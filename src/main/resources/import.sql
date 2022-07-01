INSERT INTO users (first_name, last_name, cpf,  birth_date, points, email, password) VALUES ('Tomas', 'Alric', '91933210826', '1999-08-21', 10, 'tomas@email.com', '$2a$10$wJhPy.7RXZkt8RgIAMMBXOIp71ISbW/5ddzu6jjAjbc0Jrp1AkGPW');
INSERT INTO users (first_name, last_name, cpf, birth_date, points, email, password) VALUES ('Felipe', 'Appio', '32879273960', '1984-03-15', 100, 'felipe@email.com', '$2a$10$wJhPy.7RXZkt8RgIAMMBXOIp71ISbW/5ddzu6jjAjbc0Jrp1AkGPW');
INSERT INTO users (first_name, last_name, cpf, birth_date, points, email, password) VALUES ('Vitória', 'Gonçalves',  '27724790809', '1984-12-28', 1000, 'vitoria@email.com', '$2a$10$wJhPy.7RXZkt8RgIAMMBXOIp71ISbW/5ddzu6jjAjbc0Jrp1AkGPW');
INSERT INTO users (first_name, last_name, cpf, birth_date, points, email, password) VALUES ('Marlon', 'Silva',  '47111813006', '1959-02-21', 5000, 'marlon@email.com', '$2a$10$wJhPy.7RXZkt8RgIAMMBXOIp71ISbW/5ddzu6jjAjbc0Jrp1AkGPW');

INSERT INTO role (authority) VALUES ('ROLE_READER');
INSERT INTO role (authority) VALUES ('ROLE_BASIC');
INSERT INTO role (authority) VALUES ('ROLE_ADVANCED');
INSERT INTO role (authority) VALUES ('ROLE_MODERATOR');

INSERT INTO user_role (user_id, role_id) VALUES (1,1);
INSERT INTO user_role (user_id, role_id) VALUES (2,2);
INSERT INTO user_role (user_id, role_id) VALUES (3,3);
INSERT INTO user_role (user_id, role_id) VALUES (4,4);

INSERT INTO films(TITLE, PLOT, RUNTIME, RELEASED, GENRE, DIRECTOR, WRITER, ACTORS, LANGUAGE, COUNTRY, AWARDS, score, count) VALUES ('hello', 'happy', '152min', '2022', 'action', 'james', 'cameron', 'scarlet', 'pt-br', 'brazil', 'grammy' , 5.0, 1);
INSERT INTO films(TITLE, PLOT, RUNTIME, RELEASED, GENRE, DIRECTOR, WRITER, ACTORS, LANGUAGE, COUNTRY, AWARDS, score, count) VALUES ('bye', 'sad', '149min', '2022', 'funny', 'james', 'cameron', 'scarlet', 'pt-br', 'usa', 'grammy' , 5.0, 1);

INSERT INTO scores(film_id, user_id, value) VALUES (1, 1, 5.0);

INSERT INTO comments(film_id, user_id, description, reaction_like, reaction_dislike, response, repeated) VALUES (1, 1,'scariest', 1, 2, 'I guess too', null);