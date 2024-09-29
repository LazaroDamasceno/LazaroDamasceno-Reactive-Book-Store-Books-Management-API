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
  publishing_year INTEGER NOT NULL,
  price DOUBLE PRECISION NOT NULL,
  created_at TIMESTAMP NOT NULL,
  creation_zone_id VARCHAR(255) NOT NULL,
  archived_at TIMESTAMP,
  archiving_zone_id VARCHAR(255)
);
