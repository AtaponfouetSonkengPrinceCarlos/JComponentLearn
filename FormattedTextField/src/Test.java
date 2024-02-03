
public class Test {
public static void main(String[] args)
{
	Fenetre f = new Fenetre();
	Double n = 9.0;
	String t = n.getClass().getSimpleName();
		System.out.println(n.getClass().getSimpleName());
		double d = 7.5;
		String str = String.valueOf(d);
		System.out.println(str.getClass().getSimpleName());
		try {
		System.out.println(Integer.parseInt(str));
		}catch(NumberFormatException e) {}
		System.out.println(str);
		String s = new String("12.00000");
		if(s.matches("^[0-9]+.0+$"))
		{
			System.out.print("yes");
		}
		int j = (int)d;
		System.out.println(j);
}
}
