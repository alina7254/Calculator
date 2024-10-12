package command;

import core.Command;

public class DivisionCommand implements Command {
    @Override
    public int execute(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Деление на ноль невозможно.");
        }
        return a / b;
    }
}
