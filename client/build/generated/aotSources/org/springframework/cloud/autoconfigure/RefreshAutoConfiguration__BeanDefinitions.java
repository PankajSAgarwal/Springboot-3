package org.springframework.cloud.autoconfigure;

import java.lang.Class;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.cloud.context.refresh.ConfigDataContextRefresher;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.cloud.context.scope.refresh.RefreshScope;
import org.springframework.cloud.endpoint.event.RefreshEventListener;
import org.springframework.cloud.logging.LoggingRebinder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Bean definitions for {@link RefreshAutoConfiguration}.
 */
public class RefreshAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'refreshAutoConfiguration'.
   */
  public static BeanDefinition getRefreshAutoConfigurationBeanDefinition() {
    Class<?> beanType = RefreshAutoConfiguration.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(RefreshAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean definition for 'refreshScope'.
   */
  public static BeanDefinition getRefreshScopeBeanDefinition() {
    Class<?> beanType = RefreshScope.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(BeanInstanceSupplier.<RefreshScope>forFactoryMethod(RefreshAutoConfiguration.class, "refreshScope").withGenerator(RefreshAutoConfiguration::refreshScope));
    return beanDefinition;
  }

  /**
   * Get the bean definition for 'loggingRebinder'.
   */
  public static BeanDefinition getLoggingRebinderBeanDefinition() {
    Class<?> beanType = LoggingRebinder.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(BeanInstanceSupplier.<LoggingRebinder>forFactoryMethod(RefreshAutoConfiguration.class, "loggingRebinder").withGenerator(RefreshAutoConfiguration::loggingRebinder));
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'configDataContextRefresher'.
   */
  private static BeanInstanceSupplier<ConfigDataContextRefresher> getConfigDataContextRefresherInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ConfigDataContextRefresher>forFactoryMethod(RefreshAutoConfiguration.class, "configDataContextRefresher", ConfigurableApplicationContext.class, RefreshScope.class, RefreshAutoConfiguration.RefreshProperties.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(RefreshAutoConfiguration.class).configDataContextRefresher(args.get(0), args.get(1), args.get(2)));
  }

  /**
   * Get the bean definition for 'configDataContextRefresher'.
   */
  public static BeanDefinition getConfigDataContextRefresherBeanDefinition() {
    Class<?> beanType = ConfigDataContextRefresher.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getConfigDataContextRefresherInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'refreshEventListener'.
   */
  private static BeanInstanceSupplier<RefreshEventListener> getRefreshEventListenerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<RefreshEventListener>forFactoryMethod(RefreshAutoConfiguration.class, "refreshEventListener", ContextRefresher.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(RefreshAutoConfiguration.class).refreshEventListener(args.get(0)));
  }

  /**
   * Get the bean definition for 'refreshEventListener'.
   */
  public static BeanDefinition getRefreshEventListenerBeanDefinition() {
    Class<?> beanType = RefreshEventListener.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getRefreshEventListenerInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Bean definitions for {@link RefreshAutoConfiguration.RefreshProperties}.
   */
  public static class RefreshProperties__BeanDefinitions {
    /**
     * Get the bean definition for 'refreshProperties'.
     */
    public static BeanDefinition getRefreshPropertiesBeanDefinition() {
      Class<?> beanType = RefreshAutoConfiguration.RefreshProperties.class;
      RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
      beanDefinition.setInstanceSupplier(RefreshAutoConfiguration.RefreshProperties::new);
      return beanDefinition;
    }
  }

  /**
   * Bean definitions for {@link RefreshAutoConfiguration.RefreshScopeBeanDefinitionEnhancer}.
   */
  public static class RefreshScopeBeanDefinitionEnhancer__BeanDefinitions {
    /**
     * Get the bean definition for 'refreshScopeBeanDefinitionEnhancer'.
     */
    public static BeanDefinition getRefreshScopeBeanDefinitionEnhancerBeanDefinition() {
      Class<?> beanType = RefreshAutoConfiguration.RefreshScopeBeanDefinitionEnhancer.class;
      RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
      beanDefinition.setInstanceSupplier(RefreshAutoConfiguration.RefreshScopeBeanDefinitionEnhancer::new);
      return beanDefinition;
    }
  }
}
