package il.ac.tau.cs.sw1.ex8.starfleet;

import java.util.HashMap;
import java.util.Objects;
import java.util.Set;

public abstract class MyAbsSpaceship implements Spaceship, Comparable<MyAbsSpaceship>{
    protected final String name;
    protected final int commissionYear;
    protected final float maximalSpeed;
    public final int BASIC_FIRE_POWER = 10;
    protected final Set<? extends CrewMember> crewMembers;
    private static final HashMap<String, Integer> numOf_AllInstances = new HashMap<>();
    

    public MyAbsSpaceship(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers){
        this.name = name;
        this.commissionYear = commissionYear;
        this.maximalSpeed = maximalSpeed;
        this.crewMembers = crewMembers;

        String currInstance = this.getClass().getSimpleName();
        if (!(MyAbsSpaceship.numOf_AllInstances.containsKey(currInstance))){
            MyAbsSpaceship.numOf_AllInstances.put(currInstance, 0);
        }
        int res = MyAbsSpaceship.numOf_AllInstances.put(currInstance, 0)+1;
        MyAbsSpaceship.numOf_AllInstances.put(currInstance, res);
    }

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public int getCommissionYear(){
        return this.commissionYear;
    }

    @Override
    public float getMaximalSpeed(){
        return this.maximalSpeed;
    }

    @Override
    public int getFirePower(){
        return this.BASIC_FIRE_POWER;
    }

    @Override
    public Set<? extends CrewMember> getCrewMembers(){
        return this.crewMembers;
    } 

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (!(obj instanceof MyAbsSpaceship)) return false;
        MyAbsSpaceship other = (MyAbsSpaceship) obj;
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
            "\n \tCommissionYear=" + getCommissionYear() +
             "\n \tMaximalSpeed=" + getMaximalSpeed() +
              "\n\tFirePower=" + getFirePower()+
               "\n\tCrewMembers=" + getCrewMembers().size()+
                "\n\tAnnualMaintenanceCost=" + getAnnualMaintenanceCost();
	}
    
    @Override
    public int compareTo(MyAbsSpaceship other){
        int first_comperator = Integer.compare(other.getFirePower(), this.getFirePower());
        int second_comperator = Integer.compare(other.getCommissionYear(), this.getCommissionYear());
        int third_comperator = this.name.compareTo(other.getName());
        if (first_comperator != 0){
            return first_comperator;
        }
        else{
            if (second_comperator != 0){
            return second_comperator;
            }
            else {
                return third_comperator;
            } 
        }
    }

    @Override
    public int getNumOf_AllInstances(){
        String currInstance = this.getClass().getSimpleName();
        return numOf_AllInstances.get(currInstance);
    }

}


