package org.springframework.boot.actuate.autoconfigure.env;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link EnvironmentEndpointProperties}.
 */
public class EnvironmentEndpointProperties__BeanDefinitions {
  /**
   * Get the bean definition for 'environmentEndpointProperties'.
   */
  public static BeanDefinition getEnvironmentEndpointPropertiesBeanDefinition() {
    Class<?> beanType = EnvironmentEndpointProperties.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(EnvironmentEndpointProperties::new);
    return beanDefinition;
  }
}
