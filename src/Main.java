public class Main {
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
