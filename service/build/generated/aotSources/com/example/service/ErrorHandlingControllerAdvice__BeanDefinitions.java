package com.example.service;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ErrorHandlingControllerAdvice}.
 */
public class ErrorHandlingControllerAdvice__BeanDefinitions {
  /**
   * Get the bean definition for 'errorHandlingControllerAdvice'.
   */
  public static BeanDefinition getErrorHandlingControllerAdviceBeanDefinition() {
    Class<?> beanType = ErrorHandlingControllerAdvice.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(ErrorHandlingControllerAdvice::new);
    return beanDefinition;
  }
}
