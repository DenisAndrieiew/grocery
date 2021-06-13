package com.goit.grocery.controller;

import com.goit.grocery.controller.commands.Calculate;
import com.goit.grocery.controller.commands.Command;
import com.goit.grocery.controller.commands.Help;
import com.goit.grocery.controller.commands.ShowAll;
import com.goit.grocery.model.Storage;
import com.goit.grocery.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainController {
    private View view;
    private List<Command> commands;

    public MainController(Storage storage, View view) {
        this.view = view;
        this.commands=new ArrayList<>(Arrays.asList(
                new Help(view), new ShowAll(view, storage), new Calculate(view, storage)));
    }

    public void run() {
        view.write("Welcome to the shop");
        doCommand();
    }

    private void doCommand() {
        boolean isNotExit = true;
        while (isNotExit) {
            view.write("Please enter a command or help to retrieve command list");
            String inputCommand = view.read().toLowerCase();
            for (Command command : commands) {
                if (command.canProcess(inputCommand)) {
                    command.process();
                    break;
                } else if (inputCommand.equalsIgnoreCase("exit")) {
                    view.write("Good Bye!");
                    isNotExit = false;
                    break;
                }
            }
        }
    }

}
