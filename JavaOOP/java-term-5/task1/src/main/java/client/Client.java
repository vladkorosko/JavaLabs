package client;

import java.io.*;

public interface Client {
    public static void serialize(Serializable object, String filename) {
        try (FileOutputStream file = new FileOutputStream(filename);
             ObjectOutputStream out = new ObjectOutputStream(file)) {
            out.writeObject(object);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
