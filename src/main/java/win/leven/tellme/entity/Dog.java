package win.leven.tellme.entity;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 * Created by Leven on 2017/5/22.
 */
public class Dog
{
    @Size(min = 2,max = 4)
    private String name;
    
    @Min(value = 5)
    private int age;
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public int getAge()
    {
        return age;
    }
    
    public void setAge(int age)
    {
        this.age = age;
    }
}
