import javax.swing.*;

public class MainFrameAdmin extends JFrame {
    public static Menu adminMenu;
    public static AddDelivery addDeliveryWindow;
    public static ListDelivery listDeliveryWindow;
    public static UpdateDelivery updateDeliveryWindow;
    public static DeleteDelivery deleteDeliveryWindow;

    public MainFrameAdmin(){
        setSize(500, 450);
        setTitle("DELIVERY APPLICATION FOR ADMIN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        adminMenu = new Menu();
        setLocation(0, 0);
        add(adminMenu);

        addDeliveryWindow = new AddDelivery();
        setLocation(0, 0);
        addDeliveryWindow.setVisible(false);
        add(addDeliveryWindow);

        listDeliveryWindow = new ListDelivery();
        setLocation(0, 0);
        listDeliveryWindow.setVisible(false);
        add(listDeliveryWindow);

        updateDeliveryWindow = new UpdateDelivery();
        setLocation(0, 0);
        updateDeliveryWindow.setVisible(false);
        add(updateDeliveryWindow);

        deleteDeliveryWindow = new DeleteDelivery();
        setLocation(0, 0);
        deleteDeliveryWindow.setVisible(false);
        add(deleteDeliveryWindow);
    }
}
