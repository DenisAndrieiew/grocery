package com.goit.grocery;

import com.goit.grocery.controller.MainController;
import com.goit.grocery.model.Storage;
import com.goit.grocery.view.Console;
import com.goit.grocery.view.View;

public class Application {

    public static void main(String[] args) {
        View view = new Console();
        Storage storage = Storage.getInstance();
        MainController controller = new MainController(storage, view);
        controller.run();


    }
}
