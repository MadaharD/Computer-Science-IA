package mainframe;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class homeframe extends Jframecreate implements ActionListener {
    JButton button;
    JButton button2;
    JButton button3;
    JButton button4;

    public homeframe(){
        initialize();
        initializehomeframe();
    }
    public void initializehomeframe(){


       
        JPanel mainpanel = new JPanel();
        mainpanel.setLayout(null);
        mainpanel.setPreferredSize(new Dimension(800,750));
        mainpanel.setBounds(0,50,800,750);
        this.add(mainpanel);
 

        button = new JButton();
        button.setBounds(110,50,200,100);
        button.setText("Calendar/Agenda");
        button.setFocusable(false);
        button.addActionListener(this);
        mainpanel.add(button);

        button2 = new JButton();
        button2.setBounds(450,50,200,100);
        button2.setText("Student List");
        button2.setFocusable(false);
        button2.addActionListener(this);
        mainpanel.add(button2);

        button3 = new JButton();
        button3.setBounds(110,220,200,100);
        button3.setText("Question Bank");
        button3.setFocusable(false);
        button3.addActionListener(this);
        mainpanel.add(button3);

        button4 = new JButton();
        button4.setBounds(450,220,200,100);
        button4.setText("Misc. Videos/articles");
        button4.setFocusable(false);
        button4.addActionListener(this);
        mainpanel.add(button4);

        JPanel toppanel = new JPanel();
        toppanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
        toppanel.setPreferredSize(new Dimension(800,50));
        toppanel.setBounds(0,20,800,50);
        this.add(toppanel, BorderLayout.NORTH);

        JLabel welcome = new JLabel();
        welcome.setText("Welcome! What would you like to look at?");
        toppanel.add(welcome);

         

      



        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new homeframe());
    }
 
public void actionPerformed(ActionEvent e) {
    if(e.getSource() == button) {
        dispose();
        Calendarframe calendar = new Calendarframe();
        calendar.setTitle("Calendar");
    } else if(e.getSource() == button2) {
        dispose();
        Studentlist list = new Studentlist();
        list.setTitle("Student list");
    } else if(e.getSource() == button3) {
        dispose();
        Questionframe bank = new Questionframe();
        bank.setTitle("Question banks");
    } else if (e.getSource() == button4){
        dispose();
        Miscvideos vids = new Miscvideos();
        vids.setTitle("Misc. Articles and Videos");
    }
}} 