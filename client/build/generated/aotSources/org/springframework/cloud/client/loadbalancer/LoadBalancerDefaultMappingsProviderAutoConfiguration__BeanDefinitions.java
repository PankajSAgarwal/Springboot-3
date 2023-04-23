package org.springframework.cloud.client.loadbalancer;

import java.lang.Class;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.cloud.commons.config.DefaultsBindHandlerAdvisor;

/**
 * Bean definitions for {@link LoadBalancerDefaultMappingsProviderAutoConfiguration}.
 */
public class LoadBalancerDefaultMappingsProviderAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'loadBalancerDefaultMappingsProviderAutoConfiguration'.
   */
  public static BeanDefinition getLoadBalancerDefaultMappingsProviderAutoConfigurationBeanDefinition(
      ) {
    Class<?> beanType = LoadBalancerDefaultMappingsProviderAutoConfiguration.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(LoadBalancerDefaultMappingsProviderAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'loadBalancerClientsDefaultsMappingsProvider'.
   */
  private static BeanInstanceSupplier<DefaultsBindHandlerAdvisor.MappingsProvider> getLoadBalancerClientsDefaultsMappingsProviderInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<DefaultsBindHandlerAdvisor.MappingsProvider>forFactoryMethod(LoadBalancerDefaultMappingsProviderAutoConfiguration.class, "loadBalancerClientsDefaultsMappingsProvider")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(LoadBalancerDefaultMappingsProviderAutoConfiguration.class).loadBalancerClientsDefaultsMappingsProvider());
  }

  /**
   * Get the bean definition for 'loadBalancerClientsDefaultsMappingsProvider'.
   */
  public static BeanDefinition getLoadBalancerClientsDefaultsMappingsProviderBeanDefinition() {
    Class<?> beanType = DefaultsBindHandlerAdvisor.MappingsProvider.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getLoadBalancerClientsDefaultsMappingsProviderInstanceSupplier());
    return beanDefinition;
  }
}
