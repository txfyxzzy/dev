
public class TestOrder {   
    // 静态变量   
    //public static TestA a = new TestA();   
       
    // 静态初始化块   
    static {   
        System.out.println("静态初始化块");   
    }   
       
    // 静态变量   
    //public static TestB b = new TestB();   

    public TestOrder() {
        System.out.println("TestOrder constructor");
    }
  
    public static void main(String[] args) {   
        new TestOrder();   
        TestA.getInstance().init();
    }   
}   
  
class TestA {   
    private static TestA a = new TestA();
    public static TestA getInstance() {
        return TestA.a;
    }
    public TestA() {   
        System.out.println("Test--A");   
    }   
    public void init() {
        System.out.println("--TestA init--");
    }
}   
  
class TestB {   
    public static TestB b = new TestB();   
    public TestB() {   
        System.out.println("Test--B");   
    }   
}  