CREATE TABLE TBL_AUDITORIAS (
    id_auditoria NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    usuario VARCHAR2(100),
    operacao VARCHAR2(10),
    data_hora DATE,
    valores_antigos CLOB,
    valores_novos CLOB
);