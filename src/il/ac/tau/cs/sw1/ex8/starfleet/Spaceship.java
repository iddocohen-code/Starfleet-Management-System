package il.ac.tau.cs.sw1.ex8.starfleet;

import java.util.Set;

public interface Spaceship {
    public abstract String getName();
    public abstract int getCommissionYear();
    public abstract float getMaximalSpeed();
    public abstract int getFirePower();
    public abstract Set<? extends CrewMember> getCrewMembers();
    public abstract int getAnnualMaintenanceCost();
    public abstract int getNumOf_AllInstances();
}
