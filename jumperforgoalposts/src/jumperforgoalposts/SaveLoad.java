package jumperforgoalposts;

import java.io.*;
import java.util.List;

public class SaveLoad {
    public static void saveData(List<Team> teams) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("gameData.ser"))) {
            out.writeObject(teams);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Team> loadData() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("gameData.ser"))) {
            return (List<Team>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
