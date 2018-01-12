package imagevieweer;

import imagevieweer.control.NextImageCommand;
import imagevieweer.control.PrevImageCommand;
import imagevieweer.persistence.ImageLoader;
import imagevieweer.persistence.files.FileImageLoader;

public class Main {

    public static void main(String[] args) {
       ImageLoader imageLoader = FileImageLoader("images");
       MainFrame mainFrame = new MainFrame();
       mainFrame.add(new NextImageCommand(mainFrame.getImageDisplay()));
       mainFrame.add(new PrevImageCommand(mainFrame.getImageDisplay()));
       mainFrame.getImageDisplay().display(imageLoader.load());
    }    

    private static ImageLoader FileImageLoader(String images) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
