package pl.edu.amu.bawsj.jpaint.State;

import javafx.scene.canvas.GraphicsContext;

/**
 * Created by JanJa on 07.12.2016.
 */
public class DrawingCircleState extends DrawingState {


    public DrawingCircleState(){
        super();

        System.out.println("Cirlce state");
    }






    @Override
    public void handleMouseButtonPressed(Double x, Double y, GraphicsContext gc) {
        this.gc=gc;
        this.gc.fillOval(x,y,20,20);
    }

    public void handleMouseButtonRelesed() {

    }
}
