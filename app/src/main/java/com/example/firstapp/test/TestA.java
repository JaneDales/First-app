package com.example.firstapp.test;

public class TestA implements ITestC {

    public void onCreate() {
        TestB testB = new TestB();
        testB.foo(this);
    }

    @Override
    public void doSomething() {
        System.out.println("doSomething called");
    }
}
