CREATE DEFINER=`root`@`localhost` PROCEDURE `P_MANUT_PESSOA`(P_TIPO   CHAR,
								  P_CODIGO INT,
								  P_CPF    DOUBLE,
								  P_NOME   VARCHAR(50),
								  P_SENHA  VARCHAR(32),
								  P_DATA   VARCHAR(11),
								  P_EMAIL  VARCHAR(50))
BEGIN
DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;  /* Efetua a remoção de todas as alterações em caso de erro */
        RESIGNAL;  /* Retorna o erro de sql exceção a chamada */
    END;

	/* Inicia a transação */
    START TRANSACTION;
    
    IF P_TIPO = 'A' THEN
		IF P_SENHA <> '' THEN
			UPDATE BRP_PESSOAS
			SET
			PES_CPF = P_CPF, PES_NOME = P_NOME, PES_SENHA = P_SENHA,
			PES_DATA_NASCIMENTO = DATE_FORMAT(STR_TO_DATE(P_DATA, '%Y-%m-%d'), '%Y-%m-%d'), PES_EMAIL = P_EMAIL
			WHERE
			PES_CODIGO = P_CODIGO;
		ELSE
			UPDATE BRP_PESSOAS
			SET
			PES_CPF = P_CPF, PES_NOME = P_NOME,
			PES_DATA_NASCIMENTO = DATE_FORMAT(STR_TO_DATE(P_DATA, '%Y-%m-%d'), '%Y-%m-%d'), PES_EMAIL = P_EMAIL
			WHERE
			PES_CODIGO = P_CODIGO;
		END IF;
	ELSEIF P_TIPO = 'R' THEN
		DELETE FROM BRP_PESSOAS WHERE PES_CODIGO = P_CODIGO;
        DELETE FROM BRP_ENDERECOS WHERE END_PES_CODIGO = P_CODIGO;
    END IF;

/* Grava a alteração efetuada */
COMMIT;
END