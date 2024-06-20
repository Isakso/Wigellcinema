-- Insert data into the address table
INSERT INTO address (postal_code, city, street, country)
VALUES
    (21678, 'Gävle', 'Stockholmsvägen 23', 'Sweden'),
    (21451, 'Umeå', 'Arenagatan 83', 'Sweden');

-- Insert data into the room table
INSERT INTO room (max_guests, room_type)
VALUES
    (100, 'Deluxe'),
    (200, 'Suite'),
    (50, 'Standard');

-- Insert data into the movies table
INSERT INTO movies (age_limit, movie_length, genre, title)
VALUES
    (25, 2, 'Romance', 'A View to a Kill'),
    (30, 3, 'Action', 'Romeo and Juliet');

-- Insert data into the users table
INSERT INTO users (address_id, room_id, user_name)
VALUES
    (1, 3, 'Anders Lundberg'),
    (2, 2, 'Marco Polo');

-- Insert data into the bookings table
INSERT INTO bookings (booking_date, movie_id, no_of_guests, room_id, user_id,total_cost)
VALUES
    ('2024-05-01', 1, 25, 3, 1,200000),
    ('2024-05-03', 2, 100, 2, 2,300000);

