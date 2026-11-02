package br.com.zenon;

import java.util.Optional;

public interface TransactionRepository {

	public Optional<Transaction> findByOriginName(String originName);
}
