CREATE TABLE country
  (
     id   INT4 NOT NULL,
     NAME VARCHAR(60) NOT NULL,
     PRIMARY KEY (id)
  );

CREATE TABLE state
  (
     id         INT4 NOT NULL,
     NAME       VARCHAR(90) NOT NULL,
     country_id INT4 NOT NULL,
     PRIMARY KEY (id),
     CONSTRAINT fk_state_country_id FOREIGN KEY (country_id) REFERENCES country
  );

CREATE TABLE city
  (
     id        INT4 NOT NULL,
     latitude  FLOAT8 NOT NULL,
     longitude FLOAT8 NOT NULL,
     NAME      VARCHAR(255) NOT NULL,
     state_id INT4 NOT NULL,
     PRIMARY KEY (id),
     CONSTRAINT fk_city_state_state_id FOREIGN KEY (state_id) REFERENCES state
  );


CREATE TABLE pin_code
  (
     id         INT4 NOT NULL,
     area_name  VARCHAR(120) NOT NULL,
     pin        VARCHAR(10) NOT NULL,
     city_id    INT4 NOT NULL,
     country_id INT4 NOT NULL,
     PRIMARY KEY (id),
     CONSTRAINT uk_pin_code_country_id_pin UNIQUE (country_id, pin),
     CONSTRAINT fk_pin_code_city_id FOREIGN KEY (city_id) REFERENCES city,
     CONSTRAINT fk_pin_code_country_id FOREIGN KEY (country_id) REFERENCES
     country
  );

CREATE TABLE real_estate_user
  (
     user_id       INT4 NOT NULL,
     address_line1 VARCHAR(100) NOT NULL,
     address_line2 VARCHAR(100),
     date_of_birth DATE,
     email_id      VARCHAR(255) NOT NULL,
     first_name    VARCHAR(30) NOT NULL,
     gender        VARCHAR(20),
     last_name     VARCHAR(30),
     middle_name   VARCHAR(30),
     phone_number  VARCHAR(12) NOT NULL,
     title         VARCHAR(20),
     pin_code_id   INT4 NOT NULL,
     PRIMARY KEY (user_id),
     CONSTRAINT uk_real_estate_user_email_id UNIQUE (email_id),
     CONSTRAINT fk_real_estate_user_pin_code_id FOREIGN KEY (pin_code_id)
     REFERENCES pin_code
  );

CREATE TABLE user_credential
  (
     user_id  INT4 NOT NULL,
     password VARCHAR(255) NOT NULL,
     PRIMARY KEY (user_id),
     constraint fk_user_credential_user_id foreign key (user_id) references real_estate_user  ON DELETE CASCADE
  );

CREATE TABLE society
  (
     society_id          INT4 NOT NULL,
     address_line1       VARCHAR(100) NOT NULL,
     address_line2       VARCHAR(100),
     latitude            FLOAT4 NOT NULL,
     longitude           FLOAT4 NOT NULL,
     number_of_buildings INT2 NOT NULL,
     society_name        VARCHAR(50) NOT NULL,
     pin_code_id         INT4 NOT NULL,
     PRIMARY KEY (society_id),
     CONSTRAINT fk_society_centre_pin_code_id FOREIGN KEY (pin_code_id)
     REFERENCES pin_code
  );

CREATE TABLE building
  (
     building_id          INT4 NOT NULL,
     address_line1        VARCHAR(100) NOT NULL,
     address_line2        VARCHAR(100),
     building_name        VARCHAR(50) NOT NULL,
     latitude             FLOAT4 NOT NULL,
     longitude            FLOAT4 NOT NULL,
     number_of_apartments INT2 NOT NULL,
     number_of_floors     INT2 NOT NULL,
     pin_code_id          INT4 NOT NULL,
     society_id           INT4 DEFAULT NULL,
     PRIMARY KEY (building_id),
     CONSTRAINT fk_building_centre_pin_code_id FOREIGN KEY (pin_code_id)
     REFERENCES pin_code,
     CONSTRAINT fk_building_society_id FOREIGN KEY (society_id) REFERENCES
     society
  );

