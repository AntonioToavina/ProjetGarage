CREATE TABLE NiveauEtude(
    idniveauetude serial PRIMARY KEY,
    libelle varchar(20) NOT NULL
);

CREATE TABLE Specialite(
    idspecialite serial PRIMARY KEY,
    libelle varchar(20) NOT NULL,
    salaireHoraire double precision NOT NULL
);

CREATE TABLE Employe(
    idemploye integer PRIMARY KEY default(nextval('s_employe')),
    nom varchar(20) NOT NULL,
    prenom varchar(20) NOT NULL,
    datenaissance date NOT NULL,  
    idniveauetude integer NOT NULL references NiveauEtude(idniveauetude)
);

CREATE TABLE Employe_specialite(
    idemployespecialite integer PRIMARY KEY default(nextval('s_employespecialite')),
    idspecialite integer NOT NULL references Specialite(idspecialite),
    idemploye integer NOT NULL references Employe(idemploye)
);

--Vue employe + specialite + employe_specialite : v_infoemploye
CREATE VIEW v_employespec AS SELECT Employe.*, idspecialite FROM Employe JOIN Employe_specialite ON Employe.idemploye = Employe_specialite.idemploye;
CREATE VIEW v_infoemploye AS SELECT Employe_spec.*,libelle FROM v_employespec AS Employe_spec JOIN Specialite ON Employe_spec.idspecialite = Specialite.idspecialite;

--donne de test
INSERT INTO NiveauEtude(libelle) VALUES('Bacc');
INSERT INTO NiveauEtude(libelle) VALUES('Licence');
INSERT INTO NiveauEtude(libelle) VALUES('Master');
INSERT INTO NiveauEtude(libelle) VALUES('Bepc');

INSERT INTO Specialite(libelle, salaireHoraire) VALUES('Electricien',30000);
INSERT INTO Specialite(libelle, salaireHoraire) VALUES('Mécanicien',30000);
INSERT INTO Specialite(libelle, salaireHoraire) VALUES('Agent Entretien',10000);
INSERT INTO Specialite(libelle, salaireHoraire) VALUES('Dépanneur',20000);
INSERT INTO Specialite(libelle, salaireHoraire) VALUES('Assistant mécano',15000);
INSERT INTO Specialite(libelle, salaireHoraire) VALUES('Assistant élec',15000);

INSERT INTO Employe(nom, prenom, datenaissance, idniveauetude) VALUES('Rakotomalala','Pierre','13-01-2000',2);
INSERT INTO Employe(nom, prenom, datenaissance, idniveauetude) VALUES('Ramaria','Jean Paul','19-11-1995',3);
INSERT INTO Employe(nom, prenom, datenaissance, idniveauetude) VALUES('Andriabe','Annie','23-03-1999',2);
INSERT INTO Employe(nom, prenom, datenaissance, idniveauetude) VALUES('Valisoa','Fifaliana','03-10-1997',3);
INSERT INTO Employe(nom, prenom, datenaissance, idniveauetude) VALUES('Lalaina','Tafita','19-11-2002',2);
INSERT INTO Employe(nom, prenom, datenaissance, idniveauetude) VALUES('Andrianasolo','Rakoto','01-08-2001',2);
INSERT INTO Employe(nom, prenom, datenaissance, idniveauetude) VALUES('Rakoto','Antso','12-02-2000',2);
INSERT INTO Employe(nom, prenom, datenaissance, idniveauetude) VALUES('Rabe','Henitsoa','12-02-2000',1);

INSERT INTO Employe_specialite(idemploye, idspecialite) VALUES(1,5);
INSERT INTO Employe_specialite(idemploye, idspecialite) VALUES(2,2);
INSERT INTO Employe_specialite(idemploye, idspecialite) VALUES(3,5);
INSERT INTO Employe_specialite(idemploye, idspecialite) VALUES(4,1);
INSERT INTO Employe_specialite(idemploye, idspecialite) VALUES(5,6);
INSERT INTO Employe_specialite(idemploye, idspecialite) VALUES(6,4);
INSERT INTO Employe_specialite(idemploye, idspecialite) VALUES(7,6);
INSERT INTO Employe_specialite(idemploye, idspecialite) VALUES(8,3);

