package org.springframework.boot.actuate.autoconfigure.audit;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link AuditEventsEndpointAutoConfiguration}.
 */
public class AuditEventsEndpointAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'auditEventsEndpointAutoConfiguration'.
   */
  public static BeanDefinition getAuditEventsEndpointAutoConfigurationBeanDefinition() {
    Class<?> beanType = AuditEventsEndpointAutoConfiguration.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(AuditEventsEndpointAutoConfiguration::new);
    return beanDefinition;
  }
}
