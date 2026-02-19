package РаботаВКласе;

public class ComparableIntrface {
    public static void main(String[] args){
        Product product1 = new Product(5);
        Product product2 = new Product(5);
        Product product3 = new Product(10);

        boolean r = product1.price == product2.price;
//        boolean r = product1 == product3;
        System.out.println(r);

//        boolean e = product1.equals(product2);
//        System.out.println(e);
//
//        System.out.println("product1: " + product1.getPrice());
//        System.out.println("product2: " + product2.getPrice());
//        System.out.println("product3: " + product3.getPrice());


        System.out.println(product1 == product2);

        System.out.println(product1.equals(product2));
        System.out.println(product1.equals(product3 ));

        System.out.println(product1.price == product2.price);
        System.out.println(product1.price == product3.price);
    }
}
//продемонстрировать пример 2 объектов чем они должны отличаться, что необходимо делать при сравнение 2 объектов 2 try 2 false