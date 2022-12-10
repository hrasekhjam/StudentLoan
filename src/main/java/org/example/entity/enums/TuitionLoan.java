package org.example.entity.enums;

public enum TuitionLoan {
    MAGHTA1("1300000"),//مقطع یک
    MAGHTA2("2600000"),//مقطع دو
    MAGHTA3("65000000");//مقطع سه
    private String action;

    public String getAction() {
        return this.action;
    }

    private TuitionLoan(String action) {
        this.action = action;
    }
}
