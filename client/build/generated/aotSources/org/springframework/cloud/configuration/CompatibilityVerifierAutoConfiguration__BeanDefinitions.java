package org.springframework.cloud.configuration;

import java.lang.Class;
import java.util.List;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link CompatibilityVerifierAutoConfiguration}.
 */
public class CompatibilityVerifierAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'compatibilityVerifierAutoConfiguration'.
   */
  public static BeanDefinition getCompatibilityVerifierAutoConfigurationBeanDefinition() {
    Class<?> beanType = CompatibilityVerifierAutoConfiguration.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(CompatibilityVerifierAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'compositeCompatibilityVerifier'.
   */
  private static BeanInstanceSupplier<CompositeCompatibilityVerifier> getCompositeCompatibilityVerifierInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<CompositeCompatibilityVerifier>forFactoryMethod(CompatibilityVerifierAutoConfiguration.class, "compositeCompatibilityVerifier", List.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(CompatibilityVerifierAutoConfiguration.class).compositeCompatibilityVerifier(args.get(0)));
  }

  /**
   * Get the bean definition for 'compositeCompatibilityVerifier'.
   */
  public static BeanDefinition getCompositeCompatibilityVerifierBeanDefinition() {
    Class<?> beanType = CompositeCompatibilityVerifier.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getCompositeCompatibilityVerifierInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'springBootVersionVerifier'.
   */
  private static BeanInstanceSupplier<SpringBootVersionVerifier> getSpringBootVersionVerifierInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SpringBootVersionVerifier>forFactoryMethod(CompatibilityVerifierAutoConfiguration.class, "springBootVersionVerifier", CompatibilityVerifierProperties.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(CompatibilityVerifierAutoConfiguration.class).springBootVersionVerifier(args.get(0)));
  }

  /**
   * Get the bean definition for 'springBootVersionVerifier'.
   */
  public static BeanDefinition getSpringBootVersionVerifierBeanDefinition() {
    Class<?> beanType = SpringBootVersionVerifier.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getSpringBootVersionVerifierInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'sleuthPresentVerifier'.
   */
  private static BeanInstanceSupplier<SleuthPresentVerifier> getSleuthPresentVerifierInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SleuthPresentVerifier>forFactoryMethod(CompatibilityVerifierAutoConfiguration.class, "sleuthPresentVerifier")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(CompatibilityVerifierAutoConfiguration.class).sleuthPresentVerifier());
  }

  /**
   * Get the bean definition for 'sleuthPresentVerifier'.
   */
  public static BeanDefinition getSleuthPresentVerifierBeanDefinition() {
    Class<?> beanType = SleuthPresentVerifier.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getSleuthPresentVerifierInstanceSupplier());
    return beanDefinition;
  }
}
