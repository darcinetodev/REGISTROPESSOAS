CREATE DEFINER=`root`@`localhost` PROCEDURE `P_MANUT_ENDERECO`(P_TIPO       CHAR,
									P_CODIGO_END INT,
                                    P_CODIGO_PES INT,
									P_CEP        INT,
									P_LOGRADOURO VARCHAR(50),
									P_NUMERO     INT,
									P_BAIRRO     VARCHAR(50),
									P_CIDADE     VARCHAR(50),
									P_ESTADO     VARCHAR(50),
									P_PAIS       VARCHAR(50))
BEGIN
DECLARE COUNT INT;
DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;  /* Efetua a remoção de todas as alterações em caso de erro */
        RESIGNAL;  /* Retorna o erro de sql exceção a chamada */
    END;

	/* Inicia a transação */
    START TRANSACTION;
    
    IF P_TIPO = 'I' THEN
		INSERT INTO BRP_ENDERECOS
		(END_CEP, END_LOGRADOURO, END_NUMERO, END_BAIRRO, END_CIDADE, END_ESTADO, END_PAIS, END_PES_CODIGO)
		VALUES
		(P_CEP, P_LOGRADOURO, P_NUMERO, P_BAIRRO, P_CIDADE, P_ESTADO, P_PAIS, P_CODIGO_PES);
	ELSEIF P_TIPO = 'A' THEN
		UPDATE BRP_ENDERECOS
        SET
		END_CEP = P_CEP, END_LOGRADOURO = P_LOGRADOURO,
        END_NUMERO = P_NUMERO, END_BAIRRO = P_BAIRRO, END_CIDADE = P_CIDADE,
        END_ESTADO = P_ESTADO, END_PAIS = P_PAIS, END_PES_CODIGO = P_CODIGO_PES
        WHERE
        END_CODIGO = P_CODIGO_END;
	ELSEIF P_TIPO = 'R' THEN
		SELECT COUNT(*)
        INTO COUNT
        FROM BRP_ENDERECOS
        WHERE END_PES_CODIGO = (SELECT END_PES_CODIGO
								  FROM BRP_ENDERECOS
								 WHERE END_CODIGO = P_CODIGO_END);
		
        IF COUNT > 1 THEN
			UPDATE BRP_ENDERECOS SET END_PES_CODIGO = NULL WHERE END_CODIGO = P_CODIGO_END;
			DELETE FROM BRP_ENDERECOS WHERE END_CODIGO = P_CODIGO_END;
		END IF;
    END IF;

/* Grava a alteração efetuada */
COMMIT;
END