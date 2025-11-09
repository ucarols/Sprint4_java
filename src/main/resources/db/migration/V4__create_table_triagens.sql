CREATE TABLE TBL_TRIAGENS (
    id_triagem NUMBER(10) PRIMARY KEY,
    id_moto NUMBER(10),
    data_triagem DATE NOT NULL,
    classificacao VARCHAR2(50) NOT NULL,
    problema_reportado VARCHAR2(200),
    tempo_limite VARCHAR2(50),
    status_triagem VARCHAR2(30) NOT NULL,
    CONSTRAINT fk_triagens_motos FOREIGN KEY (id_moto) REFERENCES TBL_MOTOS(id_moto)
);