package pl.edu.amu.bawsj.javafx.b;

import pl.edu.amu.bawsj.javafx.b.calculations.CalculationStrategy;

/**
 * Created by JanJa on 25.11.2016.
 */
interface CalculatorState {


    void addNumber(String number);

   void addCalculation();

    void perform();


}
