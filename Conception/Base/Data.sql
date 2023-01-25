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




--Donnee de test 
INSERT INTO Service(nomservice) VALUES('Vidange');
INSERT INTO Service(nomservice) VALUES('Réparation bougie');
INSERT INTO Service(nomservice) VALUES('Paralellisme');
INSERT INTO Service(nomservice) VALUES('Réparation circuit');
INSERT INTO Service(nomservice) VALUES('Remplacer filtre');

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

INSERT INTO TraitementService(idservice, idspecialite, duree) VALUES(1,2,1);
INSERT INTO TraitementService(idservice, idspecialite, duree) VALUES(1,3,0.5);
INSERT INTO TraitementService(idservice, idspecialite, duree) VALUES(2,1,0.5);
INSERT INTO TraitementService(idservice, idspecialite, duree) VALUES(2,2,0.5);
INSERT INTO TraitementService(idservice, idspecialite, duree) VALUES(3,2,1);
INSERT INTO TraitementService(idservice, idspecialite, duree) VALUES(4,1,1);
INSERT INTO TraitementService(idservice, idspecialite, duree) VALUES(5,2,1);        
