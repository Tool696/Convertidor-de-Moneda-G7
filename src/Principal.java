import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Principal {
    public static void main(String[] args) {
        ConvertirMonedas monedas = new ConvertirMonedas();
        String[] opcionesMoneda = {"COP", "MXN", "ARS", "USD", "EUR", "RUB"}; // Códigos ISO o Monedas

        String monedaOrigen = (String) JOptionPane.showInputDialog(null,
                "Seleccione la moneda de origen", "Moneda de Origen",
                JOptionPane.QUESTION_MESSAGE, null, opcionesMoneda, opcionesMoneda[0]);

        if (monedaOrigen != null) {
            String input = mostrarInputDialogNumerico("Ingrese un valor en " + monedaOrigen + " a convertir");

            if (input != null && !input.isEmpty()) {
                try {
                    double valorRecibido = Double.parseDouble(input);
                    String monedaDestino = (String) JOptionPane.showInputDialog(null,
                            "Seleccione la moneda de destino", "Moneda de Destino",
                            JOptionPane.QUESTION_MESSAGE, null, opcionesMoneda, opcionesMoneda[0]);

                    if (monedaDestino != null) {
                        monedas.convertir(valorRecibido, monedaOrigen, monedaDestino);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se seleccionó ninguna moneda de destino.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Error: El valor ingresado no es un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se ingresó ningún valor.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se seleccionó ninguna moneda.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static String mostrarInputDialogNumerico(String mensaje) {
        JTextField textField = new JTextField();
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                // Permitir solo dígitos y el punto
                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE && c != '.') {
                    e.consume(); // Ignorar el evento de la tecla
                }
            }
        });

        Object[] inputFields = {mensaje, textField};
        int option = JOptionPane.showConfirmDialog(null, inputFields, "Entrada numérica", JOptionPane.OK_CANCEL_OPTION);
        return option == JOptionPane.OK_OPTION ? textField.getText() : null;
    }
}
