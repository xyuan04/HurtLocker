import java.io.IOException;

public class Main {

//    public String readRawDataToString() throws Exception{
//        ClassLoader classLoader = getClass().getClassLoader();
//        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
//        return result;
//    }

    public static void main(String[] args) throws IOException {
        Engine engine = new Engine();

        engine.io.writeOutPutFile(engine);
        System.out.println(engine);
    }
}
