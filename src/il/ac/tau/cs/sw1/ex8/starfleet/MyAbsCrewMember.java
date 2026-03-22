package il.ac.tau.cs.sw1.ex8.starfleet;

import java.util.Objects;

public abstract class MyAbsCrewMember implements CrewMember{
    protected final String name;
    protected final int age;
    protected final int yearsInService;

    public MyAbsCrewMember(int age, int yearsInService, String name){
        this.name = name;
        this.age = age;
        this.yearsInService = yearsInService;
    }

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public int getAge(){
        return this.age;
    }

    @Override
    public int getYearsInService(){
        return this.yearsInService;
    }

    @Override
    public boolean equals(Object obj){
        if (obj == this) return true;
        if (!(obj instanceof MyAbsCrewMember)) return false;
        MyAbsCrewMember other = (MyAbsCrewMember)obj;
        boolean res = this.name.equals(other.getName());
        return res;
    }

    @Override
    public int hashCode(){
        return Objects.hashCode(this.name);
    }

    @Override
    public String toString(){
		return this.getClass().getSimpleName() +
          "\n \tName=" + getName() +
            "\n \tשAge=" + getAge() +
             "\n \tYearsInService=" + getYearsInService();
	}

    

}


