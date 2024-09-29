CREATE TABLE customers (
  id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
  first_name VARCHAR(255) NOT NULL,
  middle_name VARCHAR(255),
  last_name VARCHAR(255) NOT NULL,
  ssn VARCHAR(9) NOT NULL,
  birth_date DATE NOT NULL,
  email VARCHAR(255) NOT NULL,
  gender VARCHAR(255) NOT NULL,
  phone_number VARCHAR(10) NOT NULL,
  created_at TIMESTAMP NOT NULL,
  creation_zone_id VARCHAR(255),
  archived_at TIMESTAMP,
  archiving_zone_id VARCHAR(255)
);
