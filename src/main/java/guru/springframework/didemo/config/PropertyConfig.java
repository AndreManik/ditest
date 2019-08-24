package guru.springframework.didemo.config;

import guru.springframework.didemo.examplebean.FakeDataSource;
import guru.springframework.didemo.examplebean.FakeJmsBrocker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
//@PropertySource({"classpath:datasource.properties", "classpath:jms.properties"})
@PropertySources({
        @PropertySource("classpath:datasource.properties"),
        @PropertySource("classpath:jms.properties")
})
public class PropertyConfig {

    @Autowired
    Environment env;

    @Value("${guru.username}")
    String user;

    @Value("${guru.password}")
    String password;

    @Value("${guru.dburl}")
    String url;

    @Value("${guru.jms.username}")
    String JMSUser;

    @Value("${guru.jms.password}")
    String JMSPassword;

    @Value("${guru.jms.dburl}")
    String JMSUrl;


    @Bean
    public FakeDataSource fakeDataSource() {
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUser(env.getProperty("USERNAME"));
        fakeDataSource.setPassword(password);
        fakeDataSource.setUrl(url);
        return fakeDataSource;
    }

    @Bean
    public FakeJmsBrocker fakeJmsBrocker() {
        FakeJmsBrocker fakeJmsBrocker = new FakeJmsBrocker();
        fakeJmsBrocker.setUsername(JMSUser);
        fakeJmsBrocker.setPassword(JMSPassword);
        fakeJmsBrocker.setUrl(JMSUrl);
        return fakeJmsBrocker;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer property() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
