package oocamp;

public class NumberWithUnit implements Token{

    private int number;
    private Unit unit;

    public NumberWithUnit(int number, Unit unit ) {
        this.number = number;
        this.unit = unit;
    }

    public int getNumber() {
        return number;
    }

    public Unit getUnit() {
        return unit;
    }

}
