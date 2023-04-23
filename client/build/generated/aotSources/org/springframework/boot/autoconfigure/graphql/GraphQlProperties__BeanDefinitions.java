package org.springframework.boot.autoconfigure.graphql;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link GraphQlProperties}.
 */
public class GraphQlProperties__BeanDefinitions {
  /**
   * Get the bean definition for 'graphQlProperties'.
   */
  public static BeanDefinition getGraphQlPropertiesBeanDefinition() {
    Class<?> beanType = GraphQlProperties.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(GraphQlProperties::new);
    return beanDefinition;
  }
}
