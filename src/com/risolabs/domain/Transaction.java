package com.risolabs.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created by @mriso_dev on 25/08/17
 */
public class Transaction {

    private final Integer operation;
    private final LocalDateTime datetime;
    private final BigDecimal value;

    public Transaction(Integer operation, LocalDateTime datetime, BigDecimal value) {
        this.operation = operation;
        this.datetime = datetime;
        this.value = value;
    }

    public Integer getOperation() {
        return operation;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public BigDecimal getValue() {
        return value;
    }

}
