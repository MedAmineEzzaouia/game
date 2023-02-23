/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;
import java.sql.Date;
/**
 *
 * @author MSI
 */
public class Facture {
    private int id_F;
    private int Cin;
    private String Nom ;
    private String Prenom;
    private String Ville;
    private Date Date;
    private int Prix;


    public Facture(int id_F, int Cin, String Nom, String Prenom, String Ville, Date Date, int Prix) {
        this.id_F = id_F;
        this.Cin = Cin;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Ville = Ville;
        this.Date = Date;
        this.Prix = Prix;
    }

    public Facture(int Cin, String Nom, String Prenom, String Ville, Date Date, int Prix) {
        this.Cin = Cin;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Ville = Ville;
        this.Date = Date;
        this.Prix = Prix;
    }
    public Facture(int Cin,String Nom,String Prenom,String Ville, int Prix) {
        this.Cin=Cin;
        this.Nom=Nom;
        this.Prenom=Prenom;
        this.Ville=Ville;
        this.Prix=Prix;
    }

    public Facture(int id_F, int Cin,String Nom,String Prenom,String Ville, int Prix) {
        //throw new UnsupportedOperationException("Not supported yet.");
        this.id_F=id_F;
        this.Cin=Cin;
        this.Nom=Nom;
        this.Prenom=Prenom;
        this.Ville=Ville;
        this.Prix=Prix;
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Facture{" + "id_F=" + id_F + ", Cin=" + Cin + ", Nom=" + Nom + ", Prenom=" + Prenom + ", Ville=" + Ville + ", Date=" + Date + ", Prix=" + Prix + '}';
    }

    public int getId() {
        return id_F;
    }

    public void setId(int id_F) {
        this.id_F = id_F;
    }
    
    public int getCin() {
        return Cin;
    }

    public void setCin(int Cin) {
        this.Cin = Cin;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public String getVille() {
        return Ville;
    }

    public void setVille(String Ville) {
        this.Ville = Ville;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    public int getPrix() {
        return Prix;
    }

    public void setPrix(int Prix) {
        this.Prix = Prix;
    }
    
}
