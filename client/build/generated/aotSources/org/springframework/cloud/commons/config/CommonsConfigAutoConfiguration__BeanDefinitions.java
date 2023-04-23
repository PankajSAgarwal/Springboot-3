package org.springframework.cloud.commons.config;

import java.lang.Class;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link CommonsConfigAutoConfiguration}.
 */
public class CommonsConfigAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'commonsConfigAutoConfiguration'.
   */
  public static BeanDefinition getCommonsConfigAutoConfigurationBeanDefinition() {
    Class<?> beanType = CommonsConfigAutoConfiguration.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(CommonsConfigAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'defaultsBindHandlerAdvisor'.
   */
  private static BeanInstanceSupplier<DefaultsBindHandlerAdvisor> getDefaultsBindHandlerAdvisorInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<DefaultsBindHandlerAdvisor>forFactoryMethod(CommonsConfigAutoConfiguration.class, "defaultsBindHandlerAdvisor", DefaultsBindHandlerAdvisor.MappingsProvider[].class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(CommonsConfigAutoConfiguration.class).defaultsBindHandlerAdvisor(args.get(0)));
  }

  /**
   * Get the bean definition for 'defaultsBindHandlerAdvisor'.
   */
  public static BeanDefinition getDefaultsBindHandlerAdvisorBeanDefinition() {
    Class<?> beanType = DefaultsBindHandlerAdvisor.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getDefaultsBindHandlerAdvisorInstanceSupplier());
    return beanDefinition;
  }
}
