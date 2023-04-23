package org.springframework.boot.autoconfigure.graphql;

import java.lang.Class;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.graphql.ExecutionGraphQlService;
import org.springframework.graphql.data.method.annotation.support.AnnotatedControllerConfigurer;
import org.springframework.graphql.execution.BatchLoaderRegistry;
import org.springframework.graphql.execution.GraphQlSource;

/**
 * Bean definitions for {@link GraphQlAutoConfiguration}.
 */
public class GraphQlAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'org.springframework.boot.autoconfigure.graphql.GraphQlAutoConfiguration'.
   */
  private static BeanInstanceSupplier<GraphQlAutoConfiguration> getGraphQlAutoConfigurationInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<GraphQlAutoConfiguration>forConstructor(ListableBeanFactory.class)
            .withGenerator((registeredBean, args) -> new GraphQlAutoConfiguration(args.get(0)));
  }

  /**
   * Get the bean definition for 'graphQlAutoConfiguration'.
   */
  public static BeanDefinition getGraphQlAutoConfigurationBeanDefinition() {
    Class<?> beanType = GraphQlAutoConfiguration.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getGraphQlAutoConfigurationInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'graphQlSource'.
   */
  private static BeanInstanceSupplier<GraphQlSource> getGraphQlSourceInstanceSupplier() {
    return BeanInstanceSupplier.<GraphQlSource>forFactoryMethod(GraphQlAutoConfiguration.class, "graphQlSource", ResourcePatternResolver.class, GraphQlProperties.class, ObjectProvider.class, ObjectProvider.class, ObjectProvider.class, ObjectProvider.class, ObjectProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(GraphQlAutoConfiguration.class).graphQlSource(args.get(0), args.get(1), args.get(2), args.get(3), args.get(4), args.get(5), args.get(6)));
  }

  /**
   * Get the bean definition for 'graphQlSource'.
   */
  public static BeanDefinition getGraphQlSourceBeanDefinition() {
    Class<?> beanType = GraphQlSource.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getGraphQlSourceInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'batchLoaderRegistry'.
   */
  private static BeanInstanceSupplier<BatchLoaderRegistry> getBatchLoaderRegistryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<BatchLoaderRegistry>forFactoryMethod(GraphQlAutoConfiguration.class, "batchLoaderRegistry")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(GraphQlAutoConfiguration.class).batchLoaderRegistry());
  }

  /**
   * Get the bean definition for 'batchLoaderRegistry'.
   */
  public static BeanDefinition getBatchLoaderRegistryBeanDefinition() {
    Class<?> beanType = BatchLoaderRegistry.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getBatchLoaderRegistryInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'executionGraphQlService'.
   */
  private static BeanInstanceSupplier<ExecutionGraphQlService> getExecutionGraphQlServiceInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ExecutionGraphQlService>forFactoryMethod(GraphQlAutoConfiguration.class, "executionGraphQlService", GraphQlSource.class, BatchLoaderRegistry.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(GraphQlAutoConfiguration.class).executionGraphQlService(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'executionGraphQlService'.
   */
  public static BeanDefinition getExecutionGraphQlServiceBeanDefinition() {
    Class<?> beanType = ExecutionGraphQlService.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getExecutionGraphQlServiceInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'annotatedControllerConfigurer'.
   */
  private static BeanInstanceSupplier<AnnotatedControllerConfigurer> getAnnotatedControllerConfigurerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<AnnotatedControllerConfigurer>forFactoryMethod(GraphQlAutoConfiguration.class, "annotatedControllerConfigurer")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(GraphQlAutoConfiguration.class).annotatedControllerConfigurer());
  }

  /**
   * Get the bean definition for 'annotatedControllerConfigurer'.
   */
  public static BeanDefinition getAnnotatedControllerConfigurerBeanDefinition() {
    Class<?> beanType = AnnotatedControllerConfigurer.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getAnnotatedControllerConfigurerInstanceSupplier());
    return beanDefinition;
  }
}
