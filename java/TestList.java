import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
 
public class TestList {
 
    public static void main(String[] args) {
 
        List<String> list = new LinkedList<>();
//        Iterator<String> iterator = list.iterator();
 
        list.add("ba");
        list.add("b");
 
        Iterator<String> iterator = list.iterator();
        if (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
 
    }
}
