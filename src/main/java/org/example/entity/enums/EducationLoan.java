package org.example.entity.enums;

public enum EducationLoan {
    MAGHTA1("1900000"),//مقطع یک
    MAGHTA2("2250000"),//مقطع دو
    MAGHTA3("2600000");//مقطع سه
    private String action;

    public String getAction() {
        return this.action;
    }

    private EducationLoan(String action) {
        this.action = action;
    }
}
