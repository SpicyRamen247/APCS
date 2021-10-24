public class BigSib {
    String hello_msg;

    public BigSib(String msg) {
        hello_msg = msg;
    }

    public String greet(String name) {
        return hello_msg + " " + name;
    }
}
