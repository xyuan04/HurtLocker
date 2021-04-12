import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class IOClass {

    public String loadFile(){
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

    public void writeOutPutFile(Engine engine) throws IOException {
        FileWriter writer = new FileWriter("/Users/xiong/Projects/HurtLocker/src/main/resources/Output.txt");
        writer.write(engine.toString());
        writer.close();
    }
}
