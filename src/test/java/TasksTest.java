import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TasksTest {

    SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");//простая задача
    String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
    Epic epic = new Epic(55, subtasks);//задача из подзадач

    Meeting meeting = new Meeting(//номер,тема, проект,дата
            555,
            "Выкатка 3й версии приложения",
            "Приложение НетоБанка",
            "Во вторник после обеда"
    );

    @Test
    public void PositiveSimpleTaskTest() {
        TodosManager task = new TodosManager();

        task.add(simpleTask);

        boolean expected = true;
        boolean actual = simpleTask.matches("Позвонить");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void NegativeSimpleTaskTest() {
        TodosManager task = new TodosManager();

        task.add(simpleTask);

        boolean expected = false;
        boolean actual = simpleTask.matches("Пазвонить");//Ошибка "пАзванить"
        Assertions.assertEquals(expected, actual);
    }

    //////////////////////////////
    @Test
    public void PositiveMeetingTest() {
        TodosManager task = new TodosManager();

        task.add(meeting);

        boolean expected = true;
        boolean actual = meeting.matches("НетоБанк");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void NegativeMeetingTest() {
        TodosManager task = new TodosManager();

        task.add(meeting);
        //todos.add(epic);
        //todos.add(meeting);

        boolean expected = false;
        boolean actual = meeting.matches("Нетабанк");// Ошибка "НетАбанк"
        Assertions.assertEquals(expected, actual);
    }

    //////////////////////////////////////////
    @Test
    public void PositiveEpicTest() {
        TodosManager task = new TodosManager();

        task.add(epic);

        boolean expected = true;
        boolean actual = epic.matches("Молоко");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void NegativeEpicTest() {
        TodosManager task = new TodosManager();

        task.add(epic);
        //todos.add(epic);
        //todos.add(meeting);

        boolean expected = false;
        boolean actual = epic.matches("Батон");//Батона нет в списке подзадач
        Assertions.assertEquals(expected, actual);
    }
}
