package org.springframework.boot.actuate.autoconfigure.web.exchanges;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link HttpExchangesEndpointAutoConfiguration}.
 */
public class HttpExchangesEndpointAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'httpExchangesEndpointAutoConfiguration'.
   */
  public static BeanDefinition getHttpExchangesEndpointAutoConfigurationBeanDefinition() {
    Class<?> beanType = HttpExchangesEndpointAutoConfiguration.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(HttpExchangesEndpointAutoConfiguration::new);
    return beanDefinition;
  }
}
