package org.springframework.cloud.autoconfigure;

import java.lang.Class;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.cloud.context.environment.EnvironmentManager;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * Bean definitions for {@link LifecycleMvcEndpointAutoConfiguration}.
 */
public class LifecycleMvcEndpointAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'lifecycleMvcEndpointAutoConfiguration'.
   */
  public static BeanDefinition getLifecycleMvcEndpointAutoConfigurationBeanDefinition() {
    Class<?> beanType = LifecycleMvcEndpointAutoConfiguration.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(LifecycleMvcEndpointAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'environmentManager'.
   */
  private static BeanInstanceSupplier<EnvironmentManager> getEnvironmentManagerInstanceSupplier() {
    return BeanInstanceSupplier.<EnvironmentManager>forFactoryMethod(LifecycleMvcEndpointAutoConfiguration.class, "environmentManager", ConfigurableEnvironment.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(LifecycleMvcEndpointAutoConfiguration.class).environmentManager(args.get(0)));
  }

  /**
   * Get the bean definition for 'environmentManager'.
   */
  public static BeanDefinition getEnvironmentManagerBeanDefinition() {
    Class<?> beanType = EnvironmentManager.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getEnvironmentManagerInstanceSupplier());
    return beanDefinition;
  }
}
