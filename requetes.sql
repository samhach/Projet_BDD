CREATE TABLE CATEGORIE(CATEGORIE CHAR(25) PRIMARY KEY);
INSERT INTO CATEGORIE  VALUES ('Sport'), ('Habillement'), ('Meuble'), ('Musique'), ('Electro ménager');	 
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
	 
INSERT INTO ADRESSE  VALUES (0,0101, 'Robin des bois', 'Montreal', 'Quebec', 'Canada', 'H1H R2R'),
								(1,2011, 'Belle villes', 'Longueil', 'Quebec', 'Canada', 'H1H R2R'),
								(2,0333, 'Des ruelles', 'Laval', 'Quebec', 'Canada', 'H1H R2R'),
								(3,0030, 'Auclair', 'Brossard', 'Quebec', 'Canada', 'H2H R4Z'),
								(4,0403, 'Auberge', 'Brossard', 'Quebec', 'Canada', 'H4W 1K8'),
								(5,6700, 'Cote-des-Neiges', 'Montreal','Quebec', 'Canada', 'H3S 2B2'),
								(6,6755, 'Lavoie', 'Montreal','Quebec', 'Canada', 'F9X 5J5'),
								(7,6625, 'Victoria', 'Montreal','Quebec', 'Canada', 'H3W 2T2'),
								(8,6250, 'Victoria', 'Montreal', 'Quebec', 'Canada', 'H3W 3G4'),
								(9,0500, 'Laurier', 'Montreal', 'Quebec', 'Canada', 'H2J 1G8'),
								(10, 4687, 'Hutchison', 'Montreal', 'Quebec', 'Canada', 'H2X 2G3'),
								(11, 1819, 'Rene-Levesque', 'Montreal', 'Quebec', 'Canada', 'H3H 2P5'),
								(12, 5700, 'Aeroport', 'Saint-Hubert', 'Quebec', 'Canada', 'J3Y 8Y9'),
								(13, 3120, 'Taschereau', 'Greenfield Park', 'Quebec', 'Canada', 'J4V 2H1'),
								(14, 3875, 'Grande Allee', 'Saint-Hubert', 'Quebec', 'Canada', 'H2L 1J8'),
								(15, 6700, 'Laurier', 'Montreal', 'Quebec', 'Canada', 'J4T 2V8'),
								(16, 4687, 'Auberge', 'Montreal', 'Quebec', 'Canada', 'H3W 2T2'),
								(17, 6700, 'Lavoie', 'Montreal', 'Quebec', 'Canada', 'H2L 1S8'),
								(18, 4687, 'Taschereau', 'Montreal', 'Quebec', 'Canada', 'H8L 1J9'),
								(19, 0333, 'Taschereau', 'Montreal', 'Quebec', 'Canada', 'H2S 2R8'),
								(20, 0500, 'Auclair', 'Montreal', 'Quebec', 'Canada', 'H2L 1J8'),
								(21, 2011, 'August', 'Montreal', 'Quebec', 'Canada', 'H5X 1J6'),
								(22, 0403, 'Sherbrooke', 'Montreal', 'Quebec', 'Canada', 'H8W 6S6'),
								(23, 6250, 'Laurier', 'Montreal', 'Quebec', 'Canada', 'J8Y 1J8'),
								(24, 1819, 'Lavoie', 'Montreal', 'Quebec', 'Canada', 'H2L 9J8'),
								(25, 0333, 'Taschereau', 'Montreal', 'Quebec', 'Canada', 'H2L 1J8'),
								(26, 3120, 'Antoine', 'Montreal', 'Quebec', 'Canada', 'H2G 1J8'),
								(27, 2011, 'Sherbrooke', 'Montreal', 'Quebec', 'Canada', 'H2L 5J8'),
								(28, 6755, 'Laurier', 'Montreal', 'Quebec', 'Canada', 'H2L 4J8'),
								(29, 0500, 'Lavoie', 'Montreal', 'Quebec', 'Canada', 'H9W 1J5'),
								(30, 4687, 'August', 'Montreal', 'Quebec', 'Canada', 'H2L 6U8'),
								(31, 6625, 'Sherbrooke', 'Montreal', 'Quebec', 'Canada', 'H5L 1F4'),
								(32, 1819, 'Auclair', 'Montreal', 'Quebec', 'Canada', 'H5F 1W8'),
								(33, 2011, 'Sherbrooke', 'Montreal', 'Quebec', 'Canada', 'H2L 1P8'),
								(34, 0333, 'Lavoie', 'Montreal', 'Quebec', 'Canada', 'H6Y 1J8'),
								(35, 6700, 'Axe', 'Montreal', 'Quebec', 'Canada', 'H4T 7J8'),
								(36, 4687, 'Victoria', 'Montreal', 'Quebec', 'Canada', 'H2U 1I8'),								
								(37, 1111, 'Lavoie', 'Montreal', 'Quebec', 'Canada', 'J2T 7V8'),
								(38, 5687, 'Hutchison', 'Montreal', 'Quebec', 'Canada', 'H8F 1W9'),
								(39, 3696, 'Victoria', 'Montreal', 'Quebec', 'Canada', 'H4W 1J6'),
								(40, 4687, 'Lavoie', 'Montreal', 'Quebec', 'Canada', 'J0T 2V1'),
								(41, 2558, 'Auclair', 'Montreal', 'Quebec', 'Canada', 'H9T 1J2'),
								(42, 0333, 'August', 'Montreal', 'Quebec', 'Canada', 'J2T 2V0'),
								(43, 1819, 'Simard', 'Montreal', 'Quebec', 'Canada', 'H1F 7W8'),
								(44, 2558, 'Victoria', 'Montreal', 'Quebec', 'Canada', 'J7T 2V4'),
								(45, 4687, 'Sherbrooke', 'Montreal', 'Quebec', 'Canada', 'J1T 5V8'),
								(46, 9898, 'Simard', 'Montreal', 'Quebec', 'Canada', 'H7W 1J9'),
								(47, 2011, 'Riverside', 'Montreal', 'Quebec', 'Canada', 'J7T 2V3'),
								(48, 2154, 'Victoria', 'Montreal', 'Quebec', 'Canada', 'J3O 2V2'),
								(49, 5875, 'Sherbrooke', 'Montreal', 'Quebec', 'Canada', 'J1T 2V8'),
								(50, 2111, 'Lapiniere', 'Montreal', 'Quebec', 'Canada', 'J4T 5V8');	
	 
	 	 
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
	 FINALISEE BOOLEAN NOT NULL,
	 FOREIGN KEY (PROD_ID) REFERENCES PRODUIT(ID)
	 ON DELETE CASCADE ON UPDATE CASCADE,
	 FOREIGN KEY (ACHETEUR_ID) REFERENCES INTERVENANT(ID)
	 ON DELETE CASCADE ON UPDATE CASCADE,
	 FOREIGN KEY (VENDEUR_ID) REFERENCES INTERVENANT(ID)
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
  

	 
/* Insertions dans les tables */ 
	 
