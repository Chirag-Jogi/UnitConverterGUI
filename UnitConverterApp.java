import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class UnitConverter {

    // Length Conversion
    public static double lengthConvert(double value, String fromUnit, String toUnit) {
        double result = 0;
        if (fromUnit.equals("meters") && toUnit.equals("kilometers")) {
            result = value / 1000;
        } else if (fromUnit.equals("kilometers") && toUnit.equals("meters")) {
            result = value * 1000;
        } else if (fromUnit.equals("feet") && toUnit.equals("inches")) {
            result = value * 12;
        } else if (fromUnit.equals("inches") && toUnit.equals("feet")) {
            result = value / 12;
        } else {
            System.out.println("Invalid length units!");
        }
        return result;
    }

    // Temperature Conversion
    public static double tempConvert(double value, String fromUnit, String toUnit) {
        double result = 0;
        if (fromUnit.equals("celsius") && toUnit.equals("fahrenheit")) {
            result = (value * 9 / 5) + 32;
        } else if (fromUnit.equals("fahrenheit") && toUnit.equals("celsius")) {
            result = (value - 32) * 5 / 9;
        } else {
            System.out.println("Invalid temperature units!");
        }
        return result;
    }

    // Weight Conversion
    public static double weightConvert(double value, String fromUnit, String toUnit) {
        double result = 0;
        if (fromUnit.equals("kilograms") && toUnit.equals("grams")) {
            result = value * 1000;
        } else if (fromUnit.equals("grams") && toUnit.equals("kilograms")) {
            result = value / 1000;
        } else if (fromUnit.equals("pounds") && toUnit.equals("ounces")) {
            result = value * 16;
        } else if (fromUnit.equals("ounces") && toUnit.equals("pounds")) {
            result = value / 16;
        } else {
            System.out.println("Invalid weight units!");
        }
        return result;
    }

    // Time conversion
    public static double timeConvert(double value, String fromUnit, String toUnit) {
        double result = 0;
        if (fromUnit.equals("hours") && toUnit.equals("minutes")) {
            result = value * 60;
        } else if (fromUnit.equals("minutes") && toUnit.equals("hours")) {
            result = value / 60;
        } else if (fromUnit.equals("minutes") && toUnit.equals("seconds")) {
            result = value * 60;
        } else if (fromUnit.equals("seconds") && toUnit.equals("minutes")) {
            result = value / 60;
        } else {
            System.out.println("Invalid time units!");
        }
        return result;
    }

    // Volume Conversion
    public static double volumeConvert(double value, String fromUnit, String toUnit) {
        double result = 0;
        if (fromUnit.equals("liters") && toUnit.equals("milliliters")) {
            result = value * 1000;
        } else if (fromUnit.equals("milliliters") && toUnit.equals("liters")) {
            result = value / 1000;
        } else if (fromUnit.equals("gallons") && toUnit.equals("liters")) {
            result = value * 3.785;
        } else if (fromUnit.equals("liters") && toUnit.equals("gallons")) {
            result = value / 3.785;
        } else {
            System.out.println("Invalid volume units!");
        }
        return result;
    }
}

public class UnitConverterApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Unit Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());

        String[] conversionTypes = {"Length", "Temperature", "Weight", "Time", "Volume"};
        JComboBox<String> conversionTypeBox = new JComboBox<>(conversionTypes);
        JTextField valueInput = new JTextField(10);
        JComboBox<String> fromUnitBox = new JComboBox<>();
        JComboBox<String> toUnitBox = new JComboBox<>();
        JButton convertButton = new JButton("Convert");
        JLabel resultLabel = new JLabel("Converted Value: ");

        // Set initial units for the dropdown
        conversionTypeBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedType = (String) conversionTypeBox.getSelectedItem();
                fromUnitBox.removeAllItems();
                toUnitBox.removeAllItems();
                
                switch (selectedType) {
                    case "Length":
                        fromUnitBox.addItem("meters");
                        fromUnitBox.addItem("kilometers");
                        fromUnitBox.addItem("feet");
                        fromUnitBox.addItem("inches");
                        toUnitBox.addItem("meters");
                        toUnitBox.addItem("kilometers");
                        toUnitBox.addItem("feet");
                        toUnitBox.addItem("inches");
                        break;
                    case "Temperature":
                        fromUnitBox.addItem("celsius");
                        fromUnitBox.addItem("fahrenheit");
                        toUnitBox.addItem("celsius");
                        toUnitBox.addItem("fahrenheit");
                        break;
                    case "Weight":
                        fromUnitBox.addItem("kilograms");
                        fromUnitBox.addItem("grams");
                        fromUnitBox.addItem("pounds");
                        fromUnitBox.addItem("ounces");
                        toUnitBox.addItem("kilograms");
                        toUnitBox.addItem("grams");
                        toUnitBox.addItem("pounds");
                        toUnitBox.addItem("ounces");
                        break;
                    case "Time":
                        fromUnitBox.addItem("hours");
                        fromUnitBox.addItem("minutes");
                        fromUnitBox.addItem("seconds");
                        toUnitBox.addItem("hours");
                        toUnitBox.addItem("minutes");
                        toUnitBox.addItem("seconds");
                        break;
                    case "Volume":
                        fromUnitBox.addItem("liters");
                        fromUnitBox.addItem("milliliters");
                        fromUnitBox.addItem("gallons");
                        toUnitBox.addItem("liters");
                        toUnitBox.addItem("milliliters");
                        toUnitBox.addItem("gallons");
                        break;
                }
            }
        });

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double value = Double.parseDouble(valueInput.getText());
                String fromUnit = (String) fromUnitBox.getSelectedItem();
                String toUnit = (String) toUnitBox.getSelectedItem();
                double result = 0;

                switch ((String) conversionTypeBox.getSelectedItem()) {
                    case "Length":
                        result = UnitConverter.lengthConvert(value, fromUnit, toUnit);
                        break;
                    case "Temperature":
                        result = UnitConverter.tempConvert(value, fromUnit, toUnit);
                        break;
                    case "Weight":
                        result = UnitConverter.weightConvert(value, fromUnit, toUnit);
                        break;
                    case "Time":
                        result = UnitConverter.timeConvert(value, fromUnit, toUnit);
                        break;
                    case "Volume":
                        result = UnitConverter.volumeConvert(value, fromUnit, toUnit);
                        break;
                }
                resultLabel.setText("Converted Value: " + result + " " + toUnit);
            }
        });

        frame.add(new JLabel("Select Conversion Type:"));
        frame.add(conversionTypeBox);
        frame.add(new JLabel("Enter Value:"));
        frame.add(valueInput);
        frame.add(new JLabel("From Unit:"));
        frame.add(fromUnitBox);
        frame.add(new JLabel("To Unit:"));
        frame.add(toUnitBox);
        frame.add(convertButton);
        frame.add(resultLabel);

        frame.setVisible(true);
    }
}
