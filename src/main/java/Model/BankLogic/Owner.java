package Model.BankLogic;

public class Owner {
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Owner (String name, String surname)
    {
        this.name = name;
        this.surname = surname;
    }

    private String name;
    private String surname;

    @Override
    public String toString() {
        return "Owner: " +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'';
    }

}
