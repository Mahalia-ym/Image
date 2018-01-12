package imagevieweer;

import imagevieweer.control.Command;
import imagevieweer.ui.ImageDisplay;
import java.awt.Component;
import imagevieweer.ui.swing.SwingImageDisplay;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame  {
    
    private Map<String, Command> commands = new HashMap<>();
    private ImageDisplay imageDisplay;
    
    public MainFrame(){
        this.setTitle("Image Viewer");
        this.setSize (800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(image());
        this.add(toolbar(), BorderLayout.SOUTH);
        this.setVisible(true);
    }
    
    public void add(Command command){
        commands.put(command.name(), command);
    }
    
    public ImageDisplay getImageDisplay (){
        return imageDisplay;
    }
    private Component image (){
        final SwingImageDisplay display = new SwingImageDisplay();
        imageDisplay = display;
        return display;
    }
    
    private Component toolbar() {
        final JPanel panel = new JPanel();
        panel.add(button("prev"));
        panel.add(button("next"));
        return panel;
    }
    
    private Component button(String name) {
        JButton button = new JButton (name);
        button.addActionListener(execute(name));
        return button;
    }

    private ActionListener execute(String name) {
        return new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent e){
                commands.get(name).execute();
            }
        };
    }
   
}
