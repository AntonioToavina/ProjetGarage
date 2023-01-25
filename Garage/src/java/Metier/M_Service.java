package Metier;

import DAO.Connexion;
import DAO.DAO_Service;
import Metier.M_CompositionService;
import Model.CompositionMateriel;
import Model.CompositionService;
import Model.PrixService;
import Model.Service;
import Model.Taux;
import java.sql.Connection;
import java.util.ArrayList;

public class M_Service {
    public double revientSalarial(String nomService,Connection connection)throws Exception {
        double rv = 0;
        try {
            M_CompositionService mcs = new M_CompositionService();
            ArrayList<CompositionService> acs = mcs.decompositionService(connection, nomService);
            if(acs==null)
                return 0;
            
            for(int i = 0; i < acs.size(); i++) 
                rv += (acs.get(i).getSalaireHoraire()*acs.get(i).getDuree());
            
        } catch(Exception e) {
            e.printStackTrace();
            throw e;
        }
        return rv;
    }

    public double revientMateriel(String nomService,Connection connect)throws Exception {
        double rm = 0;
        try {
            M_CompositionMateriel mcm = new M_CompositionMateriel();
            ArrayList<CompositionMateriel> acm = mcm.decompositionMaterielService(connect, nomService);
            if(acm==null)
                return 0;
            for(int i = 0; i < acm.size(); i++) {
                rm += (acm.get(i).getPrixConsommation()*acm.get(i).getVolumeConsommation());
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            throw e;
        }
        return rm;
    }

    public PrixService prixService(String nomService,double taux)throws Exception{
        Connection connect=null;
        PrixService prixService=new PrixService();
        try{
             connect= new Connexion().getConnexion();
            double revientSalarial = this.revientSalarial(nomService,connect);
            double revientMateriel = this.revientMateriel(nomService,connect);

            prixService.setPrixRevient(revientMateriel+revientSalarial);
            prixService.setPrixVente((prixService.getPrixRevient()*taux)+prixService.getPrixRevient());
            prixService.setBenefice(prixService.getPrixVente()*taux);
            System.out.println("dedcsc");
        }catch (Throwable e){
            throw e;
        }finally {
            if(connect!=null)
                connect.close();
        }

        return prixService;
    }
    
    public ArrayList<Service> getAll()throws Exception{
        ArrayList<Service> list=null;
        try{
            list=new DAO_Service().getAll();
        }catch(Throwable e){
            throw e;
        }
        
        return list;
    }
    
    public ArrayList<PrixService> getAll_PrixService()throws Exception{
        ArrayList<PrixService> listPrix=new ArrayList<>();
        try{
            ArrayList<Service> listService=getAll();
            for(Service service : listService){
                PrixService prix=prixService(service.getNomService(),service.getTaux());
                prix.setService(service);
                listPrix.add(prix);
            }
            
        }catch(Throwable e){
            throw e;
        }
        
        return listPrix;
    }
    
    public void modifTaux(Service service)throws Exception{
        try{
            new DAO_Service().modifTaux(service);
        }catch(Throwable e){
            throw e;
        }
    }
}