package com.expand.interactions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import org.openqa.selenium.By;

import com.expand.interactions.click.ClickEnBy;
import com.expand.interactions.click.ClickEnTarget;
import com.expand.interactions.click.ClickEnWebElement;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.collect.NewList;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.ClickOnBy;
import net.serenitybdd.screenplay.actions.ClickOnElement;
import net.serenitybdd.screenplay.actions.ClickOnTarget;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;
import net.serenitybdd.screenplay.Task;

public class Click {
	        
	   //Personalizado: Por Target
	    public static Interaction en(Target target) {
	    	 return instrumented(ClickEnTarget.class,target);
	    }
	    
	  //Personalizado: Por Xpath
	    public static Interaction en(String cssOrXpathForElement) {
	    	 return instrumented(ClickEnTarget.class,Target.the(cssOrXpathForElement).locatedBy(cssOrXpathForElement));
	    }
	    
	  //Personalizado: Por WebElement
	    public static Interaction en(WebElementFacade element) {
	    	 return instrumented(ClickEnWebElement.class, element);
	    }
	  //Personalizado: Por WebElement
	    public static Interaction en(By... locators) {
	        return instrumented(ClickEnBy.class, NewList.of(locators));
	    }

}

