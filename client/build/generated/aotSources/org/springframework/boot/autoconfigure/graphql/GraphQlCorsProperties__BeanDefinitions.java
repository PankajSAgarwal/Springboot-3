package org.springframework.boot.autoconfigure.graphql;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link GraphQlCorsProperties}.
 */
public class GraphQlCorsProperties__BeanDefinitions {
  /**
   * Get the bean definition for 'graphQlCorsProperties'.
   */
  public static BeanDefinition getGraphQlCorsPropertiesBeanDefinition() {
    Class<?> beanType = GraphQlCorsProperties.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(GraphQlCorsProperties::new);
    return beanDefinition;
  }
}
