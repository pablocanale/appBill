package ar.pablocanale.appbills.domain;

public class ItemBill {
    private int amount;
    private Product product;

    public ItemBill(int amount, Product product) {
        this.amount = amount;
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float calcImport() {
        return this.amount * this.product.getPrice();
    }
}
