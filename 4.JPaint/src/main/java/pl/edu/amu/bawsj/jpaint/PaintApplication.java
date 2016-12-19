package pl.edu.amu.bawsj.jpaint;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import pl.edu.amu.bawsj.jpaint.Commands.*;
import pl.edu.amu.bawsj.jpaint.State.AppState;
import pl.edu.amu.bawsj.jpaint.DrawingStyle.DrawingStyle;

import java.util.Iterator;

/**
 * Created by JanJa on 07.12.2016.
 */
public class PaintApplication {

    public Document document;
    public AppState state;
    public PaintView paintView;

    CommandStack commandStack;

    private static PaintApplication instance = null;



    private PaintApplication(PaintView paintView) {
        this.paintView = paintView;
        document = new Document(this);
        commandStack = new CommandStack();

    }

    ;

    public static PaintApplication getInstance(PaintView paintView) {
        if (instance == null) instance = new PaintApplication(paintView);

        return instance;
    }


    public void changeState(AppState newState) {

        state = newState;
    }

    public void addNewLayer() {



        addToCommandStack(new AddLayerCommand(this));
        document.addLayer(new Layer("New Layer"));
    }

    public void setCurrentLayer(int position) {
        addToCommandStack(new SelectLayerCommand(document.getCurrentLayerIndex(),position,this));
        document.setCurrentLayer(position);

    }

    public void deleteLayer(int position) {
        addToCommandStack(new DeleteLayerCommand(document.layers.get(position),position, this));
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
    }

    public void handleMouseButtonDragged(double x, double y, GraphicsContext gc) {
        state.handleMouseButtonDragged(x,y,gc);
    }

    public DrawingStyle getStyleType() {
        return paintView.getFillType();
    }
}
