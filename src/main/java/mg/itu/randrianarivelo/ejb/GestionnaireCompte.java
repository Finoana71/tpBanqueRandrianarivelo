/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.itu.randrianarivelo.ejb;

import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;
import mg.itu.randrianarivelo.entities.CompteBancaire;

@DataSourceDefinition (
    className="com.mysql.cj.jdbc.MysqlDataSource",
    name="java:app/jdbc/banque",
    serverName="localhost",
    portNumber=3306,
    user="root",
    password="12345678", 
    databaseName="banque",
    properties = {
      "useSSL=false",
     "allowPublicKeyRetrieval=true"
    }
)   
@Stateless
public class GestionnaireCompte {
    
    @PersistenceContext(unitName = "banquePU")
    private EntityManager em;
    
    public void creerCompte(CompteBancaire c) {
        em.persist(c);
    }
    
    public List<CompteBancaire> getAllComptes() {
        TypedQuery<CompteBancaire> query = em.createNamedQuery("CompteBancaire.findAll", CompteBancaire.class);
        return query.getResultList();
    }
    
    public void transferer(CompteBancaire source, CompteBancaire destination, int montant) {
        source.retirer(montant);
        destination.deposer(montant);
        update(source);
        update(destination);
    }

    public CompteBancaire update(CompteBancaire compteBancaire) {
        return em.merge(compteBancaire);
    }
    
    public CompteBancaire findById(long id){
        return em.find(CompteBancaire.class, id);
    }
    
    public void deposer(CompteBancaire compte, int montant){
        compte.deposer(montant);
        update(compte);
    }
    
    public void retirer(CompteBancaire compte, int montant){
        compte.retirer(montant);
        update(compte);
    }
    
    public void supprimerCompte(CompteBancaire compte) {
        em.remove(em.merge(compte));
    }
}
