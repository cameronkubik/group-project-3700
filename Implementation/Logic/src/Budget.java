//package com.cmk;
// Budget class

public class Budget {

    private Float income;
    private Float expendable;
    private Float savings;
    private Float expenses;

    public Budget(Float _income, Float _expendable, Float _savings) {
        super();
        this.income = _income;
        this.expendable = _expendable;
        this.savings = _savings;
        this.expenses = calculateExpenses();
    }

    public Float calculateExpenses() {
        return income - savings - expendable;
    }

    public void print() {
        Printer.prForm("Income", income.toString());
        Printer.prForm("Expendable", expendable.toString());
        Printer.prForm("Savings", savings.toString());
        Printer.prForm("Expenses", expenses.toString());
    }

	/**
	* Returns value of income
	* @return
	*/
	public Float getIncome() {
		return income;
	}

	/**
	* Sets new value of income
	* @param
	*/
	public void setIncome(Float income) {
		this.income = income;
	}

	/**
	* Returns value of expendable
	* @return
	*/
	public Float getExpendable() {
		return expendable;
	}

	/**
	* Sets new value of expendable
	* @param
	*/
	public void setExpendable(Float expendable) {
		this.expendable = expendable;
	}

	/**
	* Returns value of savings
	* @return
	*/
	public Float getSavings() {
		return savings;
	}

	/**
	* Sets new value of savings
	* @param
	*/
	public void setSavings(Float savings) {
		this.savings = savings;
	}

	/**
	* Returns value of expenses
	* @return
	*/
	public Float getExpenses() {
		return expenses;
	}

	/**
	* Sets new value of expenses
	* @param
	*/
	public void setExpenses(Float expenses) {
		this.expenses = expenses;
	}
}
