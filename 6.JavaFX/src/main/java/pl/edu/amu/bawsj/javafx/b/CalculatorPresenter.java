package pl.edu.amu.bawsj.javafx.b;

import javafx.beans.property.StringProperty;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class CalculatorPresenter {
    private static final Logger LOG = LogManager.getLogger();



    private CalculatorModel model;




    CalculatorPresenter(CalculatorView calculatorView) {


        this.model = new CalculatorModel();

    }


    StringProperty getLine()
    {
        return model.line;
    }

    void numClicked(String finalI) {

        LOG.info( finalI + " clicked" );
        model.addNumber(finalI);


    }

    void additionClicked() {
        model.addAddition();

        LOG.info( "Addition clicked" );

    }

    void multiplicationClicked() {
        model.addMultiplication();
        LOG.info( "Multiplication clicked" );

    }

    void subtractionClicked() {
       model.addSubstraction();
        LOG.info( "Subtraction clicked" );

    }

    void divisionClicked() {
      model.addDivision();
        LOG.info( "Division clicked" );

    }

    void resultClicked() {

        model.resolveEquation();
        LOG.info( "Result clicked" );

    }


}
