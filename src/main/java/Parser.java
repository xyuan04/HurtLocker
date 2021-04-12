import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public String splitByPound() {
        Pattern pattern = Pattern.compile("[nN][aA][mM][eE][:]\\w+[;]\\w+[:]\\w+[.]\\w+[;]\\w+[:]\\w+[;]\\w+[:][0-9]*?[/][0-9]*?[/][0-9][0-9][0-9][0-9]");
        Matcher matcher = pattern.matcher(data);
        String splitData = "";
        int lastMatchPosition = 0;
        boolean yes = true;

        while(matcher.find()) {
            splitData += matcher.group() + "\n";
        }

        return splitData;
    }


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
