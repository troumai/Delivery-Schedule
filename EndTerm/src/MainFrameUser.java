import javax.swing.*;

public class MainFrameUser extends JFrame {
    public static UserAccount userAccountWindow;
    public static UserMainWindow userMainWindow;
    public MainFrameUser(){
        setSize(500, 450);
        setTitle("DELIVERY APPLICATION FOR USER");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        userMainWindow = new UserMainWindow();
        setLocation(0, 0);
        add(userMainWindow);

        userAccountWindow = new UserAccount();
        setLocation(0, 0);
        userAccountWindow.setVisible(false);
        add(userAccountWindow);
    }
}
