package com.goit.grocery.view;

import java.io.OutputStream;
import java.util.Scanner;


public class Console implements View {

    private Scanner scanner;
    private OutputStream out;

    public Console() {
        scanner = new Scanner(System.in);
 //       this.out = System.out;
    }


    @Override
    public String read() {
        return scanner.nextLine();
    }

    @Override
    public void write(String message) {
        System.out.println(message);
    }
}
