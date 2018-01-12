package imagevieweer.ui;

import imagevieweer.model.Image;

public interface ImageDisplay {

    Image currentImage();
    void display(Image image);   
}
