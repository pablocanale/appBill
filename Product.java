package ar.pablocanale.appbills.domain;

public class Product {
    private int code;
    private String name;
    private float price;
    private static int lastCode;

    public Product() {
        this.code = ++lastCode;
    }

    public float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
