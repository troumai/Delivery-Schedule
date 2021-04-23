import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

public class DeliverySchedule implements Serializable {
    private Integer id;
    private Date date;
    private String companyName;
    private String directorName;
    private Time time;
    private int weight;

    public DeliverySchedule(Integer id, Date date, String companyName, String directorName, Time time, int weight) {
        this.id = id;
        this.date = date;
        this.companyName = companyName;
        this.directorName = directorName;
        this.time = time;
        this.weight = weight;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return id+" "+date+" "+time+" "+companyName+" "+directorName+" "+weight;
    }
}
