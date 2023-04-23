package org.springframework.cloud.client;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link CommonsClientAutoConfiguration}.
 */
public class CommonsClientAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'commonsClientAutoConfiguration'.
   */
  public static BeanDefinition getCommonsClientAutoConfigurationBeanDefinition() {
    Class<?> beanType = CommonsClientAutoConfiguration.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(CommonsClientAutoConfiguration::new);
    return beanDefinition;
  }
}
