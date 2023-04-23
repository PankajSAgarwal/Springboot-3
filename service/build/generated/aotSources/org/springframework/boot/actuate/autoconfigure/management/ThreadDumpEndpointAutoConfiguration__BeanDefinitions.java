package org.springframework.boot.actuate.autoconfigure.management;

import java.lang.Class;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.actuate.management.ThreadDumpEndpoint;

/**
 * Bean definitions for {@link ThreadDumpEndpointAutoConfiguration}.
 */
public class ThreadDumpEndpointAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'threadDumpEndpointAutoConfiguration'.
   */
  public static BeanDefinition getThreadDumpEndpointAutoConfigurationBeanDefinition() {
    Class<?> beanType = ThreadDumpEndpointAutoConfiguration.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(ThreadDumpEndpointAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'dumpEndpoint'.
   */
  private static BeanInstanceSupplier<ThreadDumpEndpoint> getDumpEndpointInstanceSupplier() {
    return BeanInstanceSupplier.<ThreadDumpEndpoint>forFactoryMethod(ThreadDumpEndpointAutoConfiguration.class, "dumpEndpoint")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(ThreadDumpEndpointAutoConfiguration.class).dumpEndpoint());
  }

  /**
   * Get the bean definition for 'dumpEndpoint'.
   */
  public static BeanDefinition getDumpEndpointBeanDefinition() {
    Class<?> beanType = ThreadDumpEndpoint.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getDumpEndpointInstanceSupplier());
    return beanDefinition;
  }
}
