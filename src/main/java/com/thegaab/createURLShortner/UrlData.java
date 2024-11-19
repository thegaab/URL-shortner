package com.thegaab.createURLShortner;


public class UrlData {
    private String originalURL;
    private long expiryDate;

    public UrlData(String originalURL, long expiryDate) {
        this.originalURL = originalURL;
        this.expiryDate = expiryDate;
    }

    public String getOriginalURL() {
        return originalURL;
    }

    public void setOriginalURL(String originalURL) {
        this.originalURL = originalURL;
    }

    public long getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(long expiryDate) {
        this.expiryDate = expiryDate;
    }
}

