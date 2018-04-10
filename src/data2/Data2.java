/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data2;

import db.DB;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Data2 {

    private static Data2 data;
    private DB db;

    private Data2() {
        db = DB.getDbCon();
    }

    public static synchronized Data2 getData() {
        if (data == null) {
            data = new Data2();
        }
        return data;
    }

    ///***********Farmers************************************
    //..........................................................................
    //..........................................................................
    public ResultSet loadFarmerId(int id) throws SQLException {
        return db.query("select * from Farmers where id=" + id);

    }

    public ResultSet loadFarmerName(String name) throws SQLException {
        return db.query("select * from Farmers where Name='" + name + "'");

    }

    public ResultSet loadFarmers() throws SQLException {
        return db.query("select * from Farmers");

    }

    public int insertFarmer(String Name,String Date, long Number, String Region, int Sheep, int Goat, int Cow,
            String Scion, String Nurse, String Doctor) throws SQLException {

        int Total = Sheep + Goat + Cow;

        String all = "'" + Name + "'," +"'"+Date+"',"+ Number + ",'" + Region + "'," + Sheep + "," + Goat + ","
                + Cow + "," + Total + ",'" + Scion + "','" + Nurse + "','" + Doctor + "'";

        return db.insert("INSERT INTO Farmers (Name,Date,Number,Region,Sheep,Goat,Cow,Total,Scion,Nurse,Doctor)"
                + "values(" + all + ")");

    }

    public int deleteFarmer(int id) throws SQLException {
        return db.delete("delete from Farmers where id=" + id);

    }

    public int updateFarmer(int id, String Name,String Date, long Number, String Region, int Sheep, int Goat, int Cow, 
            String Scion, String Nurse, String Doctor) throws SQLException {

        int Total=Goat+Cow+Sheep;
        return db.update("UPDATE Farmers SET Name='"+Name+"',"+" Date ='" + Date + "', Number =" + Number + ", Region ='" + Region + "', Sheep =" + Sheep
                + ", Goat=" + Goat + ", Cow=" + Cow + ", Total=" + Total + ", Scion='" + Scion + "', Nurse='" + Nurse + "', Doctor='" + Doctor
                + "' WHERE id=" + id);
    }

    //.......................................................................................
    

    
    
    
      //********Licenses*************
    
    public ResultSet loadLicenseName(String name) throws SQLException {
        return db.query("select * from Licenses where name='"+name+"'");

    }

    public ResultSet loadLicenses() throws SQLException {
        return db.query("select * from Licenses");

    }

    public int insertLicenses(String DateOfLicense, String DateFinish, String Name, boolean Active) throws SQLException {
        String all = "'" + DateOfLicense + "','" + DateFinish + "','" + Name + "','" + Active + "'";

        return db.insert("INSERT INTO Licenses (DateOfLicense,DateFinish,Name,Active)"
                + "values(" + all + ")");

    }

    public int deleteLicenses(int id) throws SQLException {

        return db.delete("delete from Licenses where id=" + id);

    }

    public int updateLicenses(int id, String DateOfLicense, String DateFinish,
            String Name, boolean Active) throws SQLException {

        return db.update("UPDATE Licenses SET DateOfLicense ='" + DateOfLicense + "', DateFinish ='" + DateFinish
                + "',Name='" + Name + "', Active='" + Active 
                + "' WHERE id=" + id);
    }

    //...............................................................................................................
    
    
    
//***********Diseases****************
     
    public ResultSet loadDiseasesFarmer(String name) throws SQLException {
        return db.query("select * from Diseases where NameOfAnimalOwner='"+name+"'");

    }

     
    public ResultSet loadDiseases() throws SQLException {
        return db.query("select * from Diseases");

    }

    public int insertDiseases(String Date, String NameOfAnimalOwner, String Region, String PlaceOfView, String TypeOfAnimal,
            String Injury, int Injured, int Dissemble, int processor, int FortiFied, String Doctor, String Therapy, int Sheep, int Goat, int Cow, int Other) throws SQLException {

        String all = "'" + Date + "','" + NameOfAnimalOwner + "','" + Region + "','" + PlaceOfView + "','" + TypeOfAnimal + "','"
                + Injury + "'," + Injured + "," + Dissemble + "," + processor + "," + FortiFied + ",'" + Doctor + "','" + Therapy + "',"
                + Sheep + "," + Goat + "," + Cow + "," + Other;

        return db.insert("INSERT INTO Diseases (Date,NameOfAnimalOwner,Region,PlaceOfView,TypeOfAnimal,Injury,"
                + "Injured,Dissemble,processor,FortiFied,Doctor,Therapy,Sheep,Goat,Cow,Other)"
                + "values(" + all + ")");

    }

    public int deleteDiseases(int id) throws SQLException {
        return db.delete("delete from Diseases where id=" + id);

    }

    public int updateDiseases(int id, String Date, String NameOfAnimalOwner, String Region, String PlaceOfView, String TypeOfAnimal,
            String Injury, int Injured, int Dissemble, int processor, int FortiFied, String Doctor, String Therapy, int Sheep, int Goat, int Cow, int Other) throws SQLException {

        return db.update("UPDATE Diseases SET Date ='" + Date + "', NameOfAnimalOwner ='" + NameOfAnimalOwner + "', Region ='" + Region
                + "', PlaceOfView ='" + PlaceOfView + "', TypeOfAnimal='" + TypeOfAnimal + "', Injury='" + Injury + "', Injured=" + Injured
                + ", Dissemble=" + Dissemble + ", processor=" + processor + ", FortiFied=" + FortiFied + ", Therapy='" + Therapy + "', Doctor='" + Doctor
                + "', Sheep=" + Sheep + ", Goat=" + Goat + ", Cow=" + Cow + ", Other=" + Other + " WHERE id=" + id);
    }

    //..............................................................................................
    
   
    
// ************Doctors**********************
    
    
     public ResultSet loadDoctorName(String name) throws SQLException {
        return db.query("select * from Doctors where Name='"+name+"'");

    }
    public ResultSet loadDoctors() throws SQLException {
        return db.query("select * from Doctors");

    }

    public int insertDoctor(String Name) throws SQLException {

        return db.insert("INSERT INTO Doctors (Name)"
                + "values('" + Name + "')");

    }

    public int deleteDoctor(String id) throws SQLException {
        return db.delete("delete from Doctors where id=" + id);

    }

    public int updateDoctor(String Name, String id) throws SQLException {

        return db.update("UPDATE Doctors SET Name ='" + Name + "' WHERE id=" + id);
    }

    //..............................................................................................
    
    
   

   // ************Nurses**********************
    
    public ResultSet loadDNursesName(String name) throws SQLException {
        return db.query("select * from Nurses where name='"+name+"'");

    } 
    
    public ResultSet loadDNurses() throws SQLException {
        return db.query("select * from Nurses");

    }

    public int insertNurse(String Name) throws SQLException {

        return db.insert("INSERT INTO Nurses (Name)"
                + "values('" + Name + "')");

    }

    public int deleteNurse(String id) throws SQLException {
        return db.delete("delete from Nurses where id=" + id);

    }

    public int updateNurse(String Name, String id) throws SQLException {

        return db.update("UPDATE Nurses SET Name ='" + Name + "' WHERE id=" + id);
    }

    //...................................................................................
    
    
    
      // ************Recipes**********************
    
    public ResultSet loadDRecipes() throws SQLException {
        return db.query("select * from Recipes");

    }

    public int insertRecipe(String Name) throws SQLException {

        return db.insert("INSERT INTO Recipes (Name)"
                + "values('" + Name + "')");

    }

    public int deleteRecipe(String id) throws SQLException {
        return db.delete("delete from Recipes where id=" + id);

    }

    public int updateRecipe(String Name, String id) throws SQLException {

        return db.update("UPDATE Recipes SET Name ='" + Name + "' WHERE id=" + id);
    }

      // ************Areas**********************
    public int insertRegion(String Name) throws SQLException {

        return db.insert("INSERT INTO Areas (Name)"
                + "values('" + Name + "')");

    }
    
    
    
 public int deleteRegion(String id) throws SQLException {
        return db.delete("delete from Areas where id=" + id);

    }

    public ResultSet loadDAreas() throws SQLException {
        return db.query("select * from Areas");

    }

    //.......................................................................
    
   
    
    public static void main(String args[]) throws SQLException {
        Data2 d = new Data2();

d.deleteFarmer(2);

        
        System.out.println("kill");
        
        
 
    }

}
