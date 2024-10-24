import javax.swing.JFrame;

/**
 * Title: Distance Converter
 *
 * Description:
 * This program provides a graphical interface to convert distances
 * between inches and centimeters. The user can enter a value in a text box,
 * choose the conversion type from a combo box, and click a button to perform the conversion.
 * The result is displayed on the screen.
 */
public class Converter {
    public static void main(String[] args) {
        // Create the frame and make it visible
        ConverterFrame frame = new ConverterFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
