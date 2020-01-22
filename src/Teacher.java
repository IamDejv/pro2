public class Teacher {
    private String firstname;
    private String lastname;
    private String firstTitle;
    private String lastTitle;
    private String id;

    public Teacher(String id, String firstname, String lastname, String firstTitle, String lastTitle) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.firstTitle = firstTitle;
        this.lastTitle = lastTitle;
        this.id = id;
    }

    public Teacher() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstTitle() {
        return firstTitle;
    }

    public void setFirstTitle(String firstTitle) {
        this.firstTitle = firstTitle;
    }

    public String getLastTitle() {
        return lastTitle;
    }

    public void setLastTitle(String lastTitle) {
        this.lastTitle = lastTitle;
    }

    public String getFullName(){
        return String.format("%s %s %s %s", firstTitle, firstname, lastname, lastTitle);
    }
}
