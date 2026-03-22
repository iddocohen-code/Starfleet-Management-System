package il.ac.tau.cs.sw1.ex8.starfleet;

import java.util.List;
import java.util.Set;

public class ColonialViper  extends Fighter{

	private final int BASE_ANNUAL_MAINTENANCE_COST = 4000;
	public ColonialViper(String name, int commissionYear, float maximalSpeed, Set<CrewWoman> crewMembers,
			List<Weapon> weapons) {
				super(name, commissionYear, maximalSpeed, crewMembers, weapons);
	}

	@Override
	public int getAnnualMaintenanceCost(){
		int res = BASE_ANNUAL_MAINTENANCE_COST;
		res += this.getAnnualMaintenanceCost_OfWeapons();
		res += this.getCrewMembers().size() * 500;
		res += (int)(500 * this.getMaximalSpeed());

		return res;
	}
}
