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

CREATE TABLE Taux(
    idtaux serial PRIMARY KEY,
    taux double precision 
);


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


