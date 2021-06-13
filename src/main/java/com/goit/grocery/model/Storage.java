package com.goit.grocery.model;

import com.goit.grocery.model.entity.Product;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.RoundingMode;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Storage {

    static ConcurrentHashMap<Character, Product> priceList = new ConcurrentHashMap();
    private static Storage instance = new Storage();

    private Storage() {
        readStorageFromFile();
    }

    public static Storage getInstance() {
        return instance;
    }

    private static void readStorageFromFile() {
        final String FILE_PATH = "src\\main\\resources\\Storage.str";
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            System.out.println("file not found!");
            return;
        }
        try (FileReader reader = new FileReader(file)) {
            StringBuilder builder = new StringBuilder();
            char[] buf = new char[1024];
            int c;
            while ((c = reader.read(buf)) > 0) {
                if (c < 1024) {
                    buf = Arrays.copyOf(buf, c);
                }
                builder.append(buf);
            }
            Type collectionType = new TypeToken<ConcurrentHashMap<Character, Product>>() {
            }.getType();
            priceList = new Gson().fromJson(builder.toString(), collectionType);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public Product getProductById(char ch) {
        return priceList.get(ch);
    }

    public List<Character> getAllId(){
        List<Character> listOfId = new ArrayList<>();
        priceList.forEach((k, v)->listOfId.add(k));
        Collections.sort(listOfId);
return listOfId;

    }

    //    public static void writeToJSON() {
//        instance.priceList.put('A', new Product('A', 1.25, 3, 3));
//        instance.priceList.put('B', new Product('B', 4.25));
//        instance.priceList.put('C', new Product('C', 1, 6, 5));
//        instance.priceList.put('D', new Product('D', 0.75));
//        File file = new File(FILE_PATH);
//        if (!file.exists()) {
//            System.out.println("file not found!");
//            System.out.println("creating...");
//            try {
//                file.createNewFile();
//                System.out.println("file is created");
//            } catch (IOException e) {
//                System.out.println("file can`t be created");
//                System.out.println(e.getMessage());
//                return;
//            }
//        }
//        System.out.println("file is OK");
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        String json = gson.toJson(instance.priceList);
//        try (FileWriter fileWriter = new FileWriter(file)) {
//            fileWriter.write(json);
//            fileWriter.flush();
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("*********************************************************" + "\n");
        builder.append("*Продукт*   цена * акционное количество * акционная цена*" + "\n");
        builder.append("*********************************************************" + "\n");
        priceList.forEach((K, V) ->
                builder.append("*\t" + V.getId() + "\t*\t" + V.getPrice().setScale(2, RoundingMode.HALF_UP) +
                        (V.getActionCount() != 0 ? " *\t\t\t" + V.getActionCount() + "\t\t\t*\t" + V.getActionPrice() + "\t\t\t*" :
                                " *\t\t\t\t\t\t*\t\t\t\t*") + "\n"));
        builder.append("*********************************************************");
        return builder.toString();
    }


}
