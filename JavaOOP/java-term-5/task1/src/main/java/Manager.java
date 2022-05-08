import client.Client;
import object.TestObject;
import server.Server;

public class Manager {
    public static void main(String[] args) {
        String filename = "test.ser";
        TestObject object = new TestObject(666, "Testing client-server program");
        System.out.println("Created object");
        System.out.println("number = " + object.getNumber());
        System.out.println("text = " + object.getText());
        System.out.println();

        System.out.println("Serializing...");
        Client.serialize(object, filename);
        System.out.println();

        System.out.println("Deserializing...");
        TestObject deserialized = Server.deserialize(filename);
        System.out.println();

        System.out.println("number = " + deserialized.getNumber());
        System.out.println("text = " + deserialized.getText());
    }
}