INSERT INTO ANNONCE VALUES (01,325, 4545, 4566,'petit aspirateur','aspirateur',72.0,'25-02-2019','20-03-2019',75.0),
						   (02,125, 389, 17,'ballon de foot cote-neiges','ballon de foot',8.0,'17-02-2019','02-04-2019',8.0),
						   (03,56, 6596, 10,'armoire ancienne','garde-robes',105.0,'03-09-2018','12-09-2018',115.0),
						   (04,78, 7852, 14,'collier de perles bleus','collier',45.0,'25-02-2019','28-02-2019',48.0),
						   (05,56, 7852, 89,'stick hockey canadiens','baton de hockey',30.0,'14-03-2018','17-03-2018',31.0),
						   (06,89, 389, 6,'toaster electrique','grille-pain',12.0,'25-02-2019','28-02-2019',12.0),
						   (07,78, 6596, 36,'petit aspirateur','aspirateur',72.0,'25-02-2019','20-03-2019',75.0),
						   (08,89, 4578, 15,'petit aspirateur','aspirateur',72.0,'25-02-2019','20-03-2019',75.0),
						   (09,125, 1256, 7,'petit aspirateur','aspirateur',72.0,'25-02-2019','20-03-2019',75.0),
						   (10,325, 4863, 17,'petit aspirateur','aspirateur',72.0,'25-02-2019','20-03-2019',75.0),
						   (11,56, 7863, 10,'petit aspirateur','aspirateur',72.0,'25-02-2019','20-03-2019',75.0),
						   (12,43, 7863, 89,'petit aspirateur','aspirateur',72.0,'25-02-2019','20-03-2019',75.0),
						   (13,44, 4863, 14,'petit aspirateur','aspirateur',72.0,'25-02-2019','20-03-2019',75.0),
						   (14,23, 389, 6,'petit aspirateur','aspirateur',72.0,'25-02-2019','20-03-2019',75.0),
						   (15,56, 6596, 15,'petit aspirateur','aspirateur',72.0,'25-02-2019','20-03-2019',75.0),
						   (16,125, 7852, 7,'petit aspirateur','aspirateur',72.0,'25-02-2019','20-03-2019',75.0),
						   (17,56, 4545, 17,'petit aspirateur','aspirateur',72.0,'25-02-2019','20-03-2019',75.0),
						   (18,89, 6398, 10,'petit aspirateur','aspirateur',72.0,'25-02-2019','20-03-2019',75.0),
						   (19,325, 4545, 28,'petit aspirateur','aspirateur',72.0,'25-02-2019','20-03-2019',75.0),
						   (20,125, 6398, 30,'petit aspirateur','aspirateur',72.0,'25-02-2019','20-03-2019',75.0),
						   (21,12, 1720, 47,'petit aspirateur','aspirateur',72.0,'25-02-2019','20-03-2019',75.0),
						   (22,78, 6398, 30,'petit aspirateur','aspirateur',72.0,'25-02-2019','20-03-2019',75.0),
						   (23,12, 389, 28,'petit aspirateur','aspirateur',72.0,'25-02-2019','20-03-2019',75.0),
						   (24,89, 6596, 105,'petit aspirateur','aspirateur',72.0,'25-02-2019','20-03-2019',75.0),
						   (25,325, 1720, 47,'petit aspirateur','aspirateur',72.0,'25-02-2019','20-03-2019',75.0),
						   (26,78, 56, 105,'petit aspirateur','aspirateur',72.0,'25-02-2019','20-03-2019',75.0),
						   (27,89, 4545, 8989,'petit aspirateur','aspirateur',72.0,'25-02-2019','20-03-2019',75.0),
						   (28,111, 56, 56,'petit aspirateur','aspirateur',72.0,'25-02-2019','20-03-2019',75.0),
						   (29,63, 1720, 15,'petit aspirateur','aspirateur',72.0,'25-02-2019','20-03-2019',75.0),
						   (30,43, 389, 150,'petit aspirateur','aspirateur',72.0,'25-02-2019','20-03-2019',75.0),
						   (31,12, 4545, 17,'petit aspirateur','aspirateur',72.0,'25-02-2019','20-03-2019',75.0),
						   (32,125, 1720, 7,'petit aspirateur','aspirateur',72.0,'25-02-2019','20-03-2019',75.0),
						   (33,325, 4545, 150,'petit aspirateur','aspirateur',72.0,'25-02-2019','20-03-2019',75.0),
						   (34,78, 56, 30,'petit aspirateur','aspirateur',72.0,'25-02-2019','20-03-2019',75.0),
						   (35,89, 389, 28,'petit aspirateur','aspirateur',72.0,'25-02-2019','20-03-2019',75.0),
						   (36,43, 1720, 11,'petit aspirateur','aspirateur',72.0,'25-02-2019','20-03-2019',75.0),
						   (37,12, 389, 14,'petit aspirateur','aspirateur',72.0,'25-02-2019','20-03-2019',75.0),
						   (38,325, 16, 15,'petit aspirateur','aspirateur',72.0,'25-02-2019','20-03-2019',75.0),
						   (39,125, 1720, 17,'petit aspirateur','aspirateur',72.0,'25-02-2019','20-03-2019',75.0),
						   (40,12, 6398, 18,'petit aspirateur','aspirateur',72.0,'25-02-2019','20-03-2019',75.0),
						   (41,78, 27, 89,'petit aspirateur','aspirateur',72.0,'25-02-2019','20-03-2019',75.0),
						   (42,49, 34, 105,'petit aspirateur','aspirateur',72.0,'25-02-2019','20-03-2019',75.0),
						   (43,89, 78, 17,'petit aspirateur','aspirateur',72.0,'25-02-2019','20-03-2019',75.0),
						   (44,14, 100, 7,'petit aspirateur','aspirateur',72.0,'25-02-2019','20-03-2019',75.0),
						   (45,125, 27, 89,'petit aspirateur','aspirateur',72.0,'25-02-2019','20-03-2019',75.0),
						   (46,89, 100, 22,'petit aspirateur','aspirateur',72.0,'25-02-2019','20-03-2019',75.0),
						   (47,14, 389, 105,'petit aspirateur','aspirateur',72.0,'25-02-2019','20-03-2019',75.0),
						   (48,12, 100, 11,'petit aspirateur','aspirateur',72.0,'25-02-2019','20-03-2019',75.0),
						   (49,111, 100, 22,'petit aspirateur','aspirateur',72.0,'25-02-2019','20-03-2019',75.0),
						   (50,56, 100, 89,'petit aspirateur','aspirateur',72.0,'25-02-2019','20-03-2019',75.0);
	 

/* LISTE DE REQUÊTES */	

/* selectionner toutes les annonces qui concernent le vendeur numéro 17 et qui ont été publiées en mars 2019 */	 
	 
	 
SELECT * FROM ANNONCE HAVING VENDEUR_ID = 17 AND WHERE substring( DATE_PUB [ FROM 4]); 
	 
	 
	 
	 
	 
