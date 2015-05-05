import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

enum MultimediaType {
	Audio("MID", "WAV", "AIF", "MP3"), Video("MPG", "MOV", "WMV", "RM."), Image(
			"JPG", "TIF", "PNG", "GIF");
	private String type1;
	private String type2;
	private String type3;
	private String type4;

	private MultimediaType(String type1, String type2, String type3,
			String type4) {
		this.type1 = type1;
		this.type2 = type2;
		this.type3 = type3;
		this.type4 = type4;
	}

	public String getType1() {
		return type1;
	}

	public String getType2() {
		return type2;
	}

	public String getType3() {
		return type3;
	}

	public String getType4() {
		return type4;
	}

}

public class MultimediaTypeAdviser {

	public static void main(String[] args) {
		if (args[0] != null) {
			String path = args[0];
			File newFile = new File(path);

			System.out.println(typeChoose(format(fileChecker(newFile))));
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

	public static MultimediaType typeChoose(String str) {
		MultimediaType type1 = MultimediaType.Audio;
		MultimediaType type2 = MultimediaType.Video;
		MultimediaType type3 = MultimediaType.Image;
		if (str.equals(type1.getType1()) | str.equals(type1.getType2())
				| str.equals(type1.getType3()) | str.equals(type1.getType4())) {

			return MultimediaType.Audio;
		} else if (str.equals(type2.getType1()) | str.equals(type2.getType2())
				| str.equals(type2.getType3()) | str.equals(type2.getType4())) {

			return MultimediaType.Video;
		} else if (str.equals(type3.getType1()) | str.equals(type3.getType2())
				| str.equals(type3.getType3()) | str.equals(type3.getType4())) {

			return MultimediaType.Image;
		}

		else
			System.err.println("Unknown format");

		return null;

	}
}
