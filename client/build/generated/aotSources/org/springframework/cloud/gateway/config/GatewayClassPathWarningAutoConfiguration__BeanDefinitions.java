package org.springframework.cloud.gateway.config;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link GatewayClassPathWarningAutoConfiguration}.
 */
public class GatewayClassPathWarningAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'gatewayClassPathWarningAutoConfiguration'.
   */
  public static BeanDefinition getGatewayClassPathWarningAutoConfigurationBeanDefinition() {
    Class<?> beanType = GatewayClassPathWarningAutoConfiguration.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(GatewayClassPathWarningAutoConfiguration::new);
    return beanDefinition;
  }
}
