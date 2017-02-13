package pl.edu.amu.bawsj.javafx.b;

/**
 * Created by JanJa on 01.12.2016.
 */
class StartState implements CalculatorState {

    private CalculatorModel model;


    StartState(CalculatorModel model) {
        this.model = model;

    }

    @Override
    public void addNumber(String number) {
        model.flushLine();
        model.calculatorState= new SetFirstNumberState(model);
        model.calculatorState.addNumber(number);

    }

    @Override
    public void addCalculation() {
        System.err.println("Nothing will happen");
    }

    @Override
    public void perform() {
        System.err.println("Nothing will happen");
    }
}
