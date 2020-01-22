public class Item {
    private String day;
    private String start;
    private String end;
    private String shortcut;
    private String name;
    private String type;
    private String room;
    private String teacher;

    public Item() {}

    public Item(String day, String start, String end, String shortcut, String name, String type, String room, String teacher) {
        this.day = day;
        this.start = start;
        this.end = end;
        this.shortcut = shortcut;
        this.name = name;
        this.type = type;
        this.room = room;
        this.teacher = teacher;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public void setShortcut(String shortcut) {
        this.shortcut = shortcut;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getDay() {
        return day;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    public String getShortcut() {
        return shortcut;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getRoom() {
        return room;
    }

    public String getTeacher() {
        return teacher;
    }

    public String getByIndex(int index){
        switch (index){
            case 0:
                return getDay();
            case 1:
                return getStart();
            case 2:
                return getEnd();
            case 3:
                return getShortcut();
            case 4:
                return getName();
            case 5:
                return getType();
            case 6:
                return getRoom();
            case 7:
                return getTeacher();
            default:
                return null;
        }
    }

    @Override
    public String toString() {
        return "Item{" +
                "day='" + day + '\'' +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", shortcut='" + shortcut + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", room='" + room + '\'' +
                ", teacher='" + teacher + '\'' +
                '}';
    }
}
