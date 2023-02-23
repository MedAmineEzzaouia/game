/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import entities.Facture;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author MSI
 * @param <A>
 */
public interface IFacture<A>  {
    public void ajouterF(A C) throws SQLException;

    /**
     *
     * @param C
     * @throws SQLException
     */
    public void deleteF(int id) throws SQLException;
    public void modifierFacture() throws SQLException;
    public void modifierFacture2(Facture F) throws SQLException;


    /**
     *
     * @return
     * @throws SQLException
     */
    public List<A> afficherFacture() throws SQLException;
}
