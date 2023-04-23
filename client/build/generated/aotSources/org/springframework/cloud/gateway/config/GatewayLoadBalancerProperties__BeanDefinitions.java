package org.springframework.cloud.gateway.config;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link GatewayLoadBalancerProperties}.
 */
public class GatewayLoadBalancerProperties__BeanDefinitions {
  /**
   * Get the bean definition for 'gatewayLoadBalancerProperties'.
   */
  public static BeanDefinition getGatewayLoadBalancerPropertiesBeanDefinition() {
    Class<?> beanType = GatewayLoadBalancerProperties.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(GatewayLoadBalancerProperties::new);
    return beanDefinition;
  }
}
