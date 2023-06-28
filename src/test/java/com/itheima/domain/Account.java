package com.itheima.domain;

/**
 * @BelongsProject: SpringNew
 * @BelongsPackage: com.itheima.domain
 * @Author: ASUS
 * @CreateTime: 2023-06-27  08:58
 * @Description: TODO
 * @Version: 1.0
 */
public class Account {
    private String name;
    private double money;

    public Account(String name, double money) {
        this.name = name;
        this.money = money;
    }

    public Account() {
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", money=" + money +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
