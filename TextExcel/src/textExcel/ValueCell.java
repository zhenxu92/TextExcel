package textExcel;

public class ValueCell extends RealCell
{
	private String str;
	
	public ValueCell(String str) {
		super(str);
		this.str = str;
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
	
	public double getDoubleValue() {
		return Double.parseDouble(str);
	}
}
