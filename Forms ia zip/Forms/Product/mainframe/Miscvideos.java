package mainframe;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Miscvideos extends Jframecreate implements ActionListener  {

    JButton button;

    public Miscvideos(){
        initialize();
        initializeframe();
    }
    public void initializeframe(){

        JPanel bottompanel = new JPanel();
        bottompanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
        bottompanel.setPreferredSize(new Dimension(800,50));
        bottompanel.setBounds(0,415,800,50);
        this.add(bottompanel, BorderLayout.SOUTH);


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
        


}
}}