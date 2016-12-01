package pl.edu.amu.bawsj.javafx.b;

import javafx.beans.property.StringProperty;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.edu.amu.bawsj.javafx.b.calculations.*;

class CalculatorPresenter {
    private static final Logger LOG = LogManager.getLogger();



    private CalculatorModel model;


    CalculatorState calculatorState;
    CalculationStrategy calculation;

    CalculatorPresenter(CalculatorView calculatorView) {


        this.model = new CalculatorModel();

        calculatorState = new StartState(model, this);

    }


    StringProperty getLine()
    {
        return model.line;
    }

    void numClicked(String finalI) {

        LOG.info( finalI + " clicked" );
        calculatorState.addNumber(finalI);

    }

    void additionClicked() {
        calculatorState.addCalculation();
        calculation = new AdditionCalculation(model);
        LOG.info( "Addition clicked" );

    }

    void multiplicationClicked() {
        calculatorState.addCalculation();
        calculation = new MultiplicationCalculculation(model);
        LOG.info( "Multiplication clicked" );

    }

    void subtractionClicked() {
        calculatorState.addCalculation();
        calculation = new SubstractionCalculation(model);
        LOG.info( "Subtraction clicked" );

    }

    void divisionClicked() {
        calculatorState.addCalculation();
        calculation = new DivisionCalculation(model);
        LOG.info( "Division clicked" );

    }

    void resultClicked() {

        LOG.info( "Result clicked" );
        calculatorState.perform();

    }


}
