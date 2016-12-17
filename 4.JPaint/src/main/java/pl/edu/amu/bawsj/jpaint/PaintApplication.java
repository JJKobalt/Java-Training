package pl.edu.amu.bawsj.jpaint;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import pl.edu.amu.bawsj.jpaint.Commands.*;
import pl.edu.amu.bawsj.jpaint.State.AppState;
import pl.edu.amu.bawsj.jpaint.State.DrawingCircleState;

import java.util.Iterator;

/**
 * Created by JanJa on 07.12.2016.
 */
public class PaintApplication {

    public Document document;
    public AppState state;
    public PaintView paintView;
    AppState currentState;
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
        currentState = newState;
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

        commandStack.performedComands.get(0);

        Iterator<Command> commandIterator = commandStack.performedComands.iterator();
        while (commandIterator.hasNext()) {
            Command command = commandIterator.next();
            if(command.getClass()== MoveLayerUpCommand.class)
            {

            }
            if(command.getClass()== MoveLayerDownCommand.class)
            {

            }
        }
    }

    public void undoCommand() {
        commandStack.undo();

    }

    public void redoCommand() {
        commandStack.redo();
    }



    public void MousePressed(MouseEvent e, GraphicsContext gc) {
        state.handleMouseButtonPressed(e.getX(),e.getY(),gc);
    }
}
