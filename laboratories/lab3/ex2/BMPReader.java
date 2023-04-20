package lab3.ex2;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class BMPReader {
    public static void main(String args[]) throws Exception {
        File file = new File("C:\\Users\\Maciek\\IdeaProjects\\apro1_23l_matuszewski_maciej\\laboratories\\lab3\\ex2\\Map.bmp");
        BufferedImage image = ImageIO.read(file);
        int width = image.getWidth();
        int height = image.getHeight();
        System.out.println("Szerokość: " + width);
        System.out.println("Wysokość: " + height);
    }
}