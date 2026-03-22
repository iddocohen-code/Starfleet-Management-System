package il.ac.tau.cs.sw1.ex8.starfleet;

import java.util.List;
import java.util.Set;

public abstract class MyFightingShip extends MyAbsSpaceship {
    protected  final List<Weapon> weapons;
    

    public MyFightingShip(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers, List<Weapon> weapons){
        super(name, commissionYear, maximalSpeed, crewMembers);
		this.weapons = weapons;
    }

    
    public List<Weapon> getWeapon(){
        return this.weapons;
    }
	
	@Override
	public int getFirePower(){
		int weaponsPower = this.weapons.stream().mapToInt(weapon -> weapon.getFirePower()).sum();
		return super.getFirePower() + weaponsPower;
	}

	public int getAnnualMaintenanceCost_OfWeapons(){
		int res = 0;
		for (Weapon currWeapon : weapons){
			res += currWeapon.getAnnualMaintenanceCost();
		}
		return res;
	}

	@Override
	public String toString() {
		return super.toString()	+
		 "\n\tWeaponArray=" + weapons.toString();
	}
		
}
