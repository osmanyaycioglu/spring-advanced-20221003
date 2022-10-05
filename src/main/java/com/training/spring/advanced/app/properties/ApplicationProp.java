package com.training.spring.advanced.app.properties;

import com.training.spring.advanced.rest.models.CustomerRest;
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
    private String                    appVersion;
    private CustomerRest              defaultCustomerRest;
    private List<String>              cities;
    private List<CustomerRest>        customerRests;
    private Map<String, CustomerRest> customerMap;

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

    public CustomerRest getDefaultCustomer() {
        return defaultCustomerRest;
    }

    public void setDefaultCustomer(CustomerRest defaultCustomerRest) {
        this.defaultCustomerRest = defaultCustomerRest;
    }

    @Override
    public String toString() {
        return "ApplicationProp{" +
                "helloLanguage='" + helloLanguage + '\'' +
                ", appDesc='" + appDesc + '\'' +
                ", port=" + port +
                ", appVersion='" + appVersion + '\'' +
                ", defaultCustomer=" + defaultCustomerRest +
                '}';
    }

    public List<String> getCities() {
        return cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }

    public List<CustomerRest> getCustomers() {
        return customerRests;
    }

    public void setCustomers(List<CustomerRest> customerRests) {
        this.customerRests = customerRests;
    }

    public Map<String, CustomerRest> getCustomerMap() {
        return customerMap;
    }

    public void setCustomerMap(Map<String, CustomerRest> customerMap) {
        this.customerMap = customerMap;
    }
}