CREATE TABLE apartment
  (
     apartment_id          INT4 NOT NULL,
     address_line1         VARCHAR(100) NOT NULL,
     address_line2         VARCHAR(100),
     apartment_name        VARCHAR(50) NOT NULL,
     area_in_square_feet   FLOAT8,
     available             BOOLEAN DEFAULT FALSE,
     terrace               BOOLEAN DEFAULT FALSE,
     balcony               BOOLEAN DEFAULT FALSE,
     pets_allowed          BOOLEAN DEFAULT FALSE,
     elevator              BOOLEAN DEFAULT FALSE,
     garden                BOOLEAN DEFAULT FALSE,
     parking               BOOLEAN DEFAULT FALSE,
     full_furnished        BOOLEAN DEFAULT FALSE,
     total_floors          INT2 NOT NULL,
     floor_number          INT2 NOT NULL,
     latitude              FLOAT4 NOT NULL,
     listing_type          varchar(100) NOT NULL,
     longitude             FLOAT4 NOT NULL,
     number_of_rooms       INT2,
     property_age_in_years INT4,
     property_type         varchar(100) NOT NULL,
     rent_per_month        FLOAT8,
     security_deposit      FLOAT8,
     selling_price         FLOAT8,
     building_id           INT4 DEFAULT NULL,
     pin_code_id           INT4 NOT NULL,
     PRIMARY KEY (apartment_id),
     CONSTRAINT fk_apartment_building_id FOREIGN KEY (building_id) REFERENCES
     building,
     CONSTRAINT fk_apartment_centre_pin_code_id FOREIGN KEY (pin_code_id)
     REFERENCES pin_code
  );

CREATE TABLE apartment_amenities
  (
     apartment_id INT4 NOT NULL,
     amenity_name           VARCHAR(50) NOT NULL,
     CONSTRAINT fk_apartment_amenities_id FOREIGN KEY (apartment_id)
     REFERENCES apartment ON DELETE CASCADE
  );

CREATE TABLE apartment_images
  (
     apartment_id INT4 NOT NULL,
     image_name             VARCHAR(250) NOT NULL,
     image_url              VARCHAR(250) NOT NULL,
     CONSTRAINT fk_apartment_images_id FOREIGN KEY (apartment_id)
     REFERENCES apartment ON DELETE CASCADE
  );



CREATE TABLE building_amenities
  (
     building_id INT4 NOT NULL,
     amenity_name         VARCHAR(50) NOT NULL,
     CONSTRAINT fk_building_amenity_id FOREIGN KEY (building_id)
     REFERENCES building ON DELETE CASCADE
  );

CREATE TABLE society_amenities
  (
     society_id INT4 NOT NULL,
     amenity_name       VARCHAR(50) NOT NULL,
     CONSTRAINT fk_society_amenity_id FOREIGN KEY (society_id)
     REFERENCES society ON DELETE CASCADE
  );

CREATE TABLE user_bought_apartment
  (
     bought_date  DATE,
     apartment_id INT4 NOT NULL,
     user_id      INT4 NOT NULL,
     PRIMARY KEY (apartment_id, user_id,bought_date),
     CONSTRAINT fk_user_bought_apartment_apartment_id FOREIGN KEY (apartment_id)
     REFERENCES apartment ON DELETE CASCADE,
     CONSTRAINT fk_user_bought_apartment_user_id FOREIGN KEY (user_id) REFERENCES
     real_estate_user ON DELETE CASCADE
  );

CREATE TABLE user_owns_apartment
  (
     apartment_id INT4 NOT NULL,
     user_id      INT4 NOT NULL,
     PRIMARY KEY (apartment_id, user_id),
     CONSTRAINT fk_user_owns_apartment_apartment_id FOREIGN KEY (apartment_id)
     REFERENCES apartment ON DELETE CASCADE,
     CONSTRAINT fk_user_owns_apartment_user_id FOREIGN KEY (user_id) REFERENCES
     real_estate_user ON DELETE CASCADE
  );

