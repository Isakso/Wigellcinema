-- Insert data into the address table

INSERT INTO address (postal_code, city, street, country) VALUES (21678, 'Gävle', 'Stockholmsvägen 23', 'Sweden');
INSERT INTO address (postal_code, city, street, country) VALUES (21451, 'Umeå', 'Arenagatan 83', 'Sweden');
INSERT INTO address (postal_code, city, street, country) VALUES (22345, 'Stockholm', 'Drottninggatan 45', 'Sweden');
INSERT INTO address (postal_code, city, street, country) VALUES (23123, 'Malmö', 'Kungsgatan 12', 'Sweden');
INSERT INTO address (postal_code, city, street, country) VALUES (22002, 'Gothenburg', 'Avenyn 1', 'Sweden');

-- Insert data into the room table
INSERT INTO room (max_guests, room_type) VALUES (100, 'Deluxe');
INSERT INTO room (max_guests, room_type) VALUES  (200, 'Suite');
INSERT INTO room (max_guests, room_type) VALUES   (50, 'Standard');
INSERT INTO room (max_guests, room_type) VALUES (150, 'Family');
INSERT INTO room (max_guests, room_type) VALUES  (80, 'Economy');

-- Insert data into the movies table
INSERT INTO movies (age_limit, movie_length, genre, title)
VALUES (25, 2, 'Romance', 'A View to a Kill');
INSERT INTO movies (age_limit, movie_length, genre, title) VALUES  (30, 3, 'Action', 'Romeo and Juliet');
INSERT INTO movies (age_limit, movie_length, genre, title)VALUES   (18, 2, 'Comedy', 'The Hangover');
INSERT INTO movies (age_limit, movie_length, genre, title)VALUES (12, 2, 'Animation', 'Frozen');
INSERT INTO movies (age_limit, movie_length, genre, title)VALUES  (16, 2, 'Drama', 'The Shawshank Redemption');

-- Insert data into the users table
INSERT INTO users (address_id, room_id, user_name) VALUES (1, 3, 'Anders Lundberg');
INSERT INTO users (address_id, room_id, user_name) VALUES   (2, 2, 'Marco Polo');
INSERT INTO users (address_id, room_id, user_name) VALUES  (3, 1, 'Lena Svensson');
INSERT INTO users (address_id, room_id, user_name)VALUES  (4, 5, 'Erik Andersson');
INSERT INTO users (address_id, room_id, user_name) VALUES  (5, 4, 'Anna Karlsson');

-- Insert data into the bookings table
INSERT INTO bookings (booking_date, movie_id, no_of_guests, room_id, user_id, total_cost, total_cost_eur)VALUES ('2024-05-01', 1, 25, 3, 1, 200000, 0.0);
INSERT INTO bookings (booking_date, movie_id, no_of_guests, room_id, user_id, total_cost, total_cost_eur)vALUES ('2024-05-01', 2, 25, 3, 2, 200000, 0.0);
INSERT INTO bookings (booking_date, movie_id, no_of_guests, room_id, user_id, total_cost, total_cost_eur)VALUES ('2024-05-06', 2, 100, 2, 2, 400000, 1.0);
INSERT INTO bookings (booking_date, movie_id, no_of_guests, room_id, user_id, total_cost, total_cost_eur)VALUES   ('2024-06-10', 3, 50, 1, 3, 150000, 0.0);
INSERT INTO bookings (booking_date, movie_id, no_of_guests, room_id, user_id, total_cost, total_cost_eur)VALUES('2024-06-15', 4, 30, 5, 4, 180000, 0.0);
INSERT INTO bookings (booking_date, movie_id, no_of_guests, room_id, user_id, total_cost, total_cost_eur)VALUES ('2024-07-01', 5, 20, 4, 5, 120000, 0.0);
