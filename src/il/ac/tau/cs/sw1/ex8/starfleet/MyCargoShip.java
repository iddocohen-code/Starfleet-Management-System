package il.ac.tau.cs.sw1.ex8.starfleet;
import java.util.Set;

public abstract class MyCargoShip extends MyAbsSpaceship {
    private final int cargoCapacity;
	private final int passengerCapacity;
	
	public MyCargoShip(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, int cargoCapacity, int passengerCapacity){
		super(name, commissionYear, maximalSpeed, crewMembers);
		this.cargoCapacity = cargoCapacity;
		this.passengerCapacity = passengerCapacity;
	}

	public int getCargoCapacity(){
		return this.cargoCapacity;
	}

	public int getpassengerCapacity(){
		return this.passengerCapacity;
	}

    @Override
	public String toString() {
		return super.toString() +
		 "\n\tCargoCapacity=" + cargoCapacity +
			 "\n\tPassengerCapacity=" + passengerCapacity;
	}

		
}

