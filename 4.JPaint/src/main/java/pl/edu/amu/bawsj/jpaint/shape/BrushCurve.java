package pl.edu.amu.bawsj.jpaint.shape;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by JanJa on 01.01.2017.
 */
public class BrushCurve extends Shape {

    List<Line> lines;


   public BrushCurve() {
        lines = new ArrayList<>();
    }

    public void add(Line line){
        lines.add(line);
    }


    @Override
    public void draw(GraphicsContext gc) {

        Iterator<Line> iterator = lines.iterator();
        while(iterator.hasNext()){
            iterator.next().draw(gc);
        }
    }
}
