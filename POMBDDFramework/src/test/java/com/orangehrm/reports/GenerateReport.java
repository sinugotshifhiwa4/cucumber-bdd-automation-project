package com.orangehrm.reports;

import com.orangehrm.reusableComponents.ConfigProperties;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GenerateReport {

    public void generateHtmlReport() {

        File reportOutputDirectory = new File("target/cucumber-reports");
        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add("target/cucumber-reports/Cucumber.json");

        String buildNumber = "1";
        String projectName = "BDD Automation Report";

        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
        configuration.setBuildNumber(buildNumber);
        configuration.addClassifications("Environment", ConfigProperties.getPropertyByKey("baseUrl"));
        configuration.addClassifications("Browser", ConfigProperties.getPropertyByKey("browser"));
        configuration.addClassifications("Branch", "release/1.0");
        configuration.addClassifications("Platform", System.getProperty("os.name"));
        configuration.addClassifications("Version", System.getProperty("os.version"));
        configuration.addClassifications("User", System.getProperty("user.name"));

        // Add graphs
        configuration.setTrendsStatsFile(new File("target/test-classes/cucumber-trends.json"));


        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        reportBuilder.generateReports();
    }

    public static void main(String[] args) {
        new GenerateReport().generateHtmlReport();
    }
}
