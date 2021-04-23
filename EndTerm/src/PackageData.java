import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

public class PackageData implements Serializable {
    private String operationType;
    private DeliverySchedule deliverySchedule;
    private ArrayList<DeliverySchedule> deliveryScheduleArrayList;
    private int id;
    private String category;
    private String text;
    private Date date;

    public PackageData(String operationType, DeliverySchedule deliverySchedule) {
        this.operationType = operationType;
        this.deliverySchedule = deliverySchedule;
    }

    public PackageData(String operationType) {
        this.operationType = operationType;
    }

    public PackageData(ArrayList<DeliverySchedule> deliveryScheduleArrayList) {
        this.deliveryScheduleArrayList = deliveryScheduleArrayList;
    }

    public PackageData(String operationType, int id, String category, String text) {
        this.operationType = operationType;
        this.id = id;
        this.category = category;
        this.text = text;
    }

    public PackageData(String operationType, int id) {
        this.operationType = operationType;
        this.id = id;
    }

    public PackageData(DeliverySchedule deliverySchedule, Date date) {
        this.deliverySchedule = deliverySchedule;
        this.date = date;
    }

    public PackageData(DeliverySchedule deliverySchedule) {
        this.deliverySchedule = deliverySchedule;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public DeliverySchedule getDeliverySchedule() {
        return deliverySchedule;
    }

    public void setDeliverySchedule(DeliverySchedule deliverySchedule) {
        this.deliverySchedule = deliverySchedule;
    }

    public ArrayList<DeliverySchedule> getDeliveryScheduleArrayList() {
        return deliveryScheduleArrayList;
    }

    public void setDeliveryScheduleArrayList(ArrayList<DeliverySchedule> deliveryScheduleArrayList) {
        this.deliveryScheduleArrayList = deliveryScheduleArrayList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
