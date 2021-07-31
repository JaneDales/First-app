package com.example.firstapp.test;

public class TestB {
    private ITestC iTestC;

    public void foo(ITestC iTestC) {
        this.iTestC = iTestC;
        this.iTestC.doSomething();
    }

}
