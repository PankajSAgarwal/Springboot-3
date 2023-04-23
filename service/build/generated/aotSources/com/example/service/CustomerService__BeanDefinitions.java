package com.example.service;

import java.lang.Class;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Bean definitions for {@link CustomerService}.
 */
public class CustomerService__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'customerService'.
   */
  private static BeanInstanceSupplier<CustomerService> getCustomerServiceInstanceSupplier() {
    return BeanInstanceSupplier.<CustomerService>forConstructor(JdbcTemplate.class)
            .withGenerator((registeredBean, args) -> new CustomerService(args.get(0)));
  }

  /**
   * Get the bean definition for 'customerService'.
   */
  public static BeanDefinition getCustomerServiceBeanDefinition() {
    Class<?> beanType = CustomerService.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getCustomerServiceInstanceSupplier());
    return beanDefinition;
  }
}
