package pl.edu.amu.bawsj.refactoring.b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

public class B {

    private BufferedReader reader;
    private double avg;
    // takie rzeczy warto wrzucac w private static final
    String fileName = "gold.csv";

    B(BufferedReader reader) {
        this.reader = reader;
    }

    // ?!
    B() {
    }

    public static void main(String[] args) {
        B b = new B();
        // tutaj masz stworzony obiekt b, ktory... nie jest gotowy "do akcji".
        // musisz ustawic jeszcze readera itd itp.
        // zrob eksperyment sobie kiedys, wroc do tego kodu za 3, 4 tygodnie i sprobuj skorzystac z tej klasy bez zagladania do kodu
        // gwarantuje Ci ze dostaniesz NullPointerException, bo o tym zapomnisz.
        // konstruktor jest po to, zeby po zrobieniu "new" miec juz wszystko gotowe i nie musieć nic inicjalizować.

        b.initializeReader(b.fileName);

        try {
            System.out.println(b.GetMaxLineAvg());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // czemu notacja z C#? Java baaardzo nie lubi sie z C#, pamietaj ze przy projekcie zaliczeniowym to bedzie kwestia oceniania, tutaj to pomine.
    double GetMaxLineAvg() throws IOException {
        avg = Double.MIN_VALUE;
        String s;
        while ((s = reader.readLine()) != null) {

            String[] split = s.split(",");
           double lineAvg =  getAvgOfLine(split);
            CompereWithPreviousBest(lineAvg);
        }
        // zauwaz co tutaj zrobiles. Z jednej strony modyfikujesz zmienna klasy ( avg ), a tutaj jeszcze ja zwracasz,
        // moze to powodowac wiele WTF na prawdziwych code-review :)
        return avg;
    }

    private void CompereWithPreviousBest(double avgOfLine) {
        // ok funkcja nazywa sie Compare, ale... co ona zwraca? Modyfikuje tylko stan klasy. Warto wowczas
        // dawac konkretne nazwy
        avg = Math.max(avg, avgOfLine);

    }

    double getAvgOfLine(String[] split) {
        return (Double.parseDouble(split[1]) + Double.parseDouble(split[2]) + Double
                .parseDouble(split[3])) / 3.0;
    }

    private void initializeReader(String fileName) {
        InputStream inputStream = B.class.getClassLoader().getResourceAsStream(fileName);
        reader = new BufferedReader(new InputStreamReader(inputStream));
    }


}
