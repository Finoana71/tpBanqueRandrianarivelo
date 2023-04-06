/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.itu.randrianarivelo.ejb;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import mg.itu.randrianarivelo.entities.CompteBancaire;

/**
 *
 * @author ASUS
 */
@Singleton
@Startup
public class Init {
    
    @EJB
    private GestionnaireCompte g;
    
    @PostConstruct
    public void init(){
        g.creerCompte(new CompteBancaire("John Lennon", 150000));
        g.creerCompte(new CompteBancaire("Paul McCartney", 950000));
        g.creerCompte(new CompteBancaire("Ringo Starr", 20000));
        g.creerCompte(new CompteBancaire("Georges Harrisson", 100000));
    }
}
