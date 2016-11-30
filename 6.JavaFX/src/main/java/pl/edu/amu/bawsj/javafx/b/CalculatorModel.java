package pl.edu.amu.bawsj.javafx.b;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.TextField;

public class CalculatorModel
{

    StringProperty line;


    Double firstNumber;
    Double secondNumber;


    CalculatorModel() {
        line = new SimpleStringProperty();

    }


   public void addToLine(String add) {

        line.setValue(line.getValueSafe() + add);
    }




    public Double getFirstNumber() {
        return firstNumber;
    }

    public Double getSecondNumber() {
        return secondNumber;
    }


    public void firstNumberComplete() {
        firstNumber = Double.parseDouble(line.getValueSafe());
        flushLine();
    }

    void secondNumberComplete() {
        secondNumber = Double.parseDouble(line.getValueSafe());
        flushLine();
    }

    void flushLine()
    {
        line.setValue("");
    }
}
