//Slippage Control class

public class SlippageControl {

    private static Slippage slippage;

    public static void calculateSlippage() {
        Printer.pr("----- Slippage Report -----", 1);

        Float budgeted = fetchBudgetedExpenses();
        Float actual = fetchActualExpenses();

        slippage = new Slippage(budgeted, actual);

        slippage.print();
    }

    private static Float fetchBudgetedExpenses() {
        Budget budget = BudgetControl.getBudget();
        return budget.getExpenses();
    }

    private static Float fetchActualExpenses() {
        CashFlow cashFlow = CashFlowControl.getCashFlow();
        return cashFlow.getOutflow();
    }

}
