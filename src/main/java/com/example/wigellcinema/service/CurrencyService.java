package com.example.wigellcinema.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CurrencyService {

    @Autowired
    @Qualifier("plainRestTemplate")
    private RestTemplate restTemplate;

    private static final double SEK_TO_EUR_RATE = 0.098;
    public double convertToEur(double amountInSek) {
        return amountInSek * SEK_TO_EUR_RATE;
    }

       public static class ConversionResponse {
        private Rates rates;

        // Getter and Setter
        public Rates getRates() {
            return rates;
        }

        public void setRates(Rates rates) {
            this.rates = rates;
        }
    }

    public static class Rates {
        private double EUR;

        // Getter and Setter
        public double getEUR() {
            return EUR;
        }

        public void setEUR(double EUR) {
            this.EUR = EUR;
        }
    }
}