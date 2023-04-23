package com.example.client;

import java.lang.Class;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link CustomerGraphqlController}.
 */
public class CustomerGraphqlController__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'customerGraphqlController'.
   */
  private static BeanInstanceSupplier<CustomerGraphqlController> getCustomerGraphqlControllerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<CustomerGraphqlController>forConstructor(CustomerClient.class)
            .withGenerator((registeredBean, args) -> new CustomerGraphqlController(args.get(0)));
  }

  /**
   * Get the bean definition for 'customerGraphqlController'.
   */
  public static BeanDefinition getCustomerGraphqlControllerBeanDefinition() {
    Class<?> beanType = CustomerGraphqlController.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getCustomerGraphqlControllerInstanceSupplier());
    return beanDefinition;
  }
}
