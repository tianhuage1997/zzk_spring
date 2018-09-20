package annotation;


import java.lang.annotation.*;

//@Documented// 生成文档注释文件的注解
@Retention(RetentionPolicy.SOURCE)//注解的生效范围
/**
 * 生效范围有三个范围
 * RetentionPolicy.RUNTIME:  在编译器和字节码文件是有效的
 * RetentionPolicy.SOURCE     仅仅在字节码文件是有效的
 * RetentionPolicy.class  类名
 *
 *
 */
@Target({ElementType.TYPE,ElementType.FIELD})//用于作用范围的
@interface  AutoWrited{}

/**
 * 对于ElementType而言。作用的范围有
 * 　@Target(ElementType.TYPE)   //接口、类、枚举、注解
 * 　@Target(ElementType.FIELD) //字段、枚举的常量
 * 　@Target(ElementType.METHOD) //方法
 * 　@Target(ElementType.PARAMETER) //方法参数
 * 　@Target(ElementType.CONSTRUCTOR)  //构造函数
 * 　@Target(ElementType.LOCAL_VARIABLE)//局部变量
 * 　@Target(ElementType.ANNOTATION_TYPE)//注解
 * 　@Target(ElementType.PACKAGE) ///包
 */

/**
 * spring里面的注解。到底是怎么运作的

@AutoWrited
class   Student{
        @AutoWrited
        private  String  username;

}
 */


public class TestAnnotation {


    public static void main(String[] args) {

    }
}
