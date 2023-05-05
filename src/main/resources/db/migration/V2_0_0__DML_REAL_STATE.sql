INSERT INTO country
  VALUES (1, 'INDIA'),
  (2, 'USA'),
  (3, 'UK'),
  (4, 'CANADA'),
  (5, 'AUSTRALIA');
INSERT INTO state
  VALUES (1, 'TAMILNADU', 1),
  (2, 'KARNATAKA', 1),
  (3, 'UTTAR PRADESH', 1),
  (4, 'KERALA', 1),
  (5, 'TELANGANA', 1);
INSERT INTO city
  VALUES (1, 12.9716, 77.5946, 'BANGALORE', 2),
  (2, 13.0827, 80.2707, 'CHENNAI', 1),
  (3, 17.3850, 78.4867, 'HYDERABAD', 5),
  (4, 10.8505, 76.2711, 'KOCHI', 4),
  (5, 10.8505, 22.2711, 'NOIDA', 3);
INSERT INTO pin_code
  VALUES ('1', 'BANGALORE', '560001', 1, 1),
  ('2', 'CHENNAI', '600001', 2, 1),
  ('3', 'HYDERABAD', '500001', 3, 1),
  ('4', 'KOCHI', '682001', 4, 1),
  ('5', 'NOIDA', '201304', 5, 1),
  ('6', 'NOIDA', '201303', 5, 1);


INSERT INTO society (society_id, society_name, number_of_buildings,
latitude, longitude, address_line1,
address_line2, pin_code_id)
  VALUES (1, 'JAYPEE KOSMOS', 1, 28.5030, 77.3825, 'Sector 134', 'Noida-Greater Noida Expy', 5),
  (2, 'Amrapali Exotica Apartments', 1, 34.015, 22.8757, 'Plot E, 8, E Block', 'Sector 50, Noida', 6),
  (3, 'JAYPEE KLASSIC', 1, 28.5037, 77.3788, 'Sector 134', 'Noida-Greater Noida Expy', 5),
  (4, 'JAYPEE GREENS', 1, 28.5037, 77.3788, 'Sector 136', 'Noida-Greater Noida Expy', 5),
  (5, 'GALAXY VEGA', 2, 28.6095, 77.3514, 'Techzone 4', 'Greater Noida West', 6),
  (6, 'SUPERTECH ECOLOFTS', 4, 28.5645, 77.3412, 'Yamuna Expressway', 'Greater Noida', 6),
  (7, 'ATS GREENS VILLAGE', 3, 28.5817, 77.3952, 'Sector 93 A', 'Noida Expressway', 6),
  (8, 'PURVANCHAL ROYAL CITY', 6, 28.6463, 77.4745, 'Sector Chi V', 'Greater Noida', 5),
  (9, 'WAVE CITY', 10, 28.5129, 77.4807, 'NH 24', 'Delhi Meerut Expressway', 6);



INSERT INTO society_amenities (society_id, amenity_name)
  VALUES (1, 'WATER_SUPPLY'),
  (1, 'SECURITY_SERVICE'),
  (1, 'WASTE_DISPOSAL'),
  (1, 'POLICE_STATION'),
  (1, 'BANK'),
  (1, 'GUEST_PARKING'),
  (2, 'WATER_SUPPLY'),
  (2, 'SECURITY_SERVICE'),
  (2, 'WASTE_DISPOSAL'),
  (2, 'POLICE_STATION'),
  (2, 'BANK'),
  (2, 'GUEST_PARKING'),
  (3, 'WATER_SUPPLY'),
  (3, 'SECURITY_SERVICE'),
  (3, 'WASTE_DISPOSAL'),
  (3, 'POLICE_STATION'),
  (3, 'BANK'),
  (3, 'GUEST_PARKING'),
  (4, 'WATER_SUPPLY'),
  (4, 'SECURITY_SERVICE'),
  (4, 'WASTE_DISPOSAL'),
  (4, 'POLICE_STATION'),
  (4, 'BANK'),
  (4, 'GUEST_PARKING'),
  (5, 'WATER_SUPPLY'),
  (5, 'SECURITY_SERVICE'),
  (5, 'WASTE_DISPOSAL'),
  (5, 'POLICE_STATION'),
  (5, 'BANK'),
  (5, 'GUEST_PARKING'),
  (6, 'WATER_SUPPLY'),
  (6, 'SECURITY_SERVICE'),
  (6, 'WASTE_DISPOSAL'),
  (6, 'POLICE_STATION'),
  (6, 'BANK'),
  (6, 'GUEST_PARKING'),
  (7, 'WATER_SUPPLY'),
  (7, 'SECURITY_SERVICE'),
  (7, 'WASTE_DISPOSAL'),
  (7, 'POLICE_STATION'),
  (7, 'BANK'),
  (7, 'GUEST_PARKING');


