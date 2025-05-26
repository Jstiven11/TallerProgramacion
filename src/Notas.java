/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ASUS
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class Notas extends JFrame {
    private JTable tablaNotas;
    private DefaultTableModel modelo;

    public Notas() {
        setTitle("Vista de Notas Detallada");
        setSize(700, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        modelo = new DefaultTableModel(new String[]{
                "Estudiante", "Curso", "Docente", "Nota"
        }, 0);

        tablaNotas = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tablaNotas);

        add(scroll, BorderLayout.CENTER);

        cargarNotas();
    }

    private void cargarNotas() {
        modelo.setRowCount(0);
        String sql = "SELECT * FROM vista_notas_detalle_simple";

        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String estudiante = rs.getString("nombre_estudiante");
                String curso = rs.getString("nombre_curso");
                String docente = rs.getString("nombre_docente_curso");
                float nota = rs.getFloat("nota_curso");
                modelo.addRow(new Object[]{estudiante, curso, docente, nota});
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar vista: " + ex.getMessage());
        }
    }
}

