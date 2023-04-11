/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.randrianarivelo.jsf;

import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import mg.itu.randrianarivelo.ejb.GestionnaireCompte;
import mg.itu.randrianarivelo.entities.CompteBancaire;
import mg.itu.randrianarivelo.jsf.util.Util;

/**
 *
 * @author ASUS
 */
@Named(value = "modificationBean")
@ViewScoped
public class ModificationBean implements Serializable {
 
    @EJB
    GestionnaireCompte gestionnaireCompte;
    
    private Long id;
    private CompteBancaire compte;
    
    /**
     * Creates a new instance of ModificationBean
     */
    public ModificationBean() {
    }
    
    public void loadCompte() {
      compte = gestionnaireCompte.findById(id);
    }
    
    public String update(){
        CompteBancaire old = gestionnaireCompte.findById(id);
        gestionnaireCompte.update(compte);
        Util.addFlashInfoMessage("Modification du nom du possesseur du compte " + old.getNom() + " en " + compte.getNom());
        return "listeComptes?faces-redirect=true";
    }

    public Long getId() {
        return id;
    }

    public CompteBancaire getCompte() {
        return compte;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
}
