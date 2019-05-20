/*
In this program :
1) Create buttons and add them to the frame
2) Use ActionListener to create lambda methods for
   use of buttons

3) Use JTextField for creating the text space
4) Define  a private variable name , with setter and getter.
For setter use getText() method to load the variable name.

5) Set LookAndFeel
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class Playback extends JFrame  {
    private String name;

    public String NameGetter(String name){
        return name;
    }
    public String NameSetting (){
        return pageAddress.getText();
    }
    public Playback() {
        //Constructor

        super("Playback");
        String mes;
        setLookAndFeel();
        setSize(450, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JLabel pageLabel = new JLabel("Your Name  :", JLabel.LEFT);

        FlowLayout flo = new FlowLayout();
        setLayout(flo);

        JButton play = new JButton("Play");
        JButton stop = new JButton("Stop");
        JButton pause = new JButton("Pause");

        add(pageLabel);
        add(play);
        add(stop);
        add(pause);

        add(pageAddress);
        //Lambda definition for methods play and stop
        // Anonymous class

        ActionListener act = (event) ->{

            if (event.getSource() == play) {
                System.out.println(NameGetter(NameSetting()));
            }
            if(event.getSource() == stop) {

                System.exit(1);
            }
        };
        play.addActionListener(act);
        stop.addActionListener(act);
        pack();
        setVisible(true);
    }
    JTextField pageAddress = new JTextField(20) {
        public String pal() {
            return pageAddress.getText();
    }};

    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception exc) {
            //do nothing;
        }
    }

    public static void main(String[] args) {

        Playback frame = new Playback();

    }
}

