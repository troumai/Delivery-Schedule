import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserAccount extends Container {
    public static JTextArea text;
    private JScrollPane scrollPane;
    private JButton userInfo;
    private JButton listDeliveries;
    private JButton backButton;

    public UserAccount(){
        setSize(500, 450);
        setLayout(null);

        text = new JTextArea();
        text.setBounds(90, 20, 300, 150);
        add(text);

        scrollPane = new JScrollPane(text);
        scrollPane.setBounds(90,20, 300,150);
        add(scrollPane);

        userInfo = new JButton("MY INFO");
        userInfo.setBounds(90, 200, 120, 30);
        userInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText("");
                PackageData pd = new PackageData("MY INFO", UserMainWindow.id);
                Admin.connect(pd);
            }
        });
        add(userInfo);

        listDeliveries = new JButton("LIST DELIVERIES");
        listDeliveries.setBounds(220, 200, 120, 30);
        listDeliveries.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText("");
                PackageData pd = new PackageData("LIST DELIVERIES", UserMainWindow.id);
                Admin.connect(pd);
            }
        });
        add(listDeliveries);

        backButton = new JButton("BACK");
        backButton.setBounds(180, 250, 80, 30);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User.frameUser.userAccountWindow.setVisible(false);
                User.frameUser.userMainWindow.setVisible(true);
            }
        });
        add(backButton);
    }
}
