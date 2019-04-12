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
INSERT INTO PRODUIT VALUES (0,'Produit0','Description du produit0','0','0','0','0','0','Marque0','Sport','Bon'),
							(1,'Produit1','Description du produit0','0','0','0','0','0','Marque0','Sport','Bon'),
							(2,'Produit2','Description du produit2','2','0','0','0','0','Marque2','Sport','Bon'),
							(3,'Produit3','Description du produit3','3','0','0','0','0','Marque3','Sport','Bon'),
							(4,'Produit4','Description du produit4','4','0','0','0','0','Marque4','Sport','Bon'),
							(5,'Produit5','Description du produit5','5','0','0','0','0','Marque5','Sport','Bon'),
							(6,'Produit6 ','Description du produit6','6','0','0','0','0','Marque6','Sport','Bon'),
							(7,'Produit7 ','Description du produit7','7','0','0','0','0','Marque7','Sport','Bon'),
							(8,'Produit8 ','Description du produit8','8','0','0','0','0','Marque8','Sport','Bon'),
							(9,'Produit9 ','Description du produit9','9','0','0','0','0','Marque9','Sport','Bon'),
							(10,'Produit10','Description du produit10','10','0','0','0','0','Marque10','Sport','Bon'),
							(11,'Produit11','Description du produit11','11','0','0','0','0','Marque11','Sport','Bon'),
							(12,'Produit12','Description du produit12','12','0','0','0','0','Marque12','Sport','Bon'),
							(13,'Produit13','Description du produit13','13','0','0','0','0','Marque13','Sport','Bon'),
							(14,'Produit14','Description du produit14','14','0','0','0','0','Marque14','Sport','Bon'),
							(15,'Produit15','Description du produit15','15','0','0','0','0','Marque15','Sport','Bon'),
							(16,'Produit16','Description du produit16','16','0','0','0','0','Marque16','Sport','Bon'),
							(17,'Produit17','Description du produit17','17','0','0','0','0','Marque17','Sport','Bon'),
							(18,'Produit18','Description du produit18','18','0','0','0','0','Marque18','Sport','Bon'),
							(19,'Produit19','Description du produit19','19','0','0','0','0','Marque19','Sport','Bon'),
							(20,'Produit20','Description du produit20','20','0','0','0','0','Marque20','Sport','Bon'),
							(21,'Produit21','Description du produit21','21','0','0','0','0','Marque21','Sport','Bon'),
							(22,'Produit22','Description du produit22','22','0','0','0','0','Marque22','Sport','Bon'),
							(23,'Produit23','Description du produit23','23','0','0','0','0','Marque23','Sport','Bon'),
							(24,'Produit24','Description du produit24','24','0','0','0','0','Marque24','Sport','Bon'),
							(25,'Produit25','Description du produit25','25','0','0','0','0','Marque25','Sport','Bon'),
							(26,'Produit26','Description du produit26','26','0','0','0','0','Marque26','Sport','Bon'),
							(27,'Produit27','Description du produit27','27','0','0','0','0','Marque27','Sport','Bon'),
							(28,'Produit28','Description du produit28','28','0','0','0','0','Marque28','Sport','Bon'),
							(29,'Produit29','Description du produit29','29','0','0','0','0','Marque29','Sport','Bon'),
							(30,'Produit30','Description du produit30','30','0','0','0','0','Marque30','Sport','Bon'),
							(31,'Produit31','Description du produit31','31','0','0','0','0','Marque31','Sport','Bon'),
							(32,'Produit32','Description du produit32','32','0','0','0','0','Marque32','Sport','Bon'),
							(33,'Produit33','Description du produit33','33','0','0','0','0','Marque33','Sport','Bon'),
							(34,'Produit34','Description du produit34','34','0','0','0','0','Marque34','Sport','Bon'),
							(35,'Produit35','Description du produit35','35','0','0','0','0','Marque35','Sport','Bon'),
							(36,'Produit36','Description du produit36','36','0','0','0','0','Marque36','Sport','Bon'),
							(37,'Produit37','Description du produit37','37','0','0','0','0','Marque37','Sport','Bon'),
							(38,'Produit38','Description du produit38','38','0','0','0','0','Marque38','Sport','Bon'),
							(39,'Produit39','Description du produit39','39','0','0','0','0','Marque39','Sport','Bon'),
							(40,'Produit40','Description du produit40','40','0','0','0','0','Marque40','Sport','Bon'),
							(41,'Produit41','Description du produit41','41','0','0','0','0','Marque41','Sport','Bon'),
							(42,'Produit42','Description du produit42','42','0','0','0','0','Marque42','Sport','Bon'),
							(43,'Produit43','Description du produit43','43','0','0','0','0','Marque43','Sport','Bon'),
							(44,'Produit44','Description du produit44','44','0','0','0','0','Marque44','Sport','Bon'),
							(45,'Produit45','Description du produit45','45','0','0','0','0','Marque45','Sport','Bon'),
							(46,'Produit46','Description du produit46','46','0','0','0','0','Marque46','Sport','Bon'),
							(47,'Produit47','Description du produit47','47','0','0','0','0','Marque47','Sport','Bon'),
							(48,'Produit48','Description du produit48','48','0','0','0','0','Marque48','Sport','Bon'),
							(49,'Produit1','Description du produit1','1','0','0','0','0','Marque1','Sport','Bon'),
							(50,'Produit49','Description du produit49','49','0','0','0','0','Marque49','Sport','Bon'); 
