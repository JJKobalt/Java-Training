package pl.edu.amu.bawsj.jpaint;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import pl.edu.amu.bawsj.jpaint.Commands.*;
import pl.edu.amu.bawsj.jpaint.State.AppState;
import pl.edu.amu.bawsj.jpaint.DrawingStyle.DrawingStyle;

import java.awt.image.BufferedImage;

/**
 * Created by JanJa on 07.12.2016.
 */
public class PaintApplication {

    public Document document;
    private AppState state;
    PaintView paintView;
    CommandStack commandStack;
    ImageCalculator calculator;



    public PaintApplication(PaintView paintView) {
        this.paintView = paintView;
        document = new Document(this);
        commandStack = new CommandStack();
        calculator = new ImageCalculator();

    }





    void changeState(AppState newState) {

        state = newState;
    }

    public void addNewLayer() {


        addToCommandStack(new AddLayerCommand(this));
        document.addLayer("New Layer");
    }

    public void setCurrentLayer(int position) {
        addToCommandStack(new SelectLayerCommand(document.getCurrentLayerIndex(), position,this));
        document.setCurrentLayer(position);

    }

    public void deleteLayer(int position) {
        addToCommandStack(new DeleteLayerCommand(document.layers.get(position), position,this));
        document.delete(position);

    }

    public void moveLayerUp(int position) {
        document.moveUp(position);

    }

    public void moveLayerDown(int position) {
       document.moveDown(position);

    }

    public Layer getLayerAt(int position) {
        return document.layers.get(position);
    }


    public void addToCommandStack(Command command)
    {
        commandStack.addCommand(command);
    }

    public void printStackInConsole() {
commandStack.printCommandStackInConsole();
    }

    public void undoCommand() {
        commandStack.undo();

    }

    public void redoCommand() {
        commandStack.redo();
    }


    public void handleMouseButtonPressed(double x, double y, GraphicsContext gc) {
        state.handleMouseButtonPressed(x,y,gc);
    }


    public Color getFirstColor()
    {
        return paintView.getFirstColor();
    }

    public Color getSecondColor()
    {
        return paintView.getSecondColor();
    }

    public void handleMouseButtonRelesed(double x, double y, GraphicsContext gc) {
        state.handleMouseButtonRelesed(x,y,gc);
        tryRecognizeEquation();
    }

    public void handleMouseButtonDragged(double x, double y, GraphicsContext gc) {
        state.handleMouseButtonDragged(x,y,gc);
    }

    public DrawingStyle getStyleType() {

        return paintView.getStyleType();
    }

    public int getBrushSize() {
        return paintView.getBrushSize();
    }

    public void tryRecognizeEquation() {

        BufferedImage image = document.getCurrentLayer().getLayerAsBufferedImage();
        String answer = calculator.readFromImage(image);
paintView.setRecognitedText(answer);
        System.out.println(answer);

    }
}
