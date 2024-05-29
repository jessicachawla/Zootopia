package org.example.classes;

public class Discount implements applyDiscount{

    private final Category _category;

    public Category getCategory() {
        return _category;
    }

    public double getDiscountPercentage() {
        return _discountPercentage;
    }


    private final int _discountPercentage;

    public String getDiscountCode() {
        return discountCode;
    }

    private final String discountCode;

    public Discount(Category _category, int _discount) {
        this._category = _category;
        this._discountPercentage = _discount;
        this.discountCode = _category.name()+_discount;
    }

    @Override
    public Double apply(Double basevalue) {
        return basevalue - ((basevalue * _discountPercentage) / 100);
    }
}
