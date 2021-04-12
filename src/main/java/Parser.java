import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private String data;
    private ArrayList<String> temp;
    private String output;

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

    public ArrayList<String> splitByPound() {
        Pattern pattern = Pattern.compile("\\w*?[^\\w\\s]\\w*?[^\\w\\s]\\w*?[^\\w\\s]\\w*?[^\\w\\s]\\w*?[^\\w\\s]\\w*?[^\\w\\s]\\w*?[^\\w\\s]\\w+[^\\w\\s][0-9]*?[^\\w\\s][0-9]*?[^\\w\\s][0-9][0-9][0-9][0-9]");
        Matcher matcher = pattern.matcher(data);
        ArrayList<String> stringList = new ArrayList<>();

        while(matcher.find()) {
            stringList.add(matcher.group());
        }
        temp = stringList;
        return stringList;
    }

    public String stringOutput() {
        String output = "";

        for(String value : temp) {
            output += String.format("{\n%s\n},\n", value);
        }

        this.output = output;
        return output;
    }

    public int counter(String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(data);
        int counter = 0;

        while(matcher.find()) {
            counter++;
        }
        return counter;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getOutput() {
        return output;
    }
}
