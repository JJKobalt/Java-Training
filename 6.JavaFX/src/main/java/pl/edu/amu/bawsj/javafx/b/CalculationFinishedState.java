package pl.edu.amu.bawsj.javafx.b;

/**
 * Created by JanJa on 30.11.2016.
 */
class CalculationFinishedState implements CalculatorState {

    private CalculatorModel model;


    CalculationFinishedState(CalculatorModel model) {
        this.model = model;

    }

    @Override
    public void addNumber(String number) {
        model.calculatorState = new SetFirstNumberState(model);
        model.flushLine();
        model.calculatorState.addNumber(number);
    }

    @Override
    public void addCalculation() {
        model.calculatorState = new SetFirstNumberState(model);
        model.calculatorState.addCalculation();
    }

    @Override
    public void perform() {
        model.firstNumber=Double.valueOf(model.line.getValueSafe());

        model.flushLine();
        Double result = model.calculation.calculate();
        model.addToLine(result.toString());


    }
}
