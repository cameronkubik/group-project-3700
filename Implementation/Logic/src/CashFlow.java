// Cash flow class

public class CashFlow {

    private Float inflow;
    private Float outflow;
    private Float netCash;

    /**
	* Default public constructor
	*/
	public CashFlow(Float inflow, Float outflow) {
		super();
		this.inflow = inflow;
		this.outflow = outflow;
		this.netCash = inflow - outflow;
	}

    public void print() {
        displayInflow();
        displayOutflow();
        displayNetCash();
    }

    public void displayInflow() {
        Printer.prForm("Total Inflow", inflow.toString());
    }

    public void displayOutflow() {
        Printer.prForm("Total Outflow", outflow.toString());
    }

    public void displayNetCash() {
        Printer.prForm("Net Cash", netCash.toString());
    }

	/**
	* Returns value of inflow
	* @return
	*/
	public Float getInflow() {
		return inflow;
	}

	/**
	* Sets new value of inflow
	* @param
	*/
	public void setInflow(Float inflow) {
		this.inflow = inflow;
	}

	/**
	* Returns value of outflow
	* @return
	*/
	public Float getOutflow() {
		return outflow;
	}

	/**
	* Sets new value of outflow
	* @param
	*/
	public void setOutflow(Float outflow) {
		this.outflow = outflow;
	}

	/**
	* Returns value of netCash
	* @return
	*/
	public Float getNetCash() {
		return netCash;
	}

	/**
	* Sets new value of netCash
	* @param
	*/
	public void setNetCash(Float netCash) {
		this.netCash = netCash;
	}
}
