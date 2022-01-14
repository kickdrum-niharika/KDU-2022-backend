class Credentials
{
    private String name="";
    private int age=0;
    static Credentials instance = null;

    private Credentials(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    void display()
    {
        System.out.println("Name: "+name);
        System.out.println("Age: "+age);
    }

    static public Credentials getInstance(String name, int age)
    {
        if(instance==null)
        {
            instance = new Credentials(name,age);
        }
        return instance;
    }


}
