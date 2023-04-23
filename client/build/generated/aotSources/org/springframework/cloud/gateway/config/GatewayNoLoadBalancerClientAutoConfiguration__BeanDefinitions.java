package org.springframework.cloud.gateway.config;

import java.lang.Class;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link GatewayNoLoadBalancerClientAutoConfiguration}.
 */
public class GatewayNoLoadBalancerClientAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'gatewayNoLoadBalancerClientAutoConfiguration'.
   */
  public static BeanDefinition getGatewayNoLoadBalancerClientAutoConfigurationBeanDefinition() {
    Class<?> beanType = GatewayNoLoadBalancerClientAutoConfiguration.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(GatewayNoLoadBalancerClientAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'noLoadBalancerClientFilter'.
   */
  private static BeanInstanceSupplier<GatewayNoLoadBalancerClientAutoConfiguration.NoLoadBalancerClientFilter> getNoLoadBalancerClientFilterInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<GatewayNoLoadBalancerClientAutoConfiguration.NoLoadBalancerClientFilter>forFactoryMethod(GatewayNoLoadBalancerClientAutoConfiguration.class, "noLoadBalancerClientFilter", GatewayLoadBalancerProperties.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(GatewayNoLoadBalancerClientAutoConfiguration.class).noLoadBalancerClientFilter(args.get(0)));
  }

  /**
   * Get the bean definition for 'noLoadBalancerClientFilter'.
   */
  public static BeanDefinition getNoLoadBalancerClientFilterBeanDefinition() {
    Class<?> beanType = GatewayNoLoadBalancerClientAutoConfiguration.NoLoadBalancerClientFilter.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getNoLoadBalancerClientFilterInstanceSupplier());
    return beanDefinition;
  }
}
