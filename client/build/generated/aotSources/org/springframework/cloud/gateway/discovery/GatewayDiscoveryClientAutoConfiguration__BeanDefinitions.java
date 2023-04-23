package org.springframework.cloud.gateway.discovery;

import java.lang.Class;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link GatewayDiscoveryClientAutoConfiguration}.
 */
public class GatewayDiscoveryClientAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'gatewayDiscoveryClientAutoConfiguration'.
   */
  public static BeanDefinition getGatewayDiscoveryClientAutoConfigurationBeanDefinition() {
    Class<?> beanType = GatewayDiscoveryClientAutoConfiguration.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(GatewayDiscoveryClientAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'discoveryLocatorProperties'.
   */
  private static BeanInstanceSupplier<DiscoveryLocatorProperties> getDiscoveryLocatorPropertiesInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<DiscoveryLocatorProperties>forFactoryMethod(GatewayDiscoveryClientAutoConfiguration.class, "discoveryLocatorProperties")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(GatewayDiscoveryClientAutoConfiguration.class).discoveryLocatorProperties());
  }

  /**
   * Get the bean definition for 'discoveryLocatorProperties'.
   */
  public static BeanDefinition getDiscoveryLocatorPropertiesBeanDefinition() {
    Class<?> beanType = DiscoveryLocatorProperties.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getDiscoveryLocatorPropertiesInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Bean definitions for {@link GatewayDiscoveryClientAutoConfiguration.ReactiveDiscoveryClientRouteDefinitionLocatorConfiguration}.
   */
  public static class ReactiveDiscoveryClientRouteDefinitionLocatorConfiguration__BeanDefinitions {
    /**
     * Get the bean definition for 'reactiveDiscoveryClientRouteDefinitionLocatorConfiguration'.
     */
    public static BeanDefinition getReactiveDiscoveryClientRouteDefinitionLocatorConfigurationBeanDefinition(
        ) {
      Class<?> beanType = GatewayDiscoveryClientAutoConfiguration.ReactiveDiscoveryClientRouteDefinitionLocatorConfiguration.class;
      RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
      beanDefinition.setInstanceSupplier(GatewayDiscoveryClientAutoConfiguration.ReactiveDiscoveryClientRouteDefinitionLocatorConfiguration::new);
      return beanDefinition;
    }
  }
}
