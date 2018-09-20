package annotation;

import java.util.HashMap;

public class zzk {

    public static void main(String[] args)  throws  Exception {
        //?对应不确定的java类型
        //1.获得类名的全路径（spring里面，类名的全路径，classs= com.tedu.Strudent）
        /*
          通过流，去获取对应的文件路径
          xml解析。  遍历每个标签 SAXreader
          通过标签获得对应的类的全路径名
         */
          Class<?>  cls =Class.forName("annotation.Student");
          //直接去初始化我的对象吗？  不可以。如果我的对象是没有自定义注解的话，那么就不需要去初始化一个类
         //2.做一个准备工作。spring构建的对象是放在容器里面的。什么是容器
        /*
        容器技术：集合框架：map  set list propersies
         */
        HashMap<String,Object>  iocMap= new HashMap<String,Object>(64);
        //构建了自定义的注解。需要创建自定义注解这个类
        Component component =cls.getDeclaredAnnotation(Component.class);
        //cls.getDeclaredAnnotation(Component.class);   可以访问私有的权限
        //cls.getAnnotation(Component.class);   这个就不可以
        //通过反射去获取我对应的类名
        String simpleNmae= cls.getSimpleName();
        //3.判断value数值是否为空
        if(component.value().length()>0){
                throw  new RuntimeException("value不能为空");
        }
        //4.判断我的类名是否有非法字符
        String rexString ="[^0-9a-zA-Z]J*\\\",\\\"";//这个正则的作用是字母数字，不能有空格
        if (simpleNmae.matches(rexString)){
               throw  new RuntimeException("发现非法字符");
        }
        //5.判断首字母是否小写
         if (Character.isLowerCase(simpleNmae.charAt(0))){
                //如果首字母是小写，那么就返回对象的本身
         }else {
            //如果首字母不是小写，那么就把首字母转换为小写
             simpleNmae= new StringBuilder().
                     append(Character.toLowerCase
                             (simpleNmae.charAt(0))
                     ).append(simpleNmae.substring(1)).toString();
         }
        //6.判断对象是否单例设计模式
        // 没写。实现思路思路。  自定义一个scope的注解，判断这个注解是否存在，从而去判断它是不是单例模式
        //6.1 如果是单例设计模式

        //6.2如果是单例设计模式 ，就会去容器iocMap里面，基于类名作为key。找到当前对象，并赋值给对象
        if(iocMap.containsKey(simpleNmae)){
            //基于类名作为key，去ioc的容器里面去找对应的对象
                  Object obj = iocMap.get(simpleNmae);
        }else {
            //6.3如果容器里面没有这个类名的key。那么就去调用动态工厂方法，采用单例设计模式去构建这个类
            Object obj= BaseFactory.getFactory().getInstance(cls);
            iocMap.put(simpleNmae,obj);

        }

        System.out.println("查看我的对象有没有构建成功:"+iocMap.get(simpleNmae));


    }
}
