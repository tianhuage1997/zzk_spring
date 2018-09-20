package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 去实现一个spring'自动构建对象的注解
 *
 * Component(value="")  对象构建的时候
 * class  Yyy{}  对应的别名就是yyy
 */
@Retention(RetentionPolicy.RUNTIME)//实现的代码在编译期和字节码期间可以使用
@Target(ElementType.TYPE)//说明这个注解实现在类名上面
public @interface Component {
    //代表的是一个叫value的方法名，返回值类型是String  没有方法体的。默认值是""字符串，但它不是null
    String  value() default  "";
}