INSERT INTO building (
  building_id, building_name, number_of_apartments,
  number_of_floors, latitude, longitude,
  address_line1, address_line2, pin_code_id,
  society_id
)
VALUES
  (
    1, 'KOSMOS-1', 120, 24, 34.015, 22.8757,
    'Plot E, 8, E Block', 'Sector 134, Noida',
    5, 1
  ),
  (
    2, 'Amrapali-1', 60, 15, 34.015, 22.8757,
    'Plot E, 8, E Block', 'Sector 134, Noida',
    5, 2
  ),
  (
    3, 'KLASSIC-1', 30, 10, 34.015, 22.8757,
    'Plot E, 8, E Block', 'Sector 50, Noida',
    6, 3
  ),
  (
    4, 'GREENS-1', 30, 10, 34.015, 22.8757,
    'Plot E, 8, E Block', 'Sector 50, Noida',
    6, 4
  ),
  (
    5, 'KOSMOS-2', 110, 22, 34.016, 22.8767,
    'Plot F, 9, F Block', 'Sector 134, Noida',
    5, NULL
  ),
  (
    6, 'KOSMOS-3', 130, 26, 34.017, 22.8777,
    'Plot G, 10, G Block', 'Sector 134, Noida',
    6, 7
  ),
  (
    7, 'KOSMOS-4', 140, 28, 34.018, 22.8787,
    'Plot H, 11, H Block', 'Sector 134, Noida',
    6, NULL
  ),
  (
    8, 'KOSMOS-5', 150, 30, 34.019, 22.8797,
    'Plot I, 12, I Block', 'Sector 134, Noida',
    4, 5
  ),
  (
    9, 'KOSMOS-6', 160, 32, 34.020, 22.8807,
    'Plot J, 13, J Block', 'Sector 134, Noida',
    4, 6
  ),
  (
    10, 'KOSMOS-7', 170, 34, 34.021, 22.8817,
    'Plot K, 14, K Block', 'Sector 134, Noida',
    6, 5
  );

INSERT INTO building_amenities (building_id,
amenity_name)
  VALUES (1, 'WATER_SUPPLY'),
  (1, 'SECURITY_SERVICE'),
  (1, 'WASTE_DISPOSAL'),
  (1, 'POLICE_STATION'),
  (1, 'BANK'),
  (1, 'GUEST_PARKING'),
  (2, 'WATER_SUPPLY'),
  (2, 'SECURITY_SERVICE'),
  (2, 'WASTE_DISPOSAL'),
  (2, 'POLICE_STATION'),
  (2, 'BANK'),
  (2, 'GUEST_PARKING'),
  (3, 'WATER_SUPPLY'),
  (3, 'SECURITY_SERVICE'),
  (3, 'WASTE_DISPOSAL'),
  (3, 'POLICE_STATION'),
  (3, 'BANK'),
  (3, 'GUEST_PARKING'), (5, 'WATER_SUPPLY'),
  (5, 'SECURITY_SERVICE'),
  (5, 'WASTE_DISPOSAL'),
  (5, 'POLICE_STATION'),
  (5, 'BANK'),
  (5, 'GUEST_PARKING'), (6, 'WATER_SUPPLY'),
  (6, 'SECURITY_SERVICE'),
  (6, 'WASTE_DISPOSAL'),
  (6, 'POLICE_STATION'),
  (6, 'BANK'),
  (6, 'GUEST_PARKING'), (7, 'WATER_SUPPLY'),
  (7, 'SECURITY_SERVICE'),
  (7, 'WASTE_DISPOSAL'),
  (7, 'POLICE_STATION'),
  (7, 'BANK'),
  (7, 'GUEST_PARKING'), (8, 'WATER_SUPPLY'), (9, 'POLICE_STATION'), (10, 'GUEST_PARKING');

