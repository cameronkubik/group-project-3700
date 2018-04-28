//Cash Flow control

public class CashFlowControl {
    private static CashFlow cashFlow;
    private static Float incomeIn;
    private static Float otherIn;
    private static Float adminOut;
    private static Float personelOut;
    private static Float transportationOut;
    private static Float residentialOut;
    private static Float entertainmentOut;

    public static void createCashFlow() {
        Printer.pr("To generate your cash flow, please fill out the following form.", 2);

        getInflows();

        getOutflows();

        cashFlow = generateCashFlow();

        displayCashFlow();
    }

    private static void getInflows() {
        Printer.pr("----- Cash Inflows -----", 1);
        // attempt to get income through budget
        Budget budget = BudgetControl.getBudget();
        if(budget == null || budget.getIncome() == null) {
            incomeIn = Float.parseFloat(Printer.query("Monthly income:", 2));
        } else {
            incomeIn = budget.getIncome();
        }

        //get other income sources
        otherIn = Float.parseFloat(Printer.query("Misc. revenue:", 2));
        Printer.newlines(1);
    }

    private static void getOutflows() {
        Printer.pr("----- Cash Outflows -----", 1);

        //get all Outflows
        adminOut = Float.parseFloat(Printer.query("Administrative:", 2));
        personelOut = Float.parseFloat(Printer.query("Personal expenses:", 1));
        transportationOut = Float.parseFloat(Printer.query("Transportation:", 2));
        residentialOut = Float.parseFloat(Printer.query("Residential:", 2));
        entertainmentOut = Float.parseFloat(Printer.query("Entertainment:", 2));

        Printer.newlines(2);
    }

    private static CashFlow generateCashFlow() {
        Float inflow = incomeIn + otherIn;
        Float outflow = adminOut + personelOut + transportationOut + residentialOut + entertainmentOut;

        return new CashFlow(inflow, outflow);
    }

    private static void displayCashFlow() {
        Account user = AccountControl.getUser();
        Printer.pr("----- ", 0);
        Printer.pr(user.getUsername() + "'s Cash Flow", 0);
        Printer.pr(" -----", 1);
        cashFlow.print();
    }

    public static CashFlow getCashFlow() {
        return cashFlow;
    }
}
