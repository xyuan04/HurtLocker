import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private String data;

    public Parser() {
        IOClass io = new IOClass();
        data = io.loadFile();
    }

    public ArrayList<String> splitByPound() {
        Pattern pattern = Pattern.compile("\\w*?[^\\w\\s]\\w*?[^\\w\\s]\\w*?[^\\w\\s]\\w*?[^\\w\\s]\\w*?[^\\w\\s]\\w*?[^\\w\\s]\\w*?[^\\w\\s]\\w+[^\\w\\s][0-9]*?[^\\w\\s][0-9]*?[^\\w\\s][0-9][0-9][0-9][0-9]");
        Matcher matcher = pattern.matcher(data);
        ArrayList<String> stringList = new ArrayList<>();

        while(matcher.find()) {
            stringList.add(matcher.group());
        }
        return stringList;
    }

    public String stringOutput(ArrayList<String> stringList) {
        String output = "";

        for(String value : stringList) {
            output += String.format("{\n%s\n},\n", value);
        }

        return output;
    }

    public int counter(String regex, ArrayList<String> stringList) {
        Pattern pattern = Pattern.compile(regex);
        int counter = 0;

        for(String string : stringList) {
            Matcher matcher = pattern.matcher(string);
            while (matcher.find()) {
                counter++;
            }
        }
        return counter;
    }

}
