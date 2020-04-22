package future1;

import java.util.concurrent.TimeUnit;

/**
 * @author : lijq
 * @date : 2019/12/15 17:26
 */
public class DiscountService {

    public static void delay() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
