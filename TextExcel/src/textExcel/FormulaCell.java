package textExcel;

public class FormulaCell extends RealCell
{
	public String str;
	
	public FormulaCell(String input) {
		super(input);
		this.str = input;
	}
	
	@Override
	public String abbreviatedCellText()
	{
		// TODO Auto-generated method stub
		if (str.length() < 10) {
			return str;
		} else {
			return str.substring(0, 10);			
		}
	}

	@Override
	public String fullCellText()
	{
		// TODO Auto-generated method stub
		return this.str;
	}
	 // will not be tested
	public double getDoubleValue() {
		return Double.parseDouble(str);
	}

}
