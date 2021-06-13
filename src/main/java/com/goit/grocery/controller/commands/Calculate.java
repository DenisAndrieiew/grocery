package com.goit.grocery.controller.commands;

import com.goit.grocery.model.Storage;
import com.goit.grocery.view.View;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;

public class Calculate implements Command{
private View view;
private Storage storage;

    public Calculate(View view, Storage storage) {
        this.view = view;
        this.storage = storage;
    }

    @Override
    public String commandName() {
        return "calculate";
    }

    @Override
    public void process() {
        view.write("Enter goods sequence");
        char[] sequence = view.read().toUpperCase().toCharArray();
        BigDecimal totalCost=new BigDecimal(0);
        List<Character> id = storage.getAllId();
        int[] count = new int[id.size()];

        for (int i = 0; i<id.size(); i++) {
            for (char ch : sequence) {
                if (id.get(i) == ch) {
                    count[i]++;
                }
            }
        }
        for (int i = 0; i < id.size(); i++) {
           if (Objects.nonNull(storage.getProductById(id.get(i)).getActionPrice())) {
               totalCost = totalCost.add(storage.getProductById(id.get(i)).getActionPrice().multiply(
                       new BigDecimal(count[i] / storage.getProductById(id.get(i)).getActionCount())));
               count[i]=count[i]%storage.getProductById(id.get(i)).getActionCount();
           }
               totalCost=totalCost.add(new BigDecimal(count[i]).
                       multiply(storage.getProductById(id.get(i)).getPrice()));
           }
        view.write("total cost is "+totalCost.setScale(2, RoundingMode.HALF_UP));
    }
}
