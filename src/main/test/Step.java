/**
 * Created by muxi on 2016/9/29.
 */
public class Step {

    /** 处理时间 */
    private int acceptTime = 0;
    /** 快件所在地点 */
    private String acceptAddress = "";

    public int getAcceptTime() {
        return acceptTime;
    }

    public void setAcceptTime(int acceptTime) {
        this.acceptTime = acceptTime;
    }

    public String getAcceptAddress() {
        return acceptAddress;
    }

    public void setAcceptAddress(String acceptAddress) {
        this.acceptAddress = acceptAddress;
    }

    public Step(int acceptTime, String acceptAddress) {
        this.acceptTime = acceptTime;
        this.acceptAddress = acceptAddress;
    }
}
