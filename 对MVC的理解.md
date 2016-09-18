## IOC的理解
```
static {
        Set<Class<?>> beanClassSet = ClassHelper.getBeanClassSet();
        for (Class<?> cls: beanClassSet ) {
            Object obj = ReflectionUtil.getInstance(cls);
            BEAN_MAP.put(cls, obj);
        }
    }
```
ClassHelper是class的辅助类，通过ClassUtils将class加载到Set中，BeanHelper实现初始化，并且是在Static中
## 异常的使用
要把所有的Exception给捕获
```
public static long castLong(Object obj, long defaultValue) {
        long longValue = defaultValue;
        if (obj != null) {
            String strValue = castString(obj);
            if (StringUtils.isNotEmpty(strValue)) {
                try {
                    longValue = Long.parseLong(strValue);
                } catch (NumberFormatException e) {
                    longValue = defaultValue;
                }
            }
        }
        return longValue;
    }
```