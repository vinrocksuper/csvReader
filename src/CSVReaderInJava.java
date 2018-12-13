import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVReaderInJava {

    public static void main(String[] args) {
        List<SATtakers> x =fromCSV();
        for(SATtakers s : x)
        {
            System.out.println(s);
        }
    }


    private static List<SATtakers> fromCSV(){

        List<SATtakers> z = new ArrayList<>();
        Path pathToFile = Paths.get("src/2012_SAT_Results.csv");

        try(BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)){
            String line = br.readLine();
            line = br.readLine();
            while(line != null){
                String[] attributes = line.split(",");

                SATtakers temp = createSATTaker(attributes);

                z.add(temp);
                line = br.readLine();
            }

        } catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
        return z;
    }
    private static SATtakers createSATTaker(String[] metadata)
    {

        String dbn = metadata[0];
        String name = metadata[1];
        int total = Integer.parseInt(metadata[2]);
        int read = Integer.parseInt(metadata[3]);
        int math = Integer.parseInt(metadata[4]);
        int write = Integer.parseInt(metadata[5]);
        return new SATtakers(dbn,name,total,read,math,write);
    }


}

