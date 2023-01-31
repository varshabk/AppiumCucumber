package utils;

import base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestUtils  {
public static Logger log() {
    return LogManager.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());

}

}
