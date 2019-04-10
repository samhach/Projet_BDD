CREATE TABLE CATEGORIE(CATEGORIE CHAR(25) PRIMARY KEY);
INSERT INTO CATEGORIE  VALUES ('Sport'), ('Habillement'), ('Meuble'), ('Musique'), ('Electro m�nager');	 
CREATE TABLE ETAT (ETAT CHAR(10) PRIMARY KEY);
INSERT INTO ETAT  VALUES ('Tres bon'), ('Bon'), ('Assez bon');	
CREATE TABLE PRODUIT
	(ID  SERIAL PRIMARY KEY,
	 NOM CHAR(20) NOT NULL,
	 DESCRIPTION TEXT,
	 PRIX FLOAT NOT NULL,
	 LONGUEUR FLOAT,
	 LARGEUR FLOAT,
	 PROFONDEUR FLOAT,
	 TAILLE FLOAT,
	 MARQUE CHAR(25),
	 CATEGORIE CHAR(25) NOT NULL,
	 ETAT CHAR(10),
	 FOREIGN KEY (CATEGORIE) REFERENCES CATEGORIE(CATEGORIE)
	 ON DELETE CASCADE ON UPDATE CASCADE,
	 FOREIGN KEY (ETAT) REFERENCES ETAT(ETAT) ON DELETE CASCADE
	 ON UPDATE CASCADE
	 );
CREATE TABLE ADRESSE
	(ID  SERIAL PRIMARY KEY,
	 NUMERO_APPART INT,
	 RUE CHAR(25),
	 VILLE CHAR(25) NOT NULL,
	 PROVINCE CHAR(25),
	 PAYS CHAR(25),
	 CODE_POSTAL CHAR(7)	 
	 );
	 
INSERT INTO ADRESSE  VALUES (0,0101, 'Robin des bois', 'Montr�al', 'Qu�bec', 'Canada', 'H1H R2R'),
								(1,2011, 'Belle villes', 'Longueil', 'Qu�bec', 'Canada', 'H1H R2R'),
								(2,0333, 'Des ruelles', 'Laval', 'Qu�bec', 'Canada', 'H1H R2R');	
	 
	 	 
CREATE TABLE INTERVENANT
	(ID  SERIAL PRIMARY KEY,
	 NOM CHAR(25) NOT NULL,
	 EMAIL CHAR(25),
	 ADRESSE_ID INT,
	 NUM_TEL TEXT,
	 FOREIGN KEY (ADRESSE_ID) REFERENCES ADRESSE(ID)
	 ON DELETE CASCADE ON UPDATE CASCADE
	 );
ALTER TABLE INTERVENANT
  ADD CONSTRAINT numerotel_check CHECK (NUM_TEL ~ '^[0-9]{10,} || [0-9]{3,} [0-9]{3,}[0-9]{4,}$'::text);	
  
INSERT INTO INTERVENANT VALUES(0,'BOB', 'BOB@MAIL',0,'5141112222' ), 
								(1, 'Toto', 'TOTO@MAIL',0,'5142223333' );
 	
CREATE TABLE ANNONCE
	(ID  SERIAL PRIMARY KEY,
	 PROD_ID INT NOT NULL,
	 ACHETEUR_ID INT,
	 VENDEUR_ID INT NOT NULL,
	 TITRE CHAR(100),
	 DESCRIPTION TEXT,
	 PRIX_ESTIME FLOAT NOT NULL,
	 DATE_PUB CHAR(10) NOT NULL,
	 DATE_VENTE CHAR(10),
	 PRIX_ACHETEUR FLOAT,
	 FOREIGN KEY (PROD_ID) REFERENCES PRODUIT(ID)
	 ON DELETE CASCADE ON UPDATE CASCADE,
	 FOREIGN KEY (ACHETEUR_ID) REFERENCES INTERVENANT(ID)
	 ON DELETE CASCADE ON UPDATE CASCADE,
	 FOREIGN KEY (PROD_ID) REFERENCES PRODUIT(ID)
	 ON DELETE CASCADE ON UPDATE CASCADE
	 );
CREATE OR REPLACE FUNCTION checkName(id INTEGER)
	RETURNS BOOLEAN AS
	$$
	BEGIN
		IF VENDEUR_NOM IN (SELECT NOM FROM INTERVENANT)
			THEN RETURN true;
		ELSE RETURN false;
			END IF;
	END;
	$$ LANGUAGE PLpgSQL;
  

	 
	 
	 
	 
	 
	 
	 
	 
	 