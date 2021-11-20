import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Class<RichSoilLand> clazz = RichSoilLand.class;

		Field[] fields = clazz.getDeclaredFields();

		String printByMod = scanner.nextLine();

		while (!printByMod.equals("HARVEST")) {

			switch (printByMod) {
				case "private":
					printPrivateFieldsInfo(fields);
					break;
				case "public":
					printPublicFieldsInfo(fields);
					break;
				case "protected":
					printProtectedFieldsInfo(fields);
					break;
				case "all":
					printAllFieldsInfo(fields);
					break;
			}

			printByMod = scanner.nextLine();
		}
	}

	private static void printAllFieldsInfo(Field[] fields) {
		Arrays.stream(fields)
				.forEach(field -> System.out.printf("%s %s %s%n",
						Modifier.toString(field.getModifiers()), field.getType().getSimpleName(), field.getName()));
	}

	private static void printProtectedFieldsInfo(Field[] fields) {
		Arrays.stream(fields)
				.filter(filed -> Modifier.isProtected(filed.getModifiers()))
				.forEach(field -> System.out.printf("%s %s %s%n",
						Modifier.toString(field.getModifiers()), field.getType().getSimpleName(), field.getName()));
	}

	private static void printPublicFieldsInfo(Field[] fields) {
		Arrays.stream(fields)
				.filter(filed -> Modifier.isPublic(filed.getModifiers()))
				.forEach(field -> System.out.printf("%s %s %s%n",
						Modifier.toString(field.getModifiers()), field.getType().getSimpleName(), field.getName()));
	}

	private static void printPrivateFieldsInfo(Field[] fields) {
		Arrays.stream(fields)
				.filter(filed -> Modifier.isPrivate(filed.getModifiers()))
				.forEach(field -> System.out.printf("%s %s %s%n",
						Modifier.toString(field.getModifiers()), field.getType().getSimpleName(), field.getName()));
	}
}
