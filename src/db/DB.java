package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author SuPeR_FaNtASy
 */
public class DB {
    
    
    public static DB db;
    
    
    
    
    
    
    private static String string;
    private static Connection conn;
    private static Statement st;
    private static ResultSet rs;
    
    
    
    
    private DB() {
        String url= "jdbc:ucanaccess://";
        String dbName = "DataBase.accdb";
      /*  String driver = "com.mysql.jdbc.Driver";*/
        String userName = "";
        String password = "";
        try {
           /* Class.forName(driver).newInstance();*/
            this.conn = (Connection)DriverManager.getConnection(url+dbName,userName,password);
          st=conn.createStatement();
        }
        catch (Exception sqle) {
            sqle.printStackTrace();
        }
    }
    /**
     *
     * @return MysqlConnect Database connection object
     */
    public static DB getDbCon() {
        if ( db == null ) {
            db = new DB();
        }
        return db;
 
    }
    /**
     *
     * @param query String The query to be executed
     * @return a ResultSet object containing the results or null if not available
     * @throws SQLException
     */
    public ResultSet query(String query) throws SQLException{
        st = db.conn.createStatement();
        ResultSet res = st.executeQuery(query);
        return res;
    }
    /**
     * @desc Method to insert data to a table
     * @param insertQuery String The Insert query
     * @return boolean
     * @throws SQLException
     */
    public int insert(String insertQuery) throws SQLException {
        st = db.conn.createStatement();
        int result = st.executeUpdate(insertQuery);
        return result;
 
    }
    
    public int update(String updateQuery) throws SQLException {
        st = db.conn.createStatement();
        int result = st.executeUpdate(updateQuery);
        return result;
 
    }
    
    public int delete(String deleteQuery) throws SQLException {
        st = db.conn.createStatement();
        int result = st.executeUpdate(deleteQuery);
        return result;
 
    }
    
    
    
    
  /*  boolean isEmpty(ResultSet rs) throws SQLException{
   
            return rs.next();
    
 
}
    
    
   /* String insertBuild(ArrayList<String> list,String tablename) throws SQLException{
    list.trimToSize();
    System.out.println(list.get(0));
    string="insert into "+tablename
    +" values(";
 
 rs=st.executeQuery("select * from "+tablename+" where 1>2");
 rs=st.executeQuery("select * from "+tablename+" where 1=2");
 ResultSetMetaData rsmd=rs.getMetaData();
 String type;
 for(int i=0;i<list.size();i++){
 type=(rsmd.getColumnTypeName(i+1));
     System.out.println(type);
 if(type.equalsIgnoreCase("VARCHAR"))
 string+="'"+list.get(i)+"'";
 else
 string+=list.get(i);
 if(i!=list.size()-1)string+=",";
 else string+=")";

 }  
        System.out.println(string);
        return string;

 }*/

}