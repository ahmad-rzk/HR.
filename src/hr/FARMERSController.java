/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import data2.Data2;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author SuPeR_FaNtASy
 */
public class FARMERSController implements Initializable {
    @FXML
    private VBox container;
    @FXML
    private JFXButton cancel;
    @FXML
    private JFXTextField name;
    @FXML
    private JFXDatePicker sdate;
    @FXML
    private JFXTextField serialno;
    @FXML
    private JFXComboBox<String> region;
    @FXML
    private JFXComboBox<String> doctor;
    @FXML
    private JFXComboBox<String> nurse;
    @FXML
    private JFXComboBox<String> treatment;
    @FXML
    private JFXTextField ma3es;
    @FXML
    private JFXTextField dan;
    @FXML
    private JFXTextField bkr;
    
   
    
    void buildCombo() throws SQLException{
    
    Data2 d=Data2.getData();
    ResultSet rs;
    
    
    
    rs=d.loadDAreas();
    while(rs.next())
    region.getItems().add(rs.getString(2));
    ///////////////////////////
   rs=d.loadDNurses();
   while(rs.next())
   nurse.getItems().add(rs.getString(2));
    ///////////////////////////
    rs=d.loadDoctors();
    while(rs.next())
    doctor.getItems().add(rs.getString(2));
     ///////////////////////////
    rs=d.loadDRecipes();
    while(rs.next())
    treatment.getItems().add(rs.getString(2));
    
    
    }
    
    
    
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            buildCombo();
          name.requestFocus();
          
        } catch (SQLException ex) {
            Logger.getLogger(FARMERSController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    
    
    
    
    
    
    
    
    
boolean flag=false;
String row=""; 
int theid=0;
    void buildUpdate(){
        System.out.println(flag);
        System.out.println(row);
        System.out.println(theid);
    
           
       String id=row;
  id=id.replace("]", "");
 id=id.replace("[", "");
 String[] a=id.split(",");
 for(int i=0;i<a.length;i++) {
 a[i]=a[i].trim().trim();   
 System.out.println(a[i]);
 }
  
  name.setText(a[10]);
  //////////////////////////////////////
  {String ddd[]=a[1].split("/");
  String yyyy=ddd[2].trim().trim();
  String dd=ddd[0].trim().trim();
  String mm=ddd[1].trim().trim();
  if(dd.length()<2)dd="0"+dd;
  if(mm.length()<2)mm="0"+mm;
  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    LocalDate localDate = LocalDate.parse(dd+"-"+mm+"-"+yyyy, formatter);
  sdate.setValue(localDate);}
  ///////////////////////////////////////////
  region.getSelectionModel().select(a[2].trim());
  ///////////////////////////////////////////
   nurse.getSelectionModel().select(a[8].trim());
  ///////////////////////////////////////////
    doctor.getSelectionModel().select(a[9].trim().trim());
  ///////////////////////////////////////////
 treatment.getSelectionModel().select(a[7].trim());
  ///////////////////////////////////////////
  serialno.setText(a[11].trim().trim());
  ///////////////////////////////////////////
  theid=Integer.parseInt(a[0].trim());
  //////////////////////////////////////////
  dan.setText(a[3].trim());
   ma3es.setText(a[4].trim());
   bkr.setText(a[5].trim());
    
    
        System.out.println("builded");
    
    }
    
    
    
    void initData(boolean x,String y){
    flag=x;
    row=y;
        System.out.println("init");
         if(flag!=false){buildUpdate();}
    
    }
    
    
    
    
    
    
    
    
  @FXML
  public void close(ActionEvent event){
  
  // get a handle to the stage
    Stage stage = (Stage) cancel.getScene().getWindow();
    // do what you have to do
    stage.close();
  
  }
  
  
  @FXML
  public void insert(ActionEvent event){
  if(name.getText().trim().isEmpty()||ma3es.getText().trim().isEmpty()||dan.getText().trim().isEmpty()||bkr.getText().trim().isEmpty()||serialno.getText().trim().isEmpty()||!(sdate.getValue()!=null)||region.getSelectionModel().isEmpty()||doctor.getSelectionModel().isEmpty()||nurse.getSelectionModel().isEmpty()){eroor("الرجاء ملء جميع الحقول", event);return;}
  if(serialno.getText().trim().trim().length()!=10){eroor("خطاء في الرقم الوطني", event);return;}
  
  
  data2.Data2 d=Data2.getData();
      if(flag==false){
      
      
  String nm= name.getText().trim().trim();
  String sd= sdate.getValue().getDayOfMonth()+"".trim()+"/"+sdate.getValue().getMonthValue()+"".trim()+"/"+sdate.getValue().getYear();
  Long ser=Long.parseLong(serialno.getText().trim().trim());
  int dn=Integer.parseInt(dan.getText().trim().trim());
  int bk=Integer.parseInt(bkr.getText().trim().trim());
  int mz=Integer.parseInt(ma3es.getText().trim().trim());
  /////////////////
  String reg=region.getSelectionModel().getSelectedItem().trim();
   String nur=nurse.getSelectionModel().getSelectedItem().trim();
    String doc=doctor.getSelectionModel().getSelectedItem().trim();
    String sci=treatment.getSelectionModel().getSelectedItem().trim();
 ///////////////////////
        try {
          d.insertFarmer(nm, sd, ser, reg, dn, mz, bk, sci, nur, doc);


 close(event);
 sucsess("تمت الاضافه بنجاح", event);
            
        } catch (SQLException ex ) {
            Logger.getLogger(LICENSESController.class.getName()).log(Level.SEVERE, null, ex);
        }
  
  }
  else {
  
      
      
 String nm= name.getText().trim().trim();
  String sd= sdate.getValue().getDayOfMonth()+"".trim()+"/"+sdate.getValue().getMonthValue()+"".trim()+"/"+sdate.getValue().getYear();
  Long ser=Long.parseLong(serialno.getText().trim().trim());
  int dn=Integer.parseInt(dan.getText().trim().trim());
  int bk=Integer.parseInt(bkr.getText().trim().trim());
  int mz=Integer.parseInt(ma3es.getText().trim().trim());
  /////////////////
  String reg=region.getSelectionModel().getSelectedItem().trim();
   String nur=nurse.getSelectionModel().getSelectedItem().trim();
    String doc=doctor.getSelectionModel().getSelectedItem().trim();
    String sci=treatment.getSelectionModel().getSelectedItem().trim();
 ///////////////////////
        try {
        
d.updateFarmer(theid, nm, sd, ser, reg, dn, mz, bk, sci, nur, doc);

 close(event);
 sucsess("تمت عملية التعديل  بنجاح", event);
            
        } catch (SQLException ex ) {
            Logger.getLogger(LICENSESController.class.getName()).log(Level.SEVERE, null, ex);
        }
  
  
  }}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    private boolean conform(String msg,ActionEvent event){
    Alert emptysearch=new Alert(Alert.AlertType.CONFIRMATION,"CONFIRMATION",ButtonType.OK,ButtonType.CANCEL);
        Window owner=((Node)event.getTarget()).getScene().getWindow();
        emptysearch.setContentText(msg);
        emptysearch.initModality(Modality.APPLICATION_MODAL);
        emptysearch.initOwner(owner);
        emptysearch.showAndWait();
        if(emptysearch.getResult()==ButtonType.OK){emptysearch.close();
        return true;}
        return false;
    
    
    }
    
    private void warnning(String msg,ActionEvent event){
    Alert emptysearch=new Alert(Alert.AlertType.WARNING,"warning",ButtonType.OK);
        Window owner=((Node)event.getTarget()).getScene().getWindow();
        emptysearch.setContentText(msg);
        emptysearch.initModality(Modality.APPLICATION_MODAL);
        emptysearch.initOwner(owner);
        emptysearch.showAndWait();
        if(emptysearch.getResult()==ButtonType.OK)emptysearch.close();
        return;
    
    
    }
    
    private void eroor(String msg,ActionEvent event){
    Alert emptysearch=new Alert(Alert.AlertType.ERROR,"Error",ButtonType.OK);
        Window owner=((Node)event.getTarget()).getScene().getWindow();
        emptysearch.setContentText(msg);
        emptysearch.initModality(Modality.APPLICATION_MODAL);
        emptysearch.initOwner(owner);
        emptysearch.showAndWait();
        if(emptysearch.getResult()==ButtonType.OK)emptysearch.close();
        return;
    
    
    }
    
    private void sucsess(String msg,ActionEvent event){
    Alert emptysearch=new Alert(Alert.AlertType.INFORMATION,"تمت العملية",ButtonType.OK);
        Window owner=((Node)event.getTarget()).getScene().getWindow();
        emptysearch.setContentText(msg);
        emptysearch.initModality(Modality.APPLICATION_MODAL);
        emptysearch.initOwner(owner);
        emptysearch.showAndWait();
        if(emptysearch.getResult()==ButtonType.OK)emptysearch.close();
        return;
    
    
    }

    
    
    
}