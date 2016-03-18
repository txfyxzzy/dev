import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ForeachTest
{
    public static void main(String[] args)
    {
      
        List<String> list = new ArrayList<String>();

        // list.add("a");
        // list.add("b");
        // list.add("c");

        //System.out.println("----------方式2-----------");
        //第二种方式，使用迭代器
        /*for(Iterator<String> iter = list.iterator(); iter.hasNext();)
        {
            System.out.println(iter.next());
        }*/
        System.out.println("----------方式3-----------");
        //第三种方式，使用增强型的for循环
        for(String str: list)
        {
            System.out.println(str);
        }
    }

}
