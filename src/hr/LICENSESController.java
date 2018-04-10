/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import data2.Data2;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
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
public class LICENSESController implements Initializable {
    @FXML
    private JFXCheckBox active;
    @FXML
    private JFXDatePicker edate;
    @FXML
    private JFXTextField name;
    @FXML
    private JFXDatePicker sdate;

    @FXML
    private JFXButton cancel;
    
   @FXML
    private VBox container;
    
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
  
  name.setText(a[3]);
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
  {String ddd[]=a[2].split("/");
  String yyyy=ddd[2].trim().trim();
  String dd=ddd[0].trim().trim();
  String mm=ddd[1].trim().trim();
  if(dd.length()<2)dd="0"+dd;
  if(mm.length()<2)mm="0"+mm;
  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    LocalDate localDate = LocalDate.parse(dd+"-"+mm+"-"+yyyy, formatter);
  edate.setValue(localDate);}
  ///////////////////////////////////////////
 
  active.setSelected((a[4].equalsIgnoreCase("true")));
  ///////////////////////////////////////////
  theid=Integer.parseInt(a[0].trim());
       
    
    
    
        System.out.println("builded");
    
    }
    
    
    
    void initData(boolean x,String y){
    flag=x;
    row=y;
        System.out.println("init");
         if(flag!=false){buildUpdate();}
    
    }
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
      
       name.requestFocus();     
        System.out.println("initialized");
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
  if(name.getText().trim().isEmpty()||!(sdate.getValue()!=null)||!(edate.getValue()!=null)){eroor("الرجاء ملء جميع الحقول", event);return;}
  data2.Data2 d=Data2.getData();
      if(flag==false){
      
      
  String nm= name.getText().trim().trim();
  String sd= sdate.getValue().getDayOfMonth()+"".trim()+"/"+sdate.getValue().getMonthValue()+"".trim()+"/"+sdate.getValue().getYear();
  String ed= edate.getValue().getDayOfMonth()+"".trim()+"/"+edate.getValue().getMonthValue()+"".trim()+"/"+edate.getValue().getYear();
  boolean ac=active.isSelected();
  
 
        try {
            d.insertLicenses(sd, ed, nm, ac);


 close(event);
 sucsess("تمت الاضافه بنجاح", event);
            
        } catch (SQLException ex ) {
            Logger.getLogger(LICENSESController.class.getName()).log(Level.SEVERE, null, ex);
        }
  
  }
  else {
  
      
      
  String nm= name.getText().trim().trim();
  String sd= sdate.getValue().getDayOfMonth()+"".trim()+"/"+sdate.getValue().getMonthValue()+"".trim()+"/"+sdate.getValue().getYear();
  String ed= edate.getValue().getDayOfMonth()+"".trim()+"/"+edate.getValue().getMonthValue()+"".trim()+"/"+edate.getValue().getYear();
  boolean ac=active.isSelected();
  
 
        try {
d.updateLicenses(theid, sd, ed, nm, ac);

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
