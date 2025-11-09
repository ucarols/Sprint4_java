CREATE TABLE TBL_MOTOS (
    id_moto NUMBER(10) PRIMARY KEY,
    placa VARCHAR2(10) UNIQUE NOT NULL,
    modelo VARCHAR2(100) NOT NULL,
    categoria VARCHAR2(9) NOT NULL,
    observacao VARCHAR2(255),
    data_entrada DATE NOT NULL,
    imagem_url VARCHAR2(255),
    id_patio NUMBER(10),
    CONSTRAINT fk_motos_patios FOREIGN KEY (id_patio) REFERENCES TBL_PATIOS(id_patio)
);