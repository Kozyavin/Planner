public class Epic extends Task {   //задача с подзадачами
    private String[] subtasks; //массив из подзадач

    public Epic(int id, String[] subtasks) {
        super(id); // вызов родительского конструктора
        this.subtasks = subtasks; // заполнение своих полей
    }

    @Override
    public boolean matches(String query) {
        for (String sub : subtasks) {
            if (sub.contains(query)) {
                return true;
            }
        }
        return false;
    }

    public String[] getTitle() {
        return subtasks;
    }
}

