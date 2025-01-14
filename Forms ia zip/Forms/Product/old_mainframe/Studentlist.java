package mainframe;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class Studentlist extends Jframecreate implements ActionListener{
    JButton button;
    JButton upperbut;
    JButton underbut;
    JButton deletebut;
    JButton editbut;
    JPanel createupper;
    JPanel createunder;
    JButton addstuup;
    JTextField studentNameText1;
    JComboBox<String> optionsDropdownup;
    JComboBox<String> mathDropdownup;
    JTextField Attendencetxtup;
    JTextField GPAuptxt;
    JTextField PSATtxt;
    JTextField SATtxt;
    JButton deletebut2;
    JButton editbut2;
    JButton addstuun;

    stuuppertable uppermember;
    public Studentlist(){
        initialize();
        initializelist();
    } 

    public void initializelist(){


        JPanel chartpanel = new JPanel();
        chartpanel.setLayout(null);
        chartpanel.setPreferredSize(new Dimension(450,415));
        chartpanel.setBackground(Color.RED);
        chartpanel.setBounds(300,0,485,415);
        this.add(chartpanel);

        JPanel bottompanel = new JPanel();
        bottompanel.setLayout((LayoutManager) new FlowLayout(FlowLayout.LEFT, 10, 5));
        bottompanel.setPreferredSize(new Dimension(800,50));
        bottompanel.setBackground(Color.BLACK);
        bottompanel.setBounds(0,415,800,50);
        this.add(bottompanel, BorderLayout.SOUTH);

        JPanel choosepanel = new JPanel();
        choosepanel.setLayout((LayoutManager) new FlowLayout(FlowLayout.LEFT, 20, 5));
        choosepanel.setPreferredSize(new Dimension(800,50));
        choosepanel.setBackground(Color.BLUE);
        choosepanel.setBounds(0,380,400,50);
        this.add(choosepanel);

        createunder = new JPanel();
        createunder.setLayout(null);
        createunder.setPreferredSize(new Dimension(800,50));
        createunder.setBackground(Color.GREEN);
        createunder.setBounds(0,0,400,380);
        this.add(createunder,BorderLayout.WEST);
        createunder.setVisible(true);


        createupper = new JPanel();
        createupper.setLayout(null);
        createupper.setPreferredSize(new Dimension(800,50));
        createupper.setBackground(Color.ORANGE);
        createupper.setBounds(0,0,400,380);
        this.add(createupper,BorderLayout.WEST);
        createupper.setVisible(false);



// create underclassman and upperclassman labels


        JLabel addupper = new JLabel();
        addupper.setText("Add, edit, or delete an upperclassman");
        addupper.setBounds(30,0,250,20);
        createupper.add(addupper);
        JLabel addupper2 = new JLabel();
        addupper2.setText("When listing PSAT scores, seperate with commas!");
        addupper2.setBounds(0,15,300,20);
        createupper.add(addupper2);

        JLabel addunder = new JLabel();
        addunder.setText("Add, edit, or delete an underclassman");
        addunder.setBounds(30,0,250,20);
        createunder.add(addunder);


        JLabel studentName= new JLabel();
        studentName.setText("Student Name");
        studentName.setBounds(0,50,120,20);
        createupper.add(studentName);

        JLabel studentName2 = new JLabel();
        studentName2.setText("Student Name");
        studentName2.setBounds(0,50,120,20);
        createunder.add(studentName2);

        JLabel uppergrades = new JLabel();
        uppergrades.setText("Student Grade");
        uppergrades.setBounds(0,80,120,20);
        createupper.add(uppergrades);
          
        JLabel lowergrades = new JLabel();
        lowergrades.setText("Student Grade");
        lowergrades.setBounds(0,100,120,20);
        createunder.add(lowergrades);

        optionsDropdownup = new JComboBox<>(new String[]{"11th grade", "12th grade"});
        optionsDropdownup.setBounds(85,75,150,30);
        createupper.add(optionsDropdownup);

        JComboBox<String> optionsDropdownun = new JComboBox<>(new String[]{"9th grade", "10th grade"});
        optionsDropdownun.setBounds(85,95,150,30);
        createunder.add(optionsDropdownun);

       studentNameText1 = new JTextField(20); 
       studentNameText1.setBounds(85,50,150,20);
       createupper.add(studentNameText1); 

       JTextField studentNameText2 = new JTextField(20); 
       studentNameText2.setBounds(85,50,150,20); 
       createunder.add(studentNameText2); 

       Attendencetxtup = new JTextField(20); 
       Attendencetxtup.setBounds(112,145,150,20);
       createupper.add(Attendencetxtup); 

       JTextField Attendencetxtun = new JTextField(20); 
       Attendencetxtun.setBounds(112,200,150,20); 
       createunder.add(Attendencetxtun); 


       GPAuptxt = new JTextField(20); 
       GPAuptxt.setBounds(85,175,150,20);
       createupper.add(GPAuptxt); 

       JTextField GPAuntxt = new JTextField(20); 
       GPAuntxt.setBounds(85,250,150,20); 
       createunder.add(GPAuntxt); 

       PSATtxt = new JTextField(20); 
       PSATtxt.setBounds(125,205,150,20);
       createupper.add(PSATtxt); 

       SATtxt = new JTextField(20); 
       SATtxt.setBounds(115,235,150,20); 
       createupper.add(SATtxt); 


       addstuup = new JButton();
       addstuup.setBounds(10,290,80,40);
       addstuup.setText("Add");
       addstuup.setFocusable(false);
       addstuup.addActionListener(this);
       createupper.add(addstuup);


        JLabel mathclass= new JLabel();
        mathclass.setText("Math class");
        mathclass.setBounds(0,115,120,20);
        createupper.add(mathclass);

        JLabel mathclass2 = new JLabel();
        mathclass2.setText("Math class");
        mathclass2.setBounds(0,150,120,20);
        createunder.add(mathclass2);


       JComboBox<String> mathDropdownun = new JComboBox<>(new String[]{"Algebra 1", "Geometry", "Algebra 2", "AP Statistics"});
       mathDropdownun.setBounds(85,145,150,30);
       createunder.add(mathDropdownun);


       mathDropdownup = new JComboBox<>(new String[]{"Algebra 2", "AP Statistics", "AP Calculus AB", "AP Calculus BC", "IB Analysis SL","IB Analysis HL"});
       mathDropdownup.setBounds(85,110,150,30);
       createupper.add(mathDropdownup);





       JLabel lengthup = new JLabel();
        lengthup.setText("Attendence record");
        lengthup.setBounds(0,145,120,20);
        createupper.add(lengthup);

        JLabel lengthun = new JLabel();
        lengthun.setText("Attendence record");
        lengthun.setBounds(0,200,120,20);
        createunder.add(lengthun);

        JLabel GPA = new JLabel();
        GPA.setText("Student GPA");
        GPA.setBounds(0,175,120,20);
        createupper.add(GPA);

        JLabel GPA2 = new JLabel();
        GPA2.setText("Student GPA");
        GPA2.setBounds(0,250,120,20);
        createunder.add(GPA2);


        JLabel PSAT = new JLabel();
        PSAT.setText("Student PSAT scores");
        PSAT.setBounds(0,205,140,20);
        createupper.add(PSAT);

        JLabel SAT = new JLabel();
        SAT.setText("Highest SAT score");
        SAT.setBounds(0,235,120,20);
        createupper.add(SAT);


        upperbut = new JButton();
        bottompanel.setPreferredSize(new Dimension(100,50));
        upperbut.setText("Upperclassman");
        upperbut.setFocusable(true);
        upperbut.addActionListener(this);
        choosepanel.add(upperbut);

        underbut = new JButton();
        bottompanel.setPreferredSize(new Dimension(100,50));
        underbut.setText("Underclassman");
        underbut.setFocusable(true);
        underbut.addActionListener(this);
        choosepanel.add(underbut);


        button = new JButton();
        button.setBounds(0,0,100,50);
        button.setText("Back to homepage");
        button.setFocusable(false);
        button.addActionListener(this);
        bottompanel.add(button);

        deletebut = new JButton();
        deletebut.setBounds(200,290,80,40);
        deletebut.setText("Delete");
        deletebut.setFocusable(false);
        deletebut.addActionListener(this);
        createupper.add(deletebut);

        editbut = new JButton();
        editbut.setBounds(100,290,80,40);
        editbut.setText("Edit");
        editbut.setFocusable(false);
        editbut.addActionListener(this);
        createupper.add(editbut);


        addstuun = new JButton();
        addstuun.setBounds(10,290,80,40);
        addstuun.setText("Add");
        addstuun.setFocusable(false);
        addstuun.addActionListener(this);
        createunder.add(addstuun);

        deletebut2 = new JButton();
        deletebut2.setBounds(200,290,80,40);
        deletebut2.setText("Delete");
        deletebut2.setFocusable(false);
        deletebut2.addActionListener(this);
        createunder.add(deletebut2);

        editbut2 = new JButton();
        editbut2.setBounds(100,290,80,40);
        editbut2.setText("Edit");
        editbut2.setFocusable(false);
        editbut2.addActionListener(this);
        createunder.add(editbut2);


        uppermember = new stuuppertable();
        chartpanel.add(uppermember);  // Add the instance to the frame
        uppermember.setBounds(0,0,500,500);
        ListSelectionListener Listenerforuppermember = new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (!e.getValueIsAdjusting()) {
                Tableselection();
        }}
    };
    uppermember.getUppertable().getSelectionModel().addListSelectionListener(Listenerforuppermember);
    }

        public void Tableselection() {
        int selectedRowIndex = uppermember.getUppertable().getSelectedRow();
        if (selectedRowIndex != -1) {
            DefaultTableModel model = (DefaultTableModel) uppermember.getUppertable().getModel();

            
            String Stu_name = model.getValueAt(selectedRowIndex, 0).toString();
            String Stu_grade = model.getValueAt(selectedRowIndex, 1).toString();
            String Stu_class = model.getValueAt(selectedRowIndex, 2).toString();
            float Stu_attendence = Float.parseFloat(model.getValueAt(selectedRowIndex, 3).toString());
            float Stu_gpa = Float.parseFloat(model.getValueAt(selectedRowIndex, 4).toString());
            int Stu_PSAT = Integer.parseInt(model.getValueAt(selectedRowIndex, 5).toString());
            int Stu_SAT = Integer.parseInt(model.getValueAt(selectedRowIndex, 6).toString());

            studentNameText1.setText(Stu_name);
            optionsDropdownup.setSelectedItem(Stu_grade);
            mathDropdownup.setSelectedItem(Stu_class);
            Attendencetxtup.setText(String.valueOf(Stu_attendence));
            GPAuptxt.setText(String.valueOf(Stu_gpa));
            PSATtxt.setText(String.valueOf(Stu_PSAT));
            SATtxt.setText(String.valueOf(Stu_SAT));
        }
    }



      
        private void Additemsupper() {
            try {
                // Retrieve values from text fields and combo boxes
                String Stu_name = studentNameText1.getText();
                String Stu_grade = optionsDropdownup.getSelectedItem().toString();
                String Stu_class = mathDropdownup.getSelectedItem().toString();
                float Stu_attendence = Float.parseFloat(Attendencetxtup.getText()); 
                float Stu_gpa = Float.parseFloat(GPAuptxt.getText()); 
                int Stu_PSAT = Integer.parseInt(PSATtxt.getText()); 
                int Stu_SAT = Integer.parseInt(SATtxt.getText()); 
                // Connect to the database
                Connection connection = DriverManager.getConnection("jdbc:mysql://Laptop-4B044QS8:3306/students", "root", "Singh1038");
                // Prepare and execute the SQL INSERT statement
                String stuentryup = "INSERT INTO stuinfoup (Stu_name, Stu_grade, Stu_class, Stu_attendence, Stu_gpa, Stu_PSAT, Stu_SAT) VALUES (?,?,?,?,?,?,?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(stuentryup)) {
                    preparedStatement.setString(1, Stu_name);
                    preparedStatement.setString(2, Stu_grade);
                    preparedStatement.setString(3, Stu_class);
                    preparedStatement.setFloat(4, Stu_attendence);
                    preparedStatement.setFloat(5, Stu_gpa);
                    preparedStatement.setInt(6, Stu_PSAT);
                    preparedStatement.setInt(7, Stu_SAT);

                    // Execute the INSERT statement
                    preparedStatement.executeUpdate();


                    DefaultTableModel model = (DefaultTableModel) uppermember.getUppertable().getModel();
                    model.addRow(new Object[]{Stu_name, Stu_grade, Stu_class, Stu_attendence, Stu_gpa, Stu_PSAT, Stu_SAT});

                    model.fireTableDataChanged();
    
                 
                    // Close the connection
                    preparedStatement.close();
                }
    
                connection.close();


            } catch (NumberFormatException ex) {
                ex.printStackTrace(); //
            } catch (SQLException ex) {
                ex.printStackTrace(); }
                
            }
           
            

                private void EditItem(){
                int selectedRowIndex = uppermember.getUppertable().getSelectedRow();
                {
                if (selectedRowIndex != -1) {
                DefaultTableModel model = (DefaultTableModel) uppermember.getUppertable().getModel();
                String oldStu_name = uppermember.getUppertable().getValueAt(selectedRowIndex, 0).toString();
                //String oldStu_name = obStu_name.toString();
                String Stu_name = studentNameText1.getText();
                String Stu_grade = optionsDropdownup.getSelectedItem().toString();
                String Stu_class = mathDropdownup.getSelectedItem().toString();
                float Stu_attendence = Float.parseFloat(Attendencetxtup.getText()); 
                float Stu_gpa = Float.parseFloat(GPAuptxt.getText()); 
                int Stu_PSAT = Integer.parseInt(PSATtxt.getText()); 
                int Stu_SAT = Integer.parseInt(SATtxt.getText()); 

                uppermember.getUppertable().setValueAt(Stu_name, selectedRowIndex, 0);
                uppermember.getUppertable().setValueAt(Stu_grade, selectedRowIndex, 1);
                uppermember.getUppertable().setValueAt(Stu_class, selectedRowIndex, 2);
                uppermember.getUppertable().setValueAt(Stu_attendence, selectedRowIndex, 3);
                uppermember.getUppertable().setValueAt(Stu_gpa, selectedRowIndex, 4);
                uppermember.getUppertable().setValueAt(Stu_PSAT, selectedRowIndex, 5);
                uppermember.getUppertable().setValueAt(Stu_SAT, selectedRowIndex, 6);


                try {
                    // Connect to the database
                    Connection connection = DriverManager.getConnection("jdbc:mysql://Laptop-4B044QS8:3306/students", "root", "Singh1038");
            
                    // Prepare and execute the SQL UPDATE statement
                    String updateQuery = "UPDATE stuinfoup SET Stu_name = ?, Stu_grade = ?, Stu_class = ?,Stu_attendence = ?,Stu_gpa = ?,Stu_PSAT = ?,Stu_SAT = ? WHERE Stu_name = ?";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                        preparedStatement.setString(1, Stu_name);
                        preparedStatement.setString(2, Stu_grade);
                        preparedStatement.setString(3, Stu_class);
                        preparedStatement.setFloat(4, Stu_attendence);
                        preparedStatement.setFloat(5, Stu_gpa);
                        preparedStatement.setInt(6, Stu_PSAT);
                        preparedStatement.setInt(7, Stu_SAT);
                        preparedStatement.setString(8, oldStu_name);

                        model.fireTableDataChanged();
                        
                        // Execute the UPDATE statement
                        preparedStatement.executeUpdate();
            
                        // Optionally, display a success message or perform additional actions
            
                        // Close the connection
                        preparedStatement.close();
                    }
            
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace(); // Handle the exception (e.g., show an error message to the user)
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select a row to edit.");}
            }



                }

            private void DeleteSQLentry(int selectedRowIndex) {
                try {
                    // Connect to the database
                    Connection connection = DriverManager.getConnection("jdbc:mysql://Laptop-4B044QS8:3306/students", "root", "Singh1038");
            
                    // Get the Stu_name from the selected row
                    String removeditem = (String) uppermember.getUppertable().getValueAt(selectedRowIndex, 0);
            
                    // Prepare and execute the DELETE statement
                    String deleteQuery = "DELETE FROM stuinfoup WHERE Stu_name = ?";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
                        preparedStatement.setString(1, removeditem);
            
                        // Execute the statement
                        preparedStatement.executeUpdate();
            
            
                        // Close the connection
                        preparedStatement.close();
                    }
            
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace(); // Handle the exception (e.g., show an error message to the user)
                }
            }


                private void Deleteitem(){
                int selectedRowIndex = uppermember.getUppertable().getSelectedRow();
                {
                if (selectedRowIndex != -1) {
                // Delete the row from the table
                DefaultTableModel model = (DefaultTableModel) uppermember.getUppertable().getModel();
                model.removeRow(selectedRowIndex);
                model.fireTableDataChanged();
                DeleteSQLentry(selectedRowIndex);

                
                } else {
                // Display message that no row is selected
                JOptionPane.showMessageDialog(this, "Please select a row to delete.");}
            }}

    @Override
    public void actionPerformed(ActionEvent e) {
    if (e.getSource() == button) {
        dispose();
        homeframe home = new homeframe();
        home.setTitle("Homepage"); 
    } else if (e.getSource() == upperbut) {
        createupper.setVisible(true);
        createunder.setVisible(false);
    } else if (e.getSource() == underbut) {
        createupper.setVisible(false);
        createunder.setVisible(true);
    } else if (e.getSource() == addstuup) {
        Additemsupper();
    } else if (e.getSource() == deletebut) {
        Deleteitem();
    } else if (e.getSource() == editbut) {
        EditItem();
}}}