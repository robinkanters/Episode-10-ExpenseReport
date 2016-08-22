package expenseReport;

public class ReportPrinterSpy implements ReportPrinter {
    private String printedText = "";

    public void print(String text) {
        printedText += text;
    }

    public String getText() {
        return printedText;
    }
}
