package il.ac.tau.cs.sw1.ex8.starfleet;


import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


public class StarfleetManager {

	/**
	 * Returns a list containing string representation of all fleet ships, sorted in descending order by
	 * fire power, and then in descending order by commission year, and finally in ascending order by
	 * name
	 */
	public static List<String> getShipDescriptionsSortedByFirePowerAndCommissionYear (Collection<Spaceship> fleet) {
		return (fleet.stream()
		.sorted()
		.map(Spaceship::toString)
		.collect(Collectors.toList()));
	}

	/**
	 * Returns a map containing ship type names as keys (the class name) and the number of instances created for each type as values
	 */
	public static Map<String, Integer> getInstanceNumberPerClass(Collection<Spaceship> fleet) {
		Map<String, Integer> res = new HashMap<>();
		fleet.stream().forEach(currSpaceship -> 
			res.put(currSpaceship.getClass().getSimpleName(), currSpaceship.getNumOf_AllInstances())
		);
		return res;

	}


	/**
	 * Returns the total annual maintenance cost of the fleet (which is the sum of maintenance costs of all the fleet's ships)
	 */
	public static int getTotalMaintenanceCost (Collection<Spaceship> fleet) {
		int res;
		res = fleet.stream().mapToInt(Spaceship :: getAnnualMaintenanceCost).sum();
		return res;

	}


	/**
	 * Returns a set containing the names of all the fleet's weapons installed on any ship
	 */
	public static Set<String> getFleetWeaponNames(Collection<Spaceship> fleet) {
		Set<String> res = new HashSet<>();
		fleet.stream().filter(currSpaceship -> currSpaceship instanceof MyFightingShip)
		.map(Spaceship -> (MyFightingShip)Spaceship)
		.flatMap(Spaceship -> Spaceship.getWeapon().stream())
		.forEach(currWeapon -> res.add(currWeapon.getName()));
		
		return res;

	}

	/*
	 * Returns the total number of crew-members serving on board of the given fleet's ships.
	 */
	public static int getTotalNumberOfFleetCrewMembers(Collection<Spaceship> fleet) {
		int res;
		res = fleet.stream().mapToInt(Spaceship -> Spaceship.getCrewMembers().size()).sum();
		return res;

	}

	/*
	 * Returns the total number of Officers serving on board of the given fleet's ships.
	 */
	public static int getTotalNumberOfFleetOfficers(Collection<Spaceship> fleet) {
		int res;
		res =(int) fleet.stream().flatMap(currSpaceship -> currSpaceship.getCrewMembers().stream()) // now there is one stream of crew members only
		.filter(crew -> crew instanceof Officer) // only officers
		.count();
		return res;

	}



	/*
	 * Returns the average age of all officers serving on board of the given fleet's ships. 
	 */
	public static float getAverageAgeOfFleetOfficers(Collection<Spaceship> fleet) {
		int totalSum =  fleet.stream().mapToInt( // converting each Spaceship to its sum of officers age
			currSpaceship -> currSpaceship.getCrewMembers().stream() // streaming through eacg list of crew members
			.filter(crew -> crew instanceof Officer) // having only officers
			.mapToInt(officer -> officer.getAge()) // converting each officer to its age
			.sum())
			.sum(); // having the total sum of officers ages in the fleet
		return (float) totalSum / StarfleetManager.getTotalNumberOfFleetOfficers(fleet);
	}

	/*
	 * Returns a map mapping the highest ranking officer on each ship (as keys), to his ship (as values).
	 */
	public static Map<Officer, Spaceship> getHighestRankingOfficerPerShip(Collection<Spaceship> fleet) {
		return (fleet.stream()
		.filter(Spaceship -> Spaceship.getCrewMembers().stream().anyMatch(crew -> crew instanceof Officer)) // only Spaceships with officers
		.collect(Collectors.toMap( // building the map
			(Spaceship -> Spaceship.getCrewMembers().stream()
			.filter(crew -> crew instanceof Officer) // only officers
					.map(officer -> (Officer)officer)
					.max((o1, o2) -> o1.getRank().compareTo(o2.getRank())) // finding the max in each spaceship
				.get()) // setting the key
				,
				 (Spaceship -> Spaceship) // setting the value
			)));
	}

	/*
	 * Returns a List of entries representing ranks and their occurrences.
	 * Each entry represents a pair composed of an officer rank, and the number of its occurrences among starfleet personnel.
	 * The returned list is sorted ascendingly based on the number of occurrences.
	 */
	public static List<Map.Entry<OfficerRank, Integer>> getOfficerRanksSortedByPopularity(Collection<Spaceship> fleet) {
		Map<OfficerRank, Integer> ranksMap = new HashMap<>();
		fleet.stream()
		.flatMap(currSpaceship -> currSpaceship.getCrewMembers().stream()) // now there is one stream of crew members only
		.filter(crew -> crew instanceof Officer) // only officers
		.map(officer -> ((Officer)officer).getRank()) // converting each officer to its rank
		.forEach(rank -> {
			if (!ranksMap.containsKey(rank)){
				ranksMap.put(rank, 0);
			}
			int val = ranksMap.get(rank) + 1;
			ranksMap.put(rank, val);
		});
		return ranksMap.entrySet().stream().sorted(Map.Entry.<OfficerRank, Integer> comparingByValue()
	.thenComparing(Map.Entry.comparingByKey()))
	.toList();
	}

}
