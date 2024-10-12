package command;

import core.Command;

public class MultiplicationCommand implements Command {
    @Override
    public int execute(int a, int b) {
        return a * b;
    }
}
