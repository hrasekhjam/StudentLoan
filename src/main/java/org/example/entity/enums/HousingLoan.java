package org.example.entity.enums;

public enum HousingLoan {
    TEHRAN("32000"),//شهر تهران
    METROPOLICE("26000"),//کلان شهر
    OTHER("19500");//سایر شهرها
    private String action;

    public String getAction() {
        return this.action;
    }

    private HousingLoan(String action) {
        this.action = action;
    }
}
