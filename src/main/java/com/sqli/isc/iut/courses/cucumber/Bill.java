package com.sqli.isc.iut.courses.cucumber;

import java.util.ArrayList;

public class Bill extends ArrayList<Cocktail> {

    public float value() {
        return this.stream()
            .map(Cocktail::getPrice)
            .reduce(0f, Float::sum);
    }

    public float pay() {
        this.clear();
        return this.value();
    }
}
