import java.io.FileWriter;
import java.io.IOException;

public class Engine {
    public int milkCounter;
    public int milkPrice3_23;
    public int milkPrice1_23;
    public int breadCounter;
    public int breadPrice1_23;
    public int cookiesCounter;
    public int cookiesPrice2_25;
    public int applesCounter;
    public int applesPrice0_25;
    public int applesPrice0_23;
    public int errors; // total errors = 4

    public Engine() {
        Parser parse = new Parser();

        this.milkCounter = parse.counter("[mM][iI][lL][kK]");
        this.milkPrice3_23 = parse.counter("[mM][iI][lL][kK][^\\w\\s]\\w*?[^\\w\\s]3.23");
        this.milkPrice1_23 = parse.counter("[mM][iI][lL][kK][^\\w\\s]\\w*?[^\\w\\s]1.23");
        this.breadCounter = parse.counter("[bB][rR][eE][aA][dD]");
        this.breadPrice1_23 = parse.counter("[bB][rR][eE][aA][dD][^\\w\\s]\\w*?[^\\w\\s]1.23");
        this.cookiesCounter = parse.counter("[cC][oO][oO][kK][iI][eE][sS]");
        this.cookiesPrice2_25 = parse.counter("[cC][oO][oO][kK][iI][eE][sS][^\\w\\s]\\w*?[^\\w\\s]2.25");
        this.applesCounter = parse.counter("[aA][pP][pP][lL][eE][sS]");
        this.applesPrice0_25 = parse.counter("[aA][pP][pP][lL][eE][sS][^\\w\\s]\\w*?[^\\w\\s]0.25");
        this.applesPrice0_23 = parse.counter("[aA][pP][pP][lL][eE][sS][^\\w\\s]\\w*?[^\\w\\s]0.23");
        this.errors = parse.splitByPound().size() - parse.counter("\\w*?[^\\w\\s]\\w+?[^\\w\\s]\\w*?[^\\w\\s]\\w+?[^\\w\\s]\\w+?[^\\w\\s]\\w+?[^\\w\\s]\\w+?[^\\w\\s]\\w+[^\\w\\s][0-9]*?[^\\w\\s][0-9]*?[^\\w\\s][0-9][0-9][0-9][0-9]");
    }

    public void writeOutPutFile() throws IOException {
        FileWriter writer = new FileWriter("/Users/xiong/Projects/HurtLocker/src/main/resources/Output.txt");
        writer.write(this.toString());
        writer.close();
    }

    @Override
    public String toString() {
        return String.format("name:\tMilk\t\tseen: %s times\n=============\t\t=============\n" +
                "Price:\t3.23\t\tseen: %s times\n-------------\t\t-------------\n" +
                "Price:\t1.23\t\tseen: %s times\n" +
                "\nname:\tBread\t\tseen: %s times\n=============\t\t=============\n" +
                "Price:\t1.23\t\tseen: %s times\n-------------\t\t-------------\n" +
                "\nname:\tCookies\t\tseen: %s times\n=============\t\t=============\n" +
                "Price:\t2.25\t\tseen: %s times\n-------------\t\t-------------\n" +
                "\nname:\tApples\t\tseen: %s times\n=============\t\t=============\n" +
                "Price:\t0.25\t\tseen: %s times\n-------------\t\t-------------\n" +
                "Price:\t1.23\t\tseen: %s times\n" +
                "\nErrors\t\t\t\tseen: %s times"
                , milkCounter, milkPrice3_23, milkPrice1_23, breadCounter, breadPrice1_23, cookiesCounter, cookiesPrice2_25, applesCounter, applesPrice0_25, applesPrice0_23, errors);
    }
}
