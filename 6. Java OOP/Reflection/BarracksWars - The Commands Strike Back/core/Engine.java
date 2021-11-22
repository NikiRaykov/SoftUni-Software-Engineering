package barracksWars.core;

import barracksWars.core.commands.Add;
import barracksWars.core.commands.Fight;
import barracksWars.core.commands.Report;
import barracksWars.core.commands.Retire;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.Runnable;
import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {

	private Repository repository;
	private UnitFactory unitFactory;

	public Engine(Repository repository, UnitFactory unitFactory) {
		this.repository = repository;
		this.unitFactory = unitFactory;
	}

	@Override
	public void run() {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		while (true) {
			try {
				String input = reader.readLine();
				String[] data = input.split("\\s+");
				String commandName = data[0];
				String result = interpretCommand(data, commandName);
				if (result.equals("fight")) {
					break;
				}
				System.out.println(result);
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			} catch (IOException | ExecutionControl.NotImplementedException | NoSuchFieldException | ClassNotFoundException | InvocationTargetException | NoSuchMethodException | InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}

	// TODO: refactor for problem 4
	private String interpretCommand(String[] data, String commandName) throws ExecutionControl.NotImplementedException, NoSuchFieldException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
		String result;
		switch (commandName) {
			case "add":
				Add add = new Add(data, this.repository, this.unitFactory);
				result = add.execute();
				break;
			case "report":
				Report report = new Report(data, this.repository, this.unitFactory);
				result = report.execute();
				break;
			case "fight":
				Fight fightCommand = new Fight(data, this.repository, this.unitFactory);
				result = fightCommand.execute();
				break;
			case "retire":
				Retire retireCommand = new Retire(data, this.repository, this.unitFactory);
				result = retireCommand.execute();
				break;
			default:
				throw new RuntimeException("Invalid command!");
		}
		return result;
	}


}
