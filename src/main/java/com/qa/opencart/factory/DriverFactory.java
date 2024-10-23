package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.qa.opencart.errors.ApplicationError;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class DriverFactory {

	public static WebDriver driver;
	Properties prop;
	OptionsManager optionsManager;
	private String browserName;
	private Capabilities url;
	private RemoteWebDriver RemoteWebDriver;

	public WebDriver initDriver(Properties prop) throws Exception {

		String browserName = prop.getProperty("browser");

		System.out.println("browser name is .." + browserName);

		optionsManager = new OptionsManager(prop);

		switch (browserName.toLowerCase().trim()) {
		case "chrome":

			if (Boolean.parseBoolean(prop.getProperty("remote"))) {
				// run TC'S on remote machine inside container

				init_remoteDriver("chrome");
			}

			else {
				// run TCS's on local machine / browser
				driver = new ChromeDriver(optionsManager.getChromeOptions());
			}

			break;

		case "firefox":
			if (Boolean.parseBoolean(prop.getProperty("remote"))) {
				// run TC'S on remote machine inside container
				init_remoteDriver("firefox");
			}

			else {
				// run TCS's on local machine / browser
				driver = new FirefoxDriver(optionsManager.getFirefoxOptions());
			}

			break;

		case "edge":
			driver = new EdgeDriver();
			break;

		default:
			System.out.println(ApplicationError.INVALID_BROWSER_MESG + browserName);
			throw new BrowserException(ApplicationError.INVALID_BROWSER_MESG);

		}

		return driver;
	}

	public void init_remoteDriver(String browserName) throws MalformedURLException, BrowserException {
		System.out.println("Running test cases on grid with browser ...." + browserName);

		switch (browserName.toLowerCase().trim()) {
		case "chrome":

//			
// 			
			String urlString = "http://localhost:4444/wd/hub";
			// var url = URI.create("http://localhost:4444/wd/hub").toURL();

			try {

				driver = new RemoteWebDriver(new URL(urlString), optionsManager.getChromeOptions());
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "firefox":
			driver = new RemoteWebDriver(new URL("huburl"), optionsManager.getFirefoxOptions());
			break;

		default:
			System.out.println("please pass the right remote browser name");
			throw new BrowserException(ApplicationError.INVALID_BROWSER_MESG);
		}

	}

	private void set(org.openqa.selenium.remote.RemoteWebDriver remoteWebDriver2) {
		// TODO Auto-generated method stub

	}

	private URI url() {
		// TODO Auto-generated method stub
		return null;
	}

	private URL URL(String string, ChromeOptions chromeOptions) {

		return null;
	}

	private void ChromeDriver() {

	}

	/**
	 * this method is used to initialize the properties from the config file
	 * 
	 * @return
	 */

	public Properties initProperties() {

		prop = new Properties();

		FileInputStream ip = null;
		try {
			ip = new FileInputStream(
					"C:\\Users\\Devesh\\eclipse-workspace\\May2024POMSeries\\src\\test\\resources\\config\\config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}
}
