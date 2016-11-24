package pl.edu.amu.bawsj.refactoring.a;



public class A
{
    private Processor processor;
    Result result;

    public static void main(String[] args) {
        A aObj = new A();
        aObj.setProcessor(new Processor());

        aObj.process("test1");
        aObj.showResult();

        aObj.closeProcess();
        aObj.process("test2");
        aObj.showResult();

        aObj.openProcess();
        aObj.process("test3");
        aObj.showResult();
    }

    void setProcessor(Processor newProcessor) {
        processor = newProcessor;
    }

    public void process(String processName) {
        result = processor.process(processName);

    }

    private void showResult() {
        System.out.println(result.getText());
    }

    void closeProcess() {
        processor.setClose(true);
    }

    void openProcess() {
        processor.setClose(false);
    }

    String returnResultOfProcess(String processName) {
        Result result = processor.process(processName);
        return result.getText();

    }
}
