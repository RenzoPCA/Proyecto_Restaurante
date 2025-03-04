/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ingredientes;

/**
 *
 * @author Luis Alejandro Castro Contreras
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import Frames.VistaLogin;

public class GestorIngredientesUI {
    private GestorIngredientes gestor = new GestorIngredientes();
    private JFrame frame;
    private JTable table;
    private DefaultTableModel tableModel;
    private Timer eliminarTimer;
    private boolean esManteniendo = false;

    public GestorIngredientesUI() {
        frame = new JFrame("Gestor de Ingredientes");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());

        frame.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/logo_ingredientes.png")).getImage());

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                new VistaLogin().setVisible(true);
            }
        });

        tableModel = new DefaultTableModel(new String[]{"NOMBRE", "CANTIDAD"}, 0);
        table = new JTable(tableModel);
        table.setFont(new Font("SansSerif", Font.BOLD, 14));
        table.setRowHeight(25);
        JScrollPane scrollPane = new JScrollPane(table);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 4, 10, 10));
        panel.setBackground(new Color(30, 30, 30));

        JButton addButton = crearBoton("Añadir");
        JButton removeButton = crearBoton("Eliminar");
        JButton exportButton = crearBoton("Exportar");
        JButton importButton = crearBoton("Importar");

        addButton.addActionListener(e -> agregarIngrediente());
        exportButton.addActionListener(e -> exportarLista());
        importButton.addActionListener(e -> importarLista());

        removeButton.addMouseListener(new MouseAdapter() {
            private Timer timer;
            private boolean accionRapida = true;

            @Override
            public void mousePressed(MouseEvent e) {
                int selectedRow = table.getSelectedRow();
                accionRapida = true;

                timer = new Timer(selectedRow == -1 ? 5000 : 2000, event -> {
                    accionRapida = false;
                    if (selectedRow != -1) {
                        String nombre = (String) tableModel.getValueAt(selectedRow, 0);
                        gestor.eliminarIngrediente(nombre, Integer.MAX_VALUE);
                    } else {
                        gestor.eliminarTodosLosIngredientes();
                    }
                    actualizarTabla();
                });

                timer.setRepeats(false);
                timer.start();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (timer != null && timer.isRunning()) {
                    timer.stop();
                    if (accionRapida) {
                        int selectedRow = table.getSelectedRow();
                        if (selectedRow != -1) {
                            String nombre = (String) tableModel.getValueAt(selectedRow, 0);
                            try {
                                int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad a eliminar:"));
                                gestor.eliminarIngrediente(nombre, cantidad);
                                actualizarTabla();
                            } catch (NumberFormatException ignored) {
                                JOptionPane.showMessageDialog(frame, "Ingrese un número válido.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(frame, "Seleccione un ingrediente.");
                        }
                    }
                }
            }
        });

        panel.add(addButton);
        panel.add(removeButton);
        panel.add(exportButton);
        panel.add(importButton);

        JLabel titleLabel = new JLabel("Gestor de Ingredientes", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setOpaque(true);
        titleLabel.setBackground(new Color(50, 50, 50));

        frame.add(titleLabel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(panel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private JButton crearBoton(String texto) {
        JButton boton = new JButton(texto);
        boton.setFont(new Font("Arial", Font.BOLD, 14));
        boton.setBackground(new Color(70, 130, 180));
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
        return boton;
    }

    private void actualizarTabla() {
        tableModel.setRowCount(0);
        for (Ingrediente ing : gestor.getIngredientes()) {
            tableModel.addRow(new Object[]{ing.nombre, ing.cantidad});
        }
    }

    private void agregarIngrediente() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            String nombre = (String) tableModel.getValueAt(selectedRow, 0);
            try {
                int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad a añadir:"));
                gestor.agregarIngrediente(nombre, cantidad);
                actualizarTabla();
            } catch (NumberFormatException ignored) {
                JOptionPane.showMessageDialog(frame, "Ingrese un número válido.");
            }
        } else {
            String nombre = JOptionPane.showInputDialog("Ingrese nombre del ingrediente:");
            if (nombre != null && !nombre.trim().isEmpty()) {
                try {
                    int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad:"));
                    gestor.agregarIngrediente(nombre, cantidad);
                    actualizarTabla();
                } catch (NumberFormatException ignored) {
                    JOptionPane.showMessageDialog(frame, "Ingrese un número válido.");
                }
            }
        }
    }

    private void eliminarIngrediente() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            String nombre = (String) tableModel.getValueAt(selectedRow, 0);
            try {
                int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad a eliminar:"));
                gestor.eliminarIngrediente(nombre, cantidad);
                actualizarTabla();
            } catch (NumberFormatException ignored) {
                JOptionPane.showMessageDialog(frame, "Ingrese un número válido.");
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Seleccione un ingrediente.");
        }
    }

    private void exportarLista() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
            try {
                gestor.exportarLista(fileChooser.getSelectedFile());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Error al guardar.");
            }
        }
    }

    private void importarLista() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
            try {
                gestor.importarLista(fileChooser.getSelectedFile());
                actualizarTabla();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Error al cargar.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GestorIngredientesUI::new);
    }
}
