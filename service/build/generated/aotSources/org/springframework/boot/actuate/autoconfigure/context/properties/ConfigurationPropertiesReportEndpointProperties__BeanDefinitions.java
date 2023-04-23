package org.springframework.boot.actuate.autoconfigure.context.properties;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ConfigurationPropertiesReportEndpointProperties}.
 */
public class ConfigurationPropertiesReportEndpointProperties__BeanDefinitions {
  /**
   * Get the bean definition for 'configurationPropertiesReportEndpointProperties'.
   */
  public static BeanDefinition getConfigurationPropertiesReportEndpointPropertiesBeanDefinition() {
    Class<?> beanType = ConfigurationPropertiesReportEndpointProperties.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(ConfigurationPropertiesReportEndpointProperties::new);
    return beanDefinition;
  }
}
