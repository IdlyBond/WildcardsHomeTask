import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        Database<Number> database = new Database<>();

        List<Number> numberList = new ArrayList<>();
        numberList.add(8L);
        numberList.add(1.2);
        numberList.add(2);

        List<Integer> integerList = new ArrayList<>();
        integerList.add(4);
        integerList.add(2);
        integerList.add(7);

        database.join(numberList, integerList, Joins.FULL);
        System.out.println("Full_Outer: " + database.getBase());
        database.wipe();

        database.join(numberList, integerList, Joins.INNER);
        System.out.println("Inner_: " + database.getBase());
        database.wipe();

        database.join(numberList, integerList, Joins.LEFT);
        System.out.println("Left_: " + database.getBase());
        database.wipe();

        database.join(numberList, integerList, Joins.RIGHT);
        System.out.println("Right_: " + database.getBase());
        database.wipe();

    }
}
