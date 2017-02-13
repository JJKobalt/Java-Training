package pl.edu.amu.bawsj.javafx.b;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.TextField;
import pl.edu.amu.bawsj.javafx.b.calculations.*;

public class CalculatorModel
{

    StringProperty line;


    Double firstNumber;
    Double secondNumber;

    CalculatorState calculatorState;
    CalculationStrategy calculation;



    public CalculatorModel() {

        line = new SimpleStringProperty();
        setStartState();
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



    String takeFromLine(){
        String s = line.getValueSafe();
        flushLine();
        return s;
    }

    public String getLine() {
        return line.getValue();
    }


    void flushLine() {
        line.setValue("");
    }

    public void setStartState() {

        calculatorState = new StartState(this);
    }

    public void addNumber(String finalI) {

        calculatorState.addNumber(finalI);
    }

    public void addAddition() {
        calculatorState.addCalculation();
        calculation = new AdditionCalculation(this);
    }

    public void addMultiplication() {
        calculatorState.addCalculation();
        calculation = new MultiplicationCalculculation(this);
    }

    public void addSubstraction() {
        calculatorState.addCalculation();
        calculation = new SubstractionCalculation(this);
    }

    public void addDivision() {
        calculatorState.addCalculation();
        calculation = new DivisionCalculation(this);
    }

    public void resolveEquation() {
        calculatorState.perform();

    }

    public void clear() {
        calculatorState = new StartState(this);
        firstNumber=null;
        secondNumber=null;
        calculation=null;
    }
}
