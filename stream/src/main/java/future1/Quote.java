package future1;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * @author : lijq
 * @date : 2019/12/15 17:17
 */
@Data
@AllArgsConstructor
public class Quote {

    private String shopName;

    private Double price;

    private Discount discount;

    public static Quote parse(String content) {

        String[] split = StringUtils.splitByWholeSeparatorPreserveAllTokens(content, ":");

        return new Quote(split[0], Double.parseDouble(split[1]), Discount.valueOf(split[2]));

    }

}
