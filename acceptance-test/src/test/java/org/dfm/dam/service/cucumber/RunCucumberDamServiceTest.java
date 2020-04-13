package org.dfm.dam.service.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features", strict = true, plugin = {"json:target/cucumber/damService.json", "json:target/cucumber/damService.xml"}, tags = {
    "@DamService"}, glue = "classpath:org.dfm.dam.service.cucumber")
public class RunCucumberDamServiceTest {

}
