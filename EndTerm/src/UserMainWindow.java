import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserMainWindow extends Container {
    private JLabel idLabel;
    private JTextField idText;
    private JButton logInButton;

    public static int id;

    public UserMainWindow() {
        setSize(500, 450);
        setLayout(null);

        idLabel = new JLabel("Welcome, please, enter your id");
        idLabel.setBounds(90, 150, 300, 40);
        add(idLabel);

        idText = new JTextField();
        idText.setBounds(90, 200, 300, 40);
        add(idText);

        logInButton = new JButton("LOG IN");
        logInButton.setBounds(90, 250, 80, 40);
        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                id = Integer.parseInt(idText.getText());
                User.frameUser.userAccountWindow.setVisible(true);
                User.frameUser.userMainWindow.setVisible(false);
            }
        });
        add(logInButton);
    }
}
