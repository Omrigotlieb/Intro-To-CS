
public class StringManipulation {

	public static void main(String[] args) {
		System.out.println("2 and 3 concatenated: " + 2 + 3);
		System.out.println("2 and 3 added: " + (2 + 3));
		
		String s, city = "Tel Aviv";
		char c;
		int n;
		c = city.charAt(0);
		System.out.println(c);
		s= "" +c;
		System.out.println(s);
		n = city.length();
		System.out.println(n);
		n = city.indexOf('v');
		System.out.println(n);
		n = city.indexOf("el");
		System.out.println(city);
		System.out.println("Index of el: " + n);
		s = city.substring(2,4);
		System.out.println(s);
		System.out.println("substring 2,4: " + s);
		s = city.substring(3);
		System.out.println("substring 3:" + s);
		s = city.toUpperCase();
		System.out.println("toUpperCase: " + s);
		s = city.replace('v','g');
		System.out.println("replace v and g: " + s);
		s = city.replaceAll("v","zo");
		System.out.println("replace all v with zo: " + s);
	}

}
