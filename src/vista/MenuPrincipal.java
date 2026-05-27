package vista;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MenuPrincipal extends JFrame {
    private JDesktopPane desktopPane;

    public MenuPrincipal() {
        setTitle("Sistema de Control de Farmacia");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        desktopPane = new JDesktopPane();
        setContentPane(desktopPane);

        JMenuBar menuBar = new JMenuBar();
        JMenu menuModulos = new JMenu("Módulos");
        JMenuItem itemMedicamentos = new JMenuItem("Gestionar Medicamentos");

        itemMedicamentos.addActionListener((ActionEvent e) -> {
            FormMedicamentoInternal ventana = new FormMedicamentoInternal();
            desktopPane.add(ventana);
            ventana.setVisible(true);
        });

        menuModulos.add(itemMedicamentos);
        menuBar.add(menuModulos);
        setJMenuBar(menuBar);
    }
}
