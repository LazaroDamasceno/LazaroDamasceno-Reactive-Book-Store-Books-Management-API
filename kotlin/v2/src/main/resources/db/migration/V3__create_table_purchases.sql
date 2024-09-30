CREATE TABLE purchases (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    order_number BIGINT NOT NULL,
    customer_id UUID NOT NULL REFERENCES customers(id),
    book_id UUID NOT NULL REFERENCES books(id),
    price DOUBLE PRECISION NOT NULL,
    final_price DOUBLE PRECISION NOT NULL,
    created_at TIMESTAMP NOT NULL,
    creation_zone_id VARCHAR(255) NOT NULL
);