INSERT INTO real_estate_user (
  user_id, address_line1, address_line2,
  pin_code_id, date_of_birth, first_name,
  last_name, email_id, gender, phone_number,
  title
)
VALUES
  (
    1, 'Sector 145', 'Noida', 5, '1991-02-02',
    'Rahul', 'Singh', 'xym@gmail.com',
    'MALE', '871113923711', 'MR'
  ),
  (
    2, 'Sector 136', 'Hyderabad', 3, '1994-02-02',
    'Vijay', 'Singh', 'vijay@gmail.com',
    'MALE', '891113923711', 'MR'
  ),
  (
    3, 'Sector 123', 'Bangalore', 1, '1991-02-02',
    'Naina', 'Singh', 'naina@gmail.com',
    'FEMALE', '879913923711', 'DR'
  ),
  (
    4, 'Sector 145', 'Kochi', 4, '1991-02-02',
    'Sruthi', 'Singh', 'shruti@gmail.com',
    'FEMALE', '871113923981', 'MRS'
  ),
  (
    5, 'Sector 145', 'Chennai', 2, '1991-02-02',
    'Shaym', 'Singh', 'shyam@gmail.com',
    'MALE', '871653923711', 'MR'
  ),
  (
    6, 'Hinjewadi', 'BANGALORE', 1, '1992-10-23',
    'Aditi', 'Kumar', 'aditi.k@gmail.com',
    'FEMALE', '9735399243', 'MS'
  ),
  (
    7, 'Gandhi Nagar', 'CHENNAI', 2, '1989-04-12',
    'Alok', 'Sharma', 'alok.s@gmail.com',
    'MALE', '7896541230', 'MR'
  ),
  (
    8, 'Koramangala', 'Bangalore', 1, '1994-06-15',
    'Deepika', 'Saxena', 'deepika.s@gmail.com',
    'FEMALE', '9900112233', 'MS'
  ),
  (
    9, 'Chattarpur', 'NOIDA', 5, '1988-12-28',
    'Amit', 'Gupta', 'amit.g@gmail.com',
    'MALE', '9898989898', 'MR'
  ),
  (
    10, 'Salt Lake', 'KOCHI', 4, '1995-09-05',
    'Anjali', 'Das', 'anjali.d@gmail.com',
    'FEMALE', '9876543210', 'MS'
  );

INSERT INTO apartment (
  apartment_id, apartment_name, area_in_square_feet,
  total_floors, floor_number, listing_type,
  number_of_rooms, property_age_in_years,
  property_type, rent_per_month, security_deposit,
  selling_price, address_line1, address_line2,
  latitude, longitude, pin_code_id,
  building_id,available
)
VALUES
  (
    1, 'Yellow Heights', 1200, 1, 1, 'SELL',
    5, 4, 'STUDIO_APARTMENT', 15000, 50000,
    0, 'Plot E, 8, E Block', 'Sector 134, Noida',
    34.015, 22.8757, 5, 1,false
  ),
  (
    2, 'Pink Villa', 1200, 1, 1, 'RENT',
    5, 4, 'FLAT', 0, 0, 10000000, 'Plot E, 8, E Block',
    'Sector 134, Noida', 34.015, 22.8757,
    5, 2,false
  ),
  (
    3, 'Essentia Heights', 1800, 1, 1, 'SELL',
    5, 4, 'STUDIO_APARTMENT', 0, 0, 30000000,
    'Plot E, 8, E Block', 'Sector 134, Noida',
    34.015, 22.8757, 5, 3,false
  ),
  (
    4, '504', 1200, 24, 5, 'RENT', 5, 5, 'ROW_HOUSE',
    15000, 50000, 0, 'Plot E, 8, E Block',
    'Sector 134, Noida', 34.015, 22.8757,
     5, NULL, true
  ),
  (
    10, 'The Greens', 1500, 4, 2, 'RENT',
    3, 2, 'FLAT', 20000, 60000, 0, 'A-1, Sector 16',
    'Noida', 28.5537, 77.2893, 1, 5, true
  ),
  (
    5, 'Lavender Homes', 1800, 6, 3, 'SELL',
    4, 3, 'ROW_HOUSE', 0, 0, 20000000, 'B-2, Sector 18',
    'Noida', 28.5766, 77.3318, 2, 6, true
  ),
  (
    6, 'Skyline Apartments', 2200, 10,
    8, 'RENT', 4, 5, 'FLAT', 25000, 80000,
    0, 'C-3, Sector 21', 'Noida', 28.5801,
    77.3409, 3, 7, true
  ),
  (
    7, 'Sunflower Residency', 1300, 3,
    2, 'SELL', 3, 4, 'STUDIO_APARTMENT',
    0, 0, 15000000, 'D-4, Sector 22',
    'Noida', 28.5852, 77.3451, 4, 4, true
  ),
  (
    8, 'Amber Heights', 1600, 6, 5, 'RENT',
    3, 1, 'FLAT', 18000, 50000, 0, 'E-5, Sector 25',
    'Noida', 28.5947, 77.3579, 5, 5, true
  ),
  (
    9, 'Crimson Plaza', 800, 2, 1, 'SELL',
    2, 1, 'STUDIO_APARTMENT', 0, 0, 10000000,
    'F-6, Sector 29', 'Noida', 28.5981,
    77.3638, 6, 6, true
  );

