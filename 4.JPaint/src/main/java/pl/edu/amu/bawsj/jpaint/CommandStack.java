package pl.edu.amu.bawsj.jpaint;

import pl.edu.amu.bawsj.jpaint.Commands.Command;
import pl.edu.amu.bawsj.jpaint.Commands.MoveLayerDownCommand;
import pl.edu.amu.bawsj.jpaint.Commands.MoveLayerUpCommand;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by JanJa on 15.12.2016.
 */
public class CommandStack {
    List<Command> performedComands;

    List<Command> redoComands;


    CommandStack() {

        performedComands = new ArrayList<>();
        redoComands = new ArrayList<>();

    }



    void addCommand(Command command)
    {
        performedComands.add(command);
        redoComands.clear();
    }


    void undo() {
        if(performedComands.size()==0) return;

        Command command = performedComands.get(performedComands.size()-1);
        redoComands.add(command);
        command.undo();
        performedComands.remove(performedComands.size()-1);
    }

    void redo(){
        if(redoComands.size()==0) return;

        Command command= redoComands.get(redoComands.size()-1);
        performedComands.add(command);
        command.redo();
        redoComands.remove(redoComands.size()-1);
    }

    public void printCommandStackInConsole() {




        Iterator<Command> commandIterator = performedComands.iterator();
        while (commandIterator.hasNext()) {
            Command command = commandIterator.next();
           System.out.println(command.toString());
        }
    }
}
