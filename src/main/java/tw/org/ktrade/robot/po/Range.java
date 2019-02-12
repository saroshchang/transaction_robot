package tw.org.ktrade.robot.po;

/**
 * @auth ：niur
 * 时间：2017/11/21.
 * 项目名称 ：kline
 * 包名 ：org.ktrade.kline.kline.bean.entity
 * 功能描述 ：${DESCRIPTION}
 */
public enum Range {
    /** 日线 */
    DAY(4,"day"),
    /** 1小时 */
    HOUR(3,"hour"),
    /** 1分钟 */
    ONE_MINUTES(2,"minutes"),
    /** 1秒 */
    ONE_SECOND(1,"second");
    // 成员变量
    private Integer type;
    private String name;
    private Range(Integer type, String name){
        this.type=type;
        this.name=name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getName(Integer type) {
        for (Range c : Range.values()) {
            if (c.getType().equals(type)) {
                return c.name;
            }
        }
        return null;
    }
}
