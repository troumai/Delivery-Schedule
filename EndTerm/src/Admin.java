import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Admin {
    public static MainFrameAdmin frameAdmin;
    public static void connect(PackageData pd){
        try {
            Socket socket = new Socket("127.0.0.1", 2222);

            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            if(pd.getOperationType().equals("ADD")){
                outputStream.writeObject(pd);
            }
            else if(pd.getOperationType().equals("LIST")){
                outputStream.writeObject(pd);
                PackageData infoFromServer = (PackageData)inputStream.readObject();
                ArrayList<DeliverySchedule> listFromServer = infoFromServer.getDeliveryScheduleArrayList();
                String s ="";
                for(int i=0;i<listFromServer.size();i++){
                    s+=listFromServer.get(i)+"\n";
                }
                DeleteDelivery.text.append(s);
                UpdateDelivery.text.append(s);
            }
            else if(pd.getOperationType().equals("UNLOADING TIME LIST")){
                outputStream.writeObject(pd);
                PackageData infoFromServer = (PackageData)inputStream.readObject();
                ArrayList<DeliverySchedule> listFromServer = infoFromServer.getDeliveryScheduleArrayList();
                String s ="";
                for(int i=0;i<listFromServer.size();i++){
                    int minutes = listFromServer.get(i).getWeight()/100*20;
                    LocalTime time = listFromServer.get(i).getTime().toLocalTime().plusMinutes(minutes);
                    s+=listFromServer.get(i)+" unloading time: "+time+"\n";
                }
                ListDelivery.text.append(s);
            }
            else if(pd.getOperationType().equals("TOMORROW DELIVERY LIST")){
                outputStream.writeObject(pd);
                PackageData infoFromServer = (PackageData)inputStream.readObject();
                ArrayList<DeliverySchedule> listFromServer = infoFromServer.getDeliveryScheduleArrayList();
                String s = "";
                for(int i=0;i<listFromServer.size();i++){
                    LocalDate localDate = LocalDate.now().plusDays(1);
                    LocalDate date1 = listFromServer.get(i).getDate().toLocalDate();
                    LocalTime time1 = listFromServer.get(i).getTime().toLocalTime();
                    LocalTime time2 = LocalTime.of(12, 00);
                    if(date1.equals(localDate) && time1.isBefore(time2)){
                        s+=listFromServer.get(i)+"\n";
                    }
                }
                ListDelivery.text.append(s);
            }
            else if(pd.getOperationType().equals("UPDATE")){
                outputStream.writeObject(pd);
                PackageData infoFromServer = (PackageData)inputStream.readObject();
                ArrayList<DeliverySchedule> listFromServer = infoFromServer.getDeliveryScheduleArrayList();
                String s ="";
                for(int i=0;i<listFromServer.size();i++){
                    s+=listFromServer.get(i)+"\n";
                }
                UpdateDelivery.text.append(s);
            }
            else if(pd.getOperationType().equals("DELETE")){
                outputStream.writeObject(pd);
            }
            else if(pd.getOperationType().equals("MY INFO")){
                outputStream.writeObject(pd);
                PackageData infoFromServer = (PackageData)inputStream.readObject();
                ArrayList<DeliverySchedule> listFromServer = infoFromServer.getDeliveryScheduleArrayList();
                String s ="";
                for(int i=0;i<listFromServer.size();i++){
                    if(listFromServer.get(i).getId()==UserMainWindow.id){
                        s+=listFromServer.get(i)+"\n";
                    }
                }
                UserAccount.text.append(s);
            }
            else if(pd.getOperationType().equals("LIST DELIVERIES")){
                outputStream.writeObject(pd);
                PackageData infoFromServer = (PackageData)inputStream.readObject();
                ArrayList<DeliverySchedule> listFromServer = infoFromServer.getDeliveryScheduleArrayList();
                String s ="";
                for(int i=0;i<listFromServer.size();i++){
                    s+=listFromServer.get(i).getDate()+" "
                            +listFromServer.get(i).getTime()+" "
                            +listFromServer.get(i).getCompanyName()+" "
                            +listFromServer.get(i).getWeight()+"\n";
                }
                UserAccount.text.append(s);

            }
            outputStream.close();
            inputStream.close();
            socket.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        frameAdmin = new MainFrameAdmin();
        frameAdmin.setVisible(true);
    }
}
