package EXAMMIDMONTH;

public class Product {
   int id ;
    String NAME;
    int QUANTITY;
    String BRAND;

    public int getid() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public int getQUANTITY() {
        return QUANTITY;
    }

    public void setQUANTITY(int QUANTITY) {
        this.QUANTITY = QUANTITY;
    }

    public String getBRAND() {
        return BRAND;
    }

    public void setBRAND(String BRAND) {
        this.BRAND = BRAND;
    }

    public Product(int ID, String NAME, int QUANTITY, String BRAND) {
        this.id = ID;
        this.NAME = NAME;
        this.QUANTITY = QUANTITY;
        this.BRAND = BRAND;
    }

    @Override
    public String toString() {
        return "Product{" +
                "ID=" + id +
                ", NAME='" + NAME + '\'' +
                ", QUANTITY=" + QUANTITY +
                ", BRAND='" + BRAND + '\'' +
                '}';
    }
}
