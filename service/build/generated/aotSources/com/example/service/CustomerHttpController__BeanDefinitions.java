package com.example.service;

import io.micrometer.observation.ObservationRegistry;
import java.lang.Class;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link CustomerHttpController}.
 */
public class CustomerHttpController__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'customerHttpController'.
   */
  private static BeanInstanceSupplier<CustomerHttpController> getCustomerHttpControllerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<CustomerHttpController>forConstructor(CustomerService.class, ObservationRegistry.class)
            .withGenerator((registeredBean, args) -> new CustomerHttpController(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'customerHttpController'.
   */
  public static BeanDefinition getCustomerHttpControllerBeanDefinition() {
    Class<?> beanType = CustomerHttpController.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getCustomerHttpControllerInstanceSupplier());
    return beanDefinition;
  }
}
