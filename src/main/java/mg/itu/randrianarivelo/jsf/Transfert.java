/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.randrianarivelo.jsf;

import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import mg.itu.randrianarivelo.ejb.GestionnaireCompte;
import mg.itu.randrianarivelo.entities.CompteBancaire;

/**
 *
 * @author user050
 */
@Named(value = "transfert")
@RequestScoped
public class Transfert {

    @EJB
    GestionnaireCompte gest;
    
    private int idSource;
    private int idDestination;
    private int montant;

    public Transfert() {
    }

    public int getIdSource() {
        return idSource;
    }

    public void setIdSource(int idSource) {
        this.idSource = idSource;
    }

    public int getIdDestination() {
        return idDestination;
    }

    public void setIdDestination(int idDestination) {
        this.idDestination = idDestination;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }
    
    public String transferer(){
        CompteBancaire source = gest.findById(idSource);
        CompteBancaire destination = gest.findById(idDestination);
        gest.transferer(source, destination, montant);
        return "/listeComptes";
    }
}
