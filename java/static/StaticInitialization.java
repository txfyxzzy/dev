class Bowl{
 Bowl(int marker){
  System.out.println("Bowl("+marker+")");
 }
 void f(int marker){
  System.out.println("f("+marker+")");
 }
}

class Table{
 static Bowl b1=new Bowl(1);
 Table(){
  System.out.println("Table()");
  b2.f(1);
 }
 void f2(int marker){
  System.out.println("f2("+marker+")");
 }
 static Bowl b2=new Bowl(2);
}

class Cupboard{
 Bowl b3=new Bowl(3);
 static Bowl b4=new Bowl(4);
 Cupboard(){
  System.out.println("Cupboard()");
  b4.f(2);
 }
 void f3(int marker){
  System.out.println("f3("+marker+")");
 }
 static Bowl b5=new Bowl(5);
}

class PluginProxy {
  public static PluginProxy sInstance = new PluginProxy();
  public PluginProxy() {
    System.out.println("PluginProxy ctor");
  }
  public static PluginProxy getInstance() {
    System.out.println("getInstance");
    return sInstance;
  }
  public void download(int marker) {
    System.out.println("download(" + marker + ")");
  }
}

public class StaticInitialization{
 public static void main(String[] args){
  System.out.println("Creatin new Cupboard() in main");
  //new Cupboard();
  //System.out.println("Creatin new Cupboard() in main");
  //new Cupboard();
  //t1.f2(1);
  //c1.f3(1);
  PluginProxy.getInstance().download(6);
 }
 static Table t1=new Table();
 //static Cupboard c1=new Cupboard();
 
}
