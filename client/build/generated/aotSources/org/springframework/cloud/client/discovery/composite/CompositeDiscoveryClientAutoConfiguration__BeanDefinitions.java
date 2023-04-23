package org.springframework.cloud.client.discovery.composite;

import java.lang.Class;
import java.util.List;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link CompositeDiscoveryClientAutoConfiguration}.
 */
public class CompositeDiscoveryClientAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'compositeDiscoveryClientAutoConfiguration'.
   */
  public static BeanDefinition getCompositeDiscoveryClientAutoConfigurationBeanDefinition() {
    Class<?> beanType = CompositeDiscoveryClientAutoConfiguration.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(CompositeDiscoveryClientAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'compositeDiscoveryClient'.
   */
  private static BeanInstanceSupplier<CompositeDiscoveryClient> getCompositeDiscoveryClientInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<CompositeDiscoveryClient>forFactoryMethod(CompositeDiscoveryClientAutoConfiguration.class, "compositeDiscoveryClient", List.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(CompositeDiscoveryClientAutoConfiguration.class).compositeDiscoveryClient(args.get(0)));
  }

  /**
   * Get the bean definition for 'compositeDiscoveryClient'.
   */
  public static BeanDefinition getCompositeDiscoveryClientBeanDefinition() {
    Class<?> beanType = CompositeDiscoveryClient.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setPrimary(true);
    beanDefinition.setInstanceSupplier(getCompositeDiscoveryClientInstanceSupplier());
    return beanDefinition;
  }
}
