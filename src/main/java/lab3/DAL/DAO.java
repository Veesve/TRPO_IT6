package lab3.DAL;

import lab3.model.Film;


import java.sql.*;

public class DAO {
    private static DAO instance;
    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final String DB_URL ="jdbc:postgresql://localhost:5432/filmstore";
    private static final String USER = "postgres";
    private static final String PASS = "qwerty123";
    private DAO(){ }
    public static DAO getInstance(){
        if(instance == null) {
            instance = new DAO();
        }
        return instance;
    }

    public void insert(Film film) throws SQLException,ClassNotFoundException {
        //DriverManager.registerDriver(new Driver());
        Class.forName(JDBC_DRIVER);
        Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
        PreparedStatement inserting = conn.prepareStatement("INSERT INTO films VALUES( ?, ?, ?)");
        inserting.setString(1, film.getTitle());
        inserting.setInt(2,film.getCost());
        inserting.setString(3,""+film.getType());
        inserting.executeUpdate();
        inserting.close();
    }
    public void delete(String title) throws SQLException,ClassNotFoundException {
        Class.forName(JDBC_DRIVER);
        Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
        //Statement deleting = conn.createStatement();
        PreparedStatement deleting = conn.prepareStatement("DELETE FROM films WHERE title=(?)");
        deleting.setString(1,title);
        /*String sqlDeleteStatement =
                "DELETE FROM films WHERE title='"+title+"'";*/
        deleting.executeUpdate();
        deleting.close();
    }
}
