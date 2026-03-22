package il.ac.tau.cs.sw1.ex8.starfleet;

import java.util.List;
import java.util.Set;

public class Bomber extends MyFightingShip{

	private final int numberOfTechnicians;
	private final int BASE_ANNUAL_MAINTENANCE_COST = 5000;

	public Bomber(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons, int numberOfTechnicians){
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
		this.numberOfTechnicians = numberOfTechnicians;
	}

	@Override
	public int getAnnualMaintenanceCost(){
		int res = this.BASE_ANNUAL_MAINTENANCE_COST;
		res += (this.getAnnualMaintenanceCost_OfWeapons())*(1-0.1 * this.numberOfTechnicians);

		return (int)(res);
	}


	@Override
	public String toString() {
		return super.toString()	+ "\n\tNumberOfTechnicians=" + 5;
	}

}






