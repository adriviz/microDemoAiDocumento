CREATE TABLE IF NOT EXISTS documento (
    idDocumento INT AUTO_INCREMENT PRIMARY KEY,
    nombreDocumento VARCHAR(255) NOT NULL,
    tipoDocumento VARCHAR(50),
    fechaCreacion DATE NOT NULL,
    fechaModificacion DATE,
    idExpediente INT
); 