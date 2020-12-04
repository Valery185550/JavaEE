
package classes;

public class Agent {
    
    private String id;
    private String name;
    private String age;
    private String procent;
    private String experience;
    
    public String getId()
    {
        return id;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getAge()
    {
        return age;
    }
    
    public String getProcent()
    {
        return procent;
    }
    
    public String getExperience()
    {
        return experience;
    }
    
    public Agent()
    {
        
    }
    public Agent(String id, String name, String age, String procent, String experience)
    {
        this.id=id;
        this.name=name;
        this.age=age;
        this.procent=procent;
        this.experience=experience;
    }
    
    
}
