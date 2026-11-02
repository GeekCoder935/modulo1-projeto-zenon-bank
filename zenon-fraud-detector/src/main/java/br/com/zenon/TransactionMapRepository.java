package br.com.zenon;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class TransactionMapRepository implements TransactionRepository {

	public TransactionMapRepository(List<Transaction> transactionByOriginName) {
		Objects.requireNonNull(transactionByOriginName);
		this.transactionByOriginName = transactionByOriginName.stream()
				.collect(Collectors.toMap(transaction -> transaction.origin().nameOrig(), transaction -> transaction));
	}

	private final Map<String, Transaction> transactionByOriginName;

	@Override
	public Optional<Transaction> findByOriginName(String originName) {

		return Optional.ofNullable(transactionByOriginName.get(originName));
	}

}
