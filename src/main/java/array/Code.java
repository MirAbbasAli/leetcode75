package array;

public class Code {
    public Code() {
        System.out.println("No arg Cons");
    }
    public Code(int x){
        System.out.println("arg Cons");
    }
    static {
        System.out.println("static 1");
    }
    {
        System.out.println("init 1");
    }
    static {
        System.out.println("static 2");
    }
    {
        System.out.println("init 2");
    }
    public static void main(String[] args){
        new Code();
        new Code(2);
    }
}