INSERT INTO apartment_amenities (apartment_id, amenity_name)
VALUES
  (1, 'WATER_SUPPLY'),
  (1, 'SECURITY_SERVICE'),
  (1, 'WASTE_DISPOSAL'),
  (1, 'POLICE_STATION'),
  (1, 'BANK'),
  (1, 'GUEST_PARKING'),
  (2, 'WATER_SUPPLY'),
  (2, 'SECURITY_SERVICE'),
  (2, 'WASTE_DISPOSAL'),
  (2, 'POLICE_STATION'),
  (2, 'BANK'),
  (2, 'GUEST_PARKING'),
  (3, 'WATER_SUPPLY'),
  (3, 'SECURITY_SERVICE'),
  (3, 'WASTE_DISPOSAL'),
  (3, 'POLICE_STATION'),
  (3, 'BANK'),
  (3, 'GUEST_PARKING'),
  (4, 'WATER_SUPPLY'),
  (4, 'SECURITY_SERVICE'),
  (4, 'WASTE_DISPOSAL'),
  (4, 'POLICE_STATION'),
  (4, 'BANK'),
  (4, 'GUEST_PARKING'),
  (5, 'WATER_SUPPLY'),
  (5, 'SECURITY_SERVICE'),
  (5, 'WASTE_DISPOSAL'),
  (5, 'POLICE_STATION'),
  (5, 'BANK'),
  (6, 'WATER_SUPPLY'),
  (6, 'SECURITY_SERVICE'),
  (6, 'WASTE_DISPOSAL'),
  (6, 'POLICE_STATION'),
  (6, 'BANK'),
  (7, 'WATER_SUPPLY'),
  (7, 'SECURITY_SERVICE'),
  (7, 'WASTE_DISPOSAL'),
  (7, 'POLICE_STATION'),
  (7, 'BANK'),
  (8, 'WATER_SUPPLY'),
  (8, 'SECURITY_SERVICE'),
  (8, 'WASTE_DISPOSAL'),
  (8, 'POLICE_STATION'),
  (8, 'BANK'),
  (9, 'WATER_SUPPLY'),
  (9, 'SECURITY_SERVICE'),
  (9, 'WASTE_DISPOSAL'),
  (9, 'POLICE_STATION'),
  (9, 'BANK');

INSERT INTO apartment_images (
  apartment_id, image_url, image_name
)
VALUES
  (
    1, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.99acres.com%2Fyellow-heights-sector-134-n',
    'Kitchen'
  ),
  (
    2, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.99acres.com%2Fpink-villa-sector-134-noida-np',
    'Balcony'
  ),
  (
    3, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.99acres.com%2Fpink-villa-sector-134-noida-np',
    'Hall'
  ),
  (
    4, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.99acres.com%2Fpink-villa-sector-134-noida-np',
    'BedRoom'
  ),
  (
    1, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.99acres.com%2Fpink-villa-sector-134-noida-np',
    'Kitchen'
  ),
  (
    2, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.99acres.com%2Fpink-villa-sector-134-noida-np',
    'BedRoom'
  ),
  (
    3, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.99acres.com%2Fpink-villa-sector-134-noida-np',
    'Balcony'
  ),
  (
    4, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.99acres.com%2Fpink-villa-sector-134-noida-np',
    'Hall'
  ),
  (
    1, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.99acres.com%2Fpink-villa-sector-134-noida-np',
    'Bed Room'
  ),
  (
    2, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.99acres.com%2Fpink-villa-sector-134-noida-np',
    'Study Room'
  ),
  (
    3, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.99acres.com%2Fpink-villa-sector-134-noida-np',
    'Hall'
  ),
  (
    4, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.99acres.com%2Fpink-villa-sector-134-noida-np',
    'Servant Room'
  ),
  (
    1, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.99acres.com%2Fpink-villa-sector-134-noida-np',
    'Room'
  ),
  (
    2, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.99acres.com%2Fpink-villa-sector-134-noida-np',
    'Stairs'
  );

INSERT INTO user_owns_apartment (user_id, apartment_id)
VALUES
  (1, 1),
  (2, 2),
  (1, 3),
  (2, 4),
  (2, 5),
  (2, 6),
  (1, 7),
  (1, 8),
  (1, 9);
INSERT INTO user_rents_apartment (
  user_id, apartment_id, rent_per_month,
  security_deposit, start_date
)
VALUES
  (3, 1, 12000, 15000, '2023-02-02'),
  (4, 2, 14000, 18000, '2023-04-02'),
  (5, 3, 18000, 20000, '2023-03-02');
INSERT INTO user_visit_apartment (
  user_id, apartment_id, interested,
  visited_date
)
VALUES
  (3, 1, true, '2023-02-02'),
  (4, 2, false, '2023-04-02'),
  (5, 3, true, '2023-03-02');
