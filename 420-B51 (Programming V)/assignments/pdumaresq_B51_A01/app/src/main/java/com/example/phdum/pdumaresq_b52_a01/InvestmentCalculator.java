package com.example.phdum.pdumaresq_b52_a01;

public class InvestmentCalculator implements java.io.Serializable {
    /*
    * Instance Variables
    */
    private double presentValue;
    private double futureValue;
    private double interestRate;
    private int timeInvested;
    private int compoundFrequency;
    private int timesCompounded;

    private Double pv;
    private Double fv;


    /*
    * Constructors
    */
    public InvestmentCalculator() {
        this.presentValue = 0.0;
        this.futureValue = 0.0;
        this.interestRate = 0.0;
        this.timeInvested = 0;
        this.compoundFrequency = 0;
        this.timesCompounded = 0;
    }

    public InvestmentCalculator(double _presentValue, double _futureValue, double _interestRate, int _timeInvested, int _compoundFrequency) {
        this.presentValue = _presentValue;
        this.futureValue = _futureValue;
        this.interestRate = _interestRate;
        this.timeInvested = _timeInvested;
        this.compoundFrequency = _compoundFrequency;
        this.timesCompounded = this.compoundFrequency * this.timeInvested;
    }

    /*
    * Accessor methods
    */
    public double getPresentValue() {
        return presentValue;
    }

    public double getFutureValue() {
        return futureValue;
    }

    public int getTimeInvested() {
        return this.timeInvested;
    }

    public int getCompoundFrequency() {
        return this.compoundFrequency;
    }

    public double getInterestRate() {
        return this.interestRate;
    }
}

