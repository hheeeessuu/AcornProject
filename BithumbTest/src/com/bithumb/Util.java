package com.bithumb;

public class Util {
	// Public API
	// bithumb 거래소 마지막 거래 정보
	public static final String BITHUMB_TICKER = "https://api.bithumb.com/public/ticker/";
	// bithumb 거래소 판/구매 등록 대기 또는 거래 중 내역 정보
	public static final String BITHUMB_ORDERBOOK = "https://api.bithumb.com/public/orderbook/";
	// bithumb 거래소 거래 체결 완료 내역
	public static final String BITHUMB_TRANSACTION_HISTORY = "https://api.bithumb.com/public/transaction_history/";

	// currency
	public static final String[] BITHUMB_CURRENCY = { "BTC", "ETH", "DASH", "LTC", "ETC", "XRP", 
			"BCH", "XMR", "ZEC", "QTUM", "BTG", "EOS", "ICX", "VEN", "TRX", "ELF", "MITH", 
			"MCO", "OMG", "KNC", "GNT", "HSR", "ZIL", "ETHOS", "PAY", "WAX", "POWR", "LRC", 
			"GTO", "STEEM", "STRAT", "ZRX", "REP", "AE", "XEM", "SNT", "ADA"};
	public static final String BITHUMB_ALL = "ALL";
	
	public static final String UPBIT = "https://api.upbit.com/v1/market/all";
}
