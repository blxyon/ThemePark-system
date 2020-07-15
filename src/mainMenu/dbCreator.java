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

                    

                    Statement stmt = conn.createStatement();
                    createTables(stmt);
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

    private void createTables(Statement stmt) {
        String staffTable="CREATE TABLE IF NOT EXISTS staff (\n"
                + "	staffID integer PRIMARY KEY autoincrement,\n"
                + "	name text NOT NULL\n"
                + ");";
       
       String ridesTable="CREATE TABLE IF NOT EXISTS rides (\n"
                + "	rideID integer PRIMARY KEY autoincrement,\n"
                + "	name text NOT NULL,\n"
                + "	type integer NOT NULL\n"
                + ");";
        
        String ridePositionsTable="CREATE TABLE IF NOT EXISTS ridePositions (\n"
                + "	id integer PRIMARY KEY autoincrement,\n"
                + "	rideID integer NOT NULL,\n"
                + "	positionName text NOT NULL,\n"
                + "	operator integer NOT NULL,\n"
                + "	attendant integer NOT NULL,\n"
                + "	required integer NOT NULL, \n"
                + "	FOREIGN KEY (rideID) REFERENCES rides(rideID) \n"
                + ");";
        
        String skillTable="CREATE TABLE IF NOT EXISTS skills (\n"
                + "	id integer PRIMARY KEY autoincrement,\n"
                + "	staffID integer NOT NULL,\n"
                + "	positionID integer NOT NULL,\n"
                + "	FOREIGN KEY (staffID) REFERENCES staff(staffID),\n"
                + "	FOREIGN KEY (positionID) REFERENCES ridePositions(id)\n"
                + ");";
        
        String scheduleTable="CREATE TABLE IF NOT EXISTS schedule (\n"
                + "	id integer PRIMARY KEY autoincrement,\n"
                + "	positionID integer NOT NULL,\n"
                + "	date text NOT NULL,\n"
                + "	startTime text NOT NULL,\n"
                + "	endTime text NOT NULL,\n"
                + "	staffID integer NOT NULL,\n"
                + "	FOREIGN KEY (staffID) REFERENCES staff(staffID)\n"
                + "	FOREIGN KEY (positionID) REFERENCES ridePositions(id)\n"
                + ");";
        
        try {
			stmt.execute(staffTable);
			System.out.println("1");
			stmt.execute(ridesTable);
			System.out.println("2");
			stmt.execute(ridePositionsTable);
			System.out.println("3");
			stmt.execute(skillTable);
			System.out.println("4");
			stmt.execute(scheduleTable);
			System.out.println("5");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
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