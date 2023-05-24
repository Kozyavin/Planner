import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TodosTest {
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
    public void PositiveSearchTest() {
        TodosManager todos = new TodosManager();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask};
        Task[] actual = todos.search("Позвонить");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void NegativeSearchTest() {
        TodosManager todos = new TodosManager();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = new Task[0];
        Task[] actual = todos.search("У памятника");
        Assertions.assertArrayEquals(expected, actual);
    }

}
