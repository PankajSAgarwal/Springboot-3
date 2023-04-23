package org.springframework.cloud.gateway.config;

import java.lang.Class;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.gateway.filter.AdaptCachedBodyGlobalFilter;
import org.springframework.cloud.gateway.filter.ForwardPathFilter;
import org.springframework.cloud.gateway.filter.ForwardRoutingFilter;
import org.springframework.cloud.gateway.filter.NettyRoutingFilter;
import org.springframework.cloud.gateway.filter.NettyWriteResponseFilter;
import org.springframework.cloud.gateway.filter.RemoveCachedBodyFilter;
import org.springframework.cloud.gateway.filter.RouteToRequestUrlFilter;
import org.springframework.cloud.gateway.filter.WebsocketRoutingFilter;
import org.springframework.cloud.gateway.filter.WeightCalculatorWebFilter;
import org.springframework.cloud.gateway.filter.cors.CorsGatewayFilterApplicationListener;
import org.springframework.cloud.gateway.filter.factory.AddRequestHeaderGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.AddRequestHeadersIfNotPresentGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.AddRequestParameterGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.AddResponseHeaderGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.CacheRequestBodyGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.DedupeResponseHeaderGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.MapRequestHeaderGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.PrefixPathGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.PreserveHostHeaderGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.RedirectToGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.RemoveJsonAttributesResponseBodyGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.RemoveRequestHeaderGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.RemoveRequestParameterGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.RemoveResponseHeaderGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.RequestHeaderSizeGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.RequestHeaderToRequestUriGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.RequestSizeGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.RetryGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.RewriteLocationResponseHeaderGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.RewritePathGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.RewriteResponseHeaderGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.SaveSessionGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.SecureHeadersGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.SecureHeadersProperties;
import org.springframework.cloud.gateway.filter.factory.SetPathGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.SetRequestHeaderGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.SetRequestHostHeaderGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.SetResponseHeaderGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.SetStatusGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.StripPrefixGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.rewrite.GzipMessageBodyResolver;
import org.springframework.cloud.gateway.filter.factory.rewrite.ModifyRequestBodyGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.rewrite.ModifyResponseBodyGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.headers.ForwardedHeadersFilter;
import org.springframework.cloud.gateway.filter.headers.GRPCRequestHeadersFilter;
import org.springframework.cloud.gateway.filter.headers.GRPCResponseHeadersFilter;
import org.springframework.cloud.gateway.filter.headers.RemoveHopByHopHeadersFilter;
import org.springframework.cloud.gateway.filter.headers.TransferEncodingNormalizationHeadersFilter;
import org.springframework.cloud.gateway.filter.headers.XForwardedHeadersFilter;
import org.springframework.cloud.gateway.handler.FilteringWebHandler;
import org.springframework.cloud.gateway.handler.RoutePredicateHandlerMapping;
import org.springframework.cloud.gateway.handler.predicate.AfterRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.BeforeRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.BetweenRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.CloudFoundryRouteServiceRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.CookieRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.HeaderRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.HostRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.MethodRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.PathRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.QueryRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.ReadBodyRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.RemoteAddrRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.WeightRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.XForwardedRemoteAddrRoutePredicateFactory;
import org.springframework.cloud.gateway.route.InMemoryRouteDefinitionRepository;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.RouteRefreshListener;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.gateway.support.ConfigurationService;
import org.springframework.cloud.gateway.support.KeyValueConverter;
import org.springframework.cloud.gateway.support.StringToZonedDateTimeConverter;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.reactive.socket.client.ReactorNettyWebSocketClient;
import org.springframework.web.reactive.socket.client.WebSocketClient;
import org.springframework.web.reactive.socket.server.RequestUpgradeStrategy;
import org.springframework.web.reactive.socket.server.WebSocketService;
import org.springframework.web.reactive.socket.server.upgrade.ReactorNettyRequestUpgradeStrategy;
import reactor.netty.http.client.HttpClient;

/**
 * Bean definitions for {@link GatewayAutoConfiguration}.
 */
