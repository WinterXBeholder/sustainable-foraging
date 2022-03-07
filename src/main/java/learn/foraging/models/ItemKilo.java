package learn.foraging.models;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ItemKilo {
    private Item item;
    private double kilograms = 0;

    public ItemKilo(Item item, double kilograms) {
        this.item = item;
        this.addKilograms(kilograms);
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public double getKilograms() {
        return kilograms;
    }

    public void addKilograms(double kilograms) {
        this.kilograms += kilograms;
    }

    public BigDecimal getValue() {
        if (item == null || item.getDollarPerKilogram() == null) {
            return BigDecimal.ZERO;
        }
        BigDecimal kilos = new BigDecimal(kilograms).setScale(4, RoundingMode.HALF_UP);
        return item.getDollarPerKilogram().multiply(kilos);
    }
}
