import java.sql.*;
import java.util.ArrayList;

public class DBManager {
    private static Connection connection;
    private static String url = "jdbc:postgresql://localhost:5432/oop";
    private static String user="postgres";
    private static String password = "1234567";
    public static void connect(){
        try {
            Class.forName("org.postgresql.Driver");///////путь к драйверу
            connection = DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public void addDelivery(DeliverySchedule deliverySchedule) throws SQLException {
        String sql = "INSERT INTO delivery_sch(id, del_date, company_name, director_name, del_time, weight) " +
                "VALUES (default, ?, ?, ?, ?, ?);";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setDate(1, deliverySchedule.getDate());
        statement.setString(2, deliverySchedule.getCompanyName());
        statement.setString(3, deliverySchedule.getDirectorName());
        statement.setTime(4, deliverySchedule.getTime());
        statement.setInt(5, deliverySchedule.getWeight());

        statement.executeUpdate();
        statement.close();
    }

    public ArrayList<DeliverySchedule> listDeliveries() throws SQLException {
        ArrayList<DeliverySchedule> deliverySchedules = new ArrayList<>();
        String sql = "select*from delivery_sch";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            Integer id = resultSet.getInt("id");
            Date date = resultSet.getDate("del_date");
            String company = resultSet.getString("company_name");
            String director = resultSet.getString("director_name");
            Time time = resultSet.getTime("del_time");
            int weight = resultSet.getInt("weight");

            deliverySchedules.add(new DeliverySchedule(id, date, company, director, time, weight));
        }
        statement.close();
        return deliverySchedules;
    }

    public void updateDelivery(int id, String category, String text) throws SQLException {
        String sql = "";
        switch (category){
            case "Date":
                sql = "update delivery_sch set del_date = ? where id = ?";
                break;
            case "Company":
                sql = "update delivery_sch set company_name = ? where id = ?";
                break;
            case "Time":
                sql = "update delivery_sch set del_time = ? where id = ?";
                break;
            case "Director":
                sql = "update delivery_sch set director_name = ? where id = ?";
                break;
            case "Weight":
                sql = "update delivery_sch set weight = ? where id = ?";
                break;

        }
        PreparedStatement statement = connection.prepareStatement(sql);
        if (category.equals("Date")){
            statement.setDate(1, Date.valueOf(text));
        }
        else if(category.equals("Time")){
            statement.setTime(1, Time.valueOf(text));
        }
        else if(category.equals("Weight")){
            statement.setInt(1, Integer.parseInt(text));
        }
        else{
            statement.setString(1, text);
        }
        statement.setInt(2, id);
        statement.executeUpdate();
        statement.close();
    }

    public void deleteDelivery(int id) throws SQLException {
        String sql = "DELETE FROM delivery_sch " +
                "WHERE id = ?;";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate();
        statement.close();
        System.out.println(id);
    }

    public DeliverySchedule infoUser(int id) throws SQLException {
        String sql = "SELECT id, del_date, company_name, director_name, del_time, weight " +
                "FROM public.delivery_sch where id = ?;";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

            Integer id1 = resultSet.getInt("id");
            Date date = resultSet.getDate("del_date");
            String company = resultSet.getString("company_name");
            String director = resultSet.getString("director_name");
            Time time = resultSet.getTime("del_time");
            int weight = resultSet.getInt("weight");

            DeliverySchedule deliverySchedule = new DeliverySchedule(id1, date, company, director, time, weight);

            statement.close();
            return deliverySchedule;
    }
}
