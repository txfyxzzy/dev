public class GenericTest {

    public static void main(String[] args) {

        Box<String> name = new Box<String>("corn");
        Box<Integer> age = new Box<Integer>(712);
        Box<Number> number = new Box<Number>(3.14f);
        //error: incompatible types: Box<Integer> cannot be converted to Box<Number>
        Box<Number> b = age;

        System.out.println("name:" + name.getData());
        System.out.println();

        System.out.println("name class: " + name.getClass());      // class Box
        System.out.println("age class: " + age.getClass());        // class Box
        System.out.println(name.getClass() == age.getClass());    // true
        System.out.println();

        getData(name);
        getData(age);
        getData(number);
        System.out.println();
        
        //complie error: incompatible types: Box<String> cannot be converted to Box<? extends Number>
        //getUpperNumberData(name); // 1
        getUpperNumberData(age);    // 2
        getUpperNumberData(number); // 3
    }

    public static void getData(Box<?> data) {
        System.out.println("data :" + data.getData());
    }

    public static void getUpperNumberData(Box<? extends Number> data){
        System.out.println("data :" + data.getData());
    }

}


class Box<T> {

    private T data;

    public Box() {

    }

    public Box(T data) {
        setData(data);
        //this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
