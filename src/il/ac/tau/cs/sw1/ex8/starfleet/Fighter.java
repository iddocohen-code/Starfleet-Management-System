package il.ac.tau.cs.sw1.ex8.starfleet;

import java.util.List;
import java.util.Set;

public class Fighter extends MyFightingShip{
	protected final int BASE_ANNUAL_MAINTENANCE_COST = 2500;
	
	public Fighter(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers, List<Weapon> weapons){
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
	}

	@Override
	public int getAnnualMaintenanceCost(){
		int res = this.BASE_ANNUAL_MAINTENANCE_COST;
		res += this.getAnnualMaintenanceCost_OfWeapons();
		res += 1000 * this.maximalSpeed;

		return (int)(res);
	}
	
}
