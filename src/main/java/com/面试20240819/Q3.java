package com.面试20240819;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/*自定义注解实现依赖注入*/
class Q3 {

  public static class A {

    @Dep
    private B b;
    @Dep
    private C c;
    private String name = "A";

    @Override
    public String toString() {
      return "A{" +
          "name='" + name + '\'' +
          '}';
    }
  }

  public static class B {

    @Dep
    private C c;
    @Dep
    private A a;
    private String name = "B";

    @Override
    public String toString() {
      return "B{" +
          "name='" + name + '\'' +
          '}';
    }
  }

  public static class C {

    @Dep
    private A a;
    @Dep
    private B b;
    private String name = "C";

    @Override
    public String toString() {
      return "C{" +
          "name='" + name + '\'' +
          '}';
    }
  }

  @Target({ElementType.FIELD, ElementType.TYPE})
  @Retention(RetentionPolicy.RUNTIME)
  @interface Dep {

  }

  static class BeanFactory {

    static final Map<Class<?>, Object> map = new HashMap<>();
    static final Map<Class<?>, Object> map2 = new HashMap<>();

    public static <T> T getBean(Class<T> clazz)
        throws IllegalAccessException, InstantiationException {
      T instance = null;
      if (map.containsKey(clazz)) {
        instance = (T) map.get(clazz);
      } else if (map2.containsKey(clazz)) {
        instance = (T) map2.get(clazz);
      } else {
        instance = clazz.newInstance();
        map2.put(clazz, instance);
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
          Dep annotation = field.getAnnotation(Dep.class);
          if (!field.canAccess(instance)) {
            field.setAccessible(true);
          }
          if (annotation != null) {
            Object bean = getBean(field.getType());
            field.set(instance, bean);
          }
        }
        map2.remove(clazz);
        map.put(clazz, instance);
      }
      return instance;
    }
  }

  public static void main(String[] args) {
    try {
      A bean = BeanFactory.getBean(A.class);
      System.out.println(bean);
    } catch (IllegalAccessException | InstantiationException e) {
      e.printStackTrace();
    }

  }
}
