-- Create the schema if it does not exist
CREATE SCHEMA IF NOT EXISTS diskonect;

-- Create the table if it does not exist
CREATE TABLE IF NOT EXISTS diskonect.post (
    id bigint GENERATED ALWAYS AS IDENTITY,
    slug VARCHAR(500) NOT NULL,
    created_at TIMESTAMPTZ NOT NULL,
    title VARCHAR(300) NOT NULL,
    assets TEXT[],
    content VARCHAR(5000) NOT NULL
);
