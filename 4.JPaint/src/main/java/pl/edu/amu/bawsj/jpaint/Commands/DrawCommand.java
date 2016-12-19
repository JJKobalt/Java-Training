package pl.edu.amu.bawsj.jpaint.Commands;

import pl.edu.amu.bawsj.jpaint.shape.Shape;
import pl.edu.amu.bawsj.jpaint.Layer;

/**
 * Created by JanJa on 18.12.2016.
 */
public class DrawCommand implements  Command {
    Layer layer;
    Shape shape;

    public DrawCommand(Layer layer,Shape shape) {
        this.layer = layer;
        this.shape = shape;
    }

    @Override
    public void undo() {
        layer.removeLast();
        layer.redraw();
    }

    @Override
    public void redo() {
        layer.addDrawable(shape);
        layer.redraw();
    }


    @Override
    public String toString() {
        return "Drawed at Layer "+ layer.name+ " its a " + shape.toString();
    }
}
