package labserialization;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class LabSerialization {
    public static void main(String[] args) {
        ListVsSetDemo demo = new ListVsSetDemo(
                new ColoredSquare(4, Color.RED),
                new ColoredSquare(6, Color.BLUE),
                new ColoredSquare(4, Color.RED),
                new ColoredSquare(8, Color.YELLOW));

        //testDemo(demo);
        serialize(demo, "src/labserialization/Demo.ser");
        ListVsSetDemo newDemo = deserialize("src/labserialization/Demo.ser");
        testDemo(newDemo);

    };

    private static void testDemo(ListVsSetDemo demo) {
        System.out.println("List:");
        System.out.println(demo.getListElements());
        System.out.println("Set:");
        System.out.println(demo.getSetElements());
    }
    
    public static void serialize(ListVsSetDemo demo, String fileName) {
    	try(ObjectOutputStream serializer = new ObjectOutputStream(new FileOutputStream(fileName))) {
    		serializer.writeObject(demo);
    	} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public static ListVsSetDemo deserialize(String fileName) {
    	ListVsSetDemo demo = null;
    	try(ObjectInputStream deserializer = new ObjectInputStream(new FileInputStream(fileName))) {
    		demo = (ListVsSetDemo) deserializer.readObject();
    	} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
    	
    	return demo;
    }

}
