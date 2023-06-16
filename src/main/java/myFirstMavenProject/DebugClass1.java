package myFirstMavenProject;

public class DebugClass1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i;
		add(20,19);
		
		for(i=1; i<10; i++) {
			if(i!=5) {
				System.out.println("value of i is: "+i);
			}
		}
		
	}

	public static void add(int a, int b) {
		System.out.println(a+b);
	}
}
