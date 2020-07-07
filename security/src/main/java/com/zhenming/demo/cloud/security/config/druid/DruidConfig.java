//package com.zhenming.demo.cloud.security.config.druid;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import com.alibaba.druid.support.http.StatViewServlet;
//import com.alibaba.druid.support.http.WebStatFilter;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class DruidConfig {
//  @Value("${spring.datasource.druid.username}")
//  private String username;
//  @Value("${spring.datasource.druid.password}")
//  private String password;
//  @Value("${spring.datasource.druid.logSlowSql}")
//  private String logSlowSql;
//
//  @Bean
//  public ServletRegistrationBean<StatViewServlet> druidServlet() {
//    ServletRegistrationBean<StatViewServlet> reg = new ServletRegistrationBean<>();
//    reg.setServlet(new StatViewServlet());
//    reg.addUrlMappings("/druid/*");
//    reg.addInitParameter("loginUsername", username);
//    reg.addInitParameter("loginPassword", password);
//    reg.addInitParameter("logSlowSql", logSlowSql);
//    return reg;
//  }
//
//  @Bean
//  public FilterRegistrationBean<WebStatFilter> filterRegistrationBean() {
//    FilterRegistrationBean<WebStatFilter> filterRegistrationBean = new FilterRegistrationBean<>();
//    filterRegistrationBean.setFilter(new WebStatFilter());
//    filterRegistrationBean.addUrlPatterns("/*");
//    filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
//    filterRegistrationBean.addInitParameter("profileEnable", "true");
//    return filterRegistrationBean;
//  }
//
//  @Bean
//  @ConfigurationProperties(prefix = "spring.datasource")
//  public DataSource druidDataSource() {
//    return new DruidDataSource();
//  }
//}
