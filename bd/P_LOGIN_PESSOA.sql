CREATE DEFINER=`root`@`localhost` PROCEDURE `P_LOGIN_PESSOA`(P_EMAIL VARCHAR(50),
								  P_SENHA VARCHAR(32))
BEGIN 
    IF P_EMAIL IS NOT NULL AND P_SENHA IS NOT NULL THEN
		SELECT * FROM BRP_PESSOAS WHERE PES_EMAIL = P_EMAIL AND P_SENHA = PES_SENHA;
    END IF;
END