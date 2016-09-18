import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by muxi on 2016/9/18.
 */
public enum StatEnum {

    Monday(1, "星期一"), TuesDay(2, "星期二");

    private int code;
    private String remark;

    private StatEnum(int code, String remark) {
        this.code = code;
        this.remark = remark;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public static StatEnum codeOf(int code) {
        for (StatEnum statEnum : StatEnum.values()) {
            if (statEnum.getCode() == code) {
                return statEnum;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public static void main(String[] args) {
        System.out.println(StatEnum.codeOf(1));
        System.out.println(StatEnum.codeOf(2));
        System.out.println(StatEnum.codeOf(3));
    }
}
