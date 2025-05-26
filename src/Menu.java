/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ASUS
 */
import javax.swing.*;
import java.awt.event.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Menu extends JFrame {

    public Menu() {
    setTitle("Sistema de Información Académica");
    setSize(500, 400);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    // Crear la barra de menú
    JMenuBar menuBar = new JMenuBar();

    JMenu menuIngresar = new JMenu("Ingresar");
    JMenuItem menuEstudiantes = new JMenuItem("Estudiantes");
    JMenuItem menuDocentes = new JMenuItem("Docentes");
    JMenuItem menuCursos = new JMenuItem("Cursos");

    JMenu menuMatricula = new JMenu("Matrícula");
    JMenuItem menuMatricular = new JMenuItem("Registrar Matrícula");

    JMenu menuNotas = new JMenu("Notas");
    JMenuItem menuNotasVista = new JMenuItem("Ver Notas");

    JMenu menuSalir = new JMenu("Salir");
    JMenuItem salirItem = new JMenuItem("Salir del sistema");

    // Añadir ítems a menús
    menuIngresar.add(menuEstudiantes);
    menuIngresar.add(menuDocentes);
    menuIngresar.add(menuCursos);
    menuMatricula.add(menuMatricular);
    menuNotas.add(menuNotasVista);
    menuSalir.add(salirItem);

    // Añadir menús a la barra
    menuBar.add(menuIngresar);
    menuBar.add(menuMatricula);
    menuBar.add(menuNotas);
    menuBar.add(menuSalir);
    setJMenuBar(menuBar);

    // Eventos de navegación
    menuEstudiantes.addActionListener(e -> {
        Estudiante f = new Estudiante();
        f.setVisible(true);
    });

    menuDocentes.addActionListener(e -> {
        Docentes f = new Docentes();
        f.setVisible(true);
    });

    menuCursos.addActionListener(e -> {
        Cursos f = new Cursos();
        f.setVisible(true);
    });

    menuMatricular.addActionListener(e -> {
        Matricula f = new Matricula();
        f.setVisible(true);
    });

    menuNotasVista.addActionListener(e -> {
        Notas f = new Notas();
        f.setVisible(true);
    });

    salirItem.addActionListener(e -> System.exit(0));
}

public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> new Menu().setVisible(true));
}

}
