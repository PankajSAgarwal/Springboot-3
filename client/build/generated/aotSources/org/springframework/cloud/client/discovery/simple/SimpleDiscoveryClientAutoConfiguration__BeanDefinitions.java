package org.springframework.cloud.client.discovery.simple;

import java.lang.Class;
import java.lang.String;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.cloud.client.discovery.DiscoveryClient;

/**
 * Bean definitions for {@link SimpleDiscoveryClientAutoConfiguration}.
 */
public class SimpleDiscoveryClientAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'simpleDiscoveryClientAutoConfiguration'.
   */
  public static BeanDefinition getSimpleDiscoveryClientAutoConfigurationBeanDefinition() {
    Class<?> beanType = SimpleDiscoveryClientAutoConfiguration.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    InstanceSupplier<SimpleDiscoveryClientAutoConfiguration> instanceSupplier = InstanceSupplier.using(SimpleDiscoveryClientAutoConfiguration::new);
    instanceSupplier = instanceSupplier.andThen(SimpleDiscoveryClientAutoConfiguration__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'simpleDiscoveryProperties'.
   */
  private static BeanInstanceSupplier<SimpleDiscoveryProperties> getSimpleDiscoveryPropertiesInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SimpleDiscoveryProperties>forFactoryMethod(SimpleDiscoveryClientAutoConfiguration.class, "simpleDiscoveryProperties", String.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(SimpleDiscoveryClientAutoConfiguration.class).simpleDiscoveryProperties(args.get(0)));
  }

  /**
   * Get the bean definition for 'simpleDiscoveryProperties'.
   */
  public static BeanDefinition getSimpleDiscoveryPropertiesBeanDefinition() {
    Class<?> beanType = SimpleDiscoveryProperties.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getSimpleDiscoveryPropertiesInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'simpleDiscoveryClient'.
   */
  private static BeanInstanceSupplier<DiscoveryClient> getSimpleDiscoveryClientInstanceSupplier() {
    return BeanInstanceSupplier.<DiscoveryClient>forFactoryMethod(SimpleDiscoveryClientAutoConfiguration.class, "simpleDiscoveryClient", SimpleDiscoveryProperties.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(SimpleDiscoveryClientAutoConfiguration.class).simpleDiscoveryClient(args.get(0)));
  }

  /**
   * Get the bean definition for 'simpleDiscoveryClient'.
   */
  public static BeanDefinition getSimpleDiscoveryClientBeanDefinition() {
    Class<?> beanType = DiscoveryClient.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getSimpleDiscoveryClientInstanceSupplier());
    return beanDefinition;
  }
}
