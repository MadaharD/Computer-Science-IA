package mainframe;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Questionframe extends Jframecreate implements ActionListener{
    JButton button;
    public Questionframe(){
        initialize();
        initializeQuestionframe();
    } 

    public void initializeQuestionframe(){

        JPanel bottompanel = new JPanel();
        bottompanel.setLayout((LayoutManager) new FlowLayout(FlowLayout.LEFT, 10, 5));
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
        
    }}}