CREATE TABLE ADRESSE
	(ID  SERIAL PRIMARY KEY,
	 NUMERO_APPART INT,
	 RUE CHAR(25),
	 VILLE CHAR(25) NOT NULL,
	 PROVINCE CHAR(25),
	 PAYS CHAR(25),
	 CODE_POSTAL CHAR(7)	 
	 );
	 
INSERT INTO ADRESSE  VALUES (0,0101, 'Robin des bois ', 'Montreal', 'Quebec', 'Canada', 'H1H R2R'),
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
								(1, 'Toto', 'TOTO@MAIL',0,'5142223333' ),
								(2, 'Abnormal', 'Abnormal@mail.com', 2, '5143000002'),
(3, 'Alex', 'Alex@mail.com', 3, '5143000003'),
(4, 'Alex', 'Alex@mail.com', 4, '5143000004'),
(5, 'Alexandre', 'Alexandre@mail.com', 5, '5143000005'),
(6, 'Alexandra', 'Alexandra@mail.com', 6, '5143000006'),
(7, 'Asley', 'Asley@mail.com', 7, '5143000007'),
(8, 'Bob', 'Bob@mail.com', 8, '5143000008'),
(9, 'Bobby', 'Bobby@mail.com', 9, '5143000009'),
(10, 'Bea', 'Bea@mail.com', 10, '5143000010'),
(11, 'Beatrix', 'Beatrix@mail.com', 11, '5143000011'),
(12, 'Aabi', 'Aabi@mail.com', 12, '5143000012'),
(13, 'Abe', 'Abe@mail.com', 13, '5143000013'),
(14, 'Abnormal', 'Abnormal@mail.com', 14, '5143000014'),
(15, 'Alex', 'Alex@mail.com', 15, '5143000015'),
(16, 'Alex', 'Alex@mail.com', 16, '5143000016'),
(17, 'Alexandre', 'Alexandre@mail.com', 17, '5143000017'),
(18, 'Alexandra', 'Alexandra@mail.com', 18, '5143000018'),
(19, 'Asley', 'Asley@mail.com', 19, '5143000019'),
(20, 'Bob', 'Bob@mail.com', 20, '5143000020'),
(21, 'Bobby', 'Bobby@mail.com', 21, '5143000021'),
(22, 'Bea', 'Bea@mail.com', 22, '5143000022'),
(23, 'Beatrix', 'Beatrix@mail.com', 23, '5143000023'),
(24, 'Aabi', 'Aabi@mail.com', 24, '5143000024'),
(25, 'Abe', 'Abe@mail.com', 25, '5143000025'),
(26, 'Abnormal', 'Abnormal@mail.com', 26, '5143000026'),
(27, 'Alex', 'Alex@mail.com', 27, '5143000027'),
(28, 'Alex', 'Alex@mail.com', 28, '5143000028'),
(29, 'Alexandre', 'Alexandre@mail.com', 29, '5143000029'),
(30, 'Alexandra', 'Alexandra@mail.com', 30, '5143000030'),
(31, 'Asley', 'Asley@mail.com', 31, '5143000031'),
(32, 'Bob', 'Bob@mail.com', 32, '5143000032'),
(33, 'Bobby', 'Bobby@mail.com', 33, '5143000033'),
(34, 'Bea', 'Bea@mail.com', 34, '5143000034'),
(35, 'Beatrix', 'Beatrix@mail.com', 35, '5143000035'),
(36, 'Aabi', 'Aabi@mail.com', 36, '5143000036'),
(37, 'Abe', 'Abe@mail.com', 37, '5143000037'),
(38, 'Abnormal', 'Abnormal@mail.com', 38, '5143000038'),
(39, 'Alex', 'Alex@mail.com', 39, '5143000039'),
(40, 'Alex', 'Alex@mail.com', 40, '5143000040'),
(41, 'Alexandre', 'Alexandre@mail.com', 41, '5143000041'),
(42, 'Alexandra', 'Alexandra@mail.com', 42, '5143000042'),
(43, 'Asley', 'Asley@mail.com', 43, '5143000043'),
(44, 'Bob', 'Bob@mail.com', 44, '5143000044'),
(45, 'Bobby', 'Bobby@mail.com', 45, '5143000045'),
(46, 'Bea', 'Bea@mail.com', 46, '5143000046'),
(47, 'Beatrix', 'Beatrix@mail.com', 47, '5143000047'),
(48, 'Aabi', 'Aabi@mail.com', 48, '5143000048'),
(49, 'Abe', 'Abe@mail.com', 49, '5143000049');
 	
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
	 FINALISEE BOOLEAN DEFAULT FALSE,
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
		ELSE RETURN FALSE;
			END IF;
	END;
	$$ LANGUAGE PLpgSQL;
  

	 
