package com.example.InsurancePremiumCalculator.validation;

import com.example.InsurancePremiumCalculator.exception.IncorrectlyEnteredDataException;

import java.math.BigDecimal;

public class RiskTypeFire implements RiskType {


    private final Long ID = 1L;
    private double coefficientFire;
    private InsuranceRiskType insuranceRiskType;
    private BigDecimal value;

    private final BigDecimal PREMIUM_DEFAULT_VALUE = new BigDecimal(100);

    // через конструктор приходит value (amount)
    public RiskTypeFire(BigDecimal value){
        this.value = value;
    }

    @Override
    public BigDecimal apply(BigDecimal value) {
        if (value.compareTo(BigDecimal.ZERO) < 0) {
            throw new IncorrectlyEnteredDataException("Value cannot be negative!");
        } else if (value.compareTo(PREMIUM_DEFAULT_VALUE) > 0) {
            setCoefficientFire(0.024);
        } else {
            setCoefficientFire(0.014);
        }

        return value.add(BigDecimal.valueOf(getCoefficientFire()));
    }

    public InsuranceRiskType getInsuranceRiskType() {
        return insuranceRiskType;
    }

    public void setInsuranceRiskType(InsuranceRiskType insuranceRiskType) {
        this.insuranceRiskType = insuranceRiskType;
    }

    public double getCoefficientFire() {
        return coefficientFire;
    }

    public void setCoefficientFire(double coefficientFire) {
        this.coefficientFire = coefficientFire;
    }

    public Long getID() {
        return ID;
    }


}
