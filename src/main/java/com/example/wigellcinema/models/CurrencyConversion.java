package com.example.wigellcinema.models;

public class CurrencyConversion {
    public class CurrencyConversionResult {
        private boolean success;
        private double convertedAmount;

        // Getters and setters
        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public double getConvertedAmount() {
            return convertedAmount;
        }

        public void setConvertedAmount(double convertedAmount) {
            this.convertedAmount = convertedAmount;
        }
    }
}
