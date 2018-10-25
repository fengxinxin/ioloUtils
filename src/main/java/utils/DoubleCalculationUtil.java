package utils;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Created by FengXinXin on 2018/5/18.
 */
public class DoubleCalculationUtil {
    /**
     * 进行加法运算
     *
     * @param v1
     * @param v2
     * @return
     */
    public static double add(double v1, double v2) {
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.add(b2).doubleValue();
    }

    /**
     * 进行减法运算
     *
     * @param v1
     * @param v2
     * @return
     */
    public static double subtract(double v1, double v2) {
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.subtract(b2).doubleValue();
    }

    /**
     * 进行加法运算
     *
     * @param d1
     * @param d2
     * @return
     */
    public static double mul(double d1, double d2) {
        BigDecimal b1 = BigDecimal.valueOf(d1);
        BigDecimal b2 = BigDecimal.valueOf(d2);
        return b1.multiply(b2).doubleValue();
    }

    /**
     * 进行除法运算
     *
     * @param d1
     * @param d2
     * @param len
     * @return
     */
    public static double div(double d1, double d2, int len) {
        BigDecimal b1 = BigDecimal.valueOf(d1);
        BigDecimal b2 = BigDecimal.valueOf(d2);
        return b1.divide(b2, len, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 进行四舍五入操作
     *
     * @param d
     * @param len
     * @return
     */
    public static double round(double d, int len) {
        BigDecimal b1 = BigDecimal.valueOf(d);
        BigDecimal b2 = BigDecimal.valueOf(1);
        // 任何一个数字除以1都是原数字
        // ROUND_HALF_UP是BigDecimal的一个常量，表示进行四舍五入的操作
        return b1.divide(b2, len, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 比较两个double数值的大小
     * 利用sun提供的doubleToLongBits方法，避免因精度不同导致的结果误差
     *
     * @param d1
     * @param d2
     * @return
     */
    public static boolean doubleEqual(double d1, double d2) {
        return Double.doubleToLongBits(d1) == Double.doubleToLongBits(d2);
    }

    /**
     * 字符串转double保留小数点
     * pointNum 表示小数点格式 例如#.0000表示小数点4位
     *
     * @param string
     * @param pointNum
     * @return
     * @author Fengxinxin
     * date 2018-08-27
     **/
    public static double stringToDouble(String string, String pointNum) {
        if (StringUtils.isBlank(string)) {
            return 0;
        }
        double b = Double.valueOf(string);
        DecimalFormat df = new DecimalFormat(pointNum);
        String str = df.format(b);
        double newb = Double.valueOf(str);
        return newb;
    }

}
