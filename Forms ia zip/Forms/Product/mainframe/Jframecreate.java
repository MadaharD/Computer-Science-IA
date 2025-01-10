package mainframe;
import javax.swing.*;

public class Jframecreate extends JFrame {
    private String title = "";

    public String ecapGetTitle()
    {
        return title;
    }
    public String ecapSetTitle (String title)
    {

        this.title = title;
        return title;
    }
    public Jframecreate(){
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
        SwingUtilities.invokeLater(() -> new Jframecreate());
    }

}
