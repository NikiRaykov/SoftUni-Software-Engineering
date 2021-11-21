package barracksWars.core.factories;

import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;
import barracksWars.models.units.*;
import jdk.jshell.spi.ExecutionControl;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME = "barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) throws ExecutionControl.NotImplementedException {
		// TODO: implement for problem 3

		switch (unitType) {
			case "Archer":
				return new Archer();
			case "Gunner":
				return new Gunner();
			case "Horseman":
				return new Horseman();
			case "Pikeman":
				return new Pikeman();
			case "Swordsman":
				return new Swordsman();
		}

		throw new ExecutionControl.NotImplementedException("message");
	}
}
