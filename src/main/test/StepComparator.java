import java.util.Comparator;
import java.util.Date;

/**
 * Created by muxi on 2016/9/29.
 */
public class StepComparator implements Comparator<Step> {

    @Override
    public int compare(Step o1, Step o2) {
        if (o1.getAcceptTime() > o2.getAcceptTime()) return 1;
        return -1;
    }
}
