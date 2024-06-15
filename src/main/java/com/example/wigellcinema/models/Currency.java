package com.example.wigellcinema.models;

public enum Currency {
    EUR("Euro"),
    SEK("Swedish Krona");
    private final String displayName;
    Currency(String displayName) {
        this.displayName = displayName;
    }
    public String getDisplayName() {
        return displayName;
    }
}
