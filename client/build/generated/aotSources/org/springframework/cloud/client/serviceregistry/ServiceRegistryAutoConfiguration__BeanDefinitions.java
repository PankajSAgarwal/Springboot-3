package org.springframework.cloud.client.serviceregistry;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ServiceRegistryAutoConfiguration}.
 */
public class ServiceRegistryAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'serviceRegistryAutoConfiguration'.
   */
  public static BeanDefinition getServiceRegistryAutoConfigurationBeanDefinition() {
    Class<?> beanType = ServiceRegistryAutoConfiguration.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(ServiceRegistryAutoConfiguration::new);
    return beanDefinition;
  }
}
