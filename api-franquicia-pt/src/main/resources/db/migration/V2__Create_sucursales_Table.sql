CREATE TABLE IF NOT EXISTS sucursales (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,franquicia_id BIGINT,
    FOREIGN KEY (franquicia_id) REFERENCES franquicias(id)
);
