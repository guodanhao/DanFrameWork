import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by muxi on 2016/9/29.
 */
public class StepComparatorTest {

    @Test
    public void sort() throws Exception {

        List<Step> steps = new ArrayList<Step>();
        steps.add(new Step(1, "2"));
        steps.add(new Step(3, "2"));
        steps.add(new Step(2, "2"));


        //对集合对象进行排序
        StepComparator comparator = new StepComparator();
        Collections.sort(steps, comparator);
        if (steps != null && steps.size() > 0) {
            for (Step step : steps) {
//                System.out.println(step.getAcceptAddress());
                System.out.println(step.getAcceptTime());
            }
        }

    }
}
