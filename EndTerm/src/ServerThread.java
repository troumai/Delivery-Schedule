import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServerThread extends Thread{
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            DBManager manager = new DBManager();
            manager.connect();

            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            PackageData packageData = null;
            while((packageData = (PackageData)inputStream.readObject())!=null){
                if(packageData.getOperationType().equals("ADD")){
                    DeliverySchedule fromClient = packageData.getDeliverySchedule();
                    manager.addDelivery(fromClient);
                }
                else if(packageData.getOperationType().equals("LIST")){
                    ArrayList<DeliverySchedule> infoForClient = manager.listDeliveries();
                    PackageData toClient = new PackageData(infoForClient);
                    outputStream.writeObject(toClient);
                }
                else if(packageData.getOperationType().equals("UNLOADING TIME LIST")){
                    ArrayList<DeliverySchedule> infoForClient = manager.listDeliveries();
                    PackageData toClient = new PackageData(infoForClient);
                    outputStream.writeObject(toClient);
                }
                else if(packageData.getOperationType().equals("TOMORROW DELIVERY LIST")){
                    ArrayList<DeliverySchedule> infoForClient = manager.listDeliveries();
                    PackageData toClient = new PackageData(infoForClient);
                    outputStream.writeObject(toClient);
                }
                else if(packageData.getOperationType().equals("UPDATE")){
                    manager.updateDelivery(packageData.getId(), packageData.getCategory(), packageData.getText());
                    ArrayList<DeliverySchedule> infoForClient = manager.listDeliveries();
                    PackageData toClient = new PackageData(infoForClient);
                    outputStream.writeObject(toClient);
                }
                else if(packageData.getOperationType().equals("DELETE")){
                    manager.deleteDelivery(packageData.getId());
                }
                else if(packageData.getOperationType().equals("MY INFO")){
                    ArrayList<DeliverySchedule> infoForClient = manager.listDeliveries();
                    PackageData toClient = new PackageData(infoForClient);
                    outputStream.writeObject(toClient);
                }
                else if(packageData.getOperationType().equals("LIST DELIVERIES")){
                    ArrayList<DeliverySchedule> infoForClient = manager.listDeliveries();
                    PackageData toClient = new PackageData(infoForClient);
                    outputStream.writeObject(toClient);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
