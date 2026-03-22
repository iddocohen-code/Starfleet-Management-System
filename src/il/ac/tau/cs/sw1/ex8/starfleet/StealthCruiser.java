package il.ac.tau.cs.sw1.ex8.starfleet;


import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class StealthCruiser extends Fighter{
	private static int stealthCruiser_instanceCount = 0;

	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
		stealthCruiser_instanceCount++;
	}

	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers){
		super(name, commissionYear, maximalSpeed, crewMembers, Arrays.asList(new Weapon("Laser Cannons",10,100)));
		stealthCruiser_instanceCount++;
	}

	@Override
	public int getAnnualMaintenanceCost(){
		int res = super.getAnnualMaintenanceCost();
		res += 50 * stealthCruiser_instanceCount;

		return res;
	}
}
