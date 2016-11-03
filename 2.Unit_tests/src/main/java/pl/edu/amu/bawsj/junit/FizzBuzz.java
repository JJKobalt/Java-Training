//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package pl.edu.amu.bawsj.junit;

import java.util.Objects;

public class FizzBuzz {
    // publiczny konstruktor jest dodawany by default, po co on tu?
    public FizzBuzz() {
    }

    public static void main(String[] args) {
        (new FizzBuzz()).go(); // po co te nawiasy do okoła new FizzBuzz() ?
    }

    public void go() {
        for(int i = 1; i <= 100; ++i) {
            String result = "";
            if(i % 3 == 0) {
                result = result + "Fizz";
            }

            if(i % 5 == 0) {
                result = result + "Buzz";
            }

            if(Objects.equals(result, "")) {
                result = result + i;
            }

            System.out.println(result);
        }

    }

    // co to? po co to?
    public int checkLoop() {
        int performances = 0;

        for(int i = 1; i <= 100; ++i) {
            ++performances;
        }

        return performances;
    }

    // a nie zapomniales o podmienieniu tego w metodzie #go() ?
    public String checkValueFor(int i) {
        String result = "";
        if(i % 3 == 0) {
            result = result + "Fizz";
        }

        if(i % 5 == 0) {
            result = result + "Buzz";
        }

        if(Objects.equals(result, "")) {
            result = result + i;
        }

        return result;
    }
}
