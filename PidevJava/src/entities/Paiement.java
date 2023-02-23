/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;

/**
 *
 * @author macbook
 */
public class Paiement {
    
    private int id_P;
    private String adresse_m;
    private Date Date_P;
    private int CVC;
    

    public Paiement(String adresse_m,Date Date_P,int CVC) {
      this.adresse_m= adresse_m;
      this.Date_P= Date_P;
      this.CVC= CVC;
                               
    }
    public Paiement(int id_P,String adresse_m,Date Date_P,int CVC) {
        this.id_P=id_P;
        this.adresse_m=adresse_m;
        this.Date_P=Date_P;
        this.CVC=CVC;
    }

    public Paiement(String adresse_m, int CVC) {
        this.adresse_m=adresse_m;
        this.CVC=CVC;    }

    public Paiement(int id_P, String adresse_m, int CVC) {
        //throw new UnsupportedOperationException("Not supported yet.");
        this.id_P=id_P;
        this.adresse_m=adresse_m;
        this.CVC=CVC;//To change body of generated methods, choose Tools | Templates.
    }

    //public Paiement(int id_P,String adresse_m, int adresse_m) {
        
//this.id_P=id_P;
  //      this.adresse_m=adresse_m;
    //    this.CVC=CVC;    }

    public int getId() {
        return id_P;
    }

    public void setId(int id_P) {
        this.id_P = id_P;
    }

    public String getAdresse_m() {
        return adresse_m;
    }
    public void setAdresse_m(String adresse_m) {
        this.adresse_m = adresse_m;
    }

    public Date getDate() {
        return Date_P;
    }

    public void setDate(Date Date_P) {
        this.Date_P = Date_P;
    }

    public int getCVC() {
        return CVC;
    }

    public void setCVC(int CVC) {
        this.CVC = CVC;
    }

    @Override
    public String toString() {
        return "Paiement{" + "id_P=" + id_P + ", adresse_m=" + adresse_m + ", Date_P=" + Date_P + ", CVC=" + CVC + '}';
    }
    
    
    
    
    
    
}
