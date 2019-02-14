package com.zl.config;

import java.util.Base64;

public enum Enabled {
    DISABLED(1),
    ENABLED(2);

    private int value;

    Enabled(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
