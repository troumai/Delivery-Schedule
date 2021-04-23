import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteDelivery extends Container {
    public static JTextArea text;
    private JScrollPane scrollPane;
    private JLabel id;

    private JTextField idText;

    private JButton deleteButton;
    private JButton showButton;
    private JButton backButton;

    public DeleteDelivery(){
        setSize(500, 450);
        setLayout(null);

        text = new JTextArea();
        text.setBounds(90, 50, 300, 150);
        add(text);

        scrollPane = new JScrollPane(text);
        scrollPane.setBounds(90,50, 300,150);
        add(scrollPane);

        id = new JLabel("Enter id");
        id.setBounds(90, 210, 80, 30);
        add(id);

        idText = new JTextField();
        idText.setBounds(170, 210, 150, 30);
        add(idText);

        showButton = new JButton("SHOW");
        showButton.setBounds(90,250, 90, 30);
        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText("");
                PackageData pd = new PackageData("LIST");
                Admin.connect(pd);
            }
        });
        add(showButton);

        deleteButton = new JButton("DELETE");
        deleteButton.setBounds(200, 250, 90, 30);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idText.getText());
                PackageData pd = new PackageData("DELETE", id);
                Admin.connect(pd);
                idText.setText("");
                text.setText("");
            }
        });
        add(deleteButton);

        backButton = new JButton("BACK");
        backButton.setBounds(300, 250, 90, 30);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText("");
                Admin.frameAdmin.deleteDeliveryWindow.setVisible(false);
                Admin.frameAdmin.adminMenu.setVisible(true);
            }
        });
        add(backButton);
    }
}
