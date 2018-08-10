package com.dto;

public class BithumbDTO {

	private String bithumb_pk;
	private String bithumb_date;
	private String currency;
	private long opening_price;
	private long closing_price;
	private long min_price;
	private long max_price;
	private double average_price;
	private double units_traded;
	private double volume_1day;
	private double volume_7day;
	private long buy_price;
	private long sell_price;
	private long fluctate_24H;
	private double fluctate_rate_24H;
	
	public BithumbDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BithumbDTO(String bithumb_pk, String bithumb_date, String currency, long opening_price, long closing_price,
			long min_price, long max_price, double average_price, double units_traded, double volume_1day,
			double volume_7day, long buy_price, long sell_price, long fluctate_24h, double fluctate_rate_24H) {
		super();
		this.bithumb_pk = bithumb_pk;
		this.bithumb_date = bithumb_date;
		this.currency = currency;
		this.opening_price = opening_price;
		this.closing_price = closing_price;
		this.min_price = min_price;
		this.max_price = max_price;
		this.average_price = average_price;
		this.units_traded = units_traded;
		this.volume_1day = volume_1day;
		this.volume_7day = volume_7day;
		this.buy_price = buy_price;
		this.sell_price = sell_price;
		fluctate_24H = fluctate_24h;
		this.fluctate_rate_24H = fluctate_rate_24H;
	}
	
	public String getBithumb_pk() {
		return bithumb_pk;
	}

	public void setBithumb_pk(String bithumb_pk) {
		this.bithumb_pk = bithumb_pk;
	}

	public String getBithumb_date() {
		return bithumb_date;
	}

	public void setBithumb_date(String bithumb_date) {
		this.bithumb_date = bithumb_date;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public long getOpening_price() {
		return opening_price;
	}

	public void setOpening_price(long opening_price) {
		this.opening_price = opening_price;
	}

	public long getClosing_price() {
		return closing_price;
	}

	public void setClosing_price(long closing_price) {
		this.closing_price = closing_price;
	}

	public long getMin_price() {
		return min_price;
	}

	public void setMin_price(long min_price) {
		this.min_price = min_price;
	}

	public long getMax_price() {
		return max_price;
	}

	public void setMax_price(long max_price) {
		this.max_price = max_price;
	}

	public double getAverage_price() {
		return average_price;
	}

	public void setAverage_price(double average_price) {
		this.average_price = average_price;
	}

	public double getUnits_traded() {
		return units_traded;
	}

	public void setUnits_traded(double units_traded) {
		this.units_traded = units_traded;
	}

	public double getVolume_1day() {
		return volume_1day;
	}

	public void setVolume_1day(double volume_1day) {
		this.volume_1day = volume_1day;
	}

	public double getVolume_7day() {
		return volume_7day;
	}

	public void setVolume_7day(double volume_7day) {
		this.volume_7day = volume_7day;
	}

	public long getBuy_price() {
		return buy_price;
	}

	public void setBuy_price(long buy_price) {
		this.buy_price = buy_price;
	}

	public long getSell_price() {
		return sell_price;
	}

	public void setSell_price(long sell_price) {
		this.sell_price = sell_price;
	}

	public long getFluctate_24H() {
		return fluctate_24H;
	}

	public void setFluctate_24H(long fluctate_24h) {
		fluctate_24H = fluctate_24h;
	}

	public double getFluctate_rate_24H() {
		return fluctate_rate_24H;
	}

	public void setFluctate_rate_24H(double fluctate_rate_24H) {
		this.fluctate_rate_24H = fluctate_rate_24H;
	}
	
	@Override
	public String toString() {
		return "BithumbDTO [bithumb_pk=" + bithumb_pk + ", bithumb_date=" + bithumb_date + ", currency=" + currency
				+ ", opening_price=" + opening_price + ", closing_price=" + closing_price + ", min_price=" + min_price
				+ ", max_price=" + max_price + ", average_price=" + average_price + ", units_traded=" + units_traded
				+ ", volume_1day=" + volume_1day + ", volume_7day=" + volume_7day + ", buy_price=" + buy_price
				+ ", sell_price=" + sell_price + ", fluctate_24H=" + fluctate_24H + ", fluctate_rate_24H="
				+ fluctate_rate_24H + "]";
	}
}
