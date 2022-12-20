import ij.ImagePlus;
import ij.plugin.filter.PlugInFilter;
import ij.process.ColorProcessor;
import ij.process.ImageProcessor;

public class Resize_Image implements PlugInFilter {

    String title;

    public int setup(String args, ImagePlus im) {
        title = im.getShortTitle();
        return DOES_RGB;
    }

    public void run(ImageProcessor inputIP) {
        ImageProcessor outputIP = new ColorProcessor(inputIP.getWidth() / 5, inputIP.getHeight() / 5);

        for (int i = 0; i < inputIP.getWidth() / 5; i++) {
            for (int j = 0; j < inputIP.getHeight() / 5; j++) {
                int pixel = (inputIP.getPixel(i * 5, j * 5));
                outputIP.putPixel(i, j, pixel);
            }
        }

        (new ImagePlus(title + "COPY", outputIP)).show();
    }
}