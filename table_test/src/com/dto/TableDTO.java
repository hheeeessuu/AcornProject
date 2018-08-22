package com.dto;

public class TableDTO {

	 private String bithumb_pk;
	 private String bithumb_date;
	 private String currency;
	 private int opening_price;
	 private int closing_price;
	 private int min_price;
	 private int max_price;
	 private int average_price;
	 private int units_traded;
	 private int volume_1day;
	 private int volume_7day;
	 private int buy_price;
	 private int sell_price;
	 private int fluctate_24h;
	 private int fluctate_rate_24h;
	
	public TableDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TableDTO(String bithumb_pk, String bithumb_date, String currency, int opening_price, int closing_price,
			int min_price, int max_price, int average_price, int nuits_traded, int volume_1day, int volume_7day,
			int buy_price, int sell_price, int fluctate_24h, int fluctate_rate_24h) {
		super();
		this.bithumb_pk = bithumb_pk;
		this.bithumb_date = bithumb_date;
		this.currency = currency;
		this.opening_price = opening_price;
		this.closing_price = closing_price;
		this.min_price = min_price;
		this.max_price = max_price;
		this.average_price = average_price;
		this.units_traded = nuits_traded;
		this.volume_1day = volume_1day;
		this.volume_7day = volume_7day;
		this.buy_price = buy_price;
		this.sell_price = sell_price;
		this.fluctate_24h = fluctate_24h;
		this.fluctate_rate_24h = fluctate_rate_24h;
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

	public int getOpening_price() {
		return opening_price;
	}

	public void setOpening_price(int opening_price) {
		this.opening_price = opening_price;
	}

	public int getClosing_price() {
		return closing_price;
	}

	public void setClosing_price(int closing_price) {
		this.closing_price = closing_price;
	}

	public int getMin_price() {
		return min_price;
	}

	public void setMin_price(int min_price) {
		this.min_price = min_price;
	}

	public int getMax_price() {
		return max_price;
	}

	public void setMax_price(int max_price) {
		this.max_price = max_price;
	}

	public int getAverage_price() {
		return average_price;
	}

	public void setAverage_price(int average_price) {
		this.average_price = average_price;
	}

	public int getUnits_traded() {
		return units_traded;
	}

	public void setUnits_traded(int units_traded) {
		this.units_traded = units_traded;
	}

	public int getVolume_1day() {
		return volume_1day;
	}

	public void setVolume_1day(int volume_1day) {
		this.volume_1day = volume_1day;
	}

	public int getVolume_7day() {
		return volume_7day;
	}

	public void setVolume_7day(int volume_7day) {
		this.volume_7day = volume_7day;
	}

	public int getBuy_price() {
		return buy_price;
	}

	public void setBuy_price(int buy_price) {
		this.buy_price = buy_price;
	}

	public int getSell_price() {
		return sell_price;
	}

	public void setSell_price(int sell_price) {
		this.sell_price = sell_price;
	}

	public int getFluctate_24h() {
		return fluctate_24h;
	}

	public void setFluctate_24h(int fluctate_24h) {
		this.fluctate_24h = fluctate_24h;
	}

	public int getFluctate_rate_24h() {
		return fluctate_rate_24h;
	}

	public void setFluctate_rate_24h(int fluctate_rate_24h) {
		this.fluctate_rate_24h = fluctate_rate_24h;
	}

	@Override
	public String toString() {
		return "TableDTO [bithumb_pk=" + bithumb_pk + ", bithumb_date=" + bithumb_date + ", currency=" + currency
				+ ", opening_price=" + opening_price + ", closing_price=" + closing_price + ", min_price=" + min_price
				+ ", max_price=" + max_price + ", average_price=" + average_price + ", units_traded=" + units_traded
				+ ", volume_1day=" + volume_1day + ", volume_7day=" + volume_7day + ", buy_price=" + buy_price
				+ ", sell_price=" + sell_price + ", fluctate_24h=" + fluctate_24h + ", fluctate_rate_24h="
				+ fluctate_rate_24h + "]";
	}


}
