import lombok.Data;
import lombok.NonNull;

public class Main {
    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5};
        Cat[] cats = {new Cat("A"),new Cat("B"),new Cat("C"),new Cat("D")};

    }


    static int min(int firstArg, int... remainingArgs) {
        int min = firstArg;
        for (int arg : remainingArgs)
            if (arg < min)
                min = arg;
        return min;
    }
}

@Data
class Cat {
    @NonNull
    private String name;
    private int age;
}
