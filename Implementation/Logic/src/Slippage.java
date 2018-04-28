//Slippage class

public class Slippage {
    private Float budgetedExpenses;
    private Float actualExpenses;
    private Float slippage;

	/**
	* Default public constructor
	*/
	public Slippage(Float budgetedExpenses, Float actualExpenses) {
		super();
		this.budgetedExpenses = budgetedExpenses;
		this.actualExpenses = actualExpenses;
		this.slippage = budgetedExpenses - actualExpenses;
	}

    public void print() {
        Printer.prForm("Budgeted Expenses", budgetedExpenses.toString());
        Printer.prForm("Actual Expenses", actualExpenses.toString());
        Printer.prForm("Slippage", slippage.toString());
        Printer.newlines(1);
    }

	/**
	* Returns value of budgetedExpenses
	* @return
	*/
	public Float getBudgetedExpenses() {
		return budgetedExpenses;
	}

	/**
	* Sets new value of budgetedExpenses
	* @param
	*/
	public void setBudgetedExpenses(Float budgetedExpenses) {
		this.budgetedExpenses = budgetedExpenses;
	}

	/**
	* Returns value of actualExpenses
	* @return
	*/
	public Float getActualExpenses() {
		return actualExpenses;
	}

	/**
	* Sets new value of actualExpenses
	* @param
	*/
	public void setActualExpenses(Float actualExpenses) {
		this.actualExpenses = actualExpenses;
	}

	/**
	* Returns value of slippage
	* @return
	*/
	public Float getSlippage() {
		return slippage;
	}

	/**
	* Sets new value of slippage
	* @param
	*/
	public void setSlippage(Float slippage) {
		this.slippage = slippage;
	}
}
