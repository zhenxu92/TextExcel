package textExcel;

public class RealCell implements Cell
{

	public String str;
	
	public RealCell(String input) {
		this.str = input;
	}
	
	@Override
	public String abbreviatedCellText()
	{
		// TODO Auto-generated method stub
		return this.str;
	}

	@Override
	public String fullCellText()
	{
		// TODO Auto-generated method stub
		return this.str;
	}
	
	public double getDoubleValue() {
		return Double.parseDouble(str);
	}

}

