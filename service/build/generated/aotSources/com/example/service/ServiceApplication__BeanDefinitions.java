package com.example.service;

import java.lang.Class;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ConfigurationClassUtils;
import org.springframework.core.ResolvableType;

/**
 * Bean definitions for {@link ServiceApplication}.
 */
public class ServiceApplication__BeanDefinitions {
  /**
   * Get the bean definition for 'serviceApplication'.
   */
  public static BeanDefinition getServiceApplicationBeanDefinition() {
    Class<?> beanType = ServiceApplication.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    ConfigurationClassUtils.initializeConfigurationClass(ServiceApplication.class);
    beanDefinition.setInstanceSupplier(ServiceApplication$$SpringCGLIB$$0::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'readyEventApplicationListener'.
   */
  private static BeanInstanceSupplier<ApplicationListener> getReadyEventApplicationListenerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ApplicationListener>forFactoryMethod(ServiceApplication.class, "readyEventApplicationListener", CustomerService.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(ServiceApplication.class).readyEventApplicationListener(args.get(0)));
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
}
