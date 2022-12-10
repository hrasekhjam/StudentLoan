package org.example.entity.enums;

public enum HousingLoan {
    TEHRAN("32000000"),//شهر تهران
    METROPOLIS("26000000"),//کلان شهر
    OTHER("19500000");//سایر شهرها
    private String action;

    public String getAction() {
        return this.action;
    }

    private HousingLoan(String action) {
        this.action = action;
    }
}
