CREATE TABLE NiveauEtude(
    idniveauetude serial PRIMARY KEY,
    libelle varchar(20) NOT NULL
);

CREATE TABLE Specialite(
    idspecialite serial PRIMARY KEY,
    libelle varchar(20) NOT NULL
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

INSERT INTO Specialite(libelle) VALUES('Electricien');
INSERT INTO Specialite(libelle) VALUES('Mécanicien');
INSERT INTO Specialite(libelle) VALUES('Agent Entretien');
INSERT INTO Specialite(libelle) VALUES('Dépanneur');
INSERT INTO Specialite(libelle) VALUES('Assistant mécano');
INSERT INTO Specialite(libelle) VALUES('Assistant élec');

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
    prixHoraire double precision
);

CREATE TABLE TraitementService(
    idtraitement serial PRIMARY KEY,
    idservice integer NOT NULL references Service(idservice),
    idspecialite integer NOT NULL references Specialite(idspecialite),
    duree double precision
);

--Donnee de test 
INSERT INTO Service(nomservice, prixHoraire) VALUES('Réparation bougie',10000);1
INSERT INTO Service(nomservice, prixHoraire) VALUES('Paralellisme',12000);2
INSERT INTO Service(nomservice, prixHoraire) VALUES('Réparation circuit',15000);3
INSERT INTO Service(nomservice, prixHoraire) VALUES('Remplacer filtre',15000);4
INSERT INTO Service(nomservice, prixHoraire) VALUES('Vidange',10000);5
INSERT INTO Service(nomservice, prixHoraire) VALUES('Maintenance général',10000);6
INSERT INTO Service(nomservice, prixHoraire) VALUES('Réparation phares',10000);7
INSERT INTO Service(nomservice, prixHoraire) VALUES('Réparation freinage',10000);8
INSERT INTO Service(nomservice, prixHoraire) VALUES('Dépanage pneu',10000);9
INSERT INTO Service(nomservice, prixHoraire) VALUES('Diagnostic circuit',30000);10
INSERT INTO Service(nomservice, prixHoraire) VALUES('Nettoyage',6000);11

INSERT INTO Specialite(libelle) VALUES('Electricien');
INSERT INTO Specialite(libelle) VALUES('Mécanicien');
INSERT INTO Specialite(libelle) VALUES('Agent Entretien');
INSERT INTO Specialite(libelle) VALUES('Dépanneur');
INSERT INTO Specialite(libelle) VALUES('Assistant mécano');
INSERT INTO Specialite(libelle) VALUES('Assistant élec');

INSERT INTO TraitementService(idservice, idspecialite) VALUES(1,1);
INSERT INTO TraitementService(idservice, idspecialite) VALUES(2,1);
INSERT INTO TraitementService(idservice, idspecialite) VALUES(2,1);
INSERT INTO TraitementService(idservice, idspecialite) VALUES(3,1);
INSERT INTO TraitementService(idservice, idspecialite) VALUES(4,1);
INSERT INTO TraitementService(idservice, idspecialite) VALUES(5,1);
INSERT INTO TraitementService(idservice, idspecialite) VALUES(6,1);
INSERT INTO TraitementService(idservice, idspecialite) VALUES(7,1);
INSERT INTO TraitementService(idservice, idspecialite) VALUES(8,1);
INSERT INTO TraitementService(idservice, idspecialite) VALUES(9,1);
INSERT INTO TraitementService(idservice, idspecialite) VALUES(10,1);
INSERT INTO TraitementService(idservice, idspecialite) VALUES(11,1);


-- vue v_service: Service + Specialite + TraitementService

-- CREATE VIEW v_service AS SELECT * FROM (SELECT Specialite* FROM Specialite join TraitementService ON idspecialite = TraitementService.idspecialite) JOIN Service ON idservice = Specialite.specialite;

