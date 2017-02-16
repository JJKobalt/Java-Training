package pl.edu.amu.bawsj.jpaint;


import pl.edu.amu.bawsj.encog.recognition.FromImageNumberReader.FromImageNumberReader;
import pl.edu.amu.bawsj.javafx.b.CalculatorModel;

import java.awt.image.BufferedImage;

import static java.lang.Character.isDigit;

/**
 * Created by JanJa on 10.02.2017.
 */
public class ImageCalculator {

    FromImageNumberReader imageNumberReader;
    CalculatorModel calculator;


    public ImageCalculator() {
        calculator = new CalculatorModel();
        imageNumberReader = new FromImageNumberReader();

    }


    public String readFromImage(BufferedImage image) {
        String line = imageNumberReader.readFromImage(image);
        return resolve(line);
    }

    public String resolve(String line) {

        calculator.clear();
        for (char s : line.toCharArray()) {

            if (isDigit(s)) {

                calculator.addNumber(String.valueOf(s));
            }
            if (s == '+') {
                calculator.addAddition();
            }

            if (s == '-') {
                calculator.addSubstraction();
            }
            if (s == '*') {
                calculator.addMultiplication();
            }
            if (s == '/') {
                calculator.addDivision();
            }
            if (s == ':') {
                calculator.addDivision();
            }


        }
        calculator.resolveEquation();
        return line + "  =  " + calculator.getLine();
    }


}
