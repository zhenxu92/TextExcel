package textExcel;

public class PercentCell extends ValueCell
{
	private String str;
	
	public PercentCell(String str) {
		super(str);
		// 8.999999
		// parse to double
		double value = Double.parseDouble(str);
		value = value / 100.0;
		// parse  double to string
		this.str = Double.toString(value);
		
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
