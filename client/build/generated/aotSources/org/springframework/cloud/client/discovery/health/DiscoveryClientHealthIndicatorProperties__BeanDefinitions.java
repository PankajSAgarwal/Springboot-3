package org.springframework.cloud.client.discovery.health;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link DiscoveryClientHealthIndicatorProperties}.
 */
public class DiscoveryClientHealthIndicatorProperties__BeanDefinitions {
  /**
   * Get the bean definition for 'discoveryClientHealthIndicatorProperties'.
   */
  public static BeanDefinition getDiscoveryClientHealthIndicatorPropertiesBeanDefinition() {
    Class<?> beanType = DiscoveryClientHealthIndicatorProperties.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(DiscoveryClientHealthIndicatorProperties::new);
    return beanDefinition;
  }
}
