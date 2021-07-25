package ar.pablocanale.appbills.domain;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Bill {
    private int id;
    private String description;
    private Date date;
    private Client client;
    private int indexItems;
    public static final int MAX_ITEMS = 12;
    private static int lastId;

    public static int getLastId() {
        return lastId;
    }


    public ItemBill[] getItems() {
        return items;
    }

    public void setItems(ItemBill[] items) {
        this.items = items;
    }

    private ItemBill[] items;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Client getClient() {
        return client;
    }


    public void setClient(Client client) {

        this.client = client;
    }

    public void setClient(Client client, String description) {
        this.description = description;
        this.client = client;
        this.items = new ItemBill[MAX_ITEMS];
        this.id = ++lastId;
        this.date = new Date();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addItemBill(ItemBill item) {
        if (indexItems < MAX_ITEMS)
            this.items[indexItems++] = item;
    }

    public float total() {
        float total = 0.0f;
        for (ItemBill item : this.items) {
            if (item == null)
                continue;
            total += item.calcImport();
        }
        return total;
    }

    public String generateDetail() {
        StringBuilder sb = new StringBuilder("Factura N°:");
        sb.append(id)
                .append("\nCliente: ")
                .append(this.client.getName())
                .append("\t CUIT: ")
                .append(client.getCuit())
                .append("\n Description: ").append(this.description)
                .append("\n")
                .append("\n#\tNombre\t$\tCant.\tTotal\n");

        SimpleDateFormat df = new SimpleDateFormat("dd/ MMMM/ yyyy");
        sb.append("Fecha Emision: ")
                .append(df.format(this.date))
                .append("\n");

        for(ItemBill item: this.items){
            if(item == null){
                continue;
            }
            sb.append(item.getProduct().getCode())
                    .append("\t")
                    .append(item.getProduct().getName())
                    .append("\t")
                    .append(item.getProduct().getPrice())
                    .append("\t")
                    .append(item.getAmount())
                    .append("\t")
                    .append(item.calcImport())
                    .append("\n");
        }
        sb.append("\nTOTAL: ")
                .append(total());
        return sb.toString();
    }

}

