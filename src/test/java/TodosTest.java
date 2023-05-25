import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TodosTest {
    SimpleTask simpleTask = new SimpleTask(5, "Позвонить в НетоБанк");//простая задача

    String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
    Epic epic = new Epic(55, subtasks);//задача из подзадач

    Meeting meeting = new Meeting(//номер,тема, проект,дата
            555,
            "Выкатка 3й версии приложения",
            "Приложение НетоБанка",
            "Во вторник после обеда"
    );
@BeforeEach

    @Test
    public void PositiveSearchTest() {     //находим 1-у подходящую по запросу задачу
        TodosManager todos = new TodosManager();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask};
        Task[] actual = todos.search("Позвонить");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void NegativeSearchTest() {    //проверяем сценарий отсутствия разыскиваемой задачи
        TodosManager todos = new TodosManager();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = new Task[0];
        Task[] actual = todos.search("У памятника");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void SomeTaskSearchTest() {    //проверяем сценарий нахождения нескольких, подходящих под запрос задач
        TodosManager todos = new TodosManager();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask,meeting};
        Task[] actual = todos.search("НетоБанк");
        Assertions.assertArrayEquals(expected, actual);
    }

}
