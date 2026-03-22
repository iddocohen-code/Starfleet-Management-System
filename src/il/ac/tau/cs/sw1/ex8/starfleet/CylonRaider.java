package il.ac.tau.cs.sw1.ex8.starfleet;

import java.util.List;
import java.util.Set;

public class CylonRaider extends Fighter{
	private int BASE_ANNUAL_MAINTENANCE_COST = 3500;
	public CylonRaider(String name, int commissionYear, float maximalSpeed, Set<Cylon> crewMembers,
			List<Weapon> weapons) {
				super(name, commissionYear, maximalSpeed, crewMembers, weapons);
	}


	@Override
	public int getAnnualMaintenanceCost(){
		int res = BASE_ANNUAL_MAINTENANCE_COST;
		res += this.getAnnualMaintenanceCost_OfWeapons();
		res += this.getCrewMembers().size() * 500;
		res += (int)(1200 * this.getMaximalSpeed());

		return res;
	}

}
