package mainframe;
import javax.swing.*;

public class intro extends homeframe {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                homeframe home = new homeframe();
                home.setTitle("Homepage");
            }
        }); 

    }
}