public class User {
    String name;
    String surname;

    public User (String name, String surname)
    {
        this.name=name;
        this.surname=surname;
    }
    public User(){

    }


    public void SetName(String name)
    {
        this.name=name;
    }
    public void SetSurname(String surname)
    {
        this.surname=surname;
    }
    public String GetName()
    {
        return this.name;
    }
    public String GetSurname()
    {
        return this.surname;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
