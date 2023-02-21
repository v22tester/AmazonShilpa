package com.Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Feature",glue={"com.stepDefinition"},plugin={"html:Reports/HTMLReport.html","json:Reports/Cucumber.json","junit:Reports/Cucumber.xml"}
)		
public class RunnerClass {

}