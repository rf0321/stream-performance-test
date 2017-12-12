import java.util.Arrays;
import java.util.List;
public class DropWhileTask {

    public void use_for(){ // Avg Excution time:0.001[sec]
        List<String> list = Arrays.asList("Java","Ruby","Csharp","Scala","Haskell");
        boolean skipflag = false;

        for (String lang : list){
            if(lang.length() >= 5) {
                skipflag = true;
            }
            if(skipflag == true){
                System.out.println(lang);
            }

        }
    }

    public void use_stream(){ // Avg Excution time:0.023[sec]
        List<String> list = Arrays.asList("Java","Ruby","Csharp","Scala","Haskell");
        long skipNum = list.stream().filter(city -> city.length() < 5 ).count();
        list.stream().skip(skipNum).forEach(System.out::println);
        // parallelStream
    }

    public void use_dropwhile(){ // Avg Excution time:0.024[sec]
        List<String> list = Arrays.asList("Java","Ruby","Csharp","Scala","Haskell");
        list.stream().dropWhile(lang -> lang.length() < 5).forEach(System.out::println);
        // parallelStream
    }

}