/* Insertions dans les tables */ 
	 
INSERT INTO ANNONCE VALUES (1,0, NULL, 1,'petit aspirateur','aspirateur',72.0,'25-02-2019','20-03-2019',75.0,'TRUE'),
						   (2,1, NULL, 5,'ballon de foot cote-neiges','ballon de foot',8.0,'17-02-2019','02-04-2019',8.0,'TRUE'),
						   (3,2, NULL, 20,'armoire ancienne','garde-robes',105.0,'03-09-2018','12-09-2018',115.0,'TRUE'),
						   (4,3, NULL, 14,'collier de perles bleus','collier',45.0,'25-02-2019','28-02-2019',48.0,'TRUE'),
						   (5,4, NULL, 5,'stick hockey canadiens','baton de hockey',30.0,'14-03-2018','17-03-2018',31.0,'TRUE'),
						   (6,5, NULL, 6,'toaster electrique','grille-pain',12.0,'25-02-2019','28-02-2019',12.0,'TRUE'),
						   (7,6, NULL, 36,'petit aspirateur','aspirateur',72.0,'25-02-2019','20-03-2019',75.0,'TRUE'),
						   (8,7, NULL, 15,'petit aspirateur','aspirateur',72.0,'25-02-2019','20-03-2019',75.0,'TRUE'),
						   (9,8, NULL, 7,'petit aspirateur','aspirateur',72.0,'25-02-2019','20-03-2019',75.0,'TRUE'),
						   (10,9, NULL, 17,'petit aspirateur','aspirateur',72.0,'25-02-2019','20-03-2019',75.0,'TRUE'),
						   (11,10, NULL, 10,'petit aspirateur','aspirateur',72.0,'25-02-2019','20-03-2019',75.0,'TRUE'),
						   (12,11, NULL, 3,'petit aspirateur','aspirateur',72.0,'25-02-2019','20-03-2019',75.0,'TRUE'),
						   (13,12, NULL, 14,'petit aspirateur','aspirateur',72.0,'25-02-2019','20-03-2019',75.0,'TRUE'),
						   (14,13, NULL, 6,'petit aspirateur','aspirateur',72.0,'25-02-2019','20-03-2019',75.0,'TRUE'),
						   (15,14, NULL, 15,'petit aspirateur','aspirateur',72.0,'25-02-2019','20-03-2019',75.0,'TRUE'),
						   (16,15, 1, 7,'petit aspirateur','aspirateur',72.0,'25-02-2019',NULL,75.0, 'FALSE'),
						   (17,16, 23, 17,'petit aspirateur','aspirateur',72.0,'25-02-2019',NULL,75.0,'FALSE'),
						   (18,17, 6, 10,'petit aspirateur','aspirateur',72.0,'25-02-2019',NULL,75.0,'FALSE'),
						   (19,18, 15, 28,'petit aspirateur','aspirateur',72.0,'25-02-2019',NULL,75.0,'FALSE'),
						   (20,19, 45, 30,'petit aspirateur','aspirateur',72.0,'25-02-2019',NULL,75.0,'FALSE'),
						   (21,20, 10, 47,'petit aspirateur','aspirateur',72.0,'25-02-2019',NULL,75.0,'FALSE'),
						   (22,21, 20, 30,'petit aspirateur','aspirateur',72.0,'25-02-2019',NULL,75.0,'FALSE'),
						   (23,22, 1, 28,'petit aspirateur','aspirateur',72.0,'25-02-2019',NULL,75.0,'FALSE'),
						   (24,23, 2, 10,'petit aspirateur','aspirateur',72.0,'25-02-2019',NULL,75.0,'FALSE'),
						   (25,24, 15, 47,'petit aspirateur','aspirateur',72.0,'25-02-2019',NULL,75.0,'FALSE'),
						   (26,25, 15, 10,'petit aspirateur','aspirateur',72.0,'25-02-2019',NULL,75.0,'FALSE'),
						   (27,26, 18, 8,'petit aspirateur','aspirateur',72.0,'25-02-2019',NULL,75.0,'FALSE'),
						   (28,27, 45, 5,'petit aspirateur','aspirateur',72.0,'25-02-2019',NULL,75.0,'FALSE'),
						   (29,28, 42, 15,'petit aspirateur','aspirateur',72.0,'25-02-2019',NULL,75.0,'FALSE'),
						   (30,29, NULL, 10,'petit aspirateur','aspirateur',72.0,'25-02-2019','20-03-2019',75.0, 'TRUE'),
						   (31,30, 45, 17,'petit aspirateur','aspirateur',72.0,'25-02-2019',NULL,75.0,'FALSE'),
						   (32,31, 10, 7,'petit aspirateur','aspirateur',72.0,'25-02-2019',NULL,75.0,'FALSE'),
						   (33,32, 5, 15,'petit aspirateur','aspirateur',72.0,'25-02-2019',NULL,75.0,'FALSE'),
						   (34,33, 6, 30,'petit aspirateur','aspirateur',72.0,'25-02-2019',NULL,75.0,'FALSE'),
						   (35,34, 9, 28,'petit aspirateur','aspirateur',72.0,'25-02-2019',NULL,75.0,'FALSE'),
						   (36,35, 0, 11,'petit aspirateur','aspirateur',72.0,'25-02-2019',NULL,75.0,'FALSE'),
						   (37,36, 9, 14,'petit aspirateur','aspirateur',72.0,'25-02-2019',NULL,75.0,'FALSE'),
						   (38,38, NULL, 15,'petit aspirateur','aspirateur',72.0,'25-02-2019','20-03-2019',75.0, 'TRUE'),
						   (39,39, 1, 17,'petit aspirateur','aspirateur',72.0,'25-02-2019',NULL,75.0,'FALSE'),
						   (40,40, 6, 18,'petit aspirateur','aspirateur',72.0,'25-02-2019',NULL,75.0,'FALSE'),
						   (41,41, 27, 8,'petit aspirateur','aspirateur',72.0,'25-02-2019',NULL,75.0,'FALSE'),
						   (42,42, 34, 10,'petit aspirateur','aspirateur',72.0,'25-02-2019',NULL,75.0,'FALSE'),
						   (43,43, 8, 17,'petit aspirateur','aspirateur',72.0,'25-02-2019','20-03-2019',75.0,'FALSE'),
						   (44,44, NULL, 7,'petit aspirateur','aspirateur',72.0,'25-02-2019','20-03-2019',75.0,'TRUE'),
						   (45,45, NULL, 9,'petit aspirateur','aspirateur',72.0,'25-02-2019','20-03-2019',75.0, 'TRUE'),
						   (46,46, NULL, 22,'petit aspirateur','aspirateur',72.0,'25-02-2019','20-03-2019',75.0, 'TRUE'),
						   (47,47, 39, 15,'petit aspirateur','aspirateur',72.0,'25-02-2019',NULL,75.0,'FALSE'),
						   (48,48, 10, 11,'petit aspirateur','aspirateur',72.0,'25-02-2019',NULL,75.0,'FALSE'),
						   (49,49,0, 22,'petit aspirateur','aspirateur',72.0,'25-02-2019',NULL,75.0,'FALSE'),
						   (50,50, 36, 8,'petit aspirateur','aspirateur',72.0,'25-02-2019',NULL,75.0,'FALSE');
	 

	 
WITH RQ1 AS 
	(SELECT INTERVENANT.ID AS INTERV_ID, VILLE, PROVINCE, PAYS, NUM_TEL FROM 
			INTERVENANT JOIN ADRESSE ON (ADRESSE.ID = INTERVENANT.ADRESSE_ID )), 
	RQ2 AS
		(SELECT ANNONCE.ID AS ANNONCE_ID, VENDEUR_ID, PRODUIT.ID, NOM, 
			PRODUIT.DESCRIPTION AS DESCRIP, PRIX, TAILLE, LONGUEUR, LARGEUR, PROFONDEUR, CATEGORIE, ETAT,
			DATE_PUB, TITRE, FINALISEE FROM ANNONCE JOIN PRODUIT ON (PROD_ID = PRODUIT.ID)) 
	SELECT ANNONCE_ID, NOM, DESCRIP, PRIX, TAILLE, LONGUEUR, LARGEUR, PROFONDEUR, CATEGORIE, ETAT,  
				DATE_PUB, TITRE, VILLE, PROVINCE, PAYS, NUM_TEL, FINALISEE FROM RQ1 JOIN RQ2 ON (VENDEUR_ID = INTERV_ID); 
	 
	 
	 


