package org.springframework.cloud.commons.util;

import java.lang.Class;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link UtilAutoConfiguration}.
 */
public class UtilAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'utilAutoConfiguration'.
   */
  public static BeanDefinition getUtilAutoConfigurationBeanDefinition() {
    Class<?> beanType = UtilAutoConfiguration.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(UtilAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'inetUtilsProperties'.
   */
  private static BeanInstanceSupplier<InetUtilsProperties> getInetUtilsPropertiesInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<InetUtilsProperties>forFactoryMethod(UtilAutoConfiguration.class, "inetUtilsProperties")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(UtilAutoConfiguration.class).inetUtilsProperties());
  }

  /**
   * Get the bean definition for 'inetUtilsProperties'.
   */
  public static BeanDefinition getInetUtilsPropertiesBeanDefinition() {
    Class<?> beanType = InetUtilsProperties.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    InstanceSupplier<InetUtilsProperties> instanceSupplier = getInetUtilsPropertiesInstanceSupplier();
    instanceSupplier = instanceSupplier.andThen(InetUtilsProperties__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'inetUtils'.
   */
  private static BeanInstanceSupplier<InetUtils> getInetUtilsInstanceSupplier() {
    return BeanInstanceSupplier.<InetUtils>forFactoryMethod(UtilAutoConfiguration.class, "inetUtils", InetUtilsProperties.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(UtilAutoConfiguration.class).inetUtils(args.get(0)));
  }

  /**
   * Get the bean definition for 'inetUtils'.
   */
  public static BeanDefinition getInetUtilsBeanDefinition() {
    Class<?> beanType = InetUtils.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setDestroyMethodNames("close");
    beanDefinition.setInstanceSupplier(getInetUtilsInstanceSupplier());
    return beanDefinition;
  }
}
