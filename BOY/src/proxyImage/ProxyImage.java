package proxyImage;

import javax.swing.ImageIcon;

public class ProxyImage implements IImage {
    private final String src;
    private RealImage realImage;

    public ProxyImage(String var1) {
        this.src = var1;
    }

    public ImageIcon loadImage() {
        if (this.realImage == null) {
            this.realImage = new RealImage(this.src);
        }

        return this.realImage.loadImage();
    }
}