CREATE TABLE user_rents_apartment
  (
     rent_per_month   INT4,
     security_deposit INT4,
     start_date       DATE,
     apartment_id     INT4 NOT NULL,
     user_id          INT4 NOT NULL,
     PRIMARY KEY (apartment_id, user_id, start_date),
     CONSTRAINT fk_user_rents_apartment_apartment_id FOREIGN KEY (apartment_id)
     REFERENCES apartment ON DELETE CASCADE,
     CONSTRAINT fk_user_rents_apartment_user_id FOREIGN KEY (user_id) REFERENCES
     real_estate_user ON DELETE CASCADE
  );

CREATE TABLE user_visit_apartment
  (
     interested           BOOLEAN,
     visited_date         DATE,
     apartment_id         INT4 NOT NULL,
     user_id              INT4 NOT NULL,
          PRIMARY KEY (apartment_id, user_id, visited_date),
          CONSTRAINT fk_user_visit_apartment_apartment_id FOREIGN KEY (apartment_id)
          REFERENCES apartment ON DELETE CASCADE,
     CONSTRAINT fk_user_visit_apartment_user_id FOREIGN KEY (user_id) REFERENCES
          real_estate_user ON DELETE CASCADE
  );

-- Indexes for table apartment

CREATE INDEX apartment_listing_type_index ON apartment (listing_type);
CREATE INDEX apartment_property_type_index ON apartment (property_type);
CREATE INDEX apartment_selling_price_index ON apartment (selling_price);
CREATE INDEX apartment_number_of_rooms_index ON apartment (number_of_rooms);
CREATE INDEX apartment_available_index ON apartment (available);
CREATE INDEX apartment_pin_code_id_index ON apartment (pin_code_id);
CREATE INDEX building_building_name_index ON building (building_name);
CREATE INDEX building_pin_code_id_index ON building (pin_code_id);
CREATE INDEX real_estate_user_phone_number_index ON real_estate_user (phone_number);
CREATE INDEX real_estate_user_pin_code_id_index ON real_estate_user (pin_code_id);
CREATE INDEX society_society_name_index ON society (society_name);
CREATE INDEX society_pin_code_id_index ON society (pin_code_id);
CREATE INDEX apartment_images_apartment_id_index ON apartment_images (apartment_id);
CREATE INDEX apartment_amenities_apartment_id_index ON apartment_amenities (apartment_id);
CREATE INDEX building_amenities_building_id_index ON building_amenities (building_id);
CREATE INDEX society_amenities_society_id_index ON society_amenities (society_id);
CREATE INDEX user_bought_apartment_apartment_id_index ON user_bought_apartment (apartment_id);
CREATE INDEX user_bought_apartment_user_id_index ON user_bought_apartment (user_id);
CREATE INDEX user_rents_apartment_apartment_id_index ON user_rents_apartment (apartment_id);
CREATE INDEX user_rents_apartment_user_id_index ON user_rents_apartment (user_id);
CREATE INDEX user_owns_apartment_apartment_id_index ON user_owns_apartment (apartment_id);
CREATE INDEX user_owns_apartment_user_id_index ON user_owns_apartment (user_id);
CREATE INDEX user_visit_apartment_apartment_id_index ON user_visit_apartment (apartment_id);
CREATE INDEX user_visit_apartment_user_id_index ON user_visit_apartment (user_id);

--- Sequences

create sequence apartment_id_seq start 20 increment 1;

create sequence building_id_seq start 20 increment 1;

create sequence society_id_seq start 20 increment 1;

create sequence real_estate_user_id_seq start 20 increment 1;

-- Views
CREATE VIEW v_all_locations
AS
  SELECT pc.id,
         country.NAME country,
         s.NAME       state,
         c.NAME       city,
         c.id         city_id,
         pc.pin,
         pc.area_name area
  FROM   pin_code pc
         JOIN city c
           ON c.id = pc.city_id
         JOIN state s
           ON s.id = c.state_id
         JOIN country
           ON country.id = s.country_id;

