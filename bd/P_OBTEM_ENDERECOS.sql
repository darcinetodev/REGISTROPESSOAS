CREATE DEFINER=`root`@`localhost` PROCEDURE `P_OBTEM_ENDERECOS`(P_PES_CODIGO INT,
																P_END_CODIGO INT)
BEGIN
	IF P_PES_CODIGO IS NOT NULL THEN
		SELECT * FROM BRP_ENDERECOS WHERE END_PES_CODIGO = P_PES_CODIGO;
	ELSEIF P_END_CODIGO IS NOT NULL THEN
		SELECT END_PES_CODIGO FROM BRP_ENDERECOS WHERE END_CODIGO = P_END_CODIGO;
    ELSE
		SELECT * FROM BRP_ENDERECOS;
    END IF;
END