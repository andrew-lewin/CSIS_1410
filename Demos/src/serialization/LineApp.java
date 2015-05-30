package serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class LineApp {
	public static void main(String[] args) {
		Line line = new Line(new Point(1,1), new Point(5,4));
		System.out.println(line);
		System.out.println("Length: " + line.length());
		
		serialize(line, "src/serialization/Line.ser");
		Line deserializedLine = deserialize("src/serialization/Line.ser");
		System.out.println(deserializedLine);
	}

	private static Line deserialize(String filePath) {
		Line line = null;
		try(ObjectInputStream deserializer = new ObjectInputStream(new FileInputStream(filePath))) {
			line = (Line) deserializer.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} 
		
		return line;
	}

	private static void serialize(Line line, String filePath) {
		try(ObjectOutputStream serializer = new ObjectOutputStream(new FileOutputStream(filePath))) {
			serializer.writeObject(line);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}

}
