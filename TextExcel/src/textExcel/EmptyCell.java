package textExcel;

public class EmptyCell implements Cell
{
	public String str;
	
	public EmptyCell() {
		str = "";
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

}
