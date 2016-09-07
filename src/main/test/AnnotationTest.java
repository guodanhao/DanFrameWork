import com.halo.framework.annotation.Action;

/**
 * Created by muxi on 2016/9/6.
 */
public class AnnotationTest {

    @Action(value = "name")
    public String testName;

    public String getTestName() {
        return testName;
    }
}
