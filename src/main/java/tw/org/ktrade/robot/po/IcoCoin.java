package tw.org.ktrade.robot.po;

import java.math.BigDecimal;
import java.util.Date;

public class IcoCoin {
    
	private BigDecimal bouns;

    private BigDecimal payCoin;

    private String date;
    
    private BigDecimal Receive;
    
    private String type;

	public BigDecimal getBouns() {
		return bouns;
	}

	public void setBouns(BigDecimal bouns) {
		this.bouns = bouns;
	}

	public BigDecimal getPayCoin() {
		return payCoin;
	}

	public void setPayCoin(BigDecimal payCoin) {
		this.payCoin = payCoin;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public BigDecimal getReceive() {
		return Receive;
	}

	public void setReceive(BigDecimal receive) {
		Receive = receive;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	

    
    

    
}