/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.sun.istack.internal.logging.Logger;
import entities.Paiement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;

import utils.MyDB;
/**
 *
 * @author macbook
 */
public class PaiementService implements IPaiement<Paiement> {

    Connection connexion;
    Statement stm;

    public PaiementService() {
        connexion = MyDB.getInstance().getConnexion();
    }

    @Override
    public void ajouterP(Paiement P) throws SQLException {
        String req = "INSERT INTO `Paiement` (`adresse_m`,`Date`,`CVC`) VALUES ( '"+ P.getAdresse_m() + "', '" + P.getDate() + "', '"+ P.getCVC() +"') ";
        stm = connexion.createStatement();
        stm.executeUpdate(req);

    }
    public void modifierp(Paiement P) throws SQLException {
        String req = "UPDATE `Paiement` SET adresse_m = ? , Date = ?, CVC = ? where id = ? ";
        //stm = connexion.createStatement();
        //stm.executeUpdate(req);
        PreparedStatement k=connexion.prepareStatement(req);
k.setString(1, P.getAdresse_m() );
k.setDate(2, P.getDate() );
k.setInt(3, P.getCVC() );
k.setInt(4, P.getId() );
k.executeUpdate();
    }
    @Override
    public void modifierPaiement() throws SQLException {
        System.out.println("choisir l id du table paiement que vous voulez la modifier");
        Scanner sc= new Scanner(System.in);
        int id_P = sc.nextInt();
        sc.nextLine();
        System.out.println("tapez le numero du champ a modifier \n 1 : adresse \n 2 : Date \n 3 : CVC \n  ");
        int num_champ = sc.nextInt();
        sc.nextLine();
        switch (num_champ) {
    case 1:{
       
            System.out.println("saisir votre nouveau adresse");
        String nv_adresse = sc.nextLine();
        String req = "UPDATE Paiement SET adresse_m = ? WHERE id = ?";
         PreparedStatement ps = connexion.prepareStatement(req);
         ps.setString(1, nv_adresse);
         ps.setInt(2,id_P);
        int a= ps.executeUpdate();
        break;}
    case 2:{      
           System.out.println("saisir votre nouvelle Date");
        String nv_date = sc.nextLine();
        String req = "UPDATE Paiement SET Date = ? WHERE id = ?";
         PreparedStatement ps = connexion.prepareStatement(req);
         ps.setString(1, nv_date);
         ps.setInt(2,id_P);
        int a= ps.executeUpdate();
        break;}
    case 3:{      
           System.out.println("saisir votre nouveau CVC");
        String nv_CVC = sc.nextLine();
        String req = "UPDATE client SET CVC = ? WHERE id = ?";
         PreparedStatement ps = connexion.prepareStatement(req);
         ps.setString(1, nv_CVC);
         ps.setInt(2,id_P);
        int a= ps.executeUpdate();
        break;}
        }
    }
    
    @Override
    public List<Paiement> afficherPaiement() throws SQLException {
        List<Paiement> paiements = new ArrayList<>();
        System.out.println("La liste de la table paiement :");
        String req = "select * from paiement";
        stm = connexion.createStatement();
        //ensemble de resultat
        ResultSet rst = stm.executeQuery(req);
//
        while (rst.next()) {
            Paiement P = new Paiement(rst.getInt(1),//or rst.getInt(1)
                    rst.getString(2),
                    rst.getDate(3),
                    rst.getInt(4)
            );
            paiements.add(P);
        }
        return paiements;
    }

    @Override
    public void deletep(int id) throws SQLException {
         int num = id;

         String req = "DELETE FROM paiement WHERE id = ?";
         PreparedStatement ps = connexion.prepareStatement(req);
         ps.setInt(1, num);

      // Exécution de la requête
      int nbLignesSupprimees = ps.executeUpdate();
      System.out.println("Nombre de lignes supprimées : " + nbLignesSupprimees);

    }

    @Override
    public Paiement afficherById(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //@Override
     //public void modifierPaiement1(Paiement P) throws SQLException {
       
    //}

    @Override
    public void modifierPaiement1(Paiement P) throws SQLException {
        //throw new UnsupportedOperationException("Not supported yet.");
        try {
            String req = "UPDATE Paiement SET adresse_m = '"+ P.getAdresse_m()+ "',`CVC`='"+P.getCVC()+"' WHERE Paiement.`id` = " + P.getId();
            Statement st = connexion.createStatement();
            st.executeUpdate(req);
            System.out.println("Paiement updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }//To change body of generated methods, choose Tools | Templates.
    }

   
   
}
