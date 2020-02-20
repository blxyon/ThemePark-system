package mainMenu;

import java.io.File;
import java.sql.*;


public class dbCreator {
    String fileName;
    Connection conn;

    public dbCreator(String fileName) {
    	this.fileName=fileName+".db";
    }



    public int createNewDatabase() {

        int createdDB=2;

        if(!(new File(fileName)).exists())
        {
            String url = "jdbc:sqlite:" + fileName;

            try{
                conn = DriverManager.getConnection(url);
                if (conn != null) {
                    DatabaseMetaData meta = conn.getMetaData();
                    System.out.println("The driver name is " + meta.getDriverName());
                    System.out.println("A new database has been created.");

                    //connect();

                    String sql=getSQLTableCreation();

                    Statement stmt = conn.createStatement();
                    stmt.execute(sql);
                    
                    createdDB=0;
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }else {
            System.out.println("DB file exists already!");
            createdDB=1;}
        return createdDB;
    }

    private String getSQLTableCreation() {
        String sql="CREATE TABLE IF NOT EXISTS " +
                "CREATE TABLE IF NOT EXISTS ppl (\n"
                + "	id integer PRIMARY KEY autoincrement,\n"
                + "	fName text NOT NULL,\n"
                + "	email text NOT NULL,\n"
                + "	type text NOT NULL\n"
                + ");";
        /*String newTable="CREATE TABLE IF NOT EXISTS " +
                "CREATE TABLE IF NOT EXISTS ppl (\n"
                + "	id integer PRIMARY KEY autoincrement,\n"
                + "	fName text NOT NULL,\n"
                + "	email text NOT NULL,\n"
                + "	type text NOT NULL\n"
                + ");";*/
        return sql;
    }

    public void connect() {
        try {
            // db parameters
            String url = "jdbc:sqlite:"+fileName;
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    /*public void insert(String fName ,String sName, String email, String type) {
        String sql = "INSERT INTO 'TABLENAME''(FIELDS) VALUES(?,?,?,?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, value for first entry);
            pstmt.setString(2, value second entry);
            pstmt.setString(3, value third entry);
            pstmt.setString(4, value fourth entry);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }*/

}