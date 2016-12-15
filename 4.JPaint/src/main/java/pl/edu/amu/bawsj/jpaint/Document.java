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
    Layer currentLayer;
    PaintView paintView;

CommandStack commandStack;
    PaintApplication application;

    public Document(PaintView paintView) {

        System.out.println("Document: Document(PaintView paintView)");
        layers = FXCollections.observableList(new ArrayList<Layer>());
        this.paintView = paintView;
    }

    public void moveUp(int position){
        if (notTheHighest(position)) Collections.swap(layers, position, position + 1);
        System.out.println("Layer " + position + " moved Up");
    }

    private boolean notTheLowest(int position) {
        return position != 0;
    }




    public void moveDown(int position){
        if (notTheLowest(position)) Collections.swap(layers, position, position - 1);
        System.out.println("Layer " + position + " moved down");
    }

    private boolean notTheHighest(int position) {
        return position != layers.size() - 1;
    }




    public void delete(int position){


        Layer deletingLayer = layers.get(position);
        if(deletingLayer == currentLayer) {
           changeCurrentLayer(position);
        }
        paintView.removeObject(layers.get(position).canvas);


        layers.remove(position);
        System.out.println("Layer " + position + " deleted");
    }

    private void changeCurrentLayer(int position) {
        if(layers.size()==1) addLayer(new Layer("New Layer"));

        if(position!=0) setCurrentLayer((position-1));
        else setCurrentLayer((position+1));
    }

    void addLayer(Layer layer) {
        layer.canvas = paintView.createNewCanvas();
        System.out.println(" Added layer" + layers.size());
        layers.add(layer);
    }



    public void setCurrentLayer(int position) {

        currentLayer = layers.get(position);

        for (int i = 0; i < layers.size(); i++) {

            boolean setTransparent = (i != position);

            layers.get(i).canvas.setMouseTransparent(setTransparent);


        }
    }



}
