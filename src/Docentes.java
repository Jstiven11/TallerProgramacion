/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Docentes extends JFrame {
    private JTextField txtCodigo, txtNombre;
    private JButton btnIngresar, btnLimpiar;
    private JTable tablaDocentes;
    private DefaultTableModel modelo;

    public Docentes() {
        setTitle("Registro de Docentes");
        setSize(500, 400);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        // Panel de entrada
        JPanel panelInput = new JPanel(new GridLayout(3, 2, 10, 10));
        txtCodigo = new JTextField();
        txtNombre = new JTextField();
        btnIngresar = new JButton("Ingresar");
        btnLimpiar = new JButton("Limpiar");

        panelInput.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelInput.add(new JLabel("Código:"));
        panelInput.add(txtCodigo);
        panelInput.add(new JLabel("Nombre:"));
        panelInput.add(txtNombre);
        panelInput.add(btnIngresar);
        panelInput.add(btnLimpiar);

        // Tabla
        modelo = new DefaultTableModel(new String[]{"Código", "Nombre"}, 0);
        tablaDocentes = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tablaDocentes);

        // Agregar componentes
        add(panelInput, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        // Eventos
        btnIngresar.addActionListener(e -> insertarDocente());
        btnLimpiar.addActionListener(e -> limpiarCampos());

        cargarDocentes();
    }

    private void insertarDocente() {
        int codigo = Integer.parseInt(txtCodigo.getText());
        String nombre = txtNombre.getText();

        String sql = "INSERT INTO docentes (cod_docente, nom_docente) VALUES (?, ?)";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, codigo);
            stmt.setString(2, nombre);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Docente ingresado con éxito.");
            cargarDocentes();
            limpiarCampos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al insertar docente: " + ex.getMessage());
        }
    }

    private void cargarDocentes() {
        modelo.setRowCount(0); // limpiar tabla

        String sql = "SELECT * FROM docentes";
        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int cod = rs.getInt("cod_docente");
                String nom = rs.getString("nom_docente");
                modelo.addRow(new Object[]{cod, nom});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar docentes: " + ex.getMessage());
        }
    }

    private void limpiarCampos() {
        txtCodigo.setText("");
        txtNombre.setText("");
    }
}
