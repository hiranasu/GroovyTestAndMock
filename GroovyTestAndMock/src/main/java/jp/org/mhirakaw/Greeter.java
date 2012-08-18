package jp.org.mhirakaw;

public class Greeter {
    
    private GreetSupporter greetSupporter;
    
    public String helloWithName(String name) {
        return "hello " + name;
    }
    
    public String goodGreetingWithName(String name) {
        return greetSupporter.greetByTime() + " " + name;
    }
}
