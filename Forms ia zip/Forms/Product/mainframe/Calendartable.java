package mainframe;
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Calendartable extends JPanel{
    private JTable Caltable;
    public JTable getCaltable() {
        return Caltable;
    }

    public Calendartable() {
        initialize();
        fetchDataFromDatabase();
    }

    private void initialize() {

        setLayout(new BorderLayout());
        // Create columns and empty data model
        String[] columns = {"Meeting_num, Meeting_date, Meeting_plan"}; // Replace with your column names
        Object[][] data = {}; // fill in with data from database

        DefaultTableModel model = new DefaultTableModel(data, columns);
        Caltable = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(Caltable);

        add(scrollPane, BorderLayout.CENTER);
    }
    private void fetchDataFromDatabase() {
        try {
            // Connect to the database
            Connection connection = DriverManager.getConnection("jdbc:mysql://Laptop-4B044QS8:3306/students", "root", "Singh1038");
            // Create a statement
            Statement statement = connection.createStatement();
            // Execute a query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Calendar");
            // populate  table model
            DefaultTableModel model = (DefaultTableModel) Caltable.getModel();
            while (resultSet.next()) {
                String stuName = resultSet.getString("Stu_name");
                String stuGrade = resultSet.getString("Stu_grade");
                String stuClass = resultSet.getString("Stu_class");
                float stuAttendence = resultSet.getFloat("Stu_attendence");
                float stuGpa = resultSet.getFloat("Stu_gpa");
                int stuPSAT = resultSet.getInt("Stu_PSAT");
                int stuSAT = resultSet.getInt("Stu_SAT");

                model.addRow(new Object[]{stuName, stuGrade, stuClass, stuAttendence, stuGpa, stuPSAT, stuSAT});

                model.fireTableDataChanged();
            }

            // Close resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }}

