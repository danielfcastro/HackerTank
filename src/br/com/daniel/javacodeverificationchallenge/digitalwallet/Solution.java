package br.com.daniel.javacodeverificationchallenge.digitalwallet;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * Create TransactionException, DigitalWallet, and DigitalWalletTransaction classes here.
 */
public class Solution {
	private static final Scanner INPUT_READER = new Scanner(System.in);
	private static final DigitalWalletTransaction DIGITAL_WALLET_TRANSACTION = new DigitalWalletTransaction();

	private static final Map<String, DigitalWallet> DIGITAL_WALLETS = new HashMap<>();

	public static void main(String[] args) {
		int numberOfWallets = Integer.parseInt(INPUT_READER.nextLine());
		while (numberOfWallets-- > 0) {
			String[] wallet = INPUT_READER.nextLine().split(" ");
			DigitalWallet digitalWallet;

			if (wallet.length == 2) {
				digitalWallet = new DigitalWallet(wallet[0], wallet[1]);
			} else {
				digitalWallet = new DigitalWallet(wallet[0], wallet[1], wallet[2]);
			}

			DIGITAL_WALLETS.put(wallet[0], digitalWallet);
		}

		int numberOfTransactions = Integer.parseInt(INPUT_READER.nextLine());
		while (numberOfTransactions-- > 0) {
			String[] transaction = INPUT_READER.nextLine().split(" ");
			DigitalWallet digitalWallet = DIGITAL_WALLETS.get(transaction[0]);

			if (transaction[1].equals("add")) {
				try {
					DIGITAL_WALLET_TRANSACTION.addMoney(digitalWallet, Integer.parseInt(transaction[2]));
					System.out.println("Wallet successfully credited.");
				} catch (TransactionException ex) {
					System.out.println(ex.getErrorCode() + ": " + ex.getMessage() + ".");
				}
			} else {
				try {
					DIGITAL_WALLET_TRANSACTION.payMoney(digitalWallet, Integer.parseInt(transaction[2]));
					System.out.println("Wallet successfully debited.");
				} catch (TransactionException ex) {
					System.out.println(ex.getErrorCode() + ": " + ex.getMessage() + ".");
				}
			}
		}

		System.out.println();

		DIGITAL_WALLETS.keySet().stream().sorted().map((digitalWalletId) -> DIGITAL_WALLETS.get(digitalWalletId))
				.forEachOrdered((digitalWallet) -> {
					System.out.println(digitalWallet.getWalletId() + " " + digitalWallet.getUsername() + " "
							+ digitalWallet.getWalletBalance());
				});
	}

}

class TransactionException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7889492138004872224L;
	public static final String USER_NOT_AUTHORIZED = "USER_NOT_AUTHORIZED";
	public static final  String INVALID_AMOUNT = "INVALID_AMOUNT";
	public static final  String INSUFFICIENT_BALANCE = "INSUFFICIENT_BALANCE";
	private String errorCode = "";
	private String message = "";
	
	public TransactionException() {
		super();
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}

class DigitalWallet {
	private String walletId;
	private String username;
	private String userAccessCode;
	private int walletBalance;

	public DigitalWallet(String walletId, String username) {
		super();
		this.walletId = walletId;
		this.username = username;
	}

	public DigitalWallet(String walletId, String username, String userAccessCode) {
		super();
		this.walletId = walletId;
		this.username = username;
		this.userAccessCode = userAccessCode;
	}

	public String getWalletId() {
		return walletId;
	}

	public void setWalletId(String walletId) {
		this.walletId = walletId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserAccessCode() {
		return userAccessCode;
	}

	public void setUserAccessCode(String userAccessCode) {
		this.userAccessCode = userAccessCode;
	}

	public int getWalletBalance() {
		return walletBalance;
	}

	public void setWalletBalance(int walletBalance) {
		this.walletBalance = walletBalance;
	}
}

class DigitalWalletTransaction {
	private static final String INVALID_AMOUNT_MESSAGE = "Amount should be greater than zero";
	private static final String INSUFFICIENT_BALANCE_MESSAGE = "Insufficient balance";
	private static final String USER_NOT_AUTHORIZED_MESSAGE = "User not authorized";

	public void addMoney(DigitalWallet digitalWallet, int amount) throws TransactionException {
		if(null == digitalWallet.getUserAccessCode()) {
			TransactionException ex = new TransactionException();
			ex.setErrorCode(TransactionException.USER_NOT_AUTHORIZED);
			ex.setMessage(USER_NOT_AUTHORIZED_MESSAGE);
			throw ex;				
			
		}		
		if(amount > 0) {
			digitalWallet.setWalletBalance(digitalWallet.getWalletBalance() + amount);
		}else {
			TransactionException ex = new TransactionException();
			ex.setErrorCode(TransactionException.INVALID_AMOUNT);
			ex.setMessage(INVALID_AMOUNT_MESSAGE);
			throw ex;
		}
	}

	public void payMoney(DigitalWallet digitalWallet, int amount) throws TransactionException {
		if(null == digitalWallet.getUserAccessCode()) {
			TransactionException ex = new TransactionException();
			ex.setErrorCode(TransactionException.USER_NOT_AUTHORIZED);
			ex.setMessage(USER_NOT_AUTHORIZED_MESSAGE);
			throw ex;				
			
		}
		if(amount > 0) {
			if(digitalWallet.getWalletBalance() >= amount) {
				digitalWallet.setWalletBalance(digitalWallet.getWalletBalance() - amount);	
			}else {
				TransactionException ex = new TransactionException();
				ex.setErrorCode(TransactionException.INSUFFICIENT_BALANCE);
				ex.setMessage(INSUFFICIENT_BALANCE_MESSAGE);
				throw ex;				
			}
		}else {
			TransactionException ex = new TransactionException();
			ex.setErrorCode(TransactionException.INVALID_AMOUNT);
			ex.setMessage(INVALID_AMOUNT_MESSAGE);
			throw ex;
		}

	}

	public DigitalWalletTransaction() {
		super();
	}
}