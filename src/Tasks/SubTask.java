package Tasks;

public class SubTask extends Base {
    private boolean isCompleted = false;

    public SubTask(String title) {
        super(title);
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    @Override
    public String toString() {
        String statusMarker = isCompleted ? "[-]" : "[ ]";
        return String.format("  |__%s %-20s (SubTask)", statusMarker, title);
    }
}










//ладно забыли, Polymorph не было
//у каждого таска есть стоимость за ее выполнение, нам нужно интерфейс который реализует стоимость таска
//нужно добавить новый конкретный главный класс или абстрактный класс и от него будет наследовать следующий класс master
//Вопрос: может быть ещё один master

//принцепы solid нужно соблюдать, нужно доваить клиента
//1 шаг поле мани кто отдаёт кто-то получает (кошелёк)
//2 шаг в классе клиент держать
//отдал мастеру задачу и не запоминал её