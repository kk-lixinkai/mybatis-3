package org.apache.ibatis.reflection;

import org.apache.ibatis.domain.misc.CustomBeanWrapperFactory;
import org.apache.ibatis.domain.misc.RichType;
import org.junit.Test;

import java.util.HashMap;

/**
 * Created By lixinkai on 2020/12/5
 */
public class WrapperTest {

  @Test
  public void test01() {
    RichType object = new RichType();

    if (true) {
      object.setRichType(new RichType());
      object.getRichType().setRichMap(new HashMap());
      object.getRichType().getRichMap().put("nihao", "123");
    }

    MetaObject meta = MetaObject.forObject(object, SystemMetaObject.DEFAULT_OBJECT_FACTORY, new CustomBeanWrapperFactory(), new DefaultReflectorFactory());
    Class<?> clazz = meta.getObjectWrapper().getGetterType("richType.richMap.nihao");
    System.out.println(clazz);
  }
}
