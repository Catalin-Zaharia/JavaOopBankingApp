package service;

import model.Currency;

public class CurrencyService {

    private static CurrencyService single_instance =null;

    private CurrencyService(){}

    public static CurrencyService getInstance()
    {
        if (single_instance == null)
            single_instance = new CurrencyService();

        return single_instance;
    }
    
    public  double convertCurrency(double amount, Currency fromCurrency, Currency toCurrency){
        return amount*fromCurrency.getExchangeRate()/toCurrency.getExchangeRate();
    }


}
