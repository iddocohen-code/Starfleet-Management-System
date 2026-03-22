package il.ac.tau.cs.sw1.ex8.starfleet;

public class Cylon extends MyAbsCrewMember{

	private final int modelNumber;

	public Cylon(String name, int age, int yearsInService, int modelNumber) {
		super(age, yearsInService, name);
		this.modelNumber = modelNumber;
	}
	

	public int getModelNumber(){
		return this.modelNumber;
	}

	@Override
	public String toString() {
		return super.toString()	+
		 "\n\tRank=" + getModelNumber();
	}

}






	
	