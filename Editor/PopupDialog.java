package Editor;

import javax.swing.*;

public class PopupDialog extends JDialog {
    private JTextField nameField;
    private boolean confirm;

    public PopupDialog(JFrame mainFrame) {
        super(mainFrame, "", true);
        // Set panel
        JPanel panel = new JPanel();
        nameField = new JTextField();
        panel.add(nameField);
        
        // Set button
        JButton confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(e -> {
            confirm = true;
            setVisible(false);
        });

        JButton cancelButton = new JButton("Cancel");
        confirmButton.addActionListener(e -> {
            confirm = false;
            setVisible(false);
        });

        panel.add(confirmButton);
        panel.add(cancelButton);

        getContentPane().add(panel);
        pack();
        setLocationRelativeTo(mainFrame);
    }

    public String getName() {
        return nameField.getText();
    }

    public Boolean isConfirm() {
        return confirm;
    }
}
