import java.util.ArrayList;

public class Engine {
    Parser parse;
    IOClass io;
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
    public int errors;

    public Engine() {
        parse = new Parser();
        io = new IOClass();

        ArrayList<String> stringList = parse.splitByPound();

        this.milkCounter = parse.counter("^[nN].*?[^\\w\\s][mM][iI][lL][kK]", stringList);
        this.milkPrice3_23 = parse.counter("[mM][iI][lL][kK][^\\w\\s]\\w*?[^\\w\\s]3.23", stringList);
        this.milkPrice1_23 = parse.counter("[mM][iI][lL][kK][^\\w\\s]\\w*?[^\\w\\s]1.23", stringList);
        this.breadCounter = parse.counter("[bB][rR][eE][aA][dD]", stringList);
        this.breadPrice1_23 = parse.counter("[bB][rR][eE][aA][dD][^\\w\\s]\\w*?[^\\w\\s]1.23", stringList);
        this.cookiesCounter = parse.counter("[cC][oO0][oO0][kK][iI][eE][sS]", stringList);
        this.cookiesPrice2_25 = parse.counter("[cC][oO0][oO0][kK][iI][eE][sS][^\\w\\s]\\w*?[^\\w\\s]2.25", stringList);
        this.applesCounter = parse.counter("[aA][pP][pP][lL][eE][sS]", stringList);
        this.applesPrice0_25 = parse.counter("[aA][pP][pP][lL][eE][sS][^\\w\\s]\\w*?[^\\w\\s]0.25", stringList);
        this.applesPrice0_23 = parse.counter("[aA][pP][pP][lL][eE][sS][^\\w\\s]\\w*?[^\\w\\s]0.23", stringList);
        this.errors = parse.splitByPound().size() - parse.counter("\\w*?[^\\w\\s]\\w+?[^\\w\\s]\\w*?[^\\w\\s]\\w+?[^\\w\\s]\\w+?[^\\w\\s]\\w+?[^\\w\\s]\\w+?[^\\w\\s]\\w+[^\\w\\s][0-9]*?[^\\w\\s][0-9]*?[^\\w\\s][0-9][0-9][0-9][0-9]", stringList);
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
