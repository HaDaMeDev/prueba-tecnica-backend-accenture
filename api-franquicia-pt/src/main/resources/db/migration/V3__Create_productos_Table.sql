CREATE TABLE IF NOT EXISTS productos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    stock INT NOT NULL,sucursal_id BIGINT,
    FOREIGN KEY (sucursal_id) REFERENCES sucursales(id)
);