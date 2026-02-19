package РаботаВКласе;

public class Product {
    int price;

    public Product(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        Product other = (Product) obj;
        return this.price == other.price;
//        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Product{" + "price" + price + '}';
    }

    public int getPrice() {
        return price;
    }
}
//