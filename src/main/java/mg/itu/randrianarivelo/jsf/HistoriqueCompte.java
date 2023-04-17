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
import mg.itu.randrianarivelo.entities.OperationBancaire;

/**
 *
 * @author ASUS
 */
@Named(value = "historiqueCompte")
@ViewScoped
public class HistoriqueCompte implements Serializable {

    @EJB
    GestionnaireCompte gestionnaireCompte;
    
    private Long id;
    private CompteBancaire compte;
    /**
     * Creates a new instance of Historique
     */
    public HistoriqueCompte() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public void loadCompte(){
        compte = gestionnaireCompte.findById(id);
    }

    public CompteBancaire getCompte() {
        return compte;
    }
}
