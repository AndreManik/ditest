package guru.springframework.didemo.config;

import guru.springframework.didemo.examplebean.FakeDataSource;
import guru.springframework.didemo.examplebean.FakeJmsBrocker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropertyConfig {

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
        fakeDataSource.setUser(user);
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
}
