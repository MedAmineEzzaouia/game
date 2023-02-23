/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Facture;
import entities.Paiement;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import services.PaiementService;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;
import services.FactureService;


/**
 * FXML Controller class
 *
 * @author 21655
 */
public class FXMLController implements Initializable {

    @FXML
    private TextField tf_adresse;
    @FXML
    private DatePicker tf_paiement;
    @FXML
    private TextField tf_cvc;
    //@FXML
    //public void getDate (ActionEvent event){
        //String myFormattedDate = myDate.Format(DateTimeFormatter.ofPattern("MMM-dd-yyyy"));
      //  LocalDate MyDate = tf_paiement.getValue();
    //}
    @FXML
    private TableView<Paiement> table1;
    
    @FXML
    private TableColumn<Paiement, Integer> col_id;
    @FXML
    private TableColumn<Paiement, String> col_addresse;
    @FXML
    private TableColumn<Paiement, Timestamp> col_dp;
    @FXML
    private TableColumn<Paiement, Integer> col_cvc;
    
   private ObservableList<Paiement> dataList = FXCollections.observableArrayList();
    //private TextField id_P1;
    @FXML
    private Button delete;
    @FXML
    private TextField deletefield;
    //@FXML
    //private TableColumn<?, ?> col_dp1;
    //private TableColumn<Paiement, Timestamp> col_dp1;
    @FXML
    private Button modifierP;
    @FXML
    private TextField tf_date;
// facture
    @FXML
    private TextField tf_cin;
    @FXML
    private TextField deletefield1;
    @FXML
    private TextField tf_date1;
    @FXML
    private TextField tf_nom;
    @FXML
    private TextField tf_prenom;
    @FXML
    private Button delete2;
    @FXML
    private Button modifierF;
    @FXML
    private TextField tf_ville;
    @FXML
    private TextField tf_prix;
    @FXML
    private DatePicker tf_dd;
    @FXML
    private TableView<Facture> table2;
    @FXML
    private TableColumn<Facture, Integer> col_id2;
    @FXML
    private TableColumn<Facture, Integer> col_cin;
    @FXML
    private TableColumn<Facture, String> col_nom;
    @FXML
    private TableColumn<Facture, String> col_prenom;
    @FXML
    private TableColumn<Facture, String> col_ville;
    @FXML
    private TableColumn<Facture, Timestamp> col_dp1;
    @FXML
    private TableColumn<Facture, Integer> col_prix;
    private ObservableList<Facture> dataList1 = FXCollections.observableArrayList();
    
    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        col_id.setCellValueFactory(new PropertyValueFactory<Paiement, Integer>("id"));
        col_addresse.setCellValueFactory(new PropertyValueFactory<Paiement, String>("adresse_m"));
        col_dp.setCellValueFactory(new PropertyValueFactory<Paiement, Timestamp>("Date"));
        col_cvc.setCellValueFactory(new PropertyValueFactory<Paiement, Integer>("CVC"));
               // ObservableList<Paiement> dataList = FXCollections.observableArrayList();
        PaiementService sp = new PaiementService();
        try {
            sp.afficherPaiement().forEach(P->{dataList.add(P);});
        } catch (SQLException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        table1.setItems(dataList);  
        // facture
        col_id2.setCellValueFactory(new PropertyValueFactory<Facture, Integer>("id"));
        col_cin.setCellValueFactory(new PropertyValueFactory<Facture, Integer>("Cin"));
        col_nom.setCellValueFactory(new PropertyValueFactory<Facture, String>("Nom"));
        col_prenom.setCellValueFactory(new PropertyValueFactory<Facture, String>("Prenom"));
        col_ville.setCellValueFactory(new PropertyValueFactory<Facture, String>("Ville"));
        col_dp1.setCellValueFactory(new PropertyValueFactory<Facture, Timestamp>("Date"));
        col_prix.setCellValueFactory(new PropertyValueFactory<Facture, Integer>("Prix"));
               // ObservableList<Paiement> dataList = FXCollections.observableArrayList();
        FactureService fp = new FactureService();
        try {
            fp.afficherFacture().forEach(F->{dataList1.add(F);});
        } catch (SQLException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        table2.setItems(dataList1);
    }    
    



    @FXML
    private void AjoutP(ActionEvent event) throws SQLException {
        
        PaiementService sp = new PaiementService();
        if( controleTextFieldMAIL(tf_adresse) || controleTextFieldNumerique (tf_cvc) || validateDatePicker (tf_paiement) ) {
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
       alert.setHeaderText(null);
     
        alert.setContentText("Veuillez remplir les données");
        alert.show();    
       }  else{
        Paiement P=new Paiement(tf_adresse.getText(),Date.valueOf(tf_paiement.getValue()),Integer.parseInt(tf_cvc.getText()));
        sp.ajouterP(P);
        clean();
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Succès");
        alert.setContentText("Paiement est ajouté avec succès!");
        alert.show();
       
        System.out.println("Paiement ajouté");
    } 

    
}
    private void clean(){
        
       tf_adresse.setText(null);
       tf_paiement.setValue(null);
       tf_cvc.setText(null);
       tf_date.setText(null);
       deletefield.setText(null);
    }
    
    public ObservableList<Paiement> getPaiement(List<Paiement> l){
       ObservableList<Paiement> dataList = FXCollections.observableArrayList();
       for (int i =0; i<=l.size()-1; i++){
          System.out.println("xxx:"+l.get(i));
          dataList.add(l.get(i));
       }
       return dataList;
    }
    //C.S Paiement 
    public boolean controleTextFieldMAIL(TextField textField) {
        if (!textField.getText().contains("@")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Votre adresse mail est invalide");
            alert.showAndWait();
            return true;
        }
             return false;}
    public boolean controleTextFieldNumerique(TextField textField) {
        if (!textField.getText().matches(".*[1-9].*")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Votre CVC est invalide");
            alert.showAndWait();
            return true;
                    }

             return false;
    }
     public boolean validateDatePicker(DatePicker date)
    {
          if(date.getEditor().getText().isEmpty())
         {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Veuillez saisir la date de paiement ");
            alert.showAndWait();
            return true;
         }
           return false;
        }
    // private void checkinput(javafx.scene.input.KeyEvent event) {
        
    //}

    @FXML
    private void AfficheP(ActionEvent event) throws SQLException {
        ObservableList<Paiement> dataList = FXCollections.observableArrayList();
        PaiementService sp = new PaiementService();
        col_id.setCellValueFactory(new PropertyValueFactory<Paiement, Integer>("id"));
        col_addresse.setCellValueFactory(new PropertyValueFactory<Paiement, String>("adresse_m"));
        col_dp.setCellValueFactory(new PropertyValueFactory<Paiement, Timestamp>("Date"));
        col_cvc.setCellValueFactory(new PropertyValueFactory<Paiement, Integer>("CVC"));
        table1.setItems(getPaiement(sp.afficherPaiement()));
        
    }

    //@FXML
    //private void getDate(ActionEvent event) {
    //}

    //private void clean() {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //}

    @FXML
    private void supprimerP(ActionEvent event) throws SQLException {
        PaiementService sp = new PaiementService();

        int id = Integer.parseInt(deletefield.getText());
        sp.deletep(id);
        clean();
        System.out.print("demande de supprimer ");
    }
    @FXML 
    private void modifierP(ActionEvent event) throws SQLException {
        PaiementService sr = new PaiementService();
           int id = Integer.parseInt(deletefield.getText()) ;  
           
        Paiement P = new Paiement( id, tf_adresse.getText(),Integer.parseInt(tf_cvc.getText()));
       

        sr.modifierPaiement1(P);
        clean();
         
       
       
       Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Paiement modifier avec succès!");
            alert.showAndWait();
       
       
    }

    @FXML
    private void select(MouseEvent event) {
        Paiement P = table1.getSelectionModel().getSelectedItem();
    deletefield.setText("" +P.getId());
   tf_adresse.setText("" +P.getAdresse_m());
   tf_date.setText("" +P.getDate());
   tf_cvc.setText("" +P.getCVC());

    }

    @FXML
    private void AjoutF(ActionEvent event) throws SQLException {
        FactureService sp = new FactureService();
        if( controleTextFieldNumerique2(tf_cin) || controleTextField2 (tf_nom) || controleTextField2 (tf_prenom) || controleTextField2 (tf_ville) || validateDatePicker (tf_dd) || controleTextFieldNumerique2(tf_prix) ) {
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
       alert.setHeaderText(null);
     
        alert.setContentText("Veuillez remplir les données");
        alert.show();    
       }  else{
        Facture F=new Facture(Integer.parseInt(tf_cin.getText()),tf_nom.getText(),tf_prenom.getText(),tf_ville.getText(),Date.valueOf(tf_dd.getValue()),Integer.parseInt(tf_prix.getText()));
        sp.ajouterF(F);
        clean2();
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Succès");
        alert.setContentText("Une facture est ajoutée avec succès!");
        alert.show();
       
        System.out.println("Facture ajoutée");
    }
}
        private void clean2(){
        
       tf_cin.setText(null);
       tf_nom.setText(null);
       tf_prenom.setText(null);
       tf_ville.setText(null);
       tf_dd.setValue(null);
       tf_prix.setText(null);
    }
        public ObservableList<Facture> getFacture(List<Facture> l){
       ObservableList<Facture> dataList1 = FXCollections.observableArrayList();
       for (int i =0; i<=l.size()-1; i++){
          System.out.println("xxx:"+l.get(i));
          dataList1.add(l.get(i));
       }
       return dataList1;
    }
    //C.S Facture    
    public boolean controleTextFieldNumerique2(TextField textField) {
        if (!textField.getText().matches(".*[1-9].*")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Le Prix est invalide");
            alert.showAndWait();
            return true;
                    }

             return false;
    }
    public boolean controleTextField2(TextField textField) {
        if (!textField.getText().matches(".*[a-zA-Z].*")) {
// Alert alert = new Alert(Alert.AlertType.ERROR);
    //alert.setHeaderText("Veuillez saisir des lettres");
            JOptionPane.showMessageDialog(null,"Veuillez saisir des lettres");
  //  alert.showAndWait();
            return true;
        }
        return false;
    }
    public boolean validateDatePicker2(DatePicker date)
    {
          if(date.getEditor().getText().isEmpty())
         {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Veuillez saisir la date du facture");
            alert.showAndWait();
            return true;
         }
           return false;
        }
   
    @FXML
    private void AfficheF(ActionEvent event) throws SQLException {
        ObservableList<Facture> dataList1 = FXCollections.observableArrayList();
        FactureService sp = new FactureService();
        col_id2.setCellValueFactory(new PropertyValueFactory<Facture, Integer>("id"));
        col_cin.setCellValueFactory(new PropertyValueFactory<Facture, Integer>("Cin"));
        col_nom.setCellValueFactory(new PropertyValueFactory<Facture, String>("Nom"));
        col_prenom.setCellValueFactory(new PropertyValueFactory<Facture, String>("Prenom"));
        col_ville.setCellValueFactory(new PropertyValueFactory<Facture, String>("Ville"));
        col_dp1.setCellValueFactory(new PropertyValueFactory<Facture, Timestamp>("Date"));
        col_prix.setCellValueFactory(new PropertyValueFactory<Facture, Integer>("Prix"));
        table2.setItems(getFacture(sp.afficherFacture()));
    }

    @FXML
    private void supprimerF(ActionEvent event) throws SQLException {
        FactureService sp = new FactureService();

        int id= Integer.parseInt(deletefield1.getText());
        sp.deleteF(id);
        clean2();
        System.out.print("demande de supprimer ");
    }

    @FXML
    private void modifierF(ActionEvent event) throws SQLException {
        FactureService sr = new FactureService();
           int id = Integer.parseInt(deletefield1.getText()) ;  
           
        Facture F = new Facture( id, Integer.parseInt(tf_cin.getText()), tf_nom.getText(),tf_prenom.getText(), tf_ville.getText(),Integer.parseInt(tf_prix.getText()));
       

        sr.modifierFacture2(F);
        clean2();
       Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Facture modifier avec succès!");
            alert.showAndWait();
    }

    @FXML
    private void select2(MouseEvent event) {
        Facture F = table2.getSelectionModel().getSelectedItem();
    deletefield1.setText("" +F.getId());
   tf_cin.setText("" +F.getCin());
   tf_nom.setText("" +F.getNom());
   tf_prenom.setText("" +F.getPrenom());
   tf_ville.setText("" +F.getVille());
   tf_date1.setText("" +F.getDate());
   tf_prix.setText("" +F.getPrix());
    }

    @FXML
    private void checkinput(KeyEvent event) {
        if(event.getCharacter().matches("[^\\e\t\r\\d+$]")){
            event.consume();
           
            tf_cvc.setStyle("-fx-border-color: red");
        }else{
            tf_cvc.setStyle("-fx-border-color: green");
        }
    }

    @FXML
    private void checkinput2(KeyEvent event) {
        if(event.getCharacter().matches("[^\\e\t\r\\d+$]")){
            event.consume();
           
            tf_prix.setStyle("-fx-border-color: red");
        }else{
            tf_prix.setStyle("-fx-border-color: green");
        }
    }

    

    

    
}

    //@FXML
    //private void supprimerF(ActionEvent event) {
     
   
    //}

    //@FXML
   // private void modifierF(ActionEvent event) {
     
    //}

    //@FXML
   // private void select2(MouseEvent event) {
    
    



   
