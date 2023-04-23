package org.springframework.boot.actuate.autoconfigure.logging;

import java.lang.Class;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.actuate.logging.LoggersEndpoint;
import org.springframework.boot.logging.LoggingSystem;

/**
 * Bean definitions for {@link LoggersEndpointAutoConfiguration}.
 */
public class LoggersEndpointAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'loggersEndpointAutoConfiguration'.
   */
  public static BeanDefinition getLoggersEndpointAutoConfigurationBeanDefinition() {
    Class<?> beanType = LoggersEndpointAutoConfiguration.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(LoggersEndpointAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'loggersEndpoint'.
   */
  private static BeanInstanceSupplier<LoggersEndpoint> getLoggersEndpointInstanceSupplier() {
    return BeanInstanceSupplier.<LoggersEndpoint>forFactoryMethod(LoggersEndpointAutoConfiguration.class, "loggersEndpoint", LoggingSystem.class, ObjectProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(LoggersEndpointAutoConfiguration.class).loggersEndpoint(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'loggersEndpoint'.
   */
  public static BeanDefinition getLoggersEndpointBeanDefinition() {
    Class<?> beanType = LoggersEndpoint.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getLoggersEndpointInstanceSupplier());
    return beanDefinition;
  }
}
