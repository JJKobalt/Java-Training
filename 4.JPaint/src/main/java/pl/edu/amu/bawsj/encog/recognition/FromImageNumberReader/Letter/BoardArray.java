package pl.edu.amu.bawsj.encog.recognition.FromImageNumberReader.Letter;

/**
 * Created by JanJa on 11.02.2017.
 */
public class BoardArray {

    private int[][] values;


    public BoardArray(int[][] values) {

        this.values = values;
invert();
    }

    public BoardArray() {

    }

    public void invert() {

        int[][] newArray = new int[this.getHeight()][this.getWidth()];
        for (int i = 0; i < this.getHeight(); i++) {
            for (int j = 0; j < this.getWidth(); j++) {
                newArray[i][j] = values[j][i];
            }
        }
        values = newArray;
    }

    public int get(int x, int y) {
        return values[x][y];
    }

    public void set(int x, int y, int value) {
        values[x][y] = value;
    }

    public int[][] getValues() {
        return values;
    }

    public void setValues(int[][] values) {
        this.values = values;
    }


    public int getHeight() {
        return values[0].length;
    }

    public int getWidth() {
        return values.length;
    }


    @SuppressWarnings("unchecked")
    public int[] getHorizontalLineArray(int i) {
        int[] line;

        line = new int[getWidth()];

        for (int j = 0; j < line.length; j++) {
            line[j] = values[j][i];

        }
        return line;

    }


    public int[] getVerticalLineArray(int i) {
        int[] line;

        line = values[i];

        return line;
    }


    public void add(int[] line) {


    }

    public void addBottom(BoardArray secondArray) {

        if (values == null) {
            values = secondArray.values;
            return;
        }
        if (this.getWidth() != secondArray.getWidth())
            throw new IllegalArgumentException("sizes of Arrays are not equal");


        int newHeight = this.getHeight() + secondArray.getHeight();


        int[][] newValues = new int[getWidth()][newHeight];
        ;

        for (int i = 0; i < this.getHeight(); i++) {
            for (int j = 0; j < this.getWidth(); j++) {
                newValues[j][i] = this.values[j][i];
            }
        }
        int movedBy = this.getHeight();

        for (int i = 0; i < secondArray.getHeight(); i++) {
            for (int j = 0; j < this.getWidth(); j++) {
                newValues[j][i + movedBy] = secondArray.values[j][i];
            }
        }


        values = newValues;


    }

    public void addBottom(int[] line) {
        int[][] arr = new int[1][line.length];
        arr[0] = line;

        BoardArray newTemporaryBoard = new BoardArray(arr);

        addBottom(newTemporaryBoard);

    }


    public void removeHorizontalLine(int x) {

        int[] array = getHorizontalLineArray(x);


        int[][] newValues = new int[this.getWidth()][this.getHeight() - 1];

        int move = 0;
        for (int i = 0; i < this.getHeight(); i++) {

            if (i != x) {
                for (int j = 0; j < this.getWidth(); j++) {
                    newValues[j][i - move] = values[j][i];

                }



            } else {
                move++;

            }

        }

        values = newValues;

    }

    public void overwriteFrom(BoardArray copiedArray)
    {

        for(int i=0;i<copiedArray.getHeight();i++)
        {
            for(int j=0;j<copiedArray.getWidth();j++)
            {
                int newValue = copiedArray.get(j,i);
                set(j,i,newValue);
            }
        }


    }




    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                sb.append(values[j][i] + " ");

            }
            sb.append("\r\n");
        }

        return sb.toString();
    }

}


