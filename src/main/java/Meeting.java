public class Meeting extends Task {   //назначенная встреча

    private String topic; //тема обсуждения
    private String project;//название проекта обсуждения
    private String start; //дата и время старта

    public Meeting(int id, String topic, String project, String start) {
        super(id); // вызов родительского конструктора
        this.topic = topic; // заполнение своих полей
        this.project = project; // заполнение своих полей
        this.start = start; // заполнение своих полей
    }

    @Override
    public boolean matches(String query) {
        if (topic.contains(query)) {
            return true;
        }
        if (project.contains(query)) {
            return true;
        }
        return false;
    }

    public String getTopic() {
        return topic;
    }

    public String getProject() {

        return project;
    }

    public String getStart() {

        return start;
    }
}

