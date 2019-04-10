
/* fonction qui conclut une vente si un acheteur propose un prix d'achat supérieur au prix de vente : */

CREATE OR REPLACE FUNCTION conclure_achat_produit( code_annonce INT, code_vendeur INT, code_acheteur INT ) RETURNS TRIGGER AS
$$
DECLARE
	prix_vente FLOAT NOT NULL;
	prix_achat FLOAT NOT NULL;

BEGIN
	/* trouver quels sont les prix de vente et d'achat : */
	prix_vente = SELECT PROPOSITION FROM INTERVENANT WHERE VENDEUR_ID = code_vendeur;
	prix_achat = SELECT PROPOSITION FROM INTERVENANT WHERE ACHETEUR_ID = code_acheteur;
	
	IF ( prix_achat > prix_vente )
		THEN 
			UPDATE ANNONCE
			SET ETAT_ANNONCE = 'TERMINEE'
			WHERE ID = code_annonce;
	END IF;
END;
$BODY$ language plpgsql;