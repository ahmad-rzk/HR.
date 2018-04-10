/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr;

import data2.Data2;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.RotateTransition;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Callback;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author SuPeR_FaNtASy
 */
public class MainPageController implements Initializable {
    @FXML
    TableView licensetable;
    @FXML
    private ImageView logolabel;
    @FXML
    TableView desiestabel;
    @FXML
    TableView farmerstable;
    @FXML
    TextField fsearch;
    @FXML
    TextField dsearch;
    @FXML
    TextField lsearch;
    @FXML
    ImageView SET;
    
    
    
    
    
    
    
    
    
    
    
    @FXML
    public void buildLiense() throws SQLException {
        Data2 d= Data2.getData();
        ResultSet rs=d.loadLicenses();
      ObservableList<ObservableList> data=FXCollections.observableArrayList();
    licensetable.getColumns().clear();
    licensetable.setItems(null);
           for(int i=1 ; i<rs.getMetaData().getColumnCount(); i++){
                //We are using non property style for making dynamic table
                final int j = i; 
                String temp=rs.getMetaData().getColumnName(i+1);
                
                switch(temp){
                            case "DateOfLicense":temp="تاريخ الرخصة";break;
                                case "DateFinish":temp="تاريخ الانتهاء";break;
                                    case "Name":temp="الاسم";break;
                                        case "Active":temp="فعال";break;
       
                        }
                TableColumn col = new TableColumn(temp);
                col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                    public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {
                        
                        
                        
                        return new SimpleStringProperty(param.getValue().get(j).toString());                        
                    }                    
                });

