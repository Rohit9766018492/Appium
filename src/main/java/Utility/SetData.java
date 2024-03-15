package Utility;

public class SetData {

    public String name;
    public String lastName;

    public int accountNo;

    public static SetData get()
    {
        return new SetData();
    }

    public String getName()
    {
        return name;
    }

    public SetData setName(String name)
    {
        this.name=name;
        return this;
    }
}
