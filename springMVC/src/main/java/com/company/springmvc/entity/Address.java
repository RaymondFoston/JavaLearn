package com.company.springmvc.entity;

public class Address {
    private String street;
    private String  province;

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", province='" + province + '\'' +
                '}';
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
