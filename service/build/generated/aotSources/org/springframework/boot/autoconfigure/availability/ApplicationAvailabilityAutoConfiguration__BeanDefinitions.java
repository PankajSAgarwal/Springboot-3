package org.springframework.boot.autoconfigure.availability;

import java.lang.Class;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.availability.ApplicationAvailability;

/**
 * Bean definitions for {@link ApplicationAvailabilityAutoConfiguration}.
 */
public class ApplicationAvailabilityAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'applicationAvailabilityAutoConfiguration'.
   */
  public static BeanDefinition getApplicationAvailabilityAutoConfigurationBeanDefinition() {
    Class<?> beanType = ApplicationAvailabilityAutoConfiguration.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(ApplicationAvailabilityAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'applicationAvailability'.
   */
  private static BeanInstanceSupplier<ApplicationAvailability> getApplicationAvailabilityInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ApplicationAvailability>forFactoryMethod(ApplicationAvailabilityAutoConfiguration.class, "applicationAvailability")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(ApplicationAvailabilityAutoConfiguration.class).applicationAvailability());
  }

  /**
   * Get the bean definition for 'applicationAvailability'.
   */
  public static BeanDefinition getApplicationAvailabilityBeanDefinition() {
    Class<?> beanType = ApplicationAvailability.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getApplicationAvailabilityInstanceSupplier());
    return beanDefinition;
  }
}
