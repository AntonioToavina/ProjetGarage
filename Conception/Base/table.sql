CREATE TABLE NiveauEtude(
    idniveauetude serial PRIMARY KEY,
    libelle varchar(20) NOT NULL
);

CREATE TABLE Specialite(
    idspecilaite serial PRIMARY KEY,
    libelle varchar(20) NOT NULL
);


CREATE TABLE Employe(
    idemploye integer PRIMARY KEY default(nextval('s_employe')),
    nom varchar(20) NOT NULL,
    prenom varchar(20) NOT NULL,
    datenaissance date NOT NULL,  
    idniveauetude 
);

CREATE TABLE Employe_specialite(
    idEmploye integer PRIMARY KEY default(nextval('s_employespecialite'),
    idspecialite integer NOT NULL references Specialite(idspecialite)
);


--Vue employe + specialite + employe + employe_specialite : v_infoemploye
--donne de test

----
CREATE TABLE Service(
    idservice integer PRIMARY KEY default(nextval('s_service'),
    nomservice varchar(20) NOT NULL,
    prixHoraire double precision
);

CREATE TABLE TraitementService(
    idservice serial PRIMARY KEY,
    idspecialite integer NOT NULL references Specialite(idspecialite),
    duree double precision
);

-- vue: Service + Specialite + TraitementService
--Donnee de test v_service