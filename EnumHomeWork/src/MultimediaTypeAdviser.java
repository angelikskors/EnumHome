import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

enum MultimediaType {
	Audio("MID", "WAV", "AIF", "MP3"), Video("MPG", "MOV", "WMV", "RM."), Image(
			"JPG", "TIF", "PNG", "GIF");
	private String types[];

	MultimediaType(String... types) {
		this.types = types;

	}

	public String[] getTypes() {
		return types;
	}

	public static MultimediaType parseTypeString(String str) {

		for (MultimediaType iterable_element : MultimediaType.values()) {
			String[] str1 = iterable_element.getTypes();
			for (String string : str1) {
				if (str.equals(string)) {

					return iterable_element;
				}
			}
		}

		return null;

	}

}

public class MultimediaTypeAdviser {

	public static void main(String[] args) {
		if (args[0] != null) {
			String path = args[0];
			File newFile = new File(path);

			System.out.println(MultimediaType
					.parseTypeString(format(fileChecker(newFile))));
		} else {
			System.err.println("Incorrect Input");
		}

	}

	private static String fileChecker(File newFile) {
		if (newFile.exists() & newFile.isFile()) {
			String path = newFile.getAbsolutePath();
			return path;
		} else
			return null;

	}

	static String divider = ".";

	public static String format(String str) {
		if (str.contains(divider)) {
			String result[] = str.split("\\.");

			return result[1].toUpperCase();

		} else {
			System.err.println("incorrect name");

		}
		return null;
	}

}
