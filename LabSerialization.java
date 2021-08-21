package labSerialization;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * LabSerialization demonstrates how to serialize and deserialize a custom
 * object that references other objects on the heap. 
 * 
 * @ Author(s): Starter Code + Brittany Pruneau
 * 
 */
public class LabSerialization
{
	public static void main(String[] args)
	{
		ListVsSetDemo demo = new ListVsSetDemo(new ColoredSquare(4, Color.RED), new ColoredSquare(6, Color.BLUE),
				new ColoredSquare(4, Color.RED), new ColoredSquare(8, Color.YELLOW));

		//displayListAndSet(demo);
		String file = "src/labSerialization/Demo.ser";
		serialize(demo, file);
		System.out.println("The serialization has been completed.");
		ListVsSetDemo newDemo = new ListVsSetDemo();
		newDemo = deserialize(file);
		displayListAndSet(newDemo);
	};

	/*
	 * Converts serialized bytes back into an instance of ListVsSetDemo. 
	 */
	private static ListVsSetDemo deserialize(String filename)
	{
		ListVsSetDemo demo = new ListVsSetDemo();
		try(ObjectInputStream deserializer = new ObjectInputStream(new FileInputStream(filename)))
		{
			demo = (ListVsSetDemo)deserializer.readObject(); 
		} 
		
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		catch (IOException | ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return demo; 
	}

	/*
	 * Displays the elements of the list and the set.
	 */
	private static void displayListAndSet(ListVsSetDemo demo)
	{
		System.out.println("List:");
		System.out.println(demo.getListElements());
		System.out.println("Set:");
		System.out.println(demo.getSetElements());
	}
	
	/*
	 * Converts a ListVsSetDemo object into a series of bytes through the process of serialization. 
	 */
	private static void serialize(ListVsSetDemo demo, String filename)
	{
		
		try (ObjectOutputStream serializer = new ObjectOutputStream(new FileOutputStream(filename)))
		{
			serializer.writeObject(demo); 
		} 
		
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
