ALTER TABLE customers RENAME modified_at TO archived_at;
ALTER TABLE customers RENAME modification_zone_id TO archiving_zone_id;
ALTER TABLE books RENAME modified_at TO archived_at;
ALTER TABLE books RENAME modification_zone_id TO archiving_zone_id;
