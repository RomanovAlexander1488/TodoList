package Tasks;

public class Client extends Person {
    public Client(String id, String name) {
        super(id, name);
    }

    @Override
    public void doWork() {
        System.out.println("Клиент " + name + " делает заказ");
    }
}