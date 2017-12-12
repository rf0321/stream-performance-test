import java.util.List;
import java.util.Random;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;

public class BigDataTask {
    public long genString() {
         Random r = new Random(2111);
         List<String> data = range(0, 1_000_000)
                            .mapToObj(i ->
                            r.ints().limit(20)
                            .map(n -> Math.abs(n) % 36)
                            .map(code -> (code < 10) ? '0' + code : 'A' + code - 10)
                            .mapToObj(ch -> String.valueOf((char) ch))
                            .toString())
                            .collect(toList());
         return streamSum(data);
    }
    public static long streamSum(List<String>data){
        return data.stream()
                // parallelStream
                .map(d -> d.replaceAll("[^0-9]", ""))//数字以外を取り除く
                .filter(d -> !d.isEmpty())
                .filter(d -> d.chars().map(ch -> ch - '0').sum() < 30)//数字の合計が30より小さい
                .mapToLong(d -> Long.parseLong(d)).sum();
    }
    public static long takeWhileSum(List<String> data){
        return data.stream()
                // parallelStream
                .map(d -> d.replaceAll("[^0-9]", ""))//数字以外を取り除く
                .takeWhile(d -> !d.isEmpty())
                .takeWhile(d -> d.chars().map(ch -> ch - '0').sum() < 30)//数字の合計が30より小さい
                .mapToLong(d -> Long.parseLong(d)).sum();
    }

      public static long dropWhileSum(List<String> data){
        return data.stream()
                // parallelStream
                .map(d -> d.replaceAll("[^0-9]", ""))//数字以外を取り除く
                .dropWhile(d -> d.isEmpty())
                .dropWhile(d -> d.chars().map(ch -> ch - '0').sum() > 30)//数字の合計が30より小さい
                .mapToLong(d -> Long.parseLong(d)).sum();
      }

    public static long use_for(List<String> data){
        long result = 0;
        for(String d : data){
            String numOnly = d.replaceAll("[^0-9]", "");
            if(numOnly.isEmpty()) continue;
            int total = 0;
            for(char ch : numOnly.toCharArray()){
                total += ch - '0';
            }
            if(total >= 30) continue;
            long value = Long.parseLong(numOnly);
            result += value;
        }
        return result;
    }
 }


