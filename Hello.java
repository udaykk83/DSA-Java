import java.util.Scanner;

class Hello {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		s = s.replace(",", " - ");
		s = s.replace("-", " ");
		s = Hello.toCamelCase(s);
		
		s = s.replace(" ", "_");
		System.out.println(s);
	}

	public static String toCamelCase(final String init) {
		if (init == null)
			return null;

		final StringBuilder ret = new StringBuilder(init.length());

		for (final String word : init.split(" ")) {
			if (!word.isEmpty()) {
				ret.append(Character.toUpperCase(word.charAt(0)));
				ret.append(word.substring(1).toLowerCase());
			}
			if (!(ret.length() == init.length()))
				ret.append(" ");
		}

		return ret.toString();
	}
}