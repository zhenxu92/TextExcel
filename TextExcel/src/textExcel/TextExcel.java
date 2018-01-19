package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

// Update this file with your own code.

public class TextExcel
{

	public static void main(String[] args)
	{
	    // Add your command loop here
		
		// init scanner
		Scanner console = new Scanner(System.in);
		
		// init all the objects needed
		Spreadsheet sheet = new Spreadsheet();
		
		// a string to store the commands
		System.out.print("Welcome to Wenlin's spreadsheet (type quit to ext)? ");
		System.out.println();
		System.out.println(sheet.getGridText());
        for(;;) {
            
            String command = console.nextLine();
            if (command.equals("quit")) {
                System.out.println("See you next time!");
            	break;	
            }
            System.out.println(sheet.processCommand(command));
            System.out.print("Please keep typing your command: ");
        }
	}
}
