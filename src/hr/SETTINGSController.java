/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr;

import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import data2.Data2;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author SuPeR_FaNtASy
 */
public class SETTINGSController implements Initializable {
    @FXML
    private JFXTextField doctorsearch;
    @FXML
    private JFXTextField tsearch;
    @FXML
    private JFXTextField rsearch;
    @FXML
    private JFXTextField nsearch;
    @FXML
    private JFXListView<String> dl;
    @FXML
    private JFXListView<String> tl;
    @FXML
    private JFXListView<String> rl;
    @FXML
    private JFXListView<String> nl;

    
    @FXML
    void build() throws SQLException{
    data2.Data2 d=Data2.getData();
    ResultSet rs;
    
    
    dl.getItems().clear();
    tl.getItems().clear();
    rl.getItems().clear();
    nl.getItems().clear();
    
    rs=d.loadDAreas();
    while(rs.next())
    rl.getItems().add(rs.getString(2));
    
    rs=d.loadDoctors();
    while(rs.next())
    dl.getItems().add(rs.getString(2));
    
    rs=d.loadDRecipes();
    while(rs.next())
    tl.getItems().add(rs.getString(2));
    
    
    
    rs=d.loadDNurses();
    while(rs.next())
    nl.getItems().add(rs.getString(2));
    

    
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            build();
        } catch (SQLException ex) {
            Logger.getLogger(SETTINGSController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void fSearchEnterPressed(ActionEvent event) {
    }
   
    
    
    
    
   
    
    @FXML
    private void deleten(ActionEvent event){
    
    String id;
      id=(nl.getSelectionModel().getSelectedItems().get(0)+"");
       System.out.println(id);
        if(nl.getSelectionModel().isEmpty()){eroor("الرجاء اختيار قيمه للحذف", event);return;}
       if(conform("هل انت متاكد من حذف هذه القيمه", event)){
        Data2 d=Data2.getData();
        id=id.replace("]", "");
     id=id.replace("[", "");
     String[] a=id.split(",");
     a[0]=a[0].trim();
        System.out.println(a[0]);
            try {
                 int theid=0;
                ResultSet rs=d.loadDNurses();
                while(rs.next())if(a[0].trim().equalsIgnoreCase(rs.getString(2)))theid=Integer.parseInt(rs.getString(1).trim());
                d.deleteNurse(theid+"");
               
                build();nl.refresh(); sucsess("تم الحذف بنجاخ", event);
            } catch (SQLException ex) {
                Logger.getLogger(MainPageController.class.getName()).log(Level.SEVERE, null, ex);
            }
          }    
    
    
    
    
    }
    
    @FXML
    private void deleted(ActionEvent event){
    
    String id;
      id=(dl.getSelectionModel().getSelectedItems().get(0)+"");
       System.out.println(id);
        if(dl.getSelectionModel().isEmpty()){eroor("الرجاء اختيار قيمه للحذف", event);return;}
       if(conform("هل انت متاكد من حذف هذه القيمه", event)){
        Data2 d=Data2.getData();
        id=id.replace("]", "");
     id=id.replace("[", "");
     String[] a=id.split(",");
     a[0]=a[0].trim();
        System.out.println(a[0]);
            try {
                 int theid=0;
                ResultSet rs=d.loadDoctors();
                while(rs.next())if(a[0].trim().equalsIgnoreCase(rs.getString(2)))theid=Integer.parseInt(rs.getString(1).trim());
                d.deleteDoctor(theid+"");
               
                build();dl.refresh(); sucsess("تم الحذف بنجاخ", event);
            } catch (SQLException ex) {
                Logger.getLogger(MainPageController.class.getName()).log(Level.SEVERE, null, ex);
            }
          }    
    
    
    
    
    }
    
     @FXML
    private void deletet(ActionEvent event){
    
    String id;
      id=(tl.getSelectionModel().getSelectedItems().get(0)+"");
       System.out.println(id);
        if(tl.getSelectionModel().isEmpty()){eroor("الرجاء اختيار قيمه للحذف", event);return;}
       if(conform("هل انت متاكد من حذف هذه القيمه", event)){
        Data2 d=Data2.getData();
        id=id.replace("]", "");
     id=id.replace("[", "");
     String[] a=id.split(",");
     a[0]=a[0].trim();
        System.out.println(a[0]);
            try {
                int theid=0;
                ResultSet rs=d.loadDRecipes();
                while(rs.next())if(a[0].trim().equalsIgnoreCase(rs.getString(2)))theid=Integer.parseInt(rs.getString(1).trim());
                    
                d.deleteRecipe(theid+"");
               
                build();tl.refresh(); sucsess("تم الحذف بنجاخ", event);
            } catch (SQLException ex) {
                Logger.getLogger(MainPageController.class.getName()).log(Level.SEVERE, null, ex);
            }
          }    
    
    
    
    
    }
    
    
     @FXML
    private void deleter(ActionEvent event){
    
    String id;
      id=(rl.getSelectionModel().getSelectedItems().get(0)+"");
       System.out.println(id);
        if(rl.getSelectionModel().isEmpty()){eroor("الرجاء اختيار قيمه للحذف", event);return;}
       if(conform("هل انت متاكد من حذف هذه القيمه", event)){
        Data2 d=Data2.getData();
        id=id.replace("]", "");
     id=id.replace("[", "");
     String[] a=id.split(",");
     a[0]=a[0].trim();
        System.out.println(a[0]);
            try {
                 int theid=0;
                ResultSet rs=d.loadDAreas();
                while(rs.next())if(a[0].trim().equalsIgnoreCase(rs.getString(2)))theid=Integer.parseInt(rs.getString(1).trim());
                d.deleteRegion(theid+"");
               
                build();rl.refresh(); sucsess("تم الحذف بنجاخ", event);
            } catch (SQLException ex) {
                Logger.getLogger(MainPageController.class.getName()).log(Level.SEVERE, null, ex);
            }
          }    
    
    
    
    
    }
    
    
    
    @FXML
    private void addd(ActionEvent event){
    
     String s=doctorsearch.getText().trim();
    if(s.isEmpty()||s.equals("")){eroor("الرجاء ادخال بيانات ",event);return;}
    data2.Data2 d=Data2.getData();
    try {
        d.insertDoctor(s);
 sucsess("تمت الاضافه بنجاح", event);
 build();
   dl.getSelectionModel().selectLast();
   dl.scrollTo(dl.getSelectionModel().getSelectedIndex());
   dl.requestFocus();
        } catch (SQLException ex ) {
            Logger.getLogger(LICENSESController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
    @FXML
    private void addn(ActionEvent event){
    
     String s=nsearch.getText().trim();
    if(s.isEmpty()||s.equals("")){eroor("الرجاء ادخال بيانات ",event);return;}
    data2.Data2 d=Data2.getData();
    try {
        d.insertNurse(s);
 sucsess("تمت الاضافه بنجاح", event);
 build();
       nl.getSelectionModel().selectLast();  
       nl.scrollTo(nl.getSelectionModel().getSelectedIndex());
        nl.requestFocus();
        } catch (SQLException ex ) {
            Logger.getLogger(LICENSESController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
   @FXML
    private void addr(ActionEvent event){
    
     String s=rsearch.getText().trim();
    if(s.isEmpty()||s.equals("")){eroor("الرجاء ادخال بيانات ",event);return;}
    data2.Data2 d=Data2.getData();
    try {
        d.insertRegion(s);
 sucsess("تمت الاضافه بنجاح", event);
 build();
      rl.getSelectionModel().selectLast(); 
      rl.scrollTo(rl.getSelectionModel().getSelectedIndex());
       rl.requestFocus();
        } catch (SQLException ex ) {
            Logger.getLogger(LICENSESController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    @FXML
    private void addt(ActionEvent event){
    
     String s=tsearch.getText().trim();
    if(s.isEmpty()||s.equals("")){eroor("الرجاء ادخال بيانات ",event);return;}
    data2.Data2 d=Data2.getData();
    try {
        d.insertRecipe(s);
 sucsess("تمت الاضافه بنجاح", event);
 build();
   tl.getSelectionModel().selectLast(); 
   tl.scrollTo(tl.getSelectionModel().getSelectedIndex());
    tl.requestFocus();
        } catch (SQLException ex ) {
            Logger.getLogger(LICENSESController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
     
    
    
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
