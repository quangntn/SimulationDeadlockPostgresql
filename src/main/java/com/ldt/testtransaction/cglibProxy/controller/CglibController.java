package com.ldt.testtransaction.cglibProxy.controller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ldt.testtransaction.cglibProxy.service.PersonGreetingService;
import net.sf.cglib.beans.BeanGenerator;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;
import net.sf.cglib.proxy.MethodInterceptor;

@RestController
public class CglibController {

    @GetMapping(path = "/getFix")
    public String hello(){
        String result = "";
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(PersonGreetingService.class);
        FixedValue fixedValue = () -> "Hello Tom!";
        enhancer.setCallback(fixedValue);
        PersonGreetingService proxy = (PersonGreetingService) enhancer.create();
        String res = proxy.sayHello("Quan");
        return res;
    }

    @GetMapping(path = "/getDyn")
    public String helloworld (){
        String result = "";
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(PersonGreetingService.class);
        enhancer.setCallback(getMethodInterceptor());
        PersonGreetingService proxy = (PersonGreetingService) enhancer.create();
        System.out.println("proxy: " + proxy);
        String res = proxy.sayHello("Quan");
        return res;
    }

    private static MethodInterceptor getMethodInterceptor() {
        return (MethodInterceptor) (obj, method, args, proxy) -> {
            if (method.getDeclaringClass() != Object.class && method.getReturnType() == String.class) {
                return "start : " + proxy.invokeSuper(obj, args) + " !end";
            } else {
                return proxy.invokeSuper(obj, args);
            }
        };
    }

    @Autowired
    PersonGreetingService greetingService;
    @GetMapping(path = "/hello")
    public String hello(@Param("name") String name){
        String s = greetingService.sayHello(name);
        return s;
    }

    public void beanCreator() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        BeanGenerator beanGenerator = new BeanGenerator();

        beanGenerator.addProperty("name", String.class);
        Object myBean = beanGenerator.create();
        Method setter = myBean.getClass().getMethod("setName", String.class);
        setter.invoke(myBean, "some string value set by a cglib");

        Method getter = myBean.getClass().getMethod("getName");
    }

}
