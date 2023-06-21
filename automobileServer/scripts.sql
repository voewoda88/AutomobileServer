CREATE TABLE car_models (
                            id SERIAL PRIMARY KEY,
                            name VARCHAR(255) NOT NULL,
                            body_type VARCHAR(255) NOT NULL,
                            year INTEGER NOT NULL,
                            engine VARCHAR(255) NOT NULL,
                            color VARCHAR(255) NOT NULL,
                            manufacturer_id INTEGER NOT NULL,
                            FOREIGN KEY (manufacturer_id) REFERENCES manufacturers(manufacturer_id)
);

CREATE TABLE manufacturers (
                               manufacturer_id SERIAL PRIMARY KEY,
                               name VARCHAR(255),
                               country VARCHAR(255),
                               founder VARCHAR(255),
                               foundation_year INTEGER,
                               specialization VARCHAR(255),
                               technologies VARCHAR(255),
                               number_of_staff INTEGER
);