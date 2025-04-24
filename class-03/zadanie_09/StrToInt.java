public class StrToInt implements Transform<String, Integer>{
    
    public Integer apply (String arg){
        return (Integer)(arg.length());
    }

}
