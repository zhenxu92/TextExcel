package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	// data field
	Cell[][] sheet;
	
	public Spreadsheet() {
		sheet = new Cell[20][12];
		for (int i = 0; i < sheet.length; i++) {
			for (int j = 0; j < sheet[0].length; j++) {
				sheet[i][j] = new EmptyCell();
			}
		}
	}
	
	@Override
	public String processCommand(String command)
	{
		// TODO Auto-generated method stub
		if (command.length() == 0) {
			return "";
		}
		String[] commands = command.split(" ");
		if (commands.length == 1) {
			if (command.toLowerCase().equals("clear")) {
				// clear sheet
				for (int i = 0; i < sheet.length; i++) {
					for (int j = 0; j < sheet[0].length; j++) {
						sheet[i][j] = new EmptyCell();
					}
				}
				return this.getGridText();
			} else {
				// inspect a certain cell
				SpreadsheetLocation loc = new SpreadsheetLocation(command);
				// bug fixed: if there is nothing in the cell, return "" instead of empty

				return sheet[loc.getRow()][loc.getCol()].fullCellText();						
			}
		} else if (commands.length == 2) {
			// clear some cell
			SpreadsheetLocation loc = new SpreadsheetLocation(commands[1]);
			sheet[loc.getRow()][loc.getCol()] = new EmptyCell();
			return this.getGridText();
		} else if (commands.length >= 3) {
			// assign a new string to some cell
			// find the cell loc
			SpreadsheetLocation loc = new SpreadsheetLocation(commands[0]);
			// find the content
			// "Hello"
			// 8.908
			// 5.2%
			// (A1 + A2 )
			// command: A1 = 9.301%
			// command: A1 = ( A1 + A2 )
			if (command.indexOf("\"") != -1) {
				int start = command.indexOf("\"");
				String content = command.substring(start + 1, command.length() - 1);
				// assign
				sheet[loc.getRow()][loc.getCol()] = new TextCell(content);
			} else if (command.indexOf("%") != -1) {
				String content = commands[2].substring(0, commands[2].length() - 1);
				sheet[loc.getRow()][loc.getCol()] = new PercentCell(content);
				// Test
				//System.out.println(((PercentCell) sheet[loc.getRow()][loc.getCol()]).getDoubleValue());
			} else if (command.indexOf("(") != -1) {
				int start = command.indexOf("(");
				String content = command.substring(start, command.length());
				sheet[loc.getRow()][loc.getCol()] = new FormulaCell(content);
			} else {
				String content = commands[2];
				sheet[loc.getRow()][loc.getCol()] = new ValueCell(content);
				// Test
				// System.out.println(((ValueCell) sheet[loc.getRow()][loc.getCol()]).getDoubleValue());
			}
			return this.getGridText();
		} else {
			return null;
		}
	}

	@Override
	public int getRows()
	{
		// TODO Auto-generated method stub
		int r = sheet.length;
		return r;
	}

	@Override
	public int getCols()
	{
		// TODO Auto-generated method stub
		int c = sheet[0].length;
		return c;
	}

	@Override
	public Cell getCell(Location loc)
	{
		// TODO Auto-generated method stub
		return sheet[loc.getRow()][loc.getCol()];
	}
	
	// return the whole table
	@Override
	public String getGridText()
	{
        String gridText = "   ";
        for (int i = 0; i < 12; i++) {
            gridText += "|";
            gridText += (char) ('A' + i);
            gridText += "         ";
        }
        gridText += "|";
        
        // print each row
        for (int i = 0; i < 20; i++) {
            // print 1 2 3 
            gridText += System.lineSeparator();
            gridText += i + 1;
            if (i >= 9) {
                gridText += " ";
            } else {
                gridText += "  ";            
            }
            
            // print cells
            for (int j = 0; j < 12; j++) {
                if (sheet[i][j].fullCellText() == null) {
                    gridText += "|          ";                	
                } else {
                	int len = sheet[i][j].abbreviatedCellText().length();
                	gridText += "|" + sheet[i][j].abbreviatedCellText();
					for (int ii = 0; ii < 10 - len; ii++) {
						gridText += " ";
					}
                }

            }
            gridText += "|";
        }
        gridText += System.lineSeparator();
        return gridText;
	}
	
	// You are free to use this helper method.  It takes a column letter (starting at "A")
	// and returns the column number corresponding to that letter (0 for "A", 1 for "B", etc.)  
	// WARNING!!  If the parameter is not a single, capital letter in the range of your Spreadsheet,
	// bad things might happen!
	public static int getColumnNumberFromColumnLetter(String columnLetter)
	{
		return Character.toUpperCase(columnLetter.charAt(0)) - 'A';
	}

	// You are free to use this helper method.  It takes a column number (starting at 0)
	// and returns the column letter corresponding to that number ("A" for 0, "B" for 1, etc.)
	// WARNING!!  If the parameter is not a number in the range of your Spreadsheet,
	// bad things might happen!
	public static String getColumnLetterFromColumnNumber(int columnNumber)
	{
		return "" + (char) ('A' + columnNumber);
	}
	
}
