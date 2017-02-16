import org.junit.Assert;
import org.junit.Test;
import pl.edu.amu.bawsj.encog.recognition.FromImageNumberReader.Letter.BoardArray;

/**
 * Created by JanJa on 11.02.2017.
 */
public class BoardArrayTests {


    @Test
    public void shouldCreateArrayCorrectly() {
        int[][] arr = {{1, 1, 0}, {1, 1, 0}};
        BoardArray ints = new BoardArray(arr);
        System.out.println(ints.toString());

    }

    @Test
    public void shouldReturnCorrectLines() {
        int[][] arr = {{1, 1, 0},
                {1, 1, 0}};
        BoardArray ints = new BoardArray(arr);
        {
            int[] expectedArr = {1, 1, 0};
            Assert.assertArrayEquals(expectedArr, ints.getHorizontalLineArray(0));
        }
        {
            int[] expectedArr = {1, 1};
            Assert.assertArrayEquals(expectedArr, ints.getVerticalLineArray(0));
        }
    }

    @Test
    public void addBottomshouldWork() {
        int[][] arr1 = {{1, 1, 0},
                {1, 1, 0}};
        int[][] arr2 = {{0, 0, 1},
                {0, 0, 1}};

        BoardArray board1 = new BoardArray(arr1);

        BoardArray board2 = new BoardArray(arr2);
        board1.addBottom(board2);
        System.out.println(board1.toString());

    }


    @Test
    public void addBottomshouldWorkForSingleLine() {
        int[][] arr1 = {{1, 1, 0, 1},
                {1, 1, 0, 1}};
        int[] arr2 = {0, 0, 0, 2};


        BoardArray board1 = new BoardArray(arr1);

        board1.addBottom(arr2);
        System.out.println(board1.toString());

    }

    @Test
    public void removeLineShouldWork() {
        int[][] arr = {{1, 1, 0}, {1, 1, 0}, {1, 1, 0}};
        int[][] arr1 = { {1, 1, 0}, {1, 1, 0}};


        BoardArray board = new BoardArray(arr);
        BoardArray board1 = new BoardArray(arr1);


        board.removeHorizontalLine(0);



       Assert.assertTrue(board1.toString().equals(board.toString()));

    }




}
