package org.springframework.boot.actuate.autoconfigure.web.mappings;

import java.lang.Class;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.actuate.web.mappings.MappingsEndpoint;
import org.springframework.boot.actuate.web.mappings.servlet.DispatcherServletsMappingDescriptionProvider;
import org.springframework.boot.actuate.web.mappings.servlet.FiltersMappingDescriptionProvider;
import org.springframework.boot.actuate.web.mappings.servlet.ServletsMappingDescriptionProvider;
import org.springframework.context.ApplicationContext;

/**
 * Bean definitions for {@link MappingsEndpointAutoConfiguration}.
 */
public class MappingsEndpointAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'mappingsEndpointAutoConfiguration'.
   */
  public static BeanDefinition getMappingsEndpointAutoConfigurationBeanDefinition() {
    Class<?> beanType = MappingsEndpointAutoConfiguration.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(MappingsEndpointAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'mappingsEndpoint'.
   */
  private static BeanInstanceSupplier<MappingsEndpoint> getMappingsEndpointInstanceSupplier() {
    return BeanInstanceSupplier.<MappingsEndpoint>forFactoryMethod(MappingsEndpointAutoConfiguration.class, "mappingsEndpoint", ApplicationContext.class, ObjectProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(MappingsEndpointAutoConfiguration.class).mappingsEndpoint(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'mappingsEndpoint'.
   */
  public static BeanDefinition getMappingsEndpointBeanDefinition() {
    Class<?> beanType = MappingsEndpoint.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getMappingsEndpointInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Bean definitions for {@link MappingsEndpointAutoConfiguration.ServletWebConfiguration}.
   */
  public static class ServletWebConfiguration__BeanDefinitions {
    /**
     * Get the bean definition for 'servletWebConfiguration'.
     */
    public static BeanDefinition getServletWebConfigurationBeanDefinition() {
      Class<?> beanType = MappingsEndpointAutoConfiguration.ServletWebConfiguration.class;
      RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
      beanDefinition.setInstanceSupplier(MappingsEndpointAutoConfiguration.ServletWebConfiguration::new);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'servletMappingDescriptionProvider'.
     */
    private static BeanInstanceSupplier<ServletsMappingDescriptionProvider> getServletMappingDescriptionProviderInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<ServletsMappingDescriptionProvider>forFactoryMethod(MappingsEndpointAutoConfiguration.ServletWebConfiguration.class, "servletMappingDescriptionProvider")
              .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(MappingsEndpointAutoConfiguration.ServletWebConfiguration.class).servletMappingDescriptionProvider());
    }

    /**
     * Get the bean definition for 'servletMappingDescriptionProvider'.
     */
    public static BeanDefinition getServletMappingDescriptionProviderBeanDefinition() {
      Class<?> beanType = ServletsMappingDescriptionProvider.class;
      RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
      beanDefinition.setInstanceSupplier(getServletMappingDescriptionProviderInstanceSupplier());
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'filterMappingDescriptionProvider'.
     */
    private static BeanInstanceSupplier<FiltersMappingDescriptionProvider> getFilterMappingDescriptionProviderInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<FiltersMappingDescriptionProvider>forFactoryMethod(MappingsEndpointAutoConfiguration.ServletWebConfiguration.class, "filterMappingDescriptionProvider")
              .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(MappingsEndpointAutoConfiguration.ServletWebConfiguration.class).filterMappingDescriptionProvider());
    }

    /**
     * Get the bean definition for 'filterMappingDescriptionProvider'.
     */
    public static BeanDefinition getFilterMappingDescriptionProviderBeanDefinition() {
      Class<?> beanType = FiltersMappingDescriptionProvider.class;
      RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
      beanDefinition.setInstanceSupplier(getFilterMappingDescriptionProviderInstanceSupplier());
      return beanDefinition;
    }

    /**
     * Bean definitions for {@link MappingsEndpointAutoConfiguration.ServletWebConfiguration.SpringMvcConfiguration}.
     */
    public static class SpringMvcConfiguration__BeanDefinitions {
      /**
       * Get the bean definition for 'springMvcConfiguration'.
       */
      public static BeanDefinition getSpringMvcConfigurationBeanDefinition() {
        Class<?> beanType = MappingsEndpointAutoConfiguration.ServletWebConfiguration.SpringMvcConfiguration.class;
        RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
        beanDefinition.setInstanceSupplier(MappingsEndpointAutoConfiguration.ServletWebConfiguration.SpringMvcConfiguration::new);
        return beanDefinition;
      }

      /**
       * Get the bean instance supplier for 'dispatcherServletMappingDescriptionProvider'.
       */
      private static BeanInstanceSupplier<DispatcherServletsMappingDescriptionProvider> getDispatcherServletMappingDescriptionProviderInstanceSupplier(
          ) {
        return BeanInstanceSupplier.<DispatcherServletsMappingDescriptionProvider>forFactoryMethod(MappingsEndpointAutoConfiguration.ServletWebConfiguration.SpringMvcConfiguration.class, "dispatcherServletMappingDescriptionProvider")
                .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(MappingsEndpointAutoConfiguration.ServletWebConfiguration.SpringMvcConfiguration.class).dispatcherServletMappingDescriptionProvider());
      }

      /**
       * Get the bean definition for 'dispatcherServletMappingDescriptionProvider'.
       */
      public static BeanDefinition getDispatcherServletMappingDescriptionProviderBeanDefinition() {
        Class<?> beanType = DispatcherServletsMappingDescriptionProvider.class;
        RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
        beanDefinition.setInstanceSupplier(getDispatcherServletMappingDescriptionProviderInstanceSupplier());
        return beanDefinition;
      }
    }
  }
}
