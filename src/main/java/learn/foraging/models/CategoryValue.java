package learn.foraging.models;

import java.math.BigDecimal;

public class CategoryValue {
    private Category category;
    private BigDecimal value = BigDecimal.ZERO;

    public CategoryValue(Category category, BigDecimal value) {
        this.category = category;
        this.addValue(value);
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void addValue(BigDecimal value) {this.value = this.value.add(value);}
}
