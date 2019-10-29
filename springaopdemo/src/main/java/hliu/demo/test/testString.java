package hliu.demo.test;

public class testString {
    public static void main(String args[]){
        String param = "this is params";

        param = param == null ? new String("this is paramss") : param;

        System.out.println(param==param);
        System.out.println(param.equals(param));
    }
}
