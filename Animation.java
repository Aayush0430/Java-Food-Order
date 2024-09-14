public class Animation {

    public static void slow(String str) throws InterruptedException{
        for (int i = 0; i < str.length(); i++) {
            Thread.sleep(50);
            System.out.print(str.charAt(i));
        }
    }
    public static void fast(String str) throws InterruptedException{
        for (int i = 0; i < str.length(); i++) {
            Thread.sleep(20);
            System.out.print(str.charAt(i));
        }
    }
    public static void superSlow(String str) throws InterruptedException{
        for (int i = 0; i < str.length(); i++) {
            Thread.sleep(400);
            System.out.print(str.charAt(i));
        }
    }
    public static void superFast(String str) throws InterruptedException{
        for (int i = 0; i < str.length(); i++) {
            Thread.sleep(5);
            System.out.print(str.charAt(i));
        }
    }
}
