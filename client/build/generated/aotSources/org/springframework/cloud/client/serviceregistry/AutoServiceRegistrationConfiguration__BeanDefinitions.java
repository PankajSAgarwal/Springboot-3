package org.springframework.cloud.client.serviceregistry;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link AutoServiceRegistrationConfiguration}.
 */
public class AutoServiceRegistrationConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'autoServiceRegistrationConfiguration'.
   */
  public static BeanDefinition getAutoServiceRegistrationConfigurationBeanDefinition() {
    Class<?> beanType = AutoServiceRegistrationConfiguration.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(AutoServiceRegistrationConfiguration::new);
    return beanDefinition;
  }
}