----
CREATE TABLE Service(
    idservice integer PRIMARY KEY default(nextval('s_service')),
    nomservice varchar(20) NOT NULL,
    prixHoraire double precision,
    taux double precision NOT NULL default 20
);

CREATE TABLE TraitementService(
    idtraitement serial PRIMARY KEY,
    idservice integer NOT NULL references Service(idservice),
    idspecialite integer NOT NULL references Specialite(idspecialite),
    duree double precision
);

--Donnee de test 
<<<<<<< Updated upstream
INSERT INTO Service(nomservice) VALUES('Vidange');
INSERT INTO Service(nomservice) VALUES('Réparation bougie');
INSERT INTO Service(nomservice) VALUES('Paralellisme');
INSERT INTO Service(nomservice) VALUES('Réparation circuit');
INSERT INTO Service(nomservice) VALUES('Remplacer filtre');
=======
INSERT INTO Service(nomservice, prixHoraire,taux) VALUES('Vidange',10000,20);
INSERT INTO Service(nomservice, prixHoraire,taux) VALUES('Réparation bougie',10000,20);
INSERT INTO Service(nomservice, prixHoraire,taux) VALUES('Paralellisme',12000,20);
INSERT INTO Service(nomservice, prixHoraire,taux) VALUES('Réparation circuit',15000,29);
INSERT INTO Service(nomservice, prixHoraire,taux) VALUES('Remplacer filtre',15000,20);
>>>>>>> Stashed changes

INSERT INTO TraitementService(idservice, idspecialite, duree) VALUES(1,2,1);
INSERT INTO TraitementService(idservice, idspecialite, duree) VALUES(1,3,0.5);
INSERT INTO TraitementService(idservice, idspecialite, duree) VALUES(2,1,0.5);
INSERT INTO TraitementService(idservice, idspecialite, duree) VALUES(2,2,0.5);
INSERT INTO TraitementService(idservice, idspecialite, duree) VALUES(3,2,1);
INSERT INTO TraitementService(idservice, idspecialite, duree) VALUES(4,1,1);
INSERT INTO TraitementService(idservice, idspecialite, duree) VALUES(5,2,1);


-- vue v_service: Service + Specialite + TraitementService
CREATE VIEW v_traitement AS SELECT Specialite.*,idservice,duree FROM Specialite join TraitementService ON Specialite.idspecialite = TraitementService.idspecialite;
CREATE VIEW v_service AS SELECT v_traitement.*,nomservice,prixHoraire FROM v_traitement JOIN Service ON v_traitement.idservice = Service.idservice;


CREATE TABLE Materiel(
    idmateriel serial PRIMARY KEY,
    nom varchar(20) NOT NULL,
    prixconsommation double precision NOT NULL,
    unite varchar(20) NOT NULL
);

CREATE TABLE DepenseMateriel_Service(
    iddepensemateriel serial PRIMARY KEY,
    idmateriel integer NOT NULL REFERENCES Materiel(idmateriel),
    idservice integer NOT NULL REFERENCES Service(idservice),
    volumeconsommation double precision NOT NULL 
);

INSERT INTO Materiel(nom,prixconsommation,unite) values('Huile moteur',8000,'litre'),
                                                ('Machine',20000 ,'heure'),
                                                ('Soudure',20000,'heure'),
                                                ('Electricite',30000,'heure');

INSERT INTO DepenseMateriel_Service(idmateriel,idservice,volumeconsommation) VALUES
    (1,1,20),
    (2,1,1),

    (3,2,3),

    (3,3,2),

    (4,4,4),

    (2,5,2);


---- Vue v_depenseMateriel
CREATE OR REPLACE VIEW v_depenseMateriel AS
SELECT 
    ds.*,
    m.nom as nommateriel,
    m.prixconsommation,
    m.unite,
    s.nomservice,
    s.prixhoraire
FROM 
    Materiel m 
    join DepenseMateriel_Service ds on m.idmateriel=ds.idmateriel
    join Service s on ds.idservice=s.idservice;


