import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * Created by muxi on 2016/9/2.
 */
public class ClassGetAnnotation {

    public static ClassLoader getAnnotationClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    public static Class<?> loadAnnotationClass(String className, boolean isInitialize) {
        Class<?> cls;
        try {
            cls = Class.forName(className, isInitialize, getAnnotationClassLoader());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return cls;
    }

    public static void main(String[] arg) throws NoSuchFieldException, IllegalAccessException, InstantiationException {

        Class<?> annotationTest = loadAnnotationClass("AnnotationTest", false);
        AnnotationTest ob = (AnnotationTest) annotationTest.newInstance();

        Field field = annotationTest.getDeclaredField("testName");
        field.set(ob, "name1");

        System.out.println(ob.getTestName());
    }
}
