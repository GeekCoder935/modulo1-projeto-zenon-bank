package br.com.zenon;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import br.com.zenon.TransactionReport.Statistics;

public class ReportMain {

	public static void main(String[] args) {
		//var locale = Locale.of("pt","br");
		var locale = Locale.of("en","us");
		NumberFormat integerFormatter = NumberFormat.getIntegerInstance(locale);
		
		var transactionReport = new TransactionReport();
		Statistics statistics = transactionReport.generateReport("data/PS_20174392719_1491204439457_log.csv");
		
		String totalTransactionsFormatted = integerFormatter.format(statistics.totalTransactions());
		String totalFraudsFormatted = integerFormatter.format(statistics.totalFrauds());
		String totalAmountsFormatted = integerFormatter.format(statistics.totalAmounts());
		
		var resourceBundle = ResourceBundle.getBundle("report", locale);
		String msgTotalTransactions = resourceBundle.getString("label.total.transactions");
		String msgTotalFrauds = resourceBundle.getString("label.total.frauds");
		String msgTotalAmount = resourceBundle.getString("label.total.amount");
		
		IO.println(msgTotalTransactions + totalTransactionsFormatted);
		IO.println(msgTotalFrauds + totalFraudsFormatted);
		IO.println(msgTotalAmount + totalAmountsFormatted);
	}

}
