package learn.foraging.models;

import java.math.BigDecimal;

public class CategoryValue {
    private Category category;
    private BigDecimal value;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public BigDecimal getDollarPerKilogram() {
        return value;
    }

    public void addDollarPerKilogram(BigDecimal dollarPerKilogram) {this.value.add(dollarPerKilogram);}
}
