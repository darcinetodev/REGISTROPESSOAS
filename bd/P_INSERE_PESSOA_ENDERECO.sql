PROCEDURE `P_INSERE_PESSOA_ENDERECO`(P_CPF        DOUBLE,
											P_NOME       VARCHAR(50),
											P_SENHA      VARCHAR(32),
											P_DATA       VARCHAR(11),
											P_EMAIL      VARCHAR(50),
											P_CEP        INT,
											P_LOGRADOURO VARCHAR(50),
											P_NUMERO     INT,
											P_BAIRRO     VARCHAR(50),
											P_CIDADE     VARCHAR(50),
											P_ESTADO     VARCHAR(50),
											P_PAIS       VARCHAR(50))
BEGIN
DECLARE L_CODIGO INT;
DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;  /* Efetua a remoção de todas as alterações em caso de erro */
        RESIGNAL;  /* Retorna o erro de sql exceção a chamada */
    END;

	/* Inicia a transação */
    START TRANSACTION;

	INSERT INTO BRP_PESSOAS
	(PES_CPF, PES_NOME, PES_SENHA, PES_DATA_NASCIMENTO, PES_EMAIL)
	VALUES
	(P_CPF, P_NOME, P_SENHA, DATE_FORMAT(STR_TO_DATE(P_DATA, '%Y-%m-%d'), '%Y-%m-%d'), P_EMAIL);
    
    SELECT PES_CODIGO
    INTO L_CODIGO
    FROM
    BRP_PESSOAS
	ORDER BY PES_CODIGO DESC LIMIT 1;
    
    INSERT INTO BRP_ENDERECOS
	(END_CEP, END_LOGRADOURO, END_NUMERO, END_BAIRRO, END_CIDADE, END_ESTADO, END_PAIS, END_PES_CODIGO)
	VALUES
	(P_CEP, P_LOGRADOURO, P_NUMERO, P_BAIRRO, P_CIDADE, P_ESTADO, P_PAIS, L_CODIGO);
    
    UPDATE
    BRP_PESSOAS
    SET
    BRP_PES_END_CODIGO = L_CODIGO
    WHERE
    PES_CODIGO = L_CODIGO;

/* Grava a alteração efetuada */
COMMIT;
END