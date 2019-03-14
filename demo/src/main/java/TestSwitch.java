
public class TestSwitch {
public static void main(String[] args) {

    final String JAVA5 = "Java 5";
    final String JAVA6 = "Java 6";
    final String JAVA7 = "Java 7";
    String param = "Java 5";
	if (param .equals(JAVA5)){
        System.out.println(JAVA5);
    } else if (param.equals(JAVA6)){
        System.out.println(JAVA6);
    } else if (param.equals(JAVA7)){
        System.out.println(JAVA7);
    }
	
	int oneMillion_ = 1_000_000; //new
    int oneMillion = 1000000;
    if (oneMillion_ == oneMillion){
        System.out.println(true);
    } else{
        System.out.println(false);
    }
    
    if (oneMillion_ == oneMillion){
        System.out.println(true);
    } else{
        System.out.println(false);
    }
}
}
