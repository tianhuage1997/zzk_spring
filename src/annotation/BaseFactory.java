package annotation;

public class BaseFactory {

    private  static BaseFactory factory = new BaseFactory();
    public  static  BaseFactory getFactory(){
        return  factory;
    }


    private  BaseFactory(){

    }
    //你自己去写一个这样的反射的类的话情况下，如果你的传参数是字符串的话。
    /*
       （String  name）
        Class   name.class  如果程序员写错了这个代码，那么这边就会不匹配类型
     */
    public  <T>   T getInstance(Class<T> clazz){
        Object obj =null;
        try {
            obj=clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
            throw  new RuntimeException("bean 加载失败");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return  (T) obj;
    }
}
