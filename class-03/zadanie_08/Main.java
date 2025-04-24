import java.util.Comparator;

public class Main {
    public static void main(String[] args)
    {
    	Spiewak s1 = new Spiewak("Darrey"){
          public String spiewaj(){
            return "eeae";
          }
        };

        Spiewak s2 = new Spiewak("Darrey"){
            public String spiewaj(){
              return "bebe";
            }
          };
  
        Spiewak s3 = new Spiewak("Houston"){
            public String spiewaj(){
                return "aabbccdefgh";
            }
        };
  
        Spiewak s4 = new Spiewak("Carrey"){
            public String spiewaj(){
                return "xyzt123";
            }
        };

        Spiewak s5 = new Spiewak("Madonna"){
            public String spiewaj(){
                return "aAa";
            }
        };
  
        Spiewak sp[] = {s1, s2, s3, s4, s5};
  
        System.out.println("Przed sortowaniem:\n");
        for (Spiewak s : sp)
            System.out.println(s);
        
        java.util.Arrays.sort(sp, Comparator.reverseOrder());

        System.out.println("\nPo sortowaniu:\n");
        for (Spiewak s : sp)
            System.out.println(s);
    }
}
