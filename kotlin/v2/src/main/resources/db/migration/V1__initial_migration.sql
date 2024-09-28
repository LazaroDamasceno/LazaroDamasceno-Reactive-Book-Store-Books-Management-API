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
  modified_at TIMESTAMP,
  modification_zone_id VARCHAR(255)
);

CREATE TABLE books (
  id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
  title VARCHAR(255) NOT NULL,
  subtitle VARCHAR(255),
  isbn VARCHAR(13) NOT NULL,
  author VARCHAR(255) NOT NULL,
  field VARCHAR(255) NOT NULL,
  publisher VARCHAR(255) NOT NULL,
  number_of_pages INTEGER NOT NULL DEFAULT 1 CHECK(number_of_pages > 0),
  version INTEGER NOT NULL DEFAULT 1 CHECK(version > 0),
  created_at TIMESTAMP NOT NULL,
  creation_zone_id VARCHAR(255) NOT NULL,
  modified_at TIMESTAMP,
  modification_zone_id VARCHAR(255)
);
