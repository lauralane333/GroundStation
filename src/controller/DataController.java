package controller;

import model.Data;

import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class DataController {
    private Data data;
    private LinkedList<Data> datas;

    public DataController(){

    }

    public LinkedList<Data> read(){
        try {
            FileReader fileReader = new FileReader("./data/data.txt");
            Scanner scanner = new Scanner(fileReader);

            datas = new LinkedList<>();

            while(scanner.hasNext()){
                String[] pos = scanner.nextLine().split(",");
                data = new Data(pos[0],Double.parseDouble(pos[1]),Double.parseDouble(pos[2]),Double.parseDouble(pos[3]));
                datas.add(data);
            }

            fileReader.close();
            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return datas;
    }

}
