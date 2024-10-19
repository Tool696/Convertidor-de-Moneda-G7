import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class NumericTextField extends JTextField {
    public NumericTextField() {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                // Permitir solo números y el punto decimal
                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE && c != '.') {
                    e.consume(); // Ignorar el evento si no es válido
                }

                // Permitir solo un punto decimal
                if (c == '.' && getText().contains(".")) {
                    e.consume();
                }
            }
        });
    }
}
