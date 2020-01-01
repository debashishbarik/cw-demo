package com.debashish.aop.demoaopparent.service;

public class CoreService implements CoreServiceI {


    @Override
    public void msg() {
        System.out.println("msg method invoked");
    }

    @Override
    public int m() {
        System.out.println("m method invoked");
        return 2;
    }

    @Override
    public int k() {
        System.out.println("k method invoked");
        return 3;
    }
}
