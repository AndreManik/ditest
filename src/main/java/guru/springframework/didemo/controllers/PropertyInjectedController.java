package guru.springframework.didemo.controllers;

import guru.springframework.didemo.services.GreetingService;

public class PropertyInjectedController {

    public GreetingService greetingService;

    String sayHallo() {
        return greetingService.sayGreeting();
    }


}
