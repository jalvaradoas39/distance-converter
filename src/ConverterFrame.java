import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Title: Distance Converter GUI
 *
 * Description:
 * This class provides a graphical user interface for converting distances
 * from inches to centimeters or from centimeters to inches. It contains
 * components such as text fields, combo box, button, and a label to display results.
 */
class ConverterFrame extends JFrame {
    private JTextField inputField;      // Field to input the value for conversion
    private JLabel resultLabel;         // Label to display the conversion result
    private JComboBox comboBox;         // Combo box to select conversion type
    private static final double CM_PER_INCH = 2.54; // Conversion rate

    /**
     * Constructor for setting up the GUI layout and components.
     *
     * @return void
     * Description: Initializes the GUI components, sets up the layout using
     * GridBagLayout, and adds the necessary components for user interaction.
     */
    public ConverterFrame() {
        setTitle("Distance Converter");
        setSize(300, 150);
        setLayout(new GridBagLayout());

        // Layout constraints
        GridBagConstraints layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 10);

        // TextField for user input
        inputField = new JTextField(10);
        layoutConst.gridx = 0;
        layoutConst.gridy = 0;
        add(inputField, layoutConst);

        // Combo box for conversion type selection (no generics used)
        comboBox = new JComboBox(new Object[]{"Inches to Centimeters", "Centimeters to Inches"});
        layoutConst.gridx = 1;
        layoutConst.gridy = 0;
        add(comboBox, layoutConst);

        // Convert button
        JButton convertButton = new JButton("Convert");
        layoutConst.gridx = 0;
        layoutConst.gridy = 1;
        add(convertButton, layoutConst);

        // Result label
        resultLabel = new JLabel("Result: ");
        layoutConst.gridx = 1;
        layoutConst.gridy = 1;
        add(resultLabel, layoutConst);

        // Add ActionListener to the button
        convertButton.addActionListener(new ConvertButtonListener());
    }

    /**
     * Inner class ConvertButtonListener to handle button click events.
     * It reads user input, performs the conversion, and updates the result label.
     */
    private class ConvertButtonListener implements ActionListener {

        /**
         * Method to handle the conversion when the button is clicked.
         *
         * @param e The ActionEvent triggered by the button click.
         * @return void
         * @throws NumberFormatException if the user input is not a valid number.
         * Description: This method reads the input value from the text field, checks
         * the selected conversion type from the combo box, performs the conversion,
         * and displays the result. If the input is invalid, an error message is shown.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // Parse input value
                double inputValue = Double.parseDouble(inputField.getText());
                double result;

                // Perform conversion based on selected option
                if (comboBox.getSelectedItem().equals("Inches to Centimeters")) {
                    result = inputValue * CM_PER_INCH;
                } else {
                    result = inputValue / CM_PER_INCH;
                }

                // Display the result
                resultLabel.setText(String.format("Result: %.2f", result));
            } catch (NumberFormatException ex) {
                // Handle invalid input
                JOptionPane.showMessageDialog(ConverterFrame.this,
                        "Please enter a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}