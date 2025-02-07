package com.nttdata.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json"},
        features = "src/test/resources/features",
        glue = "com.nttdata.stepsdefinitions",
        tags = "@ValidUpdate"
)
public class CucumberTestSuite {
}