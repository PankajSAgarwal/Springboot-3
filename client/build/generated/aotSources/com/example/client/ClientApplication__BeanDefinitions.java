package com.example.client;

import java.lang.Class;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ConfigurationClassUtils;
import org.springframework.core.ResolvableType;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Bean definitions for {@link ClientApplication}.
 */
public class ClientApplication__BeanDefinitions {
  /**
   * Get the bean definition for 'clientApplication'.
   */
  public static BeanDefinition getClientApplicationBeanDefinition() {
    Class<?> beanType = ClientApplication.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    ConfigurationClassUtils.initializeConfigurationClass(ClientApplication.class);
    beanDefinition.setInstanceSupplier(ClientApplication$$SpringCGLIB$$0::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'readyEventApplicationListener'.
   */
  private static BeanInstanceSupplier<ApplicationListener> getReadyEventApplicationListenerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ApplicationListener>forFactoryMethod(ClientApplication.class, "readyEventApplicationListener", CustomerClient.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(ClientApplication.class).readyEventApplicationListener(args.get(0)));
  }

  /**
   * Get the bean definition for 'readyEventApplicationListener'.
   */
  public static BeanDefinition getReadyEventApplicationListenerBeanDefinition() {
    ResolvableType beanType = ResolvableType.forClassWithGenerics(ApplicationListener.class, ApplicationReadyEvent.class);
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getReadyEventApplicationListenerInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'customerClient'.
   */
  private static BeanInstanceSupplier<CustomerClient> getCustomerClientInstanceSupplier() {
    return BeanInstanceSupplier.<CustomerClient>forFactoryMethod(ClientApplication.class, "customerClient", WebClient.Builder.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(ClientApplication.class).customerClient(args.get(0)));
  }

  /**
   * Get the bean definition for 'customerClient'.
   */
  public static BeanDefinition getCustomerClientBeanDefinition() {
    Class<?> beanType = CustomerClient.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getCustomerClientInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'gateway'.
   */
  private static BeanInstanceSupplier<RouteLocator> getGatewayInstanceSupplier() {
    return BeanInstanceSupplier.<RouteLocator>forFactoryMethod(ClientApplication.class, "gateway", RouteLocatorBuilder.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(ClientApplication.class).gateway(args.get(0)));
  }

  /**
   * Get the bean definition for 'gateway'.
   */
  public static BeanDefinition getGatewayBeanDefinition() {
    Class<?> beanType = RouteLocator.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getGatewayInstanceSupplier());
    return beanDefinition;
  }
}
