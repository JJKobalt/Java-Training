package pl.edu.amu.bawsj.jpaint;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import javafx.scene.canvas.Canvas;
import java.util.*;

/**
 * Created by JanJa on 07.12.2016.
 */
public class Document {
    public ObservableList<Layer> layers;
    Canvas currentLayer;
    PaintView paintView;



    public Document(PaintView paintView) {
        System.out.println("Document: Document(PaintView paintView)");
        layers = FXCollections.observableList(new ArrayList<Layer>());
        this.paintView = paintView;
    }

    public void moveUp(int position){
//TODO: imp move UP
    }
    public void moveDown(int position){
//TODO: imp move DOWN
    }
    public void delete(int position){
//TODO: imp delete
    }

    void addLayer(Layer layer) {
        layer.canvas = paintView.createNewCanvas();
        layers.add(layer);
    }
}
