import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListDelivery extends Container {
    public static JTextArea text;
    private JButton listUnloadingTime;
    private JButton listTomorrowDelivery;
    private JButton backButton;
    private JScrollPane scrollPane;

    public ListDelivery(){
        setSize(500, 450);
        setLayout(null);

        text = new JTextArea();
        text.setBounds(20, 20, 410, 280);
        add(text);

        scrollPane = new JScrollPane(text);
        scrollPane.setBounds(20,20, 410,280);
        add(scrollPane);

        listUnloadingTime = new JButton("UNLOADING TIME");
        listUnloadingTime.setBounds(75, 310, 160, 30);
        listUnloadingTime.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText("");
                PackageData pd = new PackageData("UNLOADING TIME LIST");
                Admin.connect(pd);
            }
        });
        add(listUnloadingTime);

        listTomorrowDelivery = new JButton("TOMORROW DELIVERY");
        listTomorrowDelivery.setBounds(245, 310, 160, 30);
        listTomorrowDelivery.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText("");
                PackageData pd = new PackageData("TOMORROW DELIVERY LIST");
                Admin.connect(pd);
            }
        });
        add(listTomorrowDelivery);


        backButton = new JButton("BACK");
        backButton.setBounds(150, 350, 160, 30);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText("");
                Admin.frameAdmin.listDeliveryWindow.setVisible(false);
                Admin.frameAdmin.adminMenu.setVisible(true);
            }
        });
        add(backButton);
    }
}
