package org.springframework.boot.autoconfigure.graphql.reactive;

import java.lang.Class;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.autoconfigure.graphql.GraphQlCorsProperties;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.core.ResolvableType;
import org.springframework.graphql.ExecutionGraphQlService;
import org.springframework.graphql.execution.GraphQlSource;
import org.springframework.graphql.server.WebGraphQlHandler;
import org.springframework.graphql.server.webflux.GraphQlHttpHandler;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * Bean definitions for {@link GraphQlWebFluxAutoConfiguration}.
 */
public class GraphQlWebFluxAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'graphQlWebFluxAutoConfiguration'.
   */
  public static BeanDefinition getGraphQlWebFluxAutoConfigurationBeanDefinition() {
    Class<?> beanType = GraphQlWebFluxAutoConfiguration.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(GraphQlWebFluxAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'graphQlHttpHandler'.
   */
  private static BeanInstanceSupplier<GraphQlHttpHandler> getGraphQlHttpHandlerInstanceSupplier() {
    return BeanInstanceSupplier.<GraphQlHttpHandler>forFactoryMethod(GraphQlWebFluxAutoConfiguration.class, "graphQlHttpHandler", WebGraphQlHandler.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(GraphQlWebFluxAutoConfiguration.class).graphQlHttpHandler(args.get(0)));
  }

  /**
   * Get the bean definition for 'graphQlHttpHandler'.
   */
  public static BeanDefinition getGraphQlHttpHandlerBeanDefinition() {
    Class<?> beanType = GraphQlHttpHandler.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getGraphQlHttpHandlerInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'webGraphQlHandler'.
   */
  private static BeanInstanceSupplier<WebGraphQlHandler> getWebGraphQlHandlerInstanceSupplier() {
    return BeanInstanceSupplier.<WebGraphQlHandler>forFactoryMethod(GraphQlWebFluxAutoConfiguration.class, "webGraphQlHandler", ExecutionGraphQlService.class, ObjectProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(GraphQlWebFluxAutoConfiguration.class).webGraphQlHandler(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'webGraphQlHandler'.
   */
  public static BeanDefinition getWebGraphQlHandlerBeanDefinition() {
    Class<?> beanType = WebGraphQlHandler.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getWebGraphQlHandlerInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'graphQlRouterFunction'.
   */
  private static BeanInstanceSupplier<RouterFunction> getGraphQlRouterFunctionInstanceSupplier() {
    return BeanInstanceSupplier.<RouterFunction>forFactoryMethod(GraphQlWebFluxAutoConfiguration.class, "graphQlRouterFunction", GraphQlHttpHandler.class, GraphQlSource.class, GraphQlProperties.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(GraphQlWebFluxAutoConfiguration.class).graphQlRouterFunction(args.get(0), args.get(1), args.get(2)));
  }

  /**
   * Get the bean definition for 'graphQlRouterFunction'.
   */
  public static BeanDefinition getGraphQlRouterFunctionBeanDefinition() {
    ResolvableType beanType = ResolvableType.forClassWithGenerics(RouterFunction.class, ServerResponse.class);
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getGraphQlRouterFunctionInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Bean definitions for {@link GraphQlWebFluxAutoConfiguration.GraphQlEndpointCorsConfiguration}.
   */
  public static class GraphQlEndpointCorsConfiguration__BeanDefinitions {
    /**
     * Get the bean instance supplier for 'org.springframework.boot.autoconfigure.graphql.reactive.GraphQlWebFluxAutoConfiguration$GraphQlEndpointCorsConfiguration'.
     */
    private static BeanInstanceSupplier<GraphQlWebFluxAutoConfiguration.GraphQlEndpointCorsConfiguration> getGraphQlEndpointCorsConfigurationInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<GraphQlWebFluxAutoConfiguration.GraphQlEndpointCorsConfiguration>forConstructor(GraphQlProperties.class, GraphQlCorsProperties.class)
              .withGenerator((registeredBean, args) -> new GraphQlWebFluxAutoConfiguration.GraphQlEndpointCorsConfiguration(args.get(0), args.get(1)));
    }

    /**
     * Get the bean definition for 'graphQlEndpointCorsConfiguration'.
     */
    public static BeanDefinition getGraphQlEndpointCorsConfigurationBeanDefinition() {
      Class<?> beanType = GraphQlWebFluxAutoConfiguration.GraphQlEndpointCorsConfiguration.class;
      RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
      beanDefinition.setInstanceSupplier(getGraphQlEndpointCorsConfigurationInstanceSupplier());
      return beanDefinition;
    }
  }
}