-- Trigger to insert user credentials

CREATE OR REPLACE FUNCTION insert_user_credentials()
  RETURNS TRIGGER
  LANGUAGE PLPGSQL
  AS
$$
BEGIN
	INSERT INTO user_credential(user_id, password)
        VALUES(NEW.user_id, 'Welcome@12345');
    RETURN NEW;
END;
$$

$$
CREATE TRIGGER create_user_credentials AFTER INSERT ON real_estate_user FOR ROW EXECUTE PROCEDURE insert_user_credentials();
$$
-- End of triggers

-- Stored Procedures
--
create or replace procedure update_apartment_owners(updated_owners_ids INTEGER[], input_apartment_id INTEGER)
language plpgsql
as $$
DECLARE
 _userId INTEGER;
begin
  DELETE FROM user_owns_apartment WHERE apartment_id = input_apartment_id;
  FOREACH _userId IN ARRAY updated_owners_ids
  LOOP
      INSERT INTO user_owns_apartment(apartment_id, user_id) VALUES(input_apartment_id, _userId) ON CONFLICT (apartment_id, user_id) DO NOTHING ;
  END LOOP;
end;
$$

--call update_apartment_owners('{1,2}'::int[],1);

create or replace procedure add_apartment_visits(visitor_ids INTEGER[], apartment_ids INTEGER[], input_visit_date date)
language plpgsql
as $$
DECLARE
 _userId INTEGER;
 _apartmentId INTEGER;
begin
  FOREACH _userId IN ARRAY visitor_ids
  LOOP
      FOREACH _apartmentId IN ARRAY apartment_ids
      LOOP
          INSERT INTO user_visit_apartment(apartment_id, user_id, visited_date, interested) VALUES(_apartmentId, _userId, input_visit_date, true) ON CONFLICT (apartment_id, user_id, visited_date ) DO NOTHING ;
      END LOOP;
  END LOOP;
end;
$$

--call add_apartment_visits('{1,2,1}'::int[],'{3}'::int[],'2023-05-01');


create or replace procedure add_apartment_rent_details(tenant_ids INTEGER[], apartment_ids INTEGER[], in_start_date date, in_rent_per_month INTEGER,in_security_deposit INTEGER )
language plpgsql
as $$
DECLARE
 _userId INTEGER;
 _apartmentId INTEGER;
begin
  FOREACH _userId IN ARRAY tenant_ids
  LOOP
      FOREACH _apartmentId IN ARRAY apartment_ids
      LOOP
          INSERT INTO user_rents_apartment(apartment_id, user_id, start_date, rent_per_month,security_deposit) VALUES(_apartmentId, _userId, in_start_date, in_rent_per_month, in_security_deposit) ON CONFLICT (apartment_id, user_id, start_date ) DO NOTHING ;
      END LOOP;
  END LOOP;
end;
$$
--
--call add_apartment_rent_details('{1,2,1}'::int[],'{3}'::int[],'2023-05-01', 12000, 24000);


create or replace procedure add_apartment_purchase_details(new_owner_ids INTEGER[], apartment_ids INTEGER[], in_bought_date date)
language plpgsql
as $$
DECLARE
 _userId INTEGER;
 _apartmentId INTEGER;
begin
  FOREACH _apartmentId IN ARRAY apartment_ids
  LOOP
      FOREACH _userId IN ARRAY new_owner_ids
      LOOP
          INSERT INTO user_bought_apartment(apartment_id, user_id, bought_date) VALUES(_apartmentId, _userId, in_bought_date) ON CONFLICT (apartment_id, user_id, bought_date ) DO NOTHING ;
      END LOOP;
  END LOOP;
  FOREACH _apartmentId IN ARRAY apartment_ids
  LOOP
       call update_apartment_owners(new_owner_ids::int[], _apartmentId);
  END LOOP;
end;
$$
--
--call add_apartment_purchase_details('{2}'::int[],'{8,9}'::int[],'2023-05-01');

-- Path: src/main/resources/db/migration/v1_0_0_DDL.sql