CREATE TABLE TBL_MONITORAMENTOS (
    id_monitoramento NUMBER(10) PRIMARY KEY,
    id_moto NUMBER(10),
    id_patio NUMBER(10),
    data_hora_verificacao DATE NOT NULL,
    local_correto CHAR(1) NOT NULL,
    tempo_permanencia VARCHAR2(50),
    alerta VARCHAR2(255) NOT NULL,
    resolvido CHAR(1) NOT NULL,
    CONSTRAINT fk_monit_motos FOREIGN KEY (id_moto) REFERENCES TBL_MOTOS(id_moto),
    CONSTRAINT fk_monit_patios FOREIGN KEY (id_patio) REFERENCES TBL_PATIOS(id_patio)
);