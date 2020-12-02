import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

import com.sun.javafx.util.Utils;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", args[0]+"/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://motorgarage.tk/register-login");

        String password = "admin2020";
        String username = "admin@gmail.com";

        driver.findElement(By.xpath("//input[@formcontrolname = 'email']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@formcontrolname = 'password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[text()='Login']")).click();
        driver.findElement(By.xpath("//div[@id='toast-container']//descendant::div[contains(text(),'Login')]")).click();
//        new WebDriverWait(driver, 10).until(
//                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        driver.findElement(By.xpath("//span[text()='Admin Room']")).click();

        String jarPath = (Main.class.getProtectionDomain().getCodeSource().getLocation()).toString();
        String decodedPath="";
        try {
            decodedPath = URLDecoder.decode(jarPath, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        decodedPath = decodedPath.replace("/Automation.jar", "");
        try {
            String SAMPLE_XLSX_FILE_PATH = args[0]+"/Automation.xlsx";

            Workbook workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));
            Sheet datatypeSheet = workbook.getSheetAt(0);

            Iterator<Row> iterator = datatypeSheet.iterator();

            String pattern = "MM/dd/yyyy";
            DateFormat df = new SimpleDateFormat(pattern);
            Date today = Calendar.getInstance().getTime();
            String todayAsString = df.format(today);

            if(iterator.hasNext()){
                iterator.next();
            }

            while (iterator.hasNext()) {

                Row currentRow = iterator.next();

                String productName = currentRow.getCell(0).getStringCellValue();
                String categories = currentRow.getCell(2).getStringCellValue();
                String description = currentRow.getCell(3).getStringCellValue();
                String image = currentRow.getCell(4).getStringCellValue();
                List<String> imageList = Arrays.asList(image.split("~"));
                double actualPrice = currentRow.getCell(5).getNumericCellValue();
                double originalPrice = currentRow.getCell(6).getNumericCellValue();
                double stockCount = currentRow.getCell(7).getNumericCellValue();

                driver.findElement(By.xpath("//input[@id='name']")).sendKeys(productName);
                driver.findElement(By.xpath("//input[@id='date-input']")).sendKeys(todayAsString);
                driver.findElement(By.xpath("//input[@id='categories']")).sendKeys(categories);
                driver.findElement(By.xpath("//div[@class='angular-editor-textarea']")).sendKeys(description);

                int prevCount = Integer.parseInt(driver.findElement(By.xpath("//button[contains(text(),'Images')]//child::span")).getText());
                for (String path: imageList) {
                    System.setProperty("image_dir", args[0]+"/"+path);
                    File file = new File(System.getProperty("image_dir"));

                    System.out.println("file exists: " + file.exists());

                    String imagePath = file.getAbsolutePath();
                    String prevCountString = driver.findElement(By.xpath("//button[contains(text(),'Images')]//child::span")).getText();
                    driver.findElement(By.xpath("//input[@name='photo']")).sendKeys(imagePath);
                    driver.findElement(By.xpath("//button[contains(text(),'Upload This Image')]")).click();

                    if(driver.findElements(By.xpath("//div[@id='toast-container']//descendant::div[contains(text(),'File uploaded success')]")).size() == 0){
                        System.out.println("popup not found");
                    }else{
                        driver.findElement(By.xpath("//div[@id='toast-container']//descendant::div[contains(text(),'File uploaded success')]")).click();
//                        new WebDriverWait(driver, 2).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='toast-container']")));
                    }


                    WebDriverWait wait = new WebDriverWait(driver,2);
//                    wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//button[contains(text(),'Images')]//child::span"), prevCountString));
                    int currentCount = Integer.parseInt(driver.findElement(By.xpath("//button[contains(text(),'Images')]//child::span")).getText());
                    if(prevCount >= currentCount){
                        System.out.println("wrong count");
                    }
                }

                driver.findElement(By.xpath("//input[@formcontrolname='actual_price']")).sendKeys(Double.toString(actualPrice));
                driver.findElement(By.xpath("//input[@formcontrolname='original_price']")).sendKeys(Double.toString(originalPrice));
                driver.findElement(By.xpath("//input[@formcontrolname='stock_count']")).sendKeys(Double.toString(stockCount));
                driver.findElement(By.xpath("//button[text()='Save Changes']")).click();
                driver.findElement(By.xpath("//div[@id='toast-container']//descendant::div[contains(text(),'Product Creation Successfull')]")).click();
                driver.get("http://motorgarage.tk/admin/add");
                driver.navigate().refresh();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
