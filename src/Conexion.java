/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ASUS
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/gestion_academica";
    private static final String USER = "root";
    private static final String PASSWORD = "root"; 

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ La conexion se establecio correctamente");
        } catch (ClassNotFoundException e) {
            System.err.println("❌ Error: Driver no encontrado");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("❌ Error de conexión a la base de datos");
            e.printStackTrace();
        }
        return conn;
    }
}