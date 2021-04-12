public class Engine {
    public int milkCounter = 1;
    public int milkPrice3_23 = 2;
    public int milkPrice1_23 = 3;
    public int breadCounter = 4;
    public int breadPrice1_23 = 5;
    public int cookiesCounter = 6;
    public int cookiesPrice2_25 = 7;
    public int applesCounter = 8;
    public int applesPrice0_25 = 9;
    public int applesPrice0_23 = 10;
    public int errors = 11;

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
