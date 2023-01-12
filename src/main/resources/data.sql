INSERT INTO RESTAURANT (name_restaurant)
VALUES ('кафе Central Perk '),
       ('Dr. Живаго'),
       ('White Rabbit');

INSERT INTO USERS (name, email, password, restaurant_id)
VALUES ( 'Росс Гейлер', 'rossgeller@gmail.com', '{noop}friends', 1 ),
       ( 'Моника Гейлер', 'monicageller@gmail.com', '{noop}friends', 1 ),
       ( 'Джо Трибиани', 'joeytribbiani@gmail.com', '{noop}friends', 1 ),
       ( 'Чендлер Бинг', 'chandlerbing@gmail.com', '{noop}friends', 1 ),
       ( 'Рейчел Грин', 'rachelgreen@gmail.com', '{noop}friends', 1 ),
       ( 'Фиби Буфэ', 'phoebebuffay@gmail.com', '{noop}friends', 1 ),
       ( 'Давид', 'david@gmail.com' ,'{noop}qwerty', 2 ),
       ( 'Иван', 'ivan@gmail.com', '{noop}qwerty', 3 );

INSERT INTO USER_ROLE (ROLE, USER_ID)
VALUES ('ADMIN', 1),
       ('USER', 2),
       ('USER', 3),
       ('USER', 4),
       ('USER', 5),
       ('USER', 6),
       ('USER', 7),
       ('USER', 8);

INSERT INTO MEAL (DISH, PRICE, RESTAURANT_ID)
VALUES ( 'кофе', '2.2', 1 ),
       ( 'чай', '1.3', 1 ),
       ( 'пирожное', '3', 1 ),
       ( 'пицца', '8.5', 1 ),
       ( 'тортик', '2.5', 1 ),
       ( 'борщ', '2.9', 2 ),
       ( 'суп гороховый', '1.9', 2 ),
       ( 'кофе', '1.0', 2 ),
       ( 'чай', '0.5', 2 ),
       ( 'шаурма', '0.3', 2 ),
       ( 'Шоколадный ролл', '2.2', 3 ),
       ( 'Фруктовый ролл', '3.2', 3 ),
       ( 'Овощной ролл', '2.5', 3 ),
       ( 'Изуми ролл', '2.3', 3 ),
       ( 'Тропический ролл', '2.0', 3 );
