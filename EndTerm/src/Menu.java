import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends Container {
    private JButton addButton;
    private JButton listButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton exitButton;

    public Menu(){
        setSize(500, 450);
        setLayout(null);

        addButton = new JButton("ADD");
        addButton.setBounds(100, 80, 300, 30);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Admin.frameAdmin.addDeliveryWindow.setVisible(true);
                Admin.frameAdmin.adminMenu.setVisible(false);

            }
        });
        add(addButton);

        listButton = new JButton("LIST");
        listButton.setBounds(100, 120, 300, 30);
        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Admin.frameAdmin.listDeliveryWindow.setVisible(true);
                Admin.frameAdmin.adminMenu.setVisible(false);
            }
        });
        add(listButton);

        updateButton = new JButton("UPDATE");
        updateButton.setBounds(100, 160, 300, 30);
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateDelivery.text.setText("");
                Admin.frameAdmin.updateDeliveryWindow.setVisible(true);
                Admin.frameAdmin.adminMenu.setVisible(false);
                PackageData pd = new PackageData("LIST");
                Admin.connect(pd);
            }
        });
        add(updateButton);

        deleteButton = new JButton("DELETE");
        deleteButton.setBounds(100, 200, 300, 30);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Admin.frameAdmin.deleteDeliveryWindow.setVisible(true);
                Admin.frameAdmin.adminMenu.setVisible(false);
            }
        });
        add(deleteButton);

        exitButton = new JButton("EXIT");
        exitButton.setBounds(100, 240, 300, 30);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(exitButton);

    }
}
