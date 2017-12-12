import java.util.Arrays;
import java.util.List;

public class TakeWhileTask {

    public void use_for(){ // Avg Excution time:0.001[sec]
        List<String>list = Arrays.asList("Java","Ruby","Csharp","Scala","Haskell");
        for(String lang : list){
            if(lang.length() < 5){
                System.out.println(lang);
            }
         }

    }

    public void use_stream(){ // Avg Excution time:0.025[sec]
        List<String>list = Arrays.asList("Java","Ruby","Csharp","Scala","Haskell");
        list.stream().filter(lang -> lang.length() < 5).forEach(System.out::println);
        // parallelStream
    }

    public void use_takewhile(){ // Avg Excution time:0.026[sec]
        List<String>list = Arrays.asList("Java","Ruby","Csharp","Scala","Haskell");
        list.stream().takeWhile(lang -> lang.length() < 5).forEach(System.out::println);
    }
}
