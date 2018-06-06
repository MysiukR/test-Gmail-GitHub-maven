package com.epam.lab.decoratorimpl;

import com.epam.lab.decorator.LogMessage;
import com.epam.lab.decorator.PageElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.util.List;

public class MyDefaultFieldDecorator extends DefaultFieldDecorator {


    public MyDefaultFieldDecorator(ElementLocatorFactory factory) {
        super(factory);
    }

    @Override
    public Object decorate(ClassLoader loader, Field field) {
        if (PageElement.class.isAssignableFrom(field.getType())) {
            PageElement pageElement = new PageElement((WebElement) super.decorate(loader, field));
            if (field.isAnnotationPresent(LogMessage.class)) {
                pageElement.setName(
                        field.getAnnotation(LogMessage.class).value()
                );
            }
            return pageElement;
        } else if (List.class.isAssignableFrom(field.getType())) {
            return proxyForPageElementList(loader, factory.createLocator(field));
        } else {
            return super.decorate(loader, field);
        }
    }

    private List<PageElement> proxyForPageElementList(ClassLoader loader, ElementLocator locator) {
        return (List<PageElement>) Proxy.newProxyInstance(loader, new Class[]{List.class},  new PageElementListHandler(locator));
    }
}
