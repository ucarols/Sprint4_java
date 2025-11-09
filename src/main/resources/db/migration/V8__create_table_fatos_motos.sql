CREATE TABLE TBL_FATOS_MOTOS (
    id_fato NUMBER(10) PRIMARY KEY,
    id_patio NUMBER(10),
    marca VARCHAR2(50),
    valor_manutencao NUMBER(10,2) NOT NULL,
    CONSTRAINT fk_fatos_patios FOREIGN KEY (id_patio) REFERENCES TBL_PATIOS(id_patio)
);