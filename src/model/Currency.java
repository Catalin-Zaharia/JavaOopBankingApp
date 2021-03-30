package model;

public class Currency {
    
    private String name;
    private String code;
    private double exchangeRate;
    
    public Currency(String name, String code, double rate){
        this.name=name;
        this.code=code;
        this.exchangeRate = rate;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getCode() {
        return code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCode(String code) {
        this.code = code;
    }

}
