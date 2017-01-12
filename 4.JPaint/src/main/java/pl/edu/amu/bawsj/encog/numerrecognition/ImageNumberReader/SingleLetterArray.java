package pl.edu.amu.bawsj.encog.numerrecognition.ImageNumberReader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JanJa on 06.01.2017.
 */
public class SingleLetterArray {

    List<List<int[][]>> singleLetters;

    public SingleLetterArray() {
        singleLetters = new ArrayList<>();

    }

    public void addLetter(int[][] letter) {


        //  System.out.print("adding  letter at ");
        //   printGrid(letter);
        singleLetters.get(getLastLineIndex()).add(letter);
    }


    public void newLine() {
        List<int[][]> newLine = new ArrayList<>();
        singleLetters.add(newLine);
    }


    public int getLastLineIndex() {
        return singleLetters.size() - 1;
    }


    public int[][] getLetter(int i, int j) {
        try {
            return singleLetters.get(i).get(j);
        }catch (IndexOutOfBoundsException e)
        {
            System.out.println(" Wywaliło dla i = "+i + " j = "+j  );
            System.out.println(" Rozmiar całkowity to " + singleLetters.size() + " na " + singleLetters.get(i).size() );

            return null;
        }
        }


    public List<double[]> getInputValues() {
        System.out.println("getInputValues: start");
        List<double[]> inputValuesList = new ArrayList<>();
        for (int i = 0; i < singleLetters.size(); i++) {
            for (int j = 0; j < singleLetters.get(i).size(); j++) {
                double[] inputArray=getInputValues(i, j);
                inputValuesList.add(inputArray);

            }
        }
        return inputValuesList;
    }


    public double[] getInputValues(int i, int j) {
        int[][] letter = getLetter(i, j);
        //   System.out.print("letter at " + i + " " + j + " looks  ");
        //    printGrid(letter);
        int[][] simplefiedLetters = simplefyLetters(letter);
        double[] inputArray = simpliefiedLettersToArray(simplefiedLetters);

      //  System.out.print("Simplified to");
      //  printGrid(simplefiedLetters);

        return inputArray;
    }

    private double[] simpliefiedLettersToArray(int[][] simplefiedLetters) {
        double[] inputArray = new double[simplefiedLetters.length * simplefiedLetters[0].length];

        for (int i = 0; i < simplefiedLetters.length; i++) {
            for (int j = 0; j < simplefiedLetters[i].length; j++) {
                inputArray[i*10 + j] = simplefiedLetters[i][j];
            }
        }


        return inputArray;
    }


    public void printGrid(int[][] tab) {
        System.out.println("print grid");
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {

                System.out.print(tab[i][j] + " "); //You can replace ' ' by '\t', if
                //you want a tab instead of a space
            }
            System.out.println("");
        }
    }

    private int[][] simplefyLetters(int[][] letter) {

        int size = 10;
        int[][] squareLetter = makeSquareDimensions(letter);
        int[][] simplefiedLetter = new int[size][size];

        double step = (double) squareLetter.length / size;
        for (int i = 0; i < simplefiedLetter.length; i++) {
            for (int j = 0; j < simplefiedLetter.length; j++) {

                simplefiedLetter[i][j] = isBlackInSection(squareLetter, step, i, j);


            }
        }

        return simplefiedLetter;
    }

    public int isBlackInSection(int[][] letter, double step, int x, int y) {


        double beginingOfSectionForX = x * step;
        double endOfSectionForX = beginingOfSectionForX + step;
        double beginingOfSectionForY = y * step;
        double endOfSectionForY = beginingOfSectionForY + step;


        for (int i = (int) beginingOfSectionForX; i < (int) endOfSectionForX; i++) {

            for (int j = (int) beginingOfSectionForY; j < (int) endOfSectionForY; j++) {

                if (letter[i][j] == ColorBinary.BLACK.value) {
                    return ColorBinary.BLACK.value;
                }


            }


        }

        return ColorBinary.WHITE.value;
    }


    public int[][] makeSquareDimensions(int[][] letter) {

        int[][] squareLetter = makeDimensionsEqual(letter);
        // makeDimensionDividableByTen(squareLetter);

        return squareLetter;

    }

    private void makeDimensionDividableByTen(int[][] squareLetter) {
        int size = squareLetter.length;
        int newSize = size + calculateShortage(size);


        return;

    }

    private int calculateShortage(int size) {
        int shortage = size % 10;
        if (shortage == 0) return 0;
        else return 10 - shortage;
    }

    private int[][] makeDimensionsEqual(int[][] letter) {
        int[][] squareLetter;
        if (isHigherThanWider(letter)) {
            squareLetter = makeThickerAtSides(letter);
        } else {
            squareLetter = makeThickerAtTopAndBottom(letter);
        }
        return squareLetter;
    }


    private int[][] makeThickerAtTopAndBottom(int[][] letter) {
        int size = letter[0].length;

        int[][] squareRectangle = new int[size][size];

        int differencInSize = size - letter.length;

        if (differencInSize % 2 != 2) differencInSize++;
        int moved = differencInSize / 2;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                if ((i - moved) >= 0 && (i - moved) < letter.length) {
                    squareRectangle[i][j] = letter[i - moved][j];

                } else {
                    squareRectangle[i][j] = ColorBinary.WHITE.value;

                }

            }

        }

        return squareRectangle;
    }


    private int[][] makeThickerAtSides(int[][] letter) {

        int size = letter.length;


        int[][] squareRectangle = new int[size][size];

        int differenceInSize = size - letter[0].length;
        if (differenceInSize % 2 != 0) differenceInSize++;

        int moved = differenceInSize / 2;


        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                if ((j - moved) >= 0 && (j - moved) < letter[0].length) {
                    squareRectangle[i][j] = letter[i][j - moved];
                } else {
                    squareRectangle[i][j] = ColorBinary.WHITE.value;
                }

            }
        }

        return squareRectangle;
    }

    private boolean isHigherThanWider(int[][] letter) {

            return letter.length > letter[0].length;


        }


    public void showResults() {
        System.out.println("liczba lini " + singleLetters.size());
        for (int i = 0; i < singleLetters.size(); i++) {
            System.out.println("W lini " + i + "  " + singleLetters.get(i).size() + " liter");
            for (int j = 0; j < singleLetters.get(i).size(); j++) {
                System.out.println(singleLetters.get(i).get(j).length + " " + singleLetters.get(i).get(j)[0].length);
            }
        }
    }


}
