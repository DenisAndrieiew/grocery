package com.goit.grocery.controller.commands;

import com.goit.grocery.model.Storage;
import com.goit.grocery.view.View;

public class ShowAll implements Command {
    private View view;
    private Storage storage;

    public ShowAll(View view, Storage storage) {
        this.view = view;
        this.storage = storage;
    }

    @Override
    public String commandName() {
        return "show_all";
    }

    @Override
    public void process() {
        view.write(storage.toString());
    }
}
