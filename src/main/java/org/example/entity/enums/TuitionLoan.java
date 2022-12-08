package org.example.entity.enums;

public enum TuitionLoan {
    MAGHTA1("1300"),//مقطع یک
    MAGHTA2("2600"),//مقطع دو
    MAGHTA3("65000");//مقطع سه
    private String action;

    public String getAction() {
        return this.action;
    }

    private TuitionLoan(String action) {
        this.action = action;
    }
}
