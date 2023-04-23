package org.springframework.cloud.configuration;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link CompatibilityVerifierProperties}.
 */
public class CompatibilityVerifierProperties__BeanDefinitions {
  /**
   * Get the bean definition for 'compatibilityVerifierProperties'.
   */
  public static BeanDefinition getCompatibilityVerifierPropertiesBeanDefinition() {
    Class<?> beanType = CompatibilityVerifierProperties.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(CompatibilityVerifierProperties::new);
    return beanDefinition;
  }
}
