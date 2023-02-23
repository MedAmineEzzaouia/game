/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevjava;

import entities.Facture;
import entities.Paiement;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.FactureService;
import services.PaiementService;

/**
 *
 * @author macbook
 */
public class PidevJava {

    /**
     * @param args the command lineou arguments
     */
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        // TODO code application logic here
        Date DateF = new Date(1970-01-01);
        Date DateP = new Date(1970-01-01);
        Date DateF1 = new Date(1970-01-01);
        Date DateP1 = new Date(1970-01-01);
        //Date datedeNaissance1 = new Date(21/6/2020);
        //Date datedeNaissance2 = new Date(21/7/2020);
        //Date datedeNaissance3 = new Date(21/10/1999);
        Paiement P = new Paiement("amine@gmail.com",DateP,245);
        Paiement P1 = new Paiement("emna@gmail.com",DateP,230);
        //User u1= new User("mgaidi","ramy","ramy@gmail.com",27086763,datedeNaissance1,"nouha123");
        //User u2 = new User("mahjoubi","oussema","oussema@gmail.com",22820392,datedeNaissance2,"nouha123");
        //User u3 = new User("badreddine","ala","ala@gmail.com",24305902,datedeNaissance3,"nouha123");
        Facture F = new Facture(14510288,"Ezzaouia","Amine","Ariana",DateF,14);
        Facture F1 = new Facture(14100900,"Ezzaouia","Emna","Tunis",DateF,90);
        PaiementService sp = new PaiementService();
        FactureService ap = new FactureService();
        
        try {
            ap.ajouterF(F);
           ap.ajouterF(F1);
            System.out.println("ajout avec succes");
            //ap.modifierFacture(new Facture(14510288,"Ezzaouia","Amine","Ariana",DateF,14));
            //sp.modifierp(new Paiement("amine@gmail.com",DateP,245));
            System.out.println(ap.afficherFacture());
            System.out.println("voulez vous supprimer quelqu'un ?");
            Scanner sc2= new Scanner(System.in);
            String b=sc2.nextLine();
            String s3="oui";
            if(b.equals(s3)){
                System.out.println("donner son id : ");
            //ap.deleteF(F);
            System.out.println("suppression avec succes");}
            System.out.println(ap.afficherFacture());
            System.out.println("voulez vous modifier quelqu'un ?");
            Scanner sc3= new Scanner(System.in);
            String r=sc3.nextLine();
            String s4="oui";
            String s7="non";
            if(r.equals(s4)){
                System.out.println("donner son id : ");
            ap.modifierFacture();
            System.out.println("modification avec succes");}
           if(r.equals(s7)){ 
           sp.ajouterP(P);
           sp.ajouterP(P1);
           //sp.ajouterp(u2);
           //sp.ajouterp(u3);
           System.out.println("ajout avec succes");
           System.out.println(sp.afficherPaiement());
           System.out.println("voulez vous supprimer quelqu'un ?");
           Scanner sc= new Scanner(System.in);
           String a=sc.nextLine();
            String s1="oui";
            if(a.equals(s1)){
                System.out.println("donner son id : ");
           //sp.deletep(id);
           System.out.println("suppression avec succes");}
            System.out.println("voulez vous modifier quelqu'un ?");
           Scanner sc5= new Scanner(System.in);
           String f=sc5.nextLine();
            String s6="oui";
            if(a.equals(s6)){
                System.out.println("donner son id : ");
           sp.modifierPaiement();
           System.out.println("modification avec succes");
           
            
        }}} catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        try {
            System.out.println(ap.afficherFacture());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
    }
    
}
