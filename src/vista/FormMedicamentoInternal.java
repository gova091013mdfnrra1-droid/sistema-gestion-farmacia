package vista;

import dao.MedicamentoDAO;
import modelo.Medicamento;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class FormMedicamentoInternal extends JInternalFrame {
    private JTextField txtNombre, txtPrecio, txtStock;
    private JButton btnGuardar;
    private MedicamentoDAO medicamentoDAO;

    public FormMedicamentoInternal() {
        super("Registrar Medicamento", true, true, true, true);
        setSize(320, 240);
        setLayout(null);

        medicamentoDAO = new MedicamentoDAO();

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(20, 20, 80, 25);
        add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(110, 20, 160, 25);
        add(txtNombre);

        JLabel lblPrecio = new JLabel("Precio:");
        lblPrecio.setBounds(20, 60, 80, 25);
        add(lblPrecio);

        txtPrecio = new JTextField();
        txtPrecio.setBounds(110, 60, 160, 25);
        add(txtPrecio);

        JLabel lblStock = new JLabel("Stock:");
        lblStock.setBounds(20, 100, 80, 25);
        add(lblStock);

        txtStock = new JTextField();
        txtStock.setBounds(110, 100, 160, 25);
        add(txtStock);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(110, 150, 100, 30);
        add(btnGuardar);

        btnGuardar.addActionListener((ActionEvent e) -> {
            try {
                String nombre = txtNombre.getText();
                double precio = Double.parseDouble(txtPrecio.getText());
                int stock = Integer.parseInt(txtStock.getText());

                Medicamento med = new Medicamento(0, nombre, precio, stock);

                if (medicamentoDAO.insertar(med)) {
                    JOptionPane.showMessageDialog(this, "¡Medicamento registrado con éxito!");
                    txtNombre.setText("");
                    txtPrecio.setText("");
                    txtStock.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "Error al guardar en el sistema.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, ingresa valores numéricos válidos en Precio y Stock.");
            }
        });
    }
}
