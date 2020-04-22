package future1;

/**
 * @author : lijq
 * @date : 2019/12/15 17:08
 */
public enum Discount {


    NONE(0),SlIVER(5),GOLDEN(10);

    private int discount;

    Discount(int discount){
        this.discount=discount;
    }
}
