package textExcel;

public class PercentCell extends ValueCell
{
	// 0.089
	// 0.89
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
		// parse str to double first
		double value = Double.parseDouble(this.str);
		value *= 100;
		String output = Integer.toString((int)value);
		output += "%";
		return output;
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
