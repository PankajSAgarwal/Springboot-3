package org.springframework.boot.actuate.autoconfigure.logging;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link LogFileWebEndpointAutoConfiguration}.
 */
public class LogFileWebEndpointAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'logFileWebEndpointAutoConfiguration'.
   */
  public static BeanDefinition getLogFileWebEndpointAutoConfigurationBeanDefinition() {
    Class<?> beanType = LogFileWebEndpointAutoConfiguration.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(LogFileWebEndpointAutoConfiguration::new);
    return beanDefinition;
  }
}