                licensetable.getColumns().addAll(col); 
              
            }

            /********************************
             * Data added to ObservableList *
             ********************************/
            while(rs.next()){
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    //Iterate Column
                    row.add(rs.getString(i));
                }
              
                data.add(row);

            }

            //FINALLY ADDED TO TableView
            licensetable.setItems(data);
          }
    @FXML
    public void buildDesies() throws SQLException {
        Data2 d= Data2.getData();
        ResultSet rs=d.loadDiseases();
      ObservableList<ObservableList> data=FXCollections.observableArrayList();
    desiestabel.getColumns().clear();
    desiestabel.setItems(null);
           for(int i=1 ; i<rs.getMetaData().getColumnCount(); i++){
                //We are using non property style for making dynamic table
                final int j = i; 
                String temp=rs.getMetaData().getColumnName(i+1);
                
                switch(temp){
                            case "Date":temp="التاريخ ";break;
                                case "NameOfAnimalOwner":temp="اسم المالك ";break;
                                    case "Region":temp="المنطقة";break;
                                        case "PlaceOfView":temp="العنوان";break;
                                            case "TypeOfAnimal":temp="نوع الحيوان";break;
                                case "Injury":temp="الاصابة";break;
                                    case "Injured":temp="مصاب";break;
                                        case "Dissemble":temp="نافق";break;
                                            case "Processor":temp="معالجء";break;
                                    case "FortiFied":temp="محصن";break;
                                        case "Doctor":temp="الطبيب المسؤول";break;
                                            case "Therapy":temp=" العلاج المستعمل";break;
                                    case "Sheep":temp="ضان";break;
                                        case "Goat":temp="ماعز";break;
                                            case "Cow":temp="ابقار";break;
                                        case "Other":temp="اخرى";break;
       
                        }
                TableColumn col = new TableColumn(temp);
                col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                    public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {
                        
                        
                        
                        return new SimpleStringProperty(param.getValue().get(j).toString());                        
                    }                    
                });

                desiestabel.getColumns().addAll(col); 
               
            }

            /********************************
             * Data added to ObservableList *
             ********************************/
            while(rs.next()){
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    //Iterate Column
                    row.add(rs.getString(i));
                }
              
                data.add(row);

            }

            //FINALLY ADDED TO TableView
            desiestabel.setItems(data);
          }
    @FXML
     public void buildFarmers() throws SQLException {
        Data2 d= Data2.getData();
        ResultSet rs=d.loadFarmers();
      ObservableList<ObservableList> data=FXCollections.observableArrayList();
    farmerstable.getColumns().clear();
    farmerstable.setItems(null);
           for(int i=1 ; i<rs.getMetaData().getColumnCount(); i++){
                //We are using non property style for making dynamic table
                final int j = i; 
                String temp=rs.getMetaData().getColumnName(i+1);
                
                switch(temp){
                            case "Date":temp="التاريخ ";break;
                                case "Number":temp="الرقم الوطني";break;
                                    case "Region":temp="المنطقة";break;
                               
                                    case "Name":temp="الاسم";break;
                                        case "Doctor":temp="الطبيب";break;
                                            case "Nurse":temp="الممرض";break;
                                            case "Scion":temp=" مطعوم";break;
                                    case "Sheep":temp="ضان";break;
                                        case "Goat":temp="ماعز";break;
                                            case "Cow":temp="ابقار";break;
                                        case "Total":temp="مجموع";break;
       
                        }
                TableColumn col = new TableColumn(temp);
                col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                    public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {
                        
                        
                        
                        return new SimpleStringProperty(param.getValue().get(j).toString());                        
                    }                    
                });

                farmerstable.getColumns().addAll(col); 
               
            }

            /********************************
             * Data added to ObservableList *
             ********************************/
            while(rs.next()){
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    //Iterate Column
                    row.add(rs.getString(i));
                }
               
                data.add(row);

            }

            //FINALLY ADDED TO TableView
            farmerstable.setItems(data);
          }
    
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            buildLiense();
            buildDesies();
            buildFarmers();
        } catch (SQLException ex) {
            Logger.getLogger(MainPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void updateLicense(ActionEvent event){
    String id;
        id=(licensetable.getSelectionModel().getSelectedItems().get(0)+"");
       System.out.println(id);
        if(licensetable.getSelectionModel().isEmpty()){eroor("الرجاء اختيار سطر", event);return;}
   
    int v=licensetable.getSelectionModel().getSelectedIndex();
 try{   
    
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LICENSES.fxml"));
 fxmlLoader.load();
LICENSESController controller = fxmlLoader.<LICENSESController>getController();
controller.initData(true,id);
     
     Parent root1 = (Parent)fxmlLoader.getRoot();
Stage stage = new Stage();
stage.setScene(new Scene(root1));
stage.setTitle("تعديل الرخصة");  
 stage.getIcons().add(new Image("/img/icon.png"));
stage.setResizable(false);
stage.setWidth(455);
stage.setHeight(576);
root1.getStylesheets().add(Hr.class.getResource("FullStyle.css").toExternalForm());
stage.showAndWait();   

Task<Void> task = new Task<Void>() {
    @Override
    public Void call() throws Exception {
        Thread.sleep(1);
        return null ;
    }
};
task.setOnSucceeded(e -> {
    try {
        buildLiense();
        licensetable.refresh();
        licensetable.getSelectionModel().select(v);
    } catch (SQLException ex) {
        Logger.getLogger(MainPageController.class.getName()).log(Level.SEVERE, null, ex);
    }
});
new Thread(task).start();







    
        

        } catch (IOException ex) {
            Logger.getLogger(MainPageController.class.getName()).log(Level.SEVERE, null, ex);
        }}
    
    @FXML
    private void updateFarmer(ActionEvent event){
    String id;
        id=(farmerstable.getSelectionModel().getSelectedItems().get(0)+"");
       System.out.println(id);
        if(farmerstable.getSelectionModel().isEmpty()){eroor("الرجاء اختيار سطر", event);return;}
   
    int v=farmerstable.getSelectionModel().getSelectedIndex();
 try{   
    
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FARMERS.fxml"));
 fxmlLoader.load();
FARMERSController controller = fxmlLoader.<FARMERSController>getController();
controller.initData(true,id);
     
     Parent root1 = (Parent)fxmlLoader.getRoot();
Stage stage = new Stage();
stage.setScene(new Scene(root1));
stage.setTitle("تعديل سجل المزارع");  stage.getIcons().add(new Image("/img/icon.png"));
stage.setResizable(false);
stage.setWidth(455);
stage.setHeight(576);
root1.getStylesheets().add(Hr.class.getResource("FullStyle.css").toExternalForm());
stage.showAndWait();   

Task<Void> task = new Task<Void>() {
    @Override
    public Void call() throws Exception {
        Thread.sleep(1);
        return null ;
    }
};
task.setOnSucceeded(e -> {
    try {
        buildFarmers();
        farmerstable.refresh();
        farmerstable.getSelectionModel().select(v);
    } catch (SQLException ex) {
        Logger.getLogger(MainPageController.class.getName()).log(Level.SEVERE, null, ex);
    }
});
new Thread(task).start();







    
        

        } catch (IOException ex) {
            Logger.getLogger(MainPageController.class.getName()).log(Level.SEVERE, null, ex);
        }}
    
 @FXML
    private void updateDesies(ActionEvent event){
    String id;
        id=(desiestabel.getSelectionModel().getSelectedItems().get(0)+"");
       System.out.println(id);
        if(desiestabel.getSelectionModel().isEmpty()){eroor("الرجاء اختيار سطر", event);return;}
   
    int v=desiestabel.getSelectionModel().getSelectedIndex();
 try{   
    
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DISEASE.fxml"));
 fxmlLoader.load();
DISEASEController controller = fxmlLoader.<DISEASEController>getController();
controller.initData(true,id);
     
     Parent root1 = (Parent)fxmlLoader.getRoot();
Stage stage = new Stage();
stage.setScene(new Scene(root1));
stage.setTitle("تعديل السجل المرضي");  stage.getIcons().add(new Image("/img/icon.png"));
stage.setResizable(false);
stage.setWidth(455);
stage.setHeight(576);
root1.getStylesheets().add(Hr.class.getResource("FullStyle.css").toExternalForm());
stage.showAndWait();   

Task<Void> task = new Task<Void>() {
    @Override
    public Void call() throws Exception {
        Thread.sleep(1);
        return null ;
    }
};
task.setOnSucceeded(e -> {
    try {
        buildDesies();
        desiestabel.refresh();
        desiestabel.getSelectionModel().select(v);
    } catch (SQLException ex) {
        Logger.getLogger(MainPageController.class.getName()).log(Level.SEVERE, null, ex);
    }
});
new Thread(task).start();







    
        

        } catch (IOException ex) {
            Logger.getLogger(MainPageController.class.getName()).log(Level.SEVERE, null, ex);
        }}    
    
    
    @FXML
    private void deleteFarmer(ActionEvent event) {
      String id;
      id=(farmerstable.getSelectionModel().getSelectedItems().get(0)+"");
       System.out.println(id);
        if(farmerstable.getSelectionModel().isEmpty()){eroor("الرجاء اختيار سطر", event);return;}
       if(conform("هل انت متاكد من حذف هاذا السطر", event)){
        Data2 d=Data2.getData();
        id=id.replace("]", "");
     id=id.replace("[", "");
     String[] a=id.split(",");
     a[0]=a[0].trim();
        System.out.println(a[0]);
            try {
                d.deleteFarmer(Integer.parseInt(a[0]));
               
                buildFarmers();farmerstable.refresh(); sucsess("تم الحذف بنجاخ", event);
            } catch (SQLException ex) {
                Logger.getLogger(MainPageController.class.getName()).log(Level.SEVERE, null, ex);
            }
          }    
        }
       
       @FXML
    private void deleteLicens(ActionEvent event) {
      String id;
      id=(licensetable.getSelectionModel().getSelectedItems().get(0)+"");
       System.out.println(id);
        if(licensetable.getSelectionModel().isEmpty()){eroor("الرجاء اختيار سطر", event);return;}
       if(conform("هل انت متاكد من حذف هاذا السطر", event)){
        Data2 d=Data2.getData();
        id=id.replace("]", "");
     id=id.replace("[", "");
     String[] a=id.split(",");
     a[0]=a[0].trim();
        System.out.println(a[0]);
            try {
                d.deleteLicenses(Integer.parseInt(a[0]));
               
               buildLiense();licensetable.refresh(); sucsess("تم الحذف بنجاخ", event);
            } catch (SQLException ex) {
                Logger.getLogger(MainPageController.class.getName()).log(Level.SEVERE, null, ex);
            }
          }    
        }
    
    
     @FXML
    private void deleteDesies(ActionEvent event) {
      String id;
      id=(desiestabel.getSelectionModel().getSelectedItems().get(0)+"");
       System.out.println(id);
        if(desiestabel.getSelectionModel().isEmpty()){eroor("الرجاء اختيار سطر", event);return;}
       if(conform("هل انت متاكد من حذف هاذا السطر", event)){
        Data2 d=Data2.getData();
        id=id.replace("]", "");
     id=id.replace("[", "");
     String[] a=id.split(",");
     a[0]=a[0].trim();
        System.out.println(a[0]);
            try {
                d.deleteDiseases(Integer.parseInt(a[0]));
                
                buildDesies();desiestabel.refresh();sucsess("تم الحذف بنجاخ", event);
            } catch (SQLException ex) {
                Logger.getLogger(MainPageController.class.getName()).log(Level.SEVERE, null, ex);
            }
          }    
        }
        
    
    @FXML
    private void fSearch(ActionEvent event){
    String s=fsearch.getText().trim();
    if(s.isEmpty()||s.equals("")){eroor("الرجاء ادخال بيانات للبحث", event);return;}
    boolean found =false;
    for(int i=0;i<farmerstable.getItems().size();i++){
    Object v=farmerstable.getItems().get(i);
   String id= farmerstable.getItems().get(i)+"";
    id=id.replace("]", "");
     id=id.replace("[", "");
     String[] a=id.split(",");
        System.out.println(a[a.length-1]);
        if(a[a.length-1].trim().equalsIgnoreCase(s)||a[a.length-2].trim().equalsIgnoreCase(s))
        {
            farmerstable.getSelectionModel().select(v);farmerstable.scrollTo(v);farmerstable.requestFocus();found=true;break;
        }
   
   }
    if(found==false)eroor("لم يتم ايجاد مزارع بهذه المعلومات", event);
    
    }
    
    
    
@FXML
public void fSearchEnterPressed(ActionEvent event)
{
    if(event.getSource().equals(KeyCode.ENTER));
    {
      
        
        
           String s=fsearch.getText().trim();
    if(s.isEmpty()||s.equals("")){eroor("الرجاء ادخال بيانات للبحث",event);return;}
    boolean found =false;
    for(int i=0;i<farmerstable.getItems().size();i++){
    Object v=farmerstable.getItems().get(i);
   String id= farmerstable.getItems().get(i)+"";
    id=id.replace("]", "");
     id=id.replace("[", "");
     String[] a=id.split(",");
        System.out.println(a[a.length-1]);
        if(a[a.length-1].trim().equalsIgnoreCase(s)||a[a.length-2].trim().equalsIgnoreCase(s))
        {
            farmerstable.getSelectionModel().select(v);farmerstable.scrollTo(v);farmerstable.requestFocus();found=true;break;
        }
   
   }
    if(found==false)eroor("لم يتم ايجاد مزارع بهذه المعلومات", event);
        
        
        
    }
}
    
    
    
  @FXML
    private void dSearch(ActionEvent event){
    String s=dsearch.getText().trim();
    if(s.isEmpty()||s.equals("")){eroor("الرجاء ادخال بيانات للبحث", event);return;}
    boolean found =false;
    for(int i=0;i<desiestabel.getItems().size();i++){
    Object v=desiestabel.getItems().get(i);
   String id= desiestabel.getItems().get(i)+"";
    id=id.replace("]", "");
     id=id.replace("[", "");
     String[] a=id.split(",");
        System.out.println(a[2]);
        if(a[2].trim().equalsIgnoreCase(s))
        {
            System.out.println(a[2]);
            desiestabel.getSelectionModel().select(v);desiestabel.scrollTo(v);desiestabel.requestFocus();found=true;break;
        }
   
   }
    if(found==false)eroor("لم يتم ايجاد سجل مرض بهذه المعلومات", event);
    
    }  
    
    
    
    
    @FXML
public void dSearchEnterPressed(ActionEvent event)
{
    if(event.getSource().equals(KeyCode.ENTER));
    {
      
        
   String s=dsearch.getText().trim();
    if(s.isEmpty()||s.equals("")){eroor("الرجاء ادخال بيانات للبحث", event);return;}
    boolean found =false;
    for(int i=0;i<desiestabel.getItems().size();i++){
    Object v=desiestabel.getItems().get(i);
   String id= desiestabel.getItems().get(i)+"";
    id=id.replace("]", "");
     id=id.replace("[", "");
     String[] a=id.split(",");
        System.out.println(a[2]);
        if(a[2].trim().equalsIgnoreCase(s))
        {
            System.out.println(a[2]);
            desiestabel.getSelectionModel().select(v);desiestabel.scrollTo(v);desiestabel.requestFocus();found=true;break;
        }
   
   }
    if(found==false)eroor("لم يتم ايجاد سجل مرض بهذه المعلومات", event);
    
        
        
    }
}
    
 
public void lSelectlast(){
       int i=licensetable.getItems().size()-1;
    Object v=licensetable.getItems().get(i);
   String id= licensetable.getItems().get(i)+"";
    id=id.replace("]", "");
     id=id.replace("[", "");
     String[] a=id.split(",");
        System.out.println(a[3]);
        
            System.out.println(a[3]);
            licensetable.getSelectionModel().select(v);licensetable.scrollTo(v);licensetable.requestFocus();
}


@FXML
    private void lSearch(ActionEvent event){
    String s=lsearch.getText().trim();
    if(s.isEmpty()||s.equals("")){eroor("الرجاء ادخال بيانات للبحث", event);return;}
    boolean found =false;
    for(int i=0;i<licensetable.getItems().size();i++){
    Object v=licensetable.getItems().get(i);
   String id= licensetable.getItems().get(i)+"";
    id=id.replace("]", "");
     id=id.replace("[", "");
     String[] a=id.split(",");
        System.out.println(a[3]);
        if(a[3].trim().equalsIgnoreCase(s))
        {
            System.out.println(a[3]);
            licensetable.getSelectionModel().select(v);licensetable.scrollTo(v);licensetable.requestFocus();found=true;break;
        }
   
   }
    if(found==false)eroor("لم يتم ايجاد سجل رخصة بهذه المعلومات", event);
    
    }  






    
    @FXML
public void lSearchEnterPressed(ActionEvent event)
{
    if(event.getSource().equals(KeyCode.ENTER));
    {
      
        
   String s=lsearch.getText().trim();
    if(s.isEmpty()||s.equals("")){eroor("الرجاء ادخال بيانات للبحث", event);return;}
    boolean found =false;
    for(int i=0;i<licensetable.getItems().size();i++){
    Object v=licensetable.getItems().get(i);
   String id= licensetable.getItems().get(i)+"";
    id=id.replace("]", "");
     id=id.replace("[", "");
     String[] a=id.split(",");
        System.out.println(a[3]);
        if(a[3].trim().equalsIgnoreCase(s))
        {
            System.out.println(a[3]);
            licensetable.getSelectionModel().select(v);licensetable.scrollTo(v);licensetable.requestFocus();found=true;break;
        }
   
   }
    if(found==false)eroor("لم يتم ايجاد سجل رخصة بهذه المعلومات", event);
        
    }
}
    
    
    
    
    @FXML
    public void openLicenseAdd(){
        try {
           
FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LICENSES.fxml"));
long b=licensetable.getItems().size();
fxmlLoader.load();
Parent root1 = (Parent)fxmlLoader.getRoot();
Stage stage = new Stage();
stage.setScene(new Scene(root1));
stage.setTitle("اضافة رخصة جديدة");  stage.getIcons().add(new Image("/img/icon.png"));
stage.setResizable(false);
stage.setWidth(455);
stage.setHeight(576);
root1.getStylesheets().add(Hr.class.getResource("FullStyle.css").toExternalForm());
stage.showAndWait();   

Task<Void> task = new Task<Void>() {
    @Override
    public Void call() throws Exception {
        Thread.sleep(1);
        return null ;
    }
};
task.setOnSucceeded(e -> {
    try {
        
        buildLiense();
        long a=licensetable.getItems().size();
          
        if(a!=b){
          
        lSelectlast();}
    } catch (SQLException ex) {
        Logger.getLogger(MainPageController.class.getName()).log(Level.SEVERE, null, ex);
    }
});
new Thread(task).start();







    
        

        } catch (IOException ex) {
            Logger.getLogger(MainPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
  
    @FXML
    private void openSettings(){
    try {
           
FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SETTINGS.fxml"));

fxmlLoader.load();
Parent root1 = (Parent)fxmlLoader.getRoot();
Stage stage = new Stage();
stage.setScene(new Scene(root1));
stage.setTitle("تعديل اساسيات النظام");  stage.getIcons().add(new Image("/img/icon.png"));
stage.setResizable(false);

root1.getStylesheets().add(Hr.class.getResource("FullStyle.css").toExternalForm());
stage.showAndWait();   

    
    }   catch (IOException ex) {
            Logger.getLogger(MainPageController.class.getName()).log(Level.SEVERE, null, ex);
        }}
    
    @FXML
   public void openFarmersAdd(){
        try {
 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FARMERS.fxml"));
int b=farmerstable.getItems().size();
fxmlLoader.load();
Parent root1 = (Parent)fxmlLoader.getRoot();
Stage stage = new Stage();
stage.setScene(new Scene(root1));
stage.setTitle("اضافة سجل مزارع  جديد");  
stage.getIcons().add(new Image("/img/icon.png"));
stage.setResizable(false);
stage.setWidth(455);
stage.setHeight(576);
root1.getStylesheets().add(Hr.class.getResource("FullStyle.css").toExternalForm());
stage.showAndWait();   

Task<Void> task = new Task<Void>() {
    @Override
    public Void call() throws Exception {
        Thread.sleep(1);
        return null ;
    }
};
task.setOnSucceeded(e -> {
    try {
        
        buildFarmers();
        int a=farmerstable.getItems().size();
        if(a!=b){
          
       farmerstable.refresh();
            farmerstable.getSelectionModel().selectLast();
        farmerstable.scrollTo(farmerstable.getItems().size());
        farmerstable.requestFocus();}
    } catch (SQLException ex) {
        Logger.getLogger(MainPageController.class.getName()).log(Level.SEVERE, null, ex);
    }
});
new Thread(task).start();







    
        

        } catch (IOException ex) {
            Logger.getLogger(MainPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }

    @FXML
    public void openDesiessAdd(){
        try {
 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DISEASE.fxml"));
int b=desiestabel.getItems().size();
fxmlLoader.load();
Parent root1 = (Parent)fxmlLoader.getRoot();
Stage stage = new Stage();
stage.setScene(new Scene(root1));
stage.getIcons().add(new Image("/img/icon.png"));
stage.setTitle("اضافة سجل مرضي  جديد");
stage.setResizable(false);
stage.setWidth(455);
stage.setHeight(576);
root1.getStylesheets().add(Hr.class.getResource("FullStyle.css").toExternalForm());
stage.showAndWait();   

Task<Void> task = new Task<Void>() {
    @Override
    public Void call() throws Exception {
        Thread.sleep(1);
        return null ;
    }
};
task.setOnSucceeded(e -> {
    try {
        
        buildDesies();
        int a=desiestabel.getItems().size();
        if(a!=b){
       desiestabel.refresh();
       desiestabel.getSelectionModel().selectLast();
       desiestabel.scrollTo(desiestabel.getItems().size());
       desiestabel.requestFocus();}
    } catch (SQLException ex) {
        Logger.getLogger(MainPageController.class.getName()).log(Level.SEVERE, null, ex);
    }
});
new Thread(task).start();







    
        

        } catch (IOException ex) {
            Logger.getLogger(MainPageController.class.getName()).log(Level.SEVERE, null, ex);
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
