package mainframe;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Calendarframe extends Jframecreate implements ActionListener{
    JButton button;
    JPanel Calinput;
    public Calendarframe(){
        initialize();
        initializecalendar();
    } 

    public void initializecalendar(){


        JPanel bottompanel = new JPanel();
        bottompanel.setLayout((LayoutManager) new FlowLayout(FlowLayout.LEFT, 10, 5));
        bottompanel.setPreferredSize(new Dimension(800,50));
        bottompanel.setBounds(0,415,800,50);
        this.add(bottompanel, BorderLayout.SOUTH);

        Calinput = new JPanel();
        Calinput.setLayout(null);
        Calinput.setPreferredSize(new Dimension(800,50));
        Calinput.setBackground(Color.ORANGE);
        Calinput.setBounds(0,0,400,380);
        this.add(Calinput,BorderLayout.WEST);
        Calinput.setVisible(true);


        button = new JButton();
        button.setBounds(0,0,100,50);
        button.setText("Back to homepage");
        button.setFocusable(false);
        button.addActionListener(this);
        bottompanel.add(button);


}

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button) {
            dispose();
            homeframe home = new homeframe();
            home.setTitle("Homepage");
        
    }}}
