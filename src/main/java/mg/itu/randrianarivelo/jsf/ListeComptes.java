/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.randrianarivelo.jsf;

import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;
import mg.itu.randrianarivelo.ejb.GestionnaireCompte;
import mg.itu.randrianarivelo.entities.CompteBancaire;
import mg.itu.randrianarivelo.jsf.util.Util;

/**
 *
 * @author user050
 */
@Named(value = "listeComptes")
@ViewScoped
public class ListeComptes implements Serializable {

    @EJB
    GestionnaireCompte gest;
    
    private List<CompteBancaire> allComptes;
    
    /**
     * Creates a new instance of ListeComptes
     */
    public ListeComptes() {
    }
    
    public List<CompteBancaire> getAllComptes(){
        if(allComptes == null){
            allComptes = gest.getAllComptes();
        }
        return allComptes;
    }
    
    public String supprimerCompte(CompteBancaire compteBancaire){
        gest.supprimerCompte(compteBancaire);
        Util.addFlashInfoMessage("Compte de " + compteBancaire.getNom() + " supprimé");
          return "listeComptes?faces-redirect=true";
    }
}
