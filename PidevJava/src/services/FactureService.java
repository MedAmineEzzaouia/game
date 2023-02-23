/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import com.sun.istack.internal.logging.Logger;
import entities.Facture;
//import entities.User;
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
 * @author MSI
 */
public class FactureService implements IFacture<Facture> {
Connection connexion;
    Statement stm;
    public FactureService() {
        connexion = MyDB.getInstance().getConnexion();
    }


    @Override
    public void modifierFacture() throws SQLException {
        System.out.println("choisir l id du facture que vous voulez la modifier");
        Scanner sc= new Scanner(System.in);
        int id_F = sc.nextInt();
        sc.nextLine();
        System.out.println("tapez le numero du champ a modifier \n 1 : Cin \n 2 : nom \n 3 : prenom \n 4 : Ville \n 5 : Prix  \n  ");
        int num_champ = sc.nextInt();
        sc.nextLine();
        switch (num_champ) {
            case 1:{
       
            System.out.println("saisir votre nouveau cin");
        String nv_Cin = sc.nextLine();
        String req = "UPDATE client SET Cin = ? WHERE id = ?";
         PreparedStatement ps = connexion.prepareStatement(req);
         ps.setString(1, nv_Cin);
         ps.setInt(2,id_F );
        int a= ps.executeUpdate();
        break;}
    case 2:{
       
            System.out.println("saisir votre nouveau nom");
        String nv_Nom = sc.nextLine();
        String req = "UPDATE client SET Nom = ? WHERE id = ?";
         PreparedStatement ps = connexion.prepareStatement(req);
         ps.setString(1, nv_Nom);
         ps.setInt(2,id_F );
        int a= ps.executeUpdate();
        break;}
    case 3:{      
           System.out.println("saisir votre nouveau prenom");
        String nv_Prenom = sc.nextLine();
        String req = "UPDATE admin SET Prenom = ? WHERE id = ?";
         PreparedStatement ps = connexion.prepareStatement(req);
         ps.setString(1, nv_Prenom);
         ps.setInt(2,id_F );
        int a= ps.executeUpdate();
        break;}
    case 4:{      
           System.out.println("saisir votre nouveau ville");
        String nv_ville = sc.nextLine();
        String req = "UPDATE Facture SET ville = ? WHERE id = ?";
         PreparedStatement ps = connexion.prepareStatement(req);
         ps.setString(1, nv_ville);
         ps.setInt(2,id_F );
        int a= ps.executeUpdate();
        break;}
    case 5:{      
           System.out.println("saisir le nouveau Prix");
        int nv_Prix = sc.nextInt();
        String req = "UPDATE Facture SET Prix = ? WHERE id = ?";
         PreparedStatement ps = connexion.prepareStatement(req);
         ps.setInt(1, nv_Prix);
         ps.setInt(2,id_F );
        int a= ps.executeUpdate();
        break;}
        }
    }

    @Override
    public List<Facture> afficherFacture() throws SQLException {
       List<Facture> Factures = new ArrayList<>();
        System.out.println("La liste des factures :");
        String req = "select * from Facture";
        stm = connexion.createStatement();
        //ensemble de resultat
        ResultSet rst = stm.executeQuery(req);

        while (rst.next()) {
            Facture F = new Facture(rst.getInt(1),//or rst.getInt(1)
                    rst.getInt("Cin"),
                    rst.getString("Nom"),
                    rst.getString("Prenom"),
                    rst.getString("Ville"),
                    rst.getDate("Date"),
                    rst.getInt("Prix")
            );
            Factures.add(F);
        }
        return Factures;
    }

    /**
     *
     * @param A
     * @throws SQLException
     */
    @Override
    public void ajouterF(Facture F) throws SQLException {
        String req;
    req = "INSERT INTO `Facture` (`Cin`,`Nom`, `Prenom`,`Ville`, `Date`,`Prix`) VALUES ( '"+ F.getCin() + "','"+ F.getNom() + "', '" + F.getPrenom() + "', '"+ F.getVille() +"', '"+F.getDate()+"', '"+F.getPrix()+"') ";
        stm = connexion.createStatement();
        stm.executeUpdate(req);
    }

    //public void deleteF(int id) throws SQLException {
        
    //}

    @Override
    public void modifierFacture2(Facture F) throws SQLException {
        //throw new UnsupportedOperationException("Not supported yet.");
        try {
            String req = "UPDATE Facture SET Cin = '"+ F.getCin()+ "',`Nom`='"+F.getNom()+"',`Prenom`='"+F.getPrenom()+"',`Ville`='"+F.getVille()+"',`Prix`='"+F.getPrix()+"' WHERE Facture.`id` = " + F.getId();
            Statement st = connexion.createStatement();
            st.executeUpdate(req);
            System.out.println("Facture updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }//To change body of generated methods, choose Tools | Templates.//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteF(int id) throws SQLException {
        //throw new UnsupportedOperationException("Not supported yet.");
        int num = id;

         String req = "DELETE FROM facture WHERE id = ?";
         PreparedStatement ps = connexion.prepareStatement(req);
         ps.setInt(1, num);

      // Exécution de la requête
      int nbLignesSupprimees = ps.executeUpdate();
      System.out.println("Nombre de lignes supprimées : " + nbLignesSupprimees);//To change body of generated methods, choose Tools | Templates.
    }

   
    
}
