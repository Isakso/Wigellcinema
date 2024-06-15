package com.example.wigellcinema.service;

import com.example.wigellcinema.models.CurrencyConversion;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import java.util.Currency;

public class paymentService implements paymentServiceInterface {

    @Value("${external.currency.api.url}")
    private String currencyApiUrl;
    @Override
    public double convertCurrency(double amount, Currency fromCurrency, Currency toCurrency) {
        String apiUrl = String.format("%s?amount=%.2f&from=%s&to=%s", currencyApiUrl, amount, fromCurrency, toCurrency);

        RestTemplate restTemplate = new RestTemplate();
        CurrencyConversion.CurrencyConversionResult result = restTemplate.getForObject(apiUrl, CurrencyConversion.CurrencyConversionResult.class);

        if (result != null && result.isSuccess()) {
            return result.getConvertedAmount();
        } else {
            throw new RuntimeException("Failed to convert currency");
        }
    }
}
