package РаботаВКласе;

class Task {
    public void run() {
        System.out.println("Какая-то задача выполняется...");
    }
}

class DevTask extends Task {
    @Override
    public void run() {
        System.out.println("Пишем код...");
    }
}

class DesignTask extends Task {
    @Override
    public void run() {
        System.out.println("Рисуем макет...");
    }
}

public class Main1 {
    public static void main(String[] args) {
        Task t1 = new DevTask();
        Task t2 = new DesignTask();

        t1.run();
        t2.run();
    }
}


