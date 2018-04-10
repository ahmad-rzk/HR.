/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr;

import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 *
 * @author SuPeR_FaNtASy
 */
public class Hr extends Application {
    
  

    
    
    
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.getIcons().add(new Image("/img/icon.png"));
        stage.setTitle("مديرية الزراعة");
        stage.show();
     scene.getStylesheets().add(Hr.class.getResource("FullStyle.css").toExternalForm());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
