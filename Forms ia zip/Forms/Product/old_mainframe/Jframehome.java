package mainframe;
import javax.swing.*;

public class Jframehome extends JFrame {
    String title = "";
    public Jframehome(){
        initialize();
    }
    public void initialize(){
        setTitle(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,500);
        setLocationRelativeTo(null);
        setLayout(null);

       



       setVisible(true);
       
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Jframehome());
    }

}
