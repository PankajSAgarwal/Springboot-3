package org.springframework.cloud.client.serviceregistry;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link AutoServiceRegistrationAutoConfiguration}.
 */
public class AutoServiceRegistrationAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'autoServiceRegistrationAutoConfiguration'.
   */
  public static BeanDefinition getAutoServiceRegistrationAutoConfigurationBeanDefinition() {
    Class<?> beanType = AutoServiceRegistrationAutoConfiguration.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    InstanceSupplier<AutoServiceRegistrationAutoConfiguration> instanceSupplier = InstanceSupplier.using(AutoServiceRegistrationAutoConfiguration::new);
    instanceSupplier = instanceSupplier.andThen(AutoServiceRegistrationAutoConfiguration__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
