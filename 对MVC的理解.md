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
## servlet和spring mvc的不同
    spring mvc 就是把servlet进行了一次封装。利用了dispatcherServlet和handler的体系
    
## 公司解决重复提交方案
API 传方法带入token，切面将token放到redis中，提交事务之后，
（SupplyChainTransactionManager extends DataSourceTransactionManager），去clean redis中的token