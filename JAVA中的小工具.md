## comparator的使用
    大家可能发现这样的方式不是太灵活，因为一个对象实现接口后，这个方法就固定了。也就是说，它的排序算法已经固定了，如果它的排序算法不是固定的，
    是可以动态调整的，那么就用Comparator接口来扩展，它独立于被排序的对象单独存在，当需要排序的时候，以参数的形式传递，上面例子中的“CHINA_COMPARE”
    就是一个Comparator实例。你也可以自己实现一个自定义对象的排序方式来满足特定对象的要求，如果同样的对象一会想这样排序，一会想那样排序，
    就只需要使用不同的Comparator实例即可。

## JAVA util中的class使用
    抽时间把JAVA util和Apache common lang包中的所有Utils看一下
    
## 工具类的意义
    把一些class抽取出来，让业务逻辑更加清晰

文章来源：https://yq.aliyun.com/articles/20176