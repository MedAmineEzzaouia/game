/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Paiement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author macbook
 * @param <Y>
 */
public interface IPaiement<Y> {
    
    public void ajouterP(Y P) throws SQLException;
    public void deletep(int id) throws SQLException;
    public void modifierp(Y P) throws SQLException;
    public void modifierPaiement() throws SQLException;
    public void modifierPaiement1(Paiement P) throws SQLException;
    public List<Y> afficherPaiement() throws SQLException;
    public Paiement afficherById(int id) throws SQLException;
    
    
}
