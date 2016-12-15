package pl.edu.amu.bawsj.jpaint;

import pl.edu.amu.bawsj.jpaint.Commands.Command;

import java.util.Stack;

/**
 * Created by JanJa on 15.12.2016.
 */
public class CommandStack {
    Stack<Command> performedComands;

    Stack<Command> redoComands;


    void addCommand(Command command)
    {
        performedComands.add(command);
    }
}
