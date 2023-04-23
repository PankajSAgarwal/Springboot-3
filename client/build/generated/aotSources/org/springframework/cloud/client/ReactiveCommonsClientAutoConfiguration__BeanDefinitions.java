package org.springframework.cloud.client;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ReactiveCommonsClientAutoConfiguration}.
 */
public class ReactiveCommonsClientAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'reactiveCommonsClientAutoConfiguration'.
   */
  public static BeanDefinition getReactiveCommonsClientAutoConfigurationBeanDefinition() {
    Class<?> beanType = ReactiveCommonsClientAutoConfiguration.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(ReactiveCommonsClientAutoConfiguration::new);
    return beanDefinition;
  }
}
