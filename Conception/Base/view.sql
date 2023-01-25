-- vue v_service: Service + Specialite + TraitementService

CREATE VIEW v_traitement AS SELECT Specialite.*,idservice,duree FROM Specialite join TraitementService ON Specialite.idspecialite = TraitementService.idspecialite;
CREATE VIEW v_service AS SELECT v_traitement.*,nomservice,prixHoraire FROM v_traitement JOIN Service ON v_traitement.idservice = Service.idservice;

--Vue employe + specialite + employe_specialite : v_infoemploye
CREATE VIEW v_employespec AS SELECT Employe.*, idspecialite FROM Employe JOIN Employe_specialite ON Employe.idemploye = Employe_specialite.idemploye;
CREATE VIEW v_infoemploye AS SELECT Employe_spec.*,libelle FROM v_employespec AS Employe_spec JOIN Specialite ON Employe_spec.idspecialite = Specialite.idspecialite;

