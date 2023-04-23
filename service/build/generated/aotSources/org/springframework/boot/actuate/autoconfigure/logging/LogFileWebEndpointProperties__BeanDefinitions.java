package org.springframework.boot.actuate.autoconfigure.logging;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link LogFileWebEndpointProperties}.
 */
public class LogFileWebEndpointProperties__BeanDefinitions {
  /**
   * Get the bean definition for 'logFileWebEndpointProperties'.
   */
  public static BeanDefinition getLogFileWebEndpointPropertiesBeanDefinition() {
    Class<?> beanType = LogFileWebEndpointProperties.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(LogFileWebEndpointProperties::new);
    return beanDefinition;
  }
}
