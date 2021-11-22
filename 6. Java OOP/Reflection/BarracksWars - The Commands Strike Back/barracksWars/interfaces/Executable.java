package barracksWars.interfaces;

import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.InvocationTargetException;

public interface Executable {

	String execute() throws ExecutionControl.NotImplementedException, NoSuchFieldException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;

}
