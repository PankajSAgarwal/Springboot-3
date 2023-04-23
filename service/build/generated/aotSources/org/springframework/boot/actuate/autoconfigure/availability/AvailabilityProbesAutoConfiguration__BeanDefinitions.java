package org.springframework.boot.actuate.autoconfigure.availability;

import java.lang.Class;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.actuate.availability.LivenessStateHealthIndicator;
import org.springframework.boot.actuate.availability.ReadinessStateHealthIndicator;
import org.springframework.boot.availability.ApplicationAvailability;
import org.springframework.core.env.Environment;

/**
 * Bean definitions for {@link AvailabilityProbesAutoConfiguration}.
 */
public class AvailabilityProbesAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'availabilityProbesAutoConfiguration'.
   */
  public static BeanDefinition getAvailabilityProbesAutoConfigurationBeanDefinition() {
    Class<?> beanType = AvailabilityProbesAutoConfiguration.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(AvailabilityProbesAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'livenessStateHealthIndicator'.
   */
  private static BeanInstanceSupplier<LivenessStateHealthIndicator> getLivenessStateHealthIndicatorInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<LivenessStateHealthIndicator>forFactoryMethod(AvailabilityProbesAutoConfiguration.class, "livenessStateHealthIndicator", ApplicationAvailability.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(AvailabilityProbesAutoConfiguration.class).livenessStateHealthIndicator(args.get(0)));
  }

  /**
   * Get the bean definition for 'livenessStateHealthIndicator'.
   */
  public static BeanDefinition getLivenessStateHealthIndicatorBeanDefinition() {
    Class<?> beanType = LivenessStateHealthIndicator.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getLivenessStateHealthIndicatorInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'readinessStateHealthIndicator'.
   */
  private static BeanInstanceSupplier<ReadinessStateHealthIndicator> getReadinessStateHealthIndicatorInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ReadinessStateHealthIndicator>forFactoryMethod(AvailabilityProbesAutoConfiguration.class, "readinessStateHealthIndicator", ApplicationAvailability.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(AvailabilityProbesAutoConfiguration.class).readinessStateHealthIndicator(args.get(0)));
  }

  /**
   * Get the bean definition for 'readinessStateHealthIndicator'.
   */
  public static BeanDefinition getReadinessStateHealthIndicatorBeanDefinition() {
    Class<?> beanType = ReadinessStateHealthIndicator.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getReadinessStateHealthIndicatorInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'availabilityProbesHealthEndpointGroupsPostProcessor'.
   */
  private static BeanInstanceSupplier<AvailabilityProbesHealthEndpointGroupsPostProcessor> getAvailabilityProbesHealthEndpointGroupsPostProcessorInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<AvailabilityProbesHealthEndpointGroupsPostProcessor>forFactoryMethod(AvailabilityProbesAutoConfiguration.class, "availabilityProbesHealthEndpointGroupsPostProcessor", Environment.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(AvailabilityProbesAutoConfiguration.class).availabilityProbesHealthEndpointGroupsPostProcessor(args.get(0)));
  }

  /**
   * Get the bean definition for 'availabilityProbesHealthEndpointGroupsPostProcessor'.
   */
  public static BeanDefinition getAvailabilityProbesHealthEndpointGroupsPostProcessorBeanDefinition(
      ) {
    Class<?> beanType = AvailabilityProbesHealthEndpointGroupsPostProcessor.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getAvailabilityProbesHealthEndpointGroupsPostProcessorInstanceSupplier());
    return beanDefinition;
  }
}
