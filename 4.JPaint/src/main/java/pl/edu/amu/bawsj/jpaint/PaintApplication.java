package pl.edu.amu.bawsj.jpaint;

import pl.edu.amu.bawsj.jpaint.State.AppState;

/**
 * Created by JanJa on 07.12.2016.
 */
public class PaintApplication {

    public Document document;
    public AppState state;
    public PaintView paintView;


    private static PaintApplication instance = null;


    private PaintApplication(PaintView paintView) {
        this.paintView = paintView;
        document = new Document(paintView);


    }

    ;

    public static PaintApplication getInstance(PaintView paintView) {
        if (instance == null) instance = new PaintApplication(paintView);

        return instance;
    }


}
