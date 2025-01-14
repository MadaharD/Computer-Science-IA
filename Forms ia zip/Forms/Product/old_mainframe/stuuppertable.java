package mainframe;
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class stuuppertable extends JPanel{
    private JTable uppertable;
    public JTable getUppertable() {
        return uppertable;
    }

    public stuuppertable() {
        initialize();
        fetchDataFromDatabase();
    }

    private void initialize() {

        setLayout(new BorderLayout());
        // Create columns and empty data model
        String[] columns = {"Stu_name","Stu_grade","Stu_class","Stu_attendence","Stu_gpa","Stu_PSAT","Stu_SAT"}; // Replace with your column names
        Object[][] data = {}; // fill in with data from database

        DefaultTableModel model = new DefaultTableModel(data, columns);
        uppertable = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(uppertable);

        add(scrollPane, BorderLayout.CENTER);
    }
    private void fetchDataFromDatabase() {
        try {
            // Connect to the database
            Connection connection = DriverManager.getConnection("jdbc:mysql://Laptop-4B044QS8:3306/students", "root", "Singh1038");
            // Create a statement
            Statement statement = connection.createStatement();
            // Execute a query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM stuinfoup");
            // populate  table model
            DefaultTableModel model = (DefaultTableModel) uppertable.getModel();
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

    