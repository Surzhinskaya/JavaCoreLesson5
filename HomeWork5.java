package HomeWork5;

import com.opencsv.CSVWriterBuilder;
import com.opencsv.ICSVWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HomeWork5 {


    public static void main(String[] args) throws IOException{

        List appData = createAppData();

        try (ICSVWriter writer = new CSVWriterBuilder(
                new FileWriter("src/test.csv"))
                .build()) {
            writer.writeAll(appData);
        }

        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        try {

            br = new BufferedReader(new FileReader("src/test.csv"));
            while ((line = br.readLine()) != null) {

                String[] list = line.split(cvsSplitBy);

                System.out.println(list[0]);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }

    private static List createAppData() {
        String[] header = {"value1; value2; value3"};
        String[] record1 = {"100; 200 ; 123"};
        String[] record2 = {"300 ; 400 ; 500"};

        List list = new ArrayList<>();
        list.add(header);
        list.add(record1);
        list.add(record2);

        return list;
    }

}








