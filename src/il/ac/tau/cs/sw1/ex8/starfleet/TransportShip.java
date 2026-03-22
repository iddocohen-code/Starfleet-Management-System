package il.ac.tau.cs.sw1.ex8.starfleet;

import java.util.Set;

public class TransportShip extends MyCargoShip{
	private final int BASE_ANNUAL_MAINTENANCE_COST = 3000;
	
	public TransportShip(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, int cargoCapacity, int passengerCapacity){
		super(name, commissionYear, maximalSpeed, crewMembers, cargoCapacity, passengerCapacity);
	}

	@Override
	public int getAnnualMaintenanceCost(){
		int res = this.BASE_ANNUAL_MAINTENANCE_COST;
		res += 5 * this.getCargoCapacity();
		res += 3 * this.getpassengerCapacity();

		return res;
	}

}
