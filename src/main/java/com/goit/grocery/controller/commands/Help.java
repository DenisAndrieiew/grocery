package com.goit.grocery.controller.commands;

import com.goit.grocery.view.View;

public class Help implements Command{
    private View view;

    public Help(View view) {
        this.view = view;
    }

    @Override
    public void process() {
        view.write("help - show a list of commands");
        view.write("exit - exit from an application");
        view.write("show_all - show all products in store");
        view.write("calculate - calculate price of chosen goods");
    }

    @Override
    public String commandName() {
        return "help";
    }
}
