package org.springframework.boot.actuate.autoconfigure.management;

import java.lang.Class;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.actuate.management.HeapDumpWebEndpoint;

/**
 * Bean definitions for {@link HeapDumpWebEndpointAutoConfiguration}.
 */
public class HeapDumpWebEndpointAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'heapDumpWebEndpointAutoConfiguration'.
   */
  public static BeanDefinition getHeapDumpWebEndpointAutoConfigurationBeanDefinition() {
    Class<?> beanType = HeapDumpWebEndpointAutoConfiguration.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(HeapDumpWebEndpointAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'heapDumpWebEndpoint'.
   */
  private static BeanInstanceSupplier<HeapDumpWebEndpoint> getHeapDumpWebEndpointInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<HeapDumpWebEndpoint>forFactoryMethod(HeapDumpWebEndpointAutoConfiguration.class, "heapDumpWebEndpoint")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(HeapDumpWebEndpointAutoConfiguration.class).heapDumpWebEndpoint());
  }

  /**
   * Get the bean definition for 'heapDumpWebEndpoint'.
   */
  public static BeanDefinition getHeapDumpWebEndpointBeanDefinition() {
    Class<?> beanType = HeapDumpWebEndpoint.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getHeapDumpWebEndpointInstanceSupplier());
    return beanDefinition;
  }
}
