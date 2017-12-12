public class Main {
// 明日 http://d.hatena.ne.jp/nowokay/20130506 ためす
    public static void main(String[] args) {
        System.out.println("Excution time:"+benchMark()+"[sec]");
    }

    private static double benchMark(){
        long start = System.currentTimeMillis();
        BigDataTask tasks = new BigDataTask();
        tasks.genString();
        long end = System.currentTimeMillis();

        return ((end - start) / 1000.0);
    }
}
