package pl.edu.amu.bawsj.jpaint;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import pl.edu.amu.bawsj.jpaint.Commands.MoveLayerDownCommand;
import pl.edu.amu.bawsj.jpaint.Commands.MoveLayerUpCommand;
import pl.edu.amu.bawsj.jpaint.shape.Shape;

import java.util.*;

/**
 * Created by JanJa on 07.12.2016.
 */
public class Document {

    public ObservableList<Layer> layers;
    Layer currentLayer;
    PaintView paintView;


    PaintApplication application;

    public Layer getCurrentLayer() {
        return currentLayer;
    }

    public Document(PaintApplication application) {

        this.application = application;
        paintView = application.paintView;

        layers = FXCollections.observableList(new ArrayList<Layer>());
        this.paintView = paintView;


    }


    public void moveUp(int position){
        if (notTheHighest(position)) {

            swap(position, position + 1);
            application.addToCommandStack(new MoveLayerUpCommand(position, application));
        }

    }


    private boolean notTheHighest(int position) {

        return position != layers.size() - 1;
    }

    public void moveDown(int position){
        if (notTheLowest(position)) {
            swap(position, position - 1);
            application.addToCommandStack(new MoveLayerDownCommand(position, application));
        }

    }


    private boolean notTheLowest(int position) {

        return position != 0;
    }


    public void swap(int positionOne, int positionTwo) {
        Collections.swap(layers, positionOne, positionTwo);

    }


    public void delete(int position){


        Layer deletingLayer = layers.get(position);
        if(deletingLayer == currentLayer) {
           changeCurrentLayer(position);
        }
        paintView.removeObject(layers.get(position).canvas);


        layers.remove(position);

    }


    private void changeCurrentLayer(int position) {


        if (layers.size() == 1) {

            currentLayer = null;
            return;
        }
        if (position != 0) {
            setCurrentLayer((position - 1));
        } else {
            setCurrentLayer((position + 1));
        }
    }


    public void addLayer(Layer layer) {

        layer.canvas = paintView.createNewCanvas();

        deselectLayer(layer);
        layers.add(layer);

        if (layers.size() == 1) setCurrentLayer(0);

    }
    public void addLayerAt (Layer layer ,int  position) {

        layer.canvas = paintView.createNewCanvas();

        deselectLayer(layer);
        layers.add(position,layer);

        if (layers.size() == 1) setCurrentLayer(0);

    }



    public void setCurrentLayer(int position) {

        currentLayer = layers.get(position);

        for (int i = 0; i < layers.size(); i++) {


            if (layers.get(i) == currentLayer) {
                select(position);

            } else {
                deselectByPosition(i);

            }

        }
    }


    private void select(int positions) {
        layers.get(positions).canvas.setMouseTransparent(false);
        layers.get(positions).changeColor(Colors.GREY_DARK);

    }

    private void deselectByPosition(int positions) {
        deselectLayer(layers.get(positions));

    }

    private void deselectLayer(Layer layer) {
        layer.canvas.setMouseTransparent(true);
        layer.changeColor(Colors.GREY_LIGHT);
    }


    int getCurrentLayerIndex() {
        if (layers.contains(currentLayer)) {
            return layers.indexOf(currentLayer);
        }
        return -1;
    }

    public void addDrawable(Shape drawable) {
    currentLayer.addDrawable(drawable);

    }

    public void redrawCurrent() {

    currentLayer.redraw();
    }

    public void redrawAt(int position) {

        layers.get(position).redraw();
    }

    public void redrawAll() {

       for(Layer layer: layers)
       {
           layer.canvas.toFront();

       };
        for(Layer layer: layers)
        {

            layer.redraw();
        };


    }
}
