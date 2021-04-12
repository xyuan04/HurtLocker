import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Parser {
    private String data;

    public Parser() {
        data = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("RawData.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public void splitByPound() {
        String[] stringArray = this.data.split("##");
        String splitString = "";

        for(String string : stringArray) {
            splitString += string + "\n";
        }

        this.data = splitString;
    }


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