public class GatewayAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'gatewayAutoConfiguration'.
   */
  public static BeanDefinition getGatewayAutoConfigurationBeanDefinition() {
    Class<?> beanType = GatewayAutoConfiguration.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(GatewayAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'stringToZonedDateTimeConverter'.
   */
  private static BeanInstanceSupplier<StringToZonedDateTimeConverter> getStringToZonedDateTimeConverterInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<StringToZonedDateTimeConverter>forFactoryMethod(GatewayAutoConfiguration.class, "stringToZonedDateTimeConverter")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).stringToZonedDateTimeConverter());
  }

  /**
   * Get the bean definition for 'stringToZonedDateTimeConverter'.
   */
  public static BeanDefinition getStringToZonedDateTimeConverterBeanDefinition() {
    Class<?> beanType = StringToZonedDateTimeConverter.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getStringToZonedDateTimeConverterInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'keyValueConverter'.
   */
  private static BeanInstanceSupplier<KeyValueConverter> getKeyValueConverterInstanceSupplier() {
    return BeanInstanceSupplier.<KeyValueConverter>forFactoryMethod(GatewayAutoConfiguration.class, "keyValueConverter")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).keyValueConverter());
  }

  /**
   * Get the bean definition for 'keyValueConverter'.
   */
  public static BeanDefinition getKeyValueConverterBeanDefinition() {
    Class<?> beanType = KeyValueConverter.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getKeyValueConverterInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'routeLocatorBuilder'.
   */
  private static BeanInstanceSupplier<RouteLocatorBuilder> getRouteLocatorBuilderInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<RouteLocatorBuilder>forFactoryMethod(GatewayAutoConfiguration.class, "routeLocatorBuilder", ConfigurableApplicationContext.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).routeLocatorBuilder(args.get(0)));
  }

  /**
   * Get the bean definition for 'routeLocatorBuilder'.
   */
  public static BeanDefinition getRouteLocatorBuilderBeanDefinition() {
    Class<?> beanType = RouteLocatorBuilder.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getRouteLocatorBuilderInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'propertiesRouteDefinitionLocator'.
   */
  private static BeanInstanceSupplier<PropertiesRouteDefinitionLocator> getPropertiesRouteDefinitionLocatorInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<PropertiesRouteDefinitionLocator>forFactoryMethod(GatewayAutoConfiguration.class, "propertiesRouteDefinitionLocator", GatewayProperties.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).propertiesRouteDefinitionLocator(args.get(0)));
  }

  /**
   * Get the bean definition for 'propertiesRouteDefinitionLocator'.
   */
  public static BeanDefinition getPropertiesRouteDefinitionLocatorBeanDefinition() {
    Class<?> beanType = PropertiesRouteDefinitionLocator.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getPropertiesRouteDefinitionLocatorInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'inMemoryRouteDefinitionRepository'.
   */
  private static BeanInstanceSupplier<InMemoryRouteDefinitionRepository> getInMemoryRouteDefinitionRepositoryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<InMemoryRouteDefinitionRepository>forFactoryMethod(GatewayAutoConfiguration.class, "inMemoryRouteDefinitionRepository")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).inMemoryRouteDefinitionRepository());
  }

  /**
   * Get the bean definition for 'inMemoryRouteDefinitionRepository'.
   */
  public static BeanDefinition getInMemoryRouteDefinitionRepositoryBeanDefinition() {
    Class<?> beanType = InMemoryRouteDefinitionRepository.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getInMemoryRouteDefinitionRepositoryInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'routeDefinitionLocator'.
   */
  private static BeanInstanceSupplier<RouteDefinitionLocator> getRouteDefinitionLocatorInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<RouteDefinitionLocator>forFactoryMethod(GatewayAutoConfiguration.class, "routeDefinitionLocator", List.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).routeDefinitionLocator(args.get(0)));
  }

  /**
   * Get the bean definition for 'routeDefinitionLocator'.
   */
  public static BeanDefinition getRouteDefinitionLocatorBeanDefinition() {
    Class<?> beanType = RouteDefinitionLocator.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setPrimary(true);
    beanDefinition.setInstanceSupplier(getRouteDefinitionLocatorInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'gatewayConfigurationService'.
   */
  private static BeanInstanceSupplier<ConfigurationService> getGatewayConfigurationServiceInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ConfigurationService>forFactoryMethod(GatewayAutoConfiguration.class, "gatewayConfigurationService", BeanFactory.class, ObjectProvider.class, ObjectProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).gatewayConfigurationService(args.get(0), args.get(1), args.get(2)));
  }

  /**
   * Get the bean definition for 'gatewayConfigurationService'.
   */
  public static BeanDefinition getGatewayConfigurationServiceBeanDefinition() {
    Class<?> beanType = ConfigurationService.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getGatewayConfigurationServiceInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'routeDefinitionRouteLocator'.
   */
  private static BeanInstanceSupplier<RouteLocator> getRouteDefinitionRouteLocatorInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<RouteLocator>forFactoryMethod(GatewayAutoConfiguration.class, "routeDefinitionRouteLocator", GatewayProperties.class, List.class, List.class, RouteDefinitionLocator.class, ConfigurationService.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).routeDefinitionRouteLocator(args.get(0), args.get(1), args.get(2), args.get(3), args.get(4)));
  }

  /**
   * Get the bean definition for 'routeDefinitionRouteLocator'.
   */
  public static BeanDefinition getRouteDefinitionRouteLocatorBeanDefinition() {
    Class<?> beanType = RouteLocator.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getRouteDefinitionRouteLocatorInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'cachedCompositeRouteLocator'.
   */
  private static BeanInstanceSupplier<RouteLocator> getCachedCompositeRouteLocatorInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<RouteLocator>forFactoryMethod(GatewayAutoConfiguration.class, "cachedCompositeRouteLocator", List.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).cachedCompositeRouteLocator(args.get(0)));
  }

  /**
   * Get the bean definition for 'cachedCompositeRouteLocator'.
   */
  public static BeanDefinition getCachedCompositeRouteLocatorBeanDefinition() {
    Class<?> beanType = RouteLocator.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setPrimary(true);
    beanDefinition.setInstanceSupplier(getCachedCompositeRouteLocatorInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'routeRefreshListener'.
   */
  private static BeanInstanceSupplier<RouteRefreshListener> getRouteRefreshListenerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<RouteRefreshListener>forFactoryMethod(GatewayAutoConfiguration.class, "routeRefreshListener", ApplicationEventPublisher.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).routeRefreshListener(args.get(0)));
  }

  /**
   * Get the bean definition for 'routeRefreshListener'.
   */
  public static BeanDefinition getRouteRefreshListenerBeanDefinition() {
    Class<?> beanType = RouteRefreshListener.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getRouteRefreshListenerInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'filteringWebHandler'.
   */
  private static BeanInstanceSupplier<FilteringWebHandler> getFilteringWebHandlerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<FilteringWebHandler>forFactoryMethod(GatewayAutoConfiguration.class, "filteringWebHandler", List.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).filteringWebHandler(args.get(0)));
  }

  /**
   * Get the bean definition for 'filteringWebHandler'.
   */
  public static BeanDefinition getFilteringWebHandlerBeanDefinition() {
    Class<?> beanType = FilteringWebHandler.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getFilteringWebHandlerInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'globalCorsProperties'.
   */
  private static BeanInstanceSupplier<GlobalCorsProperties> getGlobalCorsPropertiesInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<GlobalCorsProperties>forFactoryMethod(GatewayAutoConfiguration.class, "globalCorsProperties")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).globalCorsProperties());
  }

  /**
   * Get the bean definition for 'globalCorsProperties'.
   */
  public static BeanDefinition getGlobalCorsPropertiesBeanDefinition() {
    Class<?> beanType = GlobalCorsProperties.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getGlobalCorsPropertiesInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'corsGatewayFilterApplicationListener'.
   */
  private static BeanInstanceSupplier<CorsGatewayFilterApplicationListener> getCorsGatewayFilterApplicationListenerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<CorsGatewayFilterApplicationListener>forFactoryMethod(GatewayAutoConfiguration.class, "corsGatewayFilterApplicationListener", GlobalCorsProperties.class, RoutePredicateHandlerMapping.class, RouteLocator.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).corsGatewayFilterApplicationListener(args.get(0), args.get(1), args.get(2)));
  }

  /**
   * Get the bean definition for 'corsGatewayFilterApplicationListener'.
   */
  public static BeanDefinition getCorsGatewayFilterApplicationListenerBeanDefinition() {
    Class<?> beanType = CorsGatewayFilterApplicationListener.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getCorsGatewayFilterApplicationListenerInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'routePredicateHandlerMapping'.
   */
  private static BeanInstanceSupplier<RoutePredicateHandlerMapping> getRoutePredicateHandlerMappingInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<RoutePredicateHandlerMapping>forFactoryMethod(GatewayAutoConfiguration.class, "routePredicateHandlerMapping", FilteringWebHandler.class, RouteLocator.class, GlobalCorsProperties.class, Environment.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).routePredicateHandlerMapping(args.get(0), args.get(1), args.get(2), args.get(3)));
  }

  /**
   * Get the bean definition for 'routePredicateHandlerMapping'.
   */
  public static BeanDefinition getRoutePredicateHandlerMappingBeanDefinition() {
    Class<?> beanType = RoutePredicateHandlerMapping.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getRoutePredicateHandlerMappingInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'gatewayProperties'.
   */
  private static BeanInstanceSupplier<GatewayProperties> getGatewayPropertiesInstanceSupplier() {
    return BeanInstanceSupplier.<GatewayProperties>forFactoryMethod(GatewayAutoConfiguration.class, "gatewayProperties")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).gatewayProperties());
  }

  /**
   * Get the bean definition for 'gatewayProperties'.
   */
  public static BeanDefinition getGatewayPropertiesBeanDefinition() {
    Class<?> beanType = GatewayProperties.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getGatewayPropertiesInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'secureHeadersProperties'.
   */
  private static BeanInstanceSupplier<SecureHeadersProperties> getSecureHeadersPropertiesInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SecureHeadersProperties>forFactoryMethod(GatewayAutoConfiguration.class, "secureHeadersProperties")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).secureHeadersProperties());
  }

  /**
   * Get the bean definition for 'secureHeadersProperties'.
   */
  public static BeanDefinition getSecureHeadersPropertiesBeanDefinition() {
    Class<?> beanType = SecureHeadersProperties.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getSecureHeadersPropertiesInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'forwardedHeadersFilter'.
   */
  private static BeanInstanceSupplier<ForwardedHeadersFilter> getForwardedHeadersFilterInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ForwardedHeadersFilter>forFactoryMethod(GatewayAutoConfiguration.class, "forwardedHeadersFilter")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).forwardedHeadersFilter());
  }

  /**
   * Get the bean definition for 'forwardedHeadersFilter'.
   */
  public static BeanDefinition getForwardedHeadersFilterBeanDefinition() {
    Class<?> beanType = ForwardedHeadersFilter.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getForwardedHeadersFilterInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'removeHopByHopHeadersFilter'.
   */
  private static BeanInstanceSupplier<RemoveHopByHopHeadersFilter> getRemoveHopByHopHeadersFilterInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<RemoveHopByHopHeadersFilter>forFactoryMethod(GatewayAutoConfiguration.class, "removeHopByHopHeadersFilter")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).removeHopByHopHeadersFilter());
  }

  /**
   * Get the bean definition for 'removeHopByHopHeadersFilter'.
   */
  public static BeanDefinition getRemoveHopByHopHeadersFilterBeanDefinition() {
    Class<?> beanType = RemoveHopByHopHeadersFilter.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getRemoveHopByHopHeadersFilterInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'xForwardedHeadersFilter'.
   */
  private static BeanInstanceSupplier<XForwardedHeadersFilter> getXForwardedHeadersFilterInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<XForwardedHeadersFilter>forFactoryMethod(GatewayAutoConfiguration.class, "xForwardedHeadersFilter")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).xForwardedHeadersFilter());
  }

  /**
   * Get the bean definition for 'xForwardedHeadersFilter'.
   */
  public static BeanDefinition getXForwardedHeadersFilterBeanDefinition() {
    Class<?> beanType = XForwardedHeadersFilter.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getXForwardedHeadersFilterInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'gRPCRequestHeadersFilter'.
   */
  private static BeanInstanceSupplier<GRPCRequestHeadersFilter> getGRPCRequestHeadersFilterInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<GRPCRequestHeadersFilter>forFactoryMethod(GatewayAutoConfiguration.class, "gRPCRequestHeadersFilter")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).gRPCRequestHeadersFilter());
  }

  /**
   * Get the bean definition for 'gRPCRequestHeadersFilter'.
   */
  public static BeanDefinition getGRPCRequestHeadersFilterBeanDefinition() {
    Class<?> beanType = GRPCRequestHeadersFilter.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getGRPCRequestHeadersFilterInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'gRPCResponseHeadersFilter'.
   */
  private static BeanInstanceSupplier<GRPCResponseHeadersFilter> getGRPCResponseHeadersFilterInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<GRPCResponseHeadersFilter>forFactoryMethod(GatewayAutoConfiguration.class, "gRPCResponseHeadersFilter")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).gRPCResponseHeadersFilter());
  }

  /**
   * Get the bean definition for 'gRPCResponseHeadersFilter'.
   */
  public static BeanDefinition getGRPCResponseHeadersFilterBeanDefinition() {
    Class<?> beanType = GRPCResponseHeadersFilter.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getGRPCResponseHeadersFilterInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'transferEncodingNormalizationHeadersFilter'.
   */
  private static BeanInstanceSupplier<TransferEncodingNormalizationHeadersFilter> getTransferEncodingNormalizationHeadersFilterInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<TransferEncodingNormalizationHeadersFilter>forFactoryMethod(GatewayAutoConfiguration.class, "transferEncodingNormalizationHeadersFilter")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).transferEncodingNormalizationHeadersFilter());
  }

  /**
   * Get the bean definition for 'transferEncodingNormalizationHeadersFilter'.
   */
  public static BeanDefinition getTransferEncodingNormalizationHeadersFilterBeanDefinition() {
    Class<?> beanType = TransferEncodingNormalizationHeadersFilter.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getTransferEncodingNormalizationHeadersFilterInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'adaptCachedBodyGlobalFilter'.
   */
  private static BeanInstanceSupplier<AdaptCachedBodyGlobalFilter> getAdaptCachedBodyGlobalFilterInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<AdaptCachedBodyGlobalFilter>forFactoryMethod(GatewayAutoConfiguration.class, "adaptCachedBodyGlobalFilter")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).adaptCachedBodyGlobalFilter());
  }

  /**
   * Get the bean definition for 'adaptCachedBodyGlobalFilter'.
   */
  public static BeanDefinition getAdaptCachedBodyGlobalFilterBeanDefinition() {
    Class<?> beanType = AdaptCachedBodyGlobalFilter.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getAdaptCachedBodyGlobalFilterInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'removeCachedBodyFilter'.
   */
  private static BeanInstanceSupplier<RemoveCachedBodyFilter> getRemoveCachedBodyFilterInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<RemoveCachedBodyFilter>forFactoryMethod(GatewayAutoConfiguration.class, "removeCachedBodyFilter")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).removeCachedBodyFilter());
  }

  /**
   * Get the bean definition for 'removeCachedBodyFilter'.
   */
  public static BeanDefinition getRemoveCachedBodyFilterBeanDefinition() {
    Class<?> beanType = RemoveCachedBodyFilter.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getRemoveCachedBodyFilterInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'routeToRequestUrlFilter'.
   */
  private static BeanInstanceSupplier<RouteToRequestUrlFilter> getRouteToRequestUrlFilterInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<RouteToRequestUrlFilter>forFactoryMethod(GatewayAutoConfiguration.class, "routeToRequestUrlFilter")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).routeToRequestUrlFilter());
  }

  /**
   * Get the bean definition for 'routeToRequestUrlFilter'.
   */
  public static BeanDefinition getRouteToRequestUrlFilterBeanDefinition() {
    Class<?> beanType = RouteToRequestUrlFilter.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getRouteToRequestUrlFilterInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'forwardRoutingFilter'.
   */
  private static BeanInstanceSupplier<ForwardRoutingFilter> getForwardRoutingFilterInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ForwardRoutingFilter>forFactoryMethod(GatewayAutoConfiguration.class, "forwardRoutingFilter", ObjectProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).forwardRoutingFilter(args.get(0)));
  }

  /**
   * Get the bean definition for 'forwardRoutingFilter'.
   */
  public static BeanDefinition getForwardRoutingFilterBeanDefinition() {
    Class<?> beanType = ForwardRoutingFilter.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getForwardRoutingFilterInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'forwardPathFilter'.
   */
  private static BeanInstanceSupplier<ForwardPathFilter> getForwardPathFilterInstanceSupplier() {
    return BeanInstanceSupplier.<ForwardPathFilter>forFactoryMethod(GatewayAutoConfiguration.class, "forwardPathFilter")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).forwardPathFilter());
  }

  /**
   * Get the bean definition for 'forwardPathFilter'.
   */
  public static BeanDefinition getForwardPathFilterBeanDefinition() {
    Class<?> beanType = ForwardPathFilter.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getForwardPathFilterInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'webSocketService'.
   */
  private static BeanInstanceSupplier<WebSocketService> getWebSocketServiceInstanceSupplier() {
    return BeanInstanceSupplier.<WebSocketService>forFactoryMethod(GatewayAutoConfiguration.class, "webSocketService", RequestUpgradeStrategy.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).webSocketService(args.get(0)));
  }

  /**
   * Get the bean definition for 'webSocketService'.
   */
  public static BeanDefinition getWebSocketServiceBeanDefinition() {
    Class<?> beanType = WebSocketService.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getWebSocketServiceInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'websocketRoutingFilter'.
   */
  private static BeanInstanceSupplier<WebsocketRoutingFilter> getWebsocketRoutingFilterInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<WebsocketRoutingFilter>forFactoryMethod(GatewayAutoConfiguration.class, "websocketRoutingFilter", WebSocketClient.class, WebSocketService.class, ObjectProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).websocketRoutingFilter(args.get(0), args.get(1), args.get(2)));
  }

  /**
   * Get the bean definition for 'websocketRoutingFilter'.
   */
  public static BeanDefinition getWebsocketRoutingFilterBeanDefinition() {
    Class<?> beanType = WebsocketRoutingFilter.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getWebsocketRoutingFilterInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'weightCalculatorWebFilter'.
   */
  private static BeanInstanceSupplier<WeightCalculatorWebFilter> getWeightCalculatorWebFilterInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<WeightCalculatorWebFilter>forFactoryMethod(GatewayAutoConfiguration.class, "weightCalculatorWebFilter", ConfigurationService.class, ObjectProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).weightCalculatorWebFilter(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'weightCalculatorWebFilter'.
   */
  public static BeanDefinition getWeightCalculatorWebFilterBeanDefinition() {
    Class<?> beanType = WeightCalculatorWebFilter.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getWeightCalculatorWebFilterInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'afterRoutePredicateFactory'.
   */
  private static BeanInstanceSupplier<AfterRoutePredicateFactory> getAfterRoutePredicateFactoryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<AfterRoutePredicateFactory>forFactoryMethod(GatewayAutoConfiguration.class, "afterRoutePredicateFactory")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).afterRoutePredicateFactory());
  }

  /**
   * Get the bean definition for 'afterRoutePredicateFactory'.
   */
  public static BeanDefinition getAfterRoutePredicateFactoryBeanDefinition() {
    Class<?> beanType = AfterRoutePredicateFactory.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getAfterRoutePredicateFactoryInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'beforeRoutePredicateFactory'.
   */
  private static BeanInstanceSupplier<BeforeRoutePredicateFactory> getBeforeRoutePredicateFactoryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<BeforeRoutePredicateFactory>forFactoryMethod(GatewayAutoConfiguration.class, "beforeRoutePredicateFactory")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).beforeRoutePredicateFactory());
  }

  /**
   * Get the bean definition for 'beforeRoutePredicateFactory'.
   */
  public static BeanDefinition getBeforeRoutePredicateFactoryBeanDefinition() {
    Class<?> beanType = BeforeRoutePredicateFactory.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getBeforeRoutePredicateFactoryInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'betweenRoutePredicateFactory'.
   */
  private static BeanInstanceSupplier<BetweenRoutePredicateFactory> getBetweenRoutePredicateFactoryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<BetweenRoutePredicateFactory>forFactoryMethod(GatewayAutoConfiguration.class, "betweenRoutePredicateFactory")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).betweenRoutePredicateFactory());
  }

  /**
   * Get the bean definition for 'betweenRoutePredicateFactory'.
   */
  public static BeanDefinition getBetweenRoutePredicateFactoryBeanDefinition() {
    Class<?> beanType = BetweenRoutePredicateFactory.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getBetweenRoutePredicateFactoryInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'cookieRoutePredicateFactory'.
   */
  private static BeanInstanceSupplier<CookieRoutePredicateFactory> getCookieRoutePredicateFactoryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<CookieRoutePredicateFactory>forFactoryMethod(GatewayAutoConfiguration.class, "cookieRoutePredicateFactory")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).cookieRoutePredicateFactory());
  }

  /**
   * Get the bean definition for 'cookieRoutePredicateFactory'.
   */
  public static BeanDefinition getCookieRoutePredicateFactoryBeanDefinition() {
    Class<?> beanType = CookieRoutePredicateFactory.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getCookieRoutePredicateFactoryInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'headerRoutePredicateFactory'.
   */
  private static BeanInstanceSupplier<HeaderRoutePredicateFactory> getHeaderRoutePredicateFactoryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<HeaderRoutePredicateFactory>forFactoryMethod(GatewayAutoConfiguration.class, "headerRoutePredicateFactory")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).headerRoutePredicateFactory());
  }

  /**
   * Get the bean definition for 'headerRoutePredicateFactory'.
   */
  public static BeanDefinition getHeaderRoutePredicateFactoryBeanDefinition() {
    Class<?> beanType = HeaderRoutePredicateFactory.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getHeaderRoutePredicateFactoryInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'hostRoutePredicateFactory'.
   */
  private static BeanInstanceSupplier<HostRoutePredicateFactory> getHostRoutePredicateFactoryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<HostRoutePredicateFactory>forFactoryMethod(GatewayAutoConfiguration.class, "hostRoutePredicateFactory")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).hostRoutePredicateFactory());
  }

  /**
   * Get the bean definition for 'hostRoutePredicateFactory'.
   */
  public static BeanDefinition getHostRoutePredicateFactoryBeanDefinition() {
    Class<?> beanType = HostRoutePredicateFactory.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getHostRoutePredicateFactoryInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'methodRoutePredicateFactory'.
   */
  private static BeanInstanceSupplier<MethodRoutePredicateFactory> getMethodRoutePredicateFactoryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<MethodRoutePredicateFactory>forFactoryMethod(GatewayAutoConfiguration.class, "methodRoutePredicateFactory")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).methodRoutePredicateFactory());
  }

  /**
   * Get the bean definition for 'methodRoutePredicateFactory'.
   */
  public static BeanDefinition getMethodRoutePredicateFactoryBeanDefinition() {
    Class<?> beanType = MethodRoutePredicateFactory.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getMethodRoutePredicateFactoryInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'pathRoutePredicateFactory'.
   */
  private static BeanInstanceSupplier<PathRoutePredicateFactory> getPathRoutePredicateFactoryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<PathRoutePredicateFactory>forFactoryMethod(GatewayAutoConfiguration.class, "pathRoutePredicateFactory")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).pathRoutePredicateFactory());
  }

  /**
   * Get the bean definition for 'pathRoutePredicateFactory'.
   */
  public static BeanDefinition getPathRoutePredicateFactoryBeanDefinition() {
    Class<?> beanType = PathRoutePredicateFactory.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getPathRoutePredicateFactoryInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'queryRoutePredicateFactory'.
   */
  private static BeanInstanceSupplier<QueryRoutePredicateFactory> getQueryRoutePredicateFactoryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<QueryRoutePredicateFactory>forFactoryMethod(GatewayAutoConfiguration.class, "queryRoutePredicateFactory")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).queryRoutePredicateFactory());
  }

  /**
   * Get the bean definition for 'queryRoutePredicateFactory'.
   */
  public static BeanDefinition getQueryRoutePredicateFactoryBeanDefinition() {
    Class<?> beanType = QueryRoutePredicateFactory.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getQueryRoutePredicateFactoryInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'readBodyPredicateFactory'.
   */
  private static BeanInstanceSupplier<ReadBodyRoutePredicateFactory> getReadBodyPredicateFactoryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ReadBodyRoutePredicateFactory>forFactoryMethod(GatewayAutoConfiguration.class, "readBodyPredicateFactory", ServerCodecConfigurer.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).readBodyPredicateFactory(args.get(0)));
  }

  /**
   * Get the bean definition for 'readBodyPredicateFactory'.
   */
  public static BeanDefinition getReadBodyPredicateFactoryBeanDefinition() {
    Class<?> beanType = ReadBodyRoutePredicateFactory.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getReadBodyPredicateFactoryInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'remoteAddrRoutePredicateFactory'.
   */
  private static BeanInstanceSupplier<RemoteAddrRoutePredicateFactory> getRemoteAddrRoutePredicateFactoryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<RemoteAddrRoutePredicateFactory>forFactoryMethod(GatewayAutoConfiguration.class, "remoteAddrRoutePredicateFactory")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).remoteAddrRoutePredicateFactory());
  }

  /**
   * Get the bean definition for 'remoteAddrRoutePredicateFactory'.
   */
  public static BeanDefinition getRemoteAddrRoutePredicateFactoryBeanDefinition() {
    Class<?> beanType = RemoteAddrRoutePredicateFactory.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getRemoteAddrRoutePredicateFactoryInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'xForwardedRemoteAddrRoutePredicateFactory'.
   */
  private static BeanInstanceSupplier<XForwardedRemoteAddrRoutePredicateFactory> getXForwardedRemoteAddrRoutePredicateFactoryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<XForwardedRemoteAddrRoutePredicateFactory>forFactoryMethod(GatewayAutoConfiguration.class, "xForwardedRemoteAddrRoutePredicateFactory")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).xForwardedRemoteAddrRoutePredicateFactory());
  }

  /**
   * Get the bean definition for 'xForwardedRemoteAddrRoutePredicateFactory'.
   */
  public static BeanDefinition getXForwardedRemoteAddrRoutePredicateFactoryBeanDefinition() {
    Class<?> beanType = XForwardedRemoteAddrRoutePredicateFactory.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getXForwardedRemoteAddrRoutePredicateFactoryInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'weightRoutePredicateFactory'.
   */
  private static BeanInstanceSupplier<WeightRoutePredicateFactory> getWeightRoutePredicateFactoryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<WeightRoutePredicateFactory>forFactoryMethod(GatewayAutoConfiguration.class, "weightRoutePredicateFactory")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).weightRoutePredicateFactory());
  }

  /**
   * Get the bean definition for 'weightRoutePredicateFactory'.
   */
  public static BeanDefinition getWeightRoutePredicateFactoryBeanDefinition() {
    Class<?> beanType = WeightRoutePredicateFactory.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setDependsOn("weightCalculatorWebFilter");
    beanDefinition.setInstanceSupplier(getWeightRoutePredicateFactoryInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'cloudFoundryRouteServiceRoutePredicateFactory'.
   */
  private static BeanInstanceSupplier<CloudFoundryRouteServiceRoutePredicateFactory> getCloudFoundryRouteServiceRoutePredicateFactoryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<CloudFoundryRouteServiceRoutePredicateFactory>forFactoryMethod(GatewayAutoConfiguration.class, "cloudFoundryRouteServiceRoutePredicateFactory")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).cloudFoundryRouteServiceRoutePredicateFactory());
  }

  /**
   * Get the bean definition for 'cloudFoundryRouteServiceRoutePredicateFactory'.
   */
  public static BeanDefinition getCloudFoundryRouteServiceRoutePredicateFactoryBeanDefinition() {
    Class<?> beanType = CloudFoundryRouteServiceRoutePredicateFactory.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getCloudFoundryRouteServiceRoutePredicateFactoryInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'addRequestHeaderGatewayFilterFactory'.
   */
  private static BeanInstanceSupplier<AddRequestHeaderGatewayFilterFactory> getAddRequestHeaderGatewayFilterFactoryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<AddRequestHeaderGatewayFilterFactory>forFactoryMethod(GatewayAutoConfiguration.class, "addRequestHeaderGatewayFilterFactory")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).addRequestHeaderGatewayFilterFactory());
  }

  /**
   * Get the bean definition for 'addRequestHeaderGatewayFilterFactory'.
   */
  public static BeanDefinition getAddRequestHeaderGatewayFilterFactoryBeanDefinition() {
    Class<?> beanType = AddRequestHeaderGatewayFilterFactory.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getAddRequestHeaderGatewayFilterFactoryInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'addRequestHeadersIfNotPresentGatewayFilterFactory'.
   */
  private static BeanInstanceSupplier<AddRequestHeadersIfNotPresentGatewayFilterFactory> getAddRequestHeadersIfNotPresentGatewayFilterFactoryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<AddRequestHeadersIfNotPresentGatewayFilterFactory>forFactoryMethod(GatewayAutoConfiguration.class, "addRequestHeadersIfNotPresentGatewayFilterFactory")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).addRequestHeadersIfNotPresentGatewayFilterFactory());
  }

  /**
   * Get the bean definition for 'addRequestHeadersIfNotPresentGatewayFilterFactory'.
   */
  public static BeanDefinition getAddRequestHeadersIfNotPresentGatewayFilterFactoryBeanDefinition(
      ) {
    Class<?> beanType = AddRequestHeadersIfNotPresentGatewayFilterFactory.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getAddRequestHeadersIfNotPresentGatewayFilterFactoryInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'mapRequestHeaderGatewayFilterFactory'.
   */
  private static BeanInstanceSupplier<MapRequestHeaderGatewayFilterFactory> getMapRequestHeaderGatewayFilterFactoryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<MapRequestHeaderGatewayFilterFactory>forFactoryMethod(GatewayAutoConfiguration.class, "mapRequestHeaderGatewayFilterFactory")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).mapRequestHeaderGatewayFilterFactory());
  }

  /**
   * Get the bean definition for 'mapRequestHeaderGatewayFilterFactory'.
   */
  public static BeanDefinition getMapRequestHeaderGatewayFilterFactoryBeanDefinition() {
    Class<?> beanType = MapRequestHeaderGatewayFilterFactory.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getMapRequestHeaderGatewayFilterFactoryInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'addRequestParameterGatewayFilterFactory'.
   */
  private static BeanInstanceSupplier<AddRequestParameterGatewayFilterFactory> getAddRequestParameterGatewayFilterFactoryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<AddRequestParameterGatewayFilterFactory>forFactoryMethod(GatewayAutoConfiguration.class, "addRequestParameterGatewayFilterFactory")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).addRequestParameterGatewayFilterFactory());
  }

  /**
   * Get the bean definition for 'addRequestParameterGatewayFilterFactory'.
   */
  public static BeanDefinition getAddRequestParameterGatewayFilterFactoryBeanDefinition() {
    Class<?> beanType = AddRequestParameterGatewayFilterFactory.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getAddRequestParameterGatewayFilterFactoryInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'addResponseHeaderGatewayFilterFactory'.
   */
  private static BeanInstanceSupplier<AddResponseHeaderGatewayFilterFactory> getAddResponseHeaderGatewayFilterFactoryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<AddResponseHeaderGatewayFilterFactory>forFactoryMethod(GatewayAutoConfiguration.class, "addResponseHeaderGatewayFilterFactory")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).addResponseHeaderGatewayFilterFactory());
  }

  /**
   * Get the bean definition for 'addResponseHeaderGatewayFilterFactory'.
   */
  public static BeanDefinition getAddResponseHeaderGatewayFilterFactoryBeanDefinition() {
    Class<?> beanType = AddResponseHeaderGatewayFilterFactory.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getAddResponseHeaderGatewayFilterFactoryInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'modifyRequestBodyGatewayFilterFactory'.
   */
  private static BeanInstanceSupplier<ModifyRequestBodyGatewayFilterFactory> getModifyRequestBodyGatewayFilterFactoryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ModifyRequestBodyGatewayFilterFactory>forFactoryMethod(GatewayAutoConfiguration.class, "modifyRequestBodyGatewayFilterFactory", ServerCodecConfigurer.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).modifyRequestBodyGatewayFilterFactory(args.get(0)));
  }

  /**
   * Get the bean definition for 'modifyRequestBodyGatewayFilterFactory'.
   */
  public static BeanDefinition getModifyRequestBodyGatewayFilterFactoryBeanDefinition() {
    Class<?> beanType = ModifyRequestBodyGatewayFilterFactory.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getModifyRequestBodyGatewayFilterFactoryInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'dedupeResponseHeaderGatewayFilterFactory'.
   */
  private static BeanInstanceSupplier<DedupeResponseHeaderGatewayFilterFactory> getDedupeResponseHeaderGatewayFilterFactoryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<DedupeResponseHeaderGatewayFilterFactory>forFactoryMethod(GatewayAutoConfiguration.class, "dedupeResponseHeaderGatewayFilterFactory")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).dedupeResponseHeaderGatewayFilterFactory());
  }

  /**
   * Get the bean definition for 'dedupeResponseHeaderGatewayFilterFactory'.
   */
  public static BeanDefinition getDedupeResponseHeaderGatewayFilterFactoryBeanDefinition() {
    Class<?> beanType = DedupeResponseHeaderGatewayFilterFactory.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getDedupeResponseHeaderGatewayFilterFactoryInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'modifyResponseBodyGatewayFilterFactory'.
   */
  private static BeanInstanceSupplier<ModifyResponseBodyGatewayFilterFactory> getModifyResponseBodyGatewayFilterFactoryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ModifyResponseBodyGatewayFilterFactory>forFactoryMethod(GatewayAutoConfiguration.class, "modifyResponseBodyGatewayFilterFactory", ServerCodecConfigurer.class, Set.class, Set.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).modifyResponseBodyGatewayFilterFactory(args.get(0), args.get(1), args.get(2)));
  }

  /**
   * Get the bean definition for 'modifyResponseBodyGatewayFilterFactory'.
   */
  public static BeanDefinition getModifyResponseBodyGatewayFilterFactoryBeanDefinition() {
    Class<?> beanType = ModifyResponseBodyGatewayFilterFactory.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getModifyResponseBodyGatewayFilterFactoryInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'cacheRequestBodyGatewayFilterFactory'.
   */
  private static BeanInstanceSupplier<CacheRequestBodyGatewayFilterFactory> getCacheRequestBodyGatewayFilterFactoryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<CacheRequestBodyGatewayFilterFactory>forFactoryMethod(GatewayAutoConfiguration.class, "cacheRequestBodyGatewayFilterFactory")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).cacheRequestBodyGatewayFilterFactory());
  }

  /**
   * Get the bean definition for 'cacheRequestBodyGatewayFilterFactory'.
   */
  public static BeanDefinition getCacheRequestBodyGatewayFilterFactoryBeanDefinition() {
    Class<?> beanType = CacheRequestBodyGatewayFilterFactory.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getCacheRequestBodyGatewayFilterFactoryInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'prefixPathGatewayFilterFactory'.
   */
  private static BeanInstanceSupplier<PrefixPathGatewayFilterFactory> getPrefixPathGatewayFilterFactoryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<PrefixPathGatewayFilterFactory>forFactoryMethod(GatewayAutoConfiguration.class, "prefixPathGatewayFilterFactory")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).prefixPathGatewayFilterFactory());
  }

  /**
   * Get the bean definition for 'prefixPathGatewayFilterFactory'.
   */
  public static BeanDefinition getPrefixPathGatewayFilterFactoryBeanDefinition() {
    Class<?> beanType = PrefixPathGatewayFilterFactory.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getPrefixPathGatewayFilterFactoryInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'preserveHostHeaderGatewayFilterFactory'.
   */
  private static BeanInstanceSupplier<PreserveHostHeaderGatewayFilterFactory> getPreserveHostHeaderGatewayFilterFactoryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<PreserveHostHeaderGatewayFilterFactory>forFactoryMethod(GatewayAutoConfiguration.class, "preserveHostHeaderGatewayFilterFactory")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).preserveHostHeaderGatewayFilterFactory());
  }

  /**
   * Get the bean definition for 'preserveHostHeaderGatewayFilterFactory'.
   */
  public static BeanDefinition getPreserveHostHeaderGatewayFilterFactoryBeanDefinition() {
    Class<?> beanType = PreserveHostHeaderGatewayFilterFactory.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getPreserveHostHeaderGatewayFilterFactoryInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'redirectToGatewayFilterFactory'.
   */
  private static BeanInstanceSupplier<RedirectToGatewayFilterFactory> getRedirectToGatewayFilterFactoryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<RedirectToGatewayFilterFactory>forFactoryMethod(GatewayAutoConfiguration.class, "redirectToGatewayFilterFactory")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).redirectToGatewayFilterFactory());
  }

  /**
   * Get the bean definition for 'redirectToGatewayFilterFactory'.
   */
  public static BeanDefinition getRedirectToGatewayFilterFactoryBeanDefinition() {
    Class<?> beanType = RedirectToGatewayFilterFactory.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getRedirectToGatewayFilterFactoryInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'removeJsonAttributesResponseBodyGatewayFilterFactory'.
   */
  private static BeanInstanceSupplier<RemoveJsonAttributesResponseBodyGatewayFilterFactory> getRemoveJsonAttributesResponseBodyGatewayFilterFactoryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<RemoveJsonAttributesResponseBodyGatewayFilterFactory>forFactoryMethod(GatewayAutoConfiguration.class, "removeJsonAttributesResponseBodyGatewayFilterFactory", ServerCodecConfigurer.class, Set.class, Set.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).removeJsonAttributesResponseBodyGatewayFilterFactory(args.get(0), args.get(1), args.get(2)));
  }

  /**
   * Get the bean definition for 'removeJsonAttributesResponseBodyGatewayFilterFactory'.
   */
  public static BeanDefinition getRemoveJsonAttributesResponseBodyGatewayFilterFactoryBeanDefinition(
      ) {
    Class<?> beanType = RemoveJsonAttributesResponseBodyGatewayFilterFactory.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getRemoveJsonAttributesResponseBodyGatewayFilterFactoryInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'removeRequestHeaderGatewayFilterFactory'.
   */
  private static BeanInstanceSupplier<RemoveRequestHeaderGatewayFilterFactory> getRemoveRequestHeaderGatewayFilterFactoryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<RemoveRequestHeaderGatewayFilterFactory>forFactoryMethod(GatewayAutoConfiguration.class, "removeRequestHeaderGatewayFilterFactory")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).removeRequestHeaderGatewayFilterFactory());
  }

  /**
   * Get the bean definition for 'removeRequestHeaderGatewayFilterFactory'.
   */
  public static BeanDefinition getRemoveRequestHeaderGatewayFilterFactoryBeanDefinition() {
    Class<?> beanType = RemoveRequestHeaderGatewayFilterFactory.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getRemoveRequestHeaderGatewayFilterFactoryInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'removeRequestParameterGatewayFilterFactory'.
   */
  private static BeanInstanceSupplier<RemoveRequestParameterGatewayFilterFactory> getRemoveRequestParameterGatewayFilterFactoryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<RemoveRequestParameterGatewayFilterFactory>forFactoryMethod(GatewayAutoConfiguration.class, "removeRequestParameterGatewayFilterFactory")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).removeRequestParameterGatewayFilterFactory());
  }

  /**
   * Get the bean definition for 'removeRequestParameterGatewayFilterFactory'.
   */
  public static BeanDefinition getRemoveRequestParameterGatewayFilterFactoryBeanDefinition() {
    Class<?> beanType = RemoveRequestParameterGatewayFilterFactory.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getRemoveRequestParameterGatewayFilterFactoryInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'removeResponseHeaderGatewayFilterFactory'.
   */
  private static BeanInstanceSupplier<RemoveResponseHeaderGatewayFilterFactory> getRemoveResponseHeaderGatewayFilterFactoryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<RemoveResponseHeaderGatewayFilterFactory>forFactoryMethod(GatewayAutoConfiguration.class, "removeResponseHeaderGatewayFilterFactory")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).removeResponseHeaderGatewayFilterFactory());
  }

  /**
   * Get the bean definition for 'removeResponseHeaderGatewayFilterFactory'.
   */
  public static BeanDefinition getRemoveResponseHeaderGatewayFilterFactoryBeanDefinition() {
    Class<?> beanType = RemoveResponseHeaderGatewayFilterFactory.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getRemoveResponseHeaderGatewayFilterFactoryInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'rewritePathGatewayFilterFactory'.
   */
  private static BeanInstanceSupplier<RewritePathGatewayFilterFactory> getRewritePathGatewayFilterFactoryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<RewritePathGatewayFilterFactory>forFactoryMethod(GatewayAutoConfiguration.class, "rewritePathGatewayFilterFactory")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).rewritePathGatewayFilterFactory());
  }

  /**
   * Get the bean definition for 'rewritePathGatewayFilterFactory'.
   */
  public static BeanDefinition getRewritePathGatewayFilterFactoryBeanDefinition() {
    Class<?> beanType = RewritePathGatewayFilterFactory.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getRewritePathGatewayFilterFactoryInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'retryGatewayFilterFactory'.
   */
  private static BeanInstanceSupplier<RetryGatewayFilterFactory> getRetryGatewayFilterFactoryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<RetryGatewayFilterFactory>forFactoryMethod(GatewayAutoConfiguration.class, "retryGatewayFilterFactory")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).retryGatewayFilterFactory());
  }

  /**
   * Get the bean definition for 'retryGatewayFilterFactory'.
   */
  public static BeanDefinition getRetryGatewayFilterFactoryBeanDefinition() {
    Class<?> beanType = RetryGatewayFilterFactory.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getRetryGatewayFilterFactoryInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'setPathGatewayFilterFactory'.
   */
  private static BeanInstanceSupplier<SetPathGatewayFilterFactory> getSetPathGatewayFilterFactoryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SetPathGatewayFilterFactory>forFactoryMethod(GatewayAutoConfiguration.class, "setPathGatewayFilterFactory")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).setPathGatewayFilterFactory());
  }

  /**
   * Get the bean definition for 'setPathGatewayFilterFactory'.
   */
  public static BeanDefinition getSetPathGatewayFilterFactoryBeanDefinition() {
    Class<?> beanType = SetPathGatewayFilterFactory.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getSetPathGatewayFilterFactoryInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'secureHeadersGatewayFilterFactory'.
   */
  private static BeanInstanceSupplier<SecureHeadersGatewayFilterFactory> getSecureHeadersGatewayFilterFactoryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SecureHeadersGatewayFilterFactory>forFactoryMethod(GatewayAutoConfiguration.class, "secureHeadersGatewayFilterFactory", SecureHeadersProperties.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).secureHeadersGatewayFilterFactory(args.get(0)));
  }

  /**
   * Get the bean definition for 'secureHeadersGatewayFilterFactory'.
   */
  public static BeanDefinition getSecureHeadersGatewayFilterFactoryBeanDefinition() {
    Class<?> beanType = SecureHeadersGatewayFilterFactory.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getSecureHeadersGatewayFilterFactoryInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'setRequestHeaderGatewayFilterFactory'.
   */
  private static BeanInstanceSupplier<SetRequestHeaderGatewayFilterFactory> getSetRequestHeaderGatewayFilterFactoryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SetRequestHeaderGatewayFilterFactory>forFactoryMethod(GatewayAutoConfiguration.class, "setRequestHeaderGatewayFilterFactory")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).setRequestHeaderGatewayFilterFactory());
  }

  /**
   * Get the bean definition for 'setRequestHeaderGatewayFilterFactory'.
   */
  public static BeanDefinition getSetRequestHeaderGatewayFilterFactoryBeanDefinition() {
    Class<?> beanType = SetRequestHeaderGatewayFilterFactory.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getSetRequestHeaderGatewayFilterFactoryInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'setRequestHostHeaderGatewayFilterFactory'.
   */
  private static BeanInstanceSupplier<SetRequestHostHeaderGatewayFilterFactory> getSetRequestHostHeaderGatewayFilterFactoryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SetRequestHostHeaderGatewayFilterFactory>forFactoryMethod(GatewayAutoConfiguration.class, "setRequestHostHeaderGatewayFilterFactory")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).setRequestHostHeaderGatewayFilterFactory());
  }

  /**
   * Get the bean definition for 'setRequestHostHeaderGatewayFilterFactory'.
   */
  public static BeanDefinition getSetRequestHostHeaderGatewayFilterFactoryBeanDefinition() {
    Class<?> beanType = SetRequestHostHeaderGatewayFilterFactory.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getSetRequestHostHeaderGatewayFilterFactoryInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'setResponseHeaderGatewayFilterFactory'.
   */
  private static BeanInstanceSupplier<SetResponseHeaderGatewayFilterFactory> getSetResponseHeaderGatewayFilterFactoryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SetResponseHeaderGatewayFilterFactory>forFactoryMethod(GatewayAutoConfiguration.class, "setResponseHeaderGatewayFilterFactory")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).setResponseHeaderGatewayFilterFactory());
  }

  /**
   * Get the bean definition for 'setResponseHeaderGatewayFilterFactory'.
   */
  public static BeanDefinition getSetResponseHeaderGatewayFilterFactoryBeanDefinition() {
    Class<?> beanType = SetResponseHeaderGatewayFilterFactory.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getSetResponseHeaderGatewayFilterFactoryInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'rewriteResponseHeaderGatewayFilterFactory'.
   */
  private static BeanInstanceSupplier<RewriteResponseHeaderGatewayFilterFactory> getRewriteResponseHeaderGatewayFilterFactoryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<RewriteResponseHeaderGatewayFilterFactory>forFactoryMethod(GatewayAutoConfiguration.class, "rewriteResponseHeaderGatewayFilterFactory")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).rewriteResponseHeaderGatewayFilterFactory());
  }

  /**
   * Get the bean definition for 'rewriteResponseHeaderGatewayFilterFactory'.
   */
  public static BeanDefinition getRewriteResponseHeaderGatewayFilterFactoryBeanDefinition() {
    Class<?> beanType = RewriteResponseHeaderGatewayFilterFactory.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getRewriteResponseHeaderGatewayFilterFactoryInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'rewriteLocationResponseHeaderGatewayFilterFactory'.
   */
  private static BeanInstanceSupplier<RewriteLocationResponseHeaderGatewayFilterFactory> getRewriteLocationResponseHeaderGatewayFilterFactoryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<RewriteLocationResponseHeaderGatewayFilterFactory>forFactoryMethod(GatewayAutoConfiguration.class, "rewriteLocationResponseHeaderGatewayFilterFactory")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).rewriteLocationResponseHeaderGatewayFilterFactory());
  }

  /**
   * Get the bean definition for 'rewriteLocationResponseHeaderGatewayFilterFactory'.
   */
  public static BeanDefinition getRewriteLocationResponseHeaderGatewayFilterFactoryBeanDefinition(
      ) {
    Class<?> beanType = RewriteLocationResponseHeaderGatewayFilterFactory.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getRewriteLocationResponseHeaderGatewayFilterFactoryInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'setStatusGatewayFilterFactory'.
   */
  private static BeanInstanceSupplier<SetStatusGatewayFilterFactory> getSetStatusGatewayFilterFactoryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SetStatusGatewayFilterFactory>forFactoryMethod(GatewayAutoConfiguration.class, "setStatusGatewayFilterFactory")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).setStatusGatewayFilterFactory());
  }

  /**
   * Get the bean definition for 'setStatusGatewayFilterFactory'.
   */
  public static BeanDefinition getSetStatusGatewayFilterFactoryBeanDefinition() {
    Class<?> beanType = SetStatusGatewayFilterFactory.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getSetStatusGatewayFilterFactoryInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'saveSessionGatewayFilterFactory'.
   */
  private static BeanInstanceSupplier<SaveSessionGatewayFilterFactory> getSaveSessionGatewayFilterFactoryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SaveSessionGatewayFilterFactory>forFactoryMethod(GatewayAutoConfiguration.class, "saveSessionGatewayFilterFactory")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).saveSessionGatewayFilterFactory());
  }

  /**
   * Get the bean definition for 'saveSessionGatewayFilterFactory'.
   */
  public static BeanDefinition getSaveSessionGatewayFilterFactoryBeanDefinition() {
    Class<?> beanType = SaveSessionGatewayFilterFactory.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getSaveSessionGatewayFilterFactoryInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'stripPrefixGatewayFilterFactory'.
   */
  private static BeanInstanceSupplier<StripPrefixGatewayFilterFactory> getStripPrefixGatewayFilterFactoryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<StripPrefixGatewayFilterFactory>forFactoryMethod(GatewayAutoConfiguration.class, "stripPrefixGatewayFilterFactory")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).stripPrefixGatewayFilterFactory());
  }

  /**
   * Get the bean definition for 'stripPrefixGatewayFilterFactory'.
   */
  public static BeanDefinition getStripPrefixGatewayFilterFactoryBeanDefinition() {
    Class<?> beanType = StripPrefixGatewayFilterFactory.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getStripPrefixGatewayFilterFactoryInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'requestHeaderToRequestUriGatewayFilterFactory'.
   */
  private static BeanInstanceSupplier<RequestHeaderToRequestUriGatewayFilterFactory> getRequestHeaderToRequestUriGatewayFilterFactoryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<RequestHeaderToRequestUriGatewayFilterFactory>forFactoryMethod(GatewayAutoConfiguration.class, "requestHeaderToRequestUriGatewayFilterFactory")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).requestHeaderToRequestUriGatewayFilterFactory());
  }

  /**
   * Get the bean definition for 'requestHeaderToRequestUriGatewayFilterFactory'.
   */
  public static BeanDefinition getRequestHeaderToRequestUriGatewayFilterFactoryBeanDefinition() {
    Class<?> beanType = RequestHeaderToRequestUriGatewayFilterFactory.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getRequestHeaderToRequestUriGatewayFilterFactoryInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'requestSizeGatewayFilterFactory'.
   */
  private static BeanInstanceSupplier<RequestSizeGatewayFilterFactory> getRequestSizeGatewayFilterFactoryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<RequestSizeGatewayFilterFactory>forFactoryMethod(GatewayAutoConfiguration.class, "requestSizeGatewayFilterFactory")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).requestSizeGatewayFilterFactory());
  }

  /**
   * Get the bean definition for 'requestSizeGatewayFilterFactory'.
   */
  public static BeanDefinition getRequestSizeGatewayFilterFactoryBeanDefinition() {
    Class<?> beanType = RequestSizeGatewayFilterFactory.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getRequestSizeGatewayFilterFactoryInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'requestHeaderSizeGatewayFilterFactory'.
   */
  private static BeanInstanceSupplier<RequestHeaderSizeGatewayFilterFactory> getRequestHeaderSizeGatewayFilterFactoryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<RequestHeaderSizeGatewayFilterFactory>forFactoryMethod(GatewayAutoConfiguration.class, "requestHeaderSizeGatewayFilterFactory")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).requestHeaderSizeGatewayFilterFactory());
  }

  /**
   * Get the bean definition for 'requestHeaderSizeGatewayFilterFactory'.
   */
  public static BeanDefinition getRequestHeaderSizeGatewayFilterFactoryBeanDefinition() {
    Class<?> beanType = RequestHeaderSizeGatewayFilterFactory.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getRequestHeaderSizeGatewayFilterFactoryInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'gzipMessageBodyResolver'.
   */
  private static BeanInstanceSupplier<GzipMessageBodyResolver> getGzipMessageBodyResolverInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<GzipMessageBodyResolver>forFactoryMethod(GatewayAutoConfiguration.class, "gzipMessageBodyResolver")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.class).gzipMessageBodyResolver());
  }

  /**
   * Get the bean definition for 'gzipMessageBodyResolver'.
   */
  public static BeanDefinition getGzipMessageBodyResolverBeanDefinition() {
    Class<?> beanType = GzipMessageBodyResolver.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getGzipMessageBodyResolverInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Bean definitions for {@link GatewayAutoConfiguration.NettyConfiguration}.
   */
  public static class NettyConfiguration__BeanDefinitions {
    /**
     * Get the bean definition for 'nettyConfiguration'.
     */
    public static BeanDefinition getNettyConfigurationBeanDefinition() {
      Class<?> beanType = GatewayAutoConfiguration.NettyConfiguration.class;
      RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
      beanDefinition.setInstanceSupplier(GatewayAutoConfiguration.NettyConfiguration::new);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'httpClientSslConfigurer'.
     */
    private static BeanInstanceSupplier<HttpClientSslConfigurer> getHttpClientSslConfigurerInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<HttpClientSslConfigurer>forFactoryMethod(GatewayAutoConfiguration.NettyConfiguration.class, "httpClientSslConfigurer", ServerProperties.class, HttpClientProperties.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.NettyConfiguration.class).httpClientSslConfigurer(args.get(0), args.get(1)));
    }

    /**
     * Get the bean definition for 'httpClientSslConfigurer'.
     */
    public static BeanDefinition getHttpClientSslConfigurerBeanDefinition() {
      Class<?> beanType = HttpClientSslConfigurer.class;
      RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
      beanDefinition.setInstanceSupplier(getHttpClientSslConfigurerInstanceSupplier());
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'gatewayHttpClientFactory'.
     */
    private static BeanInstanceSupplier<HttpClientFactory> getGatewayHttpClientFactoryInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<HttpClientFactory>forFactoryMethod(GatewayAutoConfiguration.NettyConfiguration.class, "gatewayHttpClientFactory", HttpClientProperties.class, ServerProperties.class, List.class, HttpClientSslConfigurer.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.NettyConfiguration.class).gatewayHttpClientFactory(args.get(0), args.get(1), args.get(2), args.get(3)));
    }

    /**
     * Get the bean definition for 'gatewayHttpClientFactory'.
     */
    public static BeanDefinition getGatewayHttpClientFactoryBeanDefinition() {
      Class<?> beanType = HttpClientFactory.class;
      RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
      beanDefinition.setInstanceSupplier(getGatewayHttpClientFactoryInstanceSupplier());
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'httpClientProperties'.
     */
    private static BeanInstanceSupplier<HttpClientProperties> getHttpClientPropertiesInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<HttpClientProperties>forFactoryMethod(GatewayAutoConfiguration.NettyConfiguration.class, "httpClientProperties")
              .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.NettyConfiguration.class).httpClientProperties());
    }

    /**
     * Get the bean definition for 'httpClientProperties'.
     */
    public static BeanDefinition getHttpClientPropertiesBeanDefinition() {
      Class<?> beanType = HttpClientProperties.class;
      RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
      beanDefinition.setInstanceSupplier(getHttpClientPropertiesInstanceSupplier());
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'routingFilter'.
     */
    private static BeanInstanceSupplier<NettyRoutingFilter> getRoutingFilterInstanceSupplier() {
      return BeanInstanceSupplier.<NettyRoutingFilter>forFactoryMethod(GatewayAutoConfiguration.NettyConfiguration.class, "routingFilter", HttpClient.class, ObjectProvider.class, HttpClientProperties.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.NettyConfiguration.class).routingFilter(args.get(0), args.get(1), args.get(2)));
    }

    /**
     * Get the bean definition for 'routingFilter'.
     */
    public static BeanDefinition getRoutingFilterBeanDefinition() {
      Class<?> beanType = NettyRoutingFilter.class;
      RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
      beanDefinition.setInstanceSupplier(getRoutingFilterInstanceSupplier());
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'nettyWriteResponseFilter'.
     */
    private static BeanInstanceSupplier<NettyWriteResponseFilter> getNettyWriteResponseFilterInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<NettyWriteResponseFilter>forFactoryMethod(GatewayAutoConfiguration.NettyConfiguration.class, "nettyWriteResponseFilter", GatewayProperties.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.NettyConfiguration.class).nettyWriteResponseFilter(args.get(0)));
    }

    /**
     * Get the bean definition for 'nettyWriteResponseFilter'.
     */
    public static BeanDefinition getNettyWriteResponseFilterBeanDefinition() {
      Class<?> beanType = NettyWriteResponseFilter.class;
      RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
      beanDefinition.setInstanceSupplier(getNettyWriteResponseFilterInstanceSupplier());
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'reactorNettyWebSocketClient'.
     */
    private static BeanInstanceSupplier<ReactorNettyWebSocketClient> getReactorNettyWebSocketClientInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<ReactorNettyWebSocketClient>forFactoryMethod(GatewayAutoConfiguration.NettyConfiguration.class, "reactorNettyWebSocketClient", HttpClientProperties.class, HttpClient.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.NettyConfiguration.class).reactorNettyWebSocketClient(args.get(0), args.get(1)));
    }

    /**
     * Get the bean definition for 'reactorNettyWebSocketClient'.
     */
    public static BeanDefinition getReactorNettyWebSocketClientBeanDefinition() {
      Class<?> beanType = ReactorNettyWebSocketClient.class;
      RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
      beanDefinition.setInstanceSupplier(getReactorNettyWebSocketClientInstanceSupplier());
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'reactorNettyRequestUpgradeStrategy'.
     */
    private static BeanInstanceSupplier<ReactorNettyRequestUpgradeStrategy> getReactorNettyRequestUpgradeStrategyInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<ReactorNettyRequestUpgradeStrategy>forFactoryMethod(GatewayAutoConfiguration.NettyConfiguration.class, "reactorNettyRequestUpgradeStrategy", HttpClientProperties.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(GatewayAutoConfiguration.NettyConfiguration.class).reactorNettyRequestUpgradeStrategy(args.get(0)));
    }

    /**
     * Get the bean definition for 'reactorNettyRequestUpgradeStrategy'.
     */
    public static BeanDefinition getReactorNettyRequestUpgradeStrategyBeanDefinition() {
      Class<?> beanType = ReactorNettyRequestUpgradeStrategy.class;
      RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
      beanDefinition.setInstanceSupplier(getReactorNettyRequestUpgradeStrategyInstanceSupplier());
      return beanDefinition;
    }
  }
}
