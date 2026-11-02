package br.com.zenon;

import br.com.zenon.TransactionReport.Statistics;

public class ReportMain {

	public static void main(String[] args) {
		var transactionReport = new TransactionReport();
		Statistics statistics = transactionReport.generateReport("data/PS_20174392719_1491204439457_log.csv");
		IO.println("Total de linhas: " + statistics.totalTransactions());
		IO.println("Total de fraudes: " + statistics.totalFrauds());
		IO.println("Valor total transacionado: " + statistics.totalAmounts());
	}

}
