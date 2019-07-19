package supply;

import java.util.function.Supplier;

public class SupplierDemo1 {

    public static Integer getMax(Supplier<Integer> supplier) {

        return supplier.get();
    }


    public static void main(String[] args) {

        int[] arr = {3, 10, 9, 8};
        int max1 = getMax(() -> {
                    int max = arr[0];

                    for (int i : arr) {

                        if (i > max) {

                            max = i;
                        }

                    }

                    return max;

                }

        );
        System.out.println(max1);
    }
}
