package org.springframework.cloud.autoconfigure;

import java.lang.Class;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.cloud.context.properties.ConfigurationPropertiesBeans;
import org.springframework.cloud.context.properties.ConfigurationPropertiesRebinder;

/**
 * Bean definitions for {@link ConfigurationPropertiesRebinderAutoConfiguration}.
 */
public class ConfigurationPropertiesRebinderAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'configurationPropertiesRebinderAutoConfiguration'.
   */
  public static BeanDefinition getConfigurationPropertiesRebinderAutoConfigurationBeanDefinition() {
    Class<?> beanType = ConfigurationPropertiesRebinderAutoConfiguration.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(ConfigurationPropertiesRebinderAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean definition for 'configurationPropertiesBeans'.
   */
  public static BeanDefinition getConfigurationPropertiesBeansBeanDefinition() {
    Class<?> beanType = ConfigurationPropertiesBeans.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(BeanInstanceSupplier.<ConfigurationPropertiesBeans>forFactoryMethod(ConfigurationPropertiesRebinderAutoConfiguration.class, "configurationPropertiesBeans").withGenerator(ConfigurationPropertiesRebinderAutoConfiguration::configurationPropertiesBeans));
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'configurationPropertiesRebinder'.
   */
  private static BeanInstanceSupplier<ConfigurationPropertiesRebinder> getConfigurationPropertiesRebinderInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ConfigurationPropertiesRebinder>forFactoryMethod(ConfigurationPropertiesRebinderAutoConfiguration.class, "configurationPropertiesRebinder", ConfigurationPropertiesBeans.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(ConfigurationPropertiesRebinderAutoConfiguration.class).configurationPropertiesRebinder(args.get(0)));
  }

  /**
   * Get the bean definition for 'configurationPropertiesRebinder'.
   */
  public static BeanDefinition getConfigurationPropertiesRebinderBeanDefinition() {
    Class<?> beanType = ConfigurationPropertiesRebinder.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getConfigurationPropertiesRebinderInstanceSupplier());
    return beanDefinition;
  }
}
