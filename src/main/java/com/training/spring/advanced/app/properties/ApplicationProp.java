package com.training.spring.advanced.app.properties;

import com.training.spring.advanced.basics.models.Customer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "app.prop")
public class ApplicationProp {
    private String helloLanguage = "eng";
    private String appDesc = "test app";
    private Integer port;
    private String appVersion;
    private Customer defaultCustomer;
    private List<String> cities;
    private List<Customer> customers;
    private Map<String,Customer> customerMap;

    public String getHelloLanguage() {
        return helloLanguage;
    }

    public void setHelloLanguage(String helloLanguage) {
        this.helloLanguage = helloLanguage;
    }

    public String getAppDesc() {
        return appDesc;
    }

    public void setAppDesc(String appDesc) {
        this.appDesc = appDesc;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public Customer getDefaultCustomer() {
        return defaultCustomer;
    }

    public void setDefaultCustomer(Customer defaultCustomer) {
        this.defaultCustomer = defaultCustomer;
    }

    @Override
    public String toString() {
        return "ApplicationProp{" +
                "helloLanguage='" + helloLanguage + '\'' +
                ", appDesc='" + appDesc + '\'' +
                ", port=" + port +
                ", appVersion='" + appVersion + '\'' +
                ", defaultCustomer=" + defaultCustomer +
                '}';
    }

    public List<String> getCities() {
        return cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public Map<String, Customer> getCustomerMap() {
        return customerMap;
    }

    public void setCustomerMap(Map<String, Customer> customerMap) {
        this.customerMap = customerMap;
    }
}
