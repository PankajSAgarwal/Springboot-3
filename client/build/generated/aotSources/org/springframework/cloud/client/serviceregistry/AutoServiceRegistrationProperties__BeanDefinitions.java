package org.springframework.cloud.client.serviceregistry;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link AutoServiceRegistrationProperties}.
 */
public class AutoServiceRegistrationProperties__BeanDefinitions {
  /**
   * Get the bean definition for 'autoServiceRegistrationProperties'.
   */
  public static BeanDefinition getAutoServiceRegistrationPropertiesBeanDefinition() {
    Class<?> beanType = AutoServiceRegistrationProperties.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(AutoServiceRegistrationProperties::new);
    return beanDefinition;
  }
}
