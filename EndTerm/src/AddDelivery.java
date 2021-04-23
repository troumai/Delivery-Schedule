import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class AddDelivery extends Container {
    private JLabel dateLabel;
    private JLabel companyLabel;
    private JLabel directorNameLabel;
    private JLabel timeLabel;
    private JLabel weightLabel;
    private JLabel dotLabel;
    private JLabel monthLabel;
    private JLabel yearLabel;
    private JLabel dayLabel;

    private JTextField dayText;
    private JTextField monthText;
    private JTextField yearText;
    private JTextField companyText;
    private JTextField directorNameText;
    private JTextField hourText;
    private JTextField minuteText;
    private JTextField weightText;

    private JButton addButton;
    private JButton backButton;

    public AddDelivery(){
        setSize(500, 450);
        setLayout(null);

        //date
        dateLabel = new JLabel("DATE: ");
        dateLabel.setBounds(50, 80, 60, 30);
        add(dateLabel);

        dayText = new JTextField();
        dayText.setBounds(130, 80, 60, 30);
        add(dayText);

        monthText = new JTextField();
        monthText.setBounds(200, 80, 60, 30);
        add(monthText);

        yearText = new JTextField();
        yearText.setBounds(270, 80, 60, 30);
        add(yearText);

        companyLabel = new JLabel("COMPANY");
        companyLabel.setBounds(50, 120, 80, 30);
        add(companyLabel);

        companyText = new JTextField();
        companyText.setBounds(130, 120, 200, 30);
        add(companyText);

        directorNameLabel = new JLabel("DIRECTOR");
        directorNameLabel.setBounds(50, 160, 80, 30);
        add(directorNameLabel);

        directorNameText = new JTextField();
        directorNameText.setBounds(130, 160, 200, 30);
        add(directorNameText);

        timeLabel = new JLabel("TIME");
        timeLabel.setBounds(50, 200, 80, 30);
        add(timeLabel);

        hourText = new JTextField();
        hourText.setBounds(130, 200, 50, 30);
        add(hourText);

        dotLabel = new JLabel(":");
        dotLabel.setBounds(190, 200,10, 30);
        add(dotLabel);

        minuteText = new JTextField();
        minuteText.setBounds(200, 200, 50, 30);
        add(minuteText);

        weightLabel = new JLabel("WEIGHT");
        weightLabel.setBounds(50, 240, 80, 30);
        add(weightLabel);

        weightText = new JTextField();
        weightText.setBounds(130, 240, 200, 30);
        add(weightText);

        addButton = new JButton("ADD");
        addButton.setBounds(90, 310, 230, 30);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int day = Integer.parseInt(dayText.getText());
                int month = Integer.parseInt(monthText.getText());
                int year = Integer.parseInt(yearText.getText());
                String company = companyText.getText();
                String director = directorNameText.getText();
                int hour = Integer.parseInt(hourText.getText());
                int minute = Integer.parseInt(minuteText.getText());
                int weight = Integer.parseInt(weightText.getText());

                LocalDate ldate = LocalDate.of(year, month, day);
                LocalTime ltime = LocalTime.of(hour, minute);

                Date date = Date.valueOf(ldate);
                Time time = Time.valueOf(ltime);

                DeliverySchedule deliverySchedule = new DeliverySchedule(null, date, company, director, time, weight);
                PackageData pd = new PackageData("ADD", deliverySchedule);

                Admin.connect(pd);

                dayText.setText("");
                monthText.setText("");
                yearText.setText("");
                companyText.setText("");
                directorNameText.setText("");
                hourText.setText("");
                minuteText.setText("");
                minuteText.setText("");
                weightText.setText("");
            }
        });
        add(addButton);

        //backButt
        backButton = new JButton("BACK");
        backButton.setBounds(90, 350, 230, 30);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Admin.frameAdmin.addDeliveryWindow.setVisible(false);
                Admin.frameAdmin.adminMenu.setVisible(true);
            }
        });
        add(backButton);
    }
}
