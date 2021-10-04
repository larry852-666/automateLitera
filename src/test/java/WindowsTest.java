import io.appium.java_client.windows.WindowsDriver;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class WindowsTest {

        private static WindowsDriver configRuleSession = null;

        @BeforeClass
        public static void setUp() {
            try {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("app", "C:\\Users\\p.larionov\\Desktop\\2.2.1\\RuleEditor.exe");
                capabilities.setCapability("platformName","Windows");
                capabilities.setCapability("deviceName", "WindowsPC");
                configRuleSession = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
                configRuleSession.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Ignore
        @Test
        public void ok() {
            configRuleSession.findElementByName("Тест").click();
            configRuleSession.findElementByName("ОК").click();
       }

        @Test
        public void checkAboutWindow() {
           // Проверка открытия режима "Редактировать"
            configRuleSession.findElementByName("rules_ILService").click();
            configRuleSession.findElementByAccessibilityId("b_edit").click();
            configRuleSession.findElementByName("Назад").click();
       }

        @Test
        public void sendTestText() {
           // Проверка открытия режима "Просмотр"
            configRuleSession.findElementByName("rules_набор правил по описанию Табакова 1.3").click();
            configRuleSession.findElementByAccessibilityId("b_view").click();
            configRuleSession.findElementByName("Назад").click();
        }

        @Test
        public void writeNumbers() {
           // Проверка написания цифр в поле "Индентификатор файла правил"
            configRuleSession.findElementByName("rules_ILService").click();
            configRuleSession.findElementByAccessibilityId("b_edit").click();
            configRuleSession.findElementByClassName("TextBox").click();
            configRuleSession.findElementByClassName("TextBox").clear();
            configRuleSession.findElementByClassName("TextBox").sendKeys("123");
            configRuleSession.findElementByAccessibilityId("BrowseBack").click();
            configRuleSession.findElementByAccessibilityId("BrowseForward").click();
            Assert.assertNotNull(configRuleSession.findElementByClassName("TextBox"));
            configRuleSession.findElementByAccessibilityId("BrowseBack").click();
        }

        @Test
        public void buttonReference() {
           // Проверка что откроется область "Справка" по нажатию кнопки "Справка"
            configRuleSession.findElementByClassName("Button").click();
            Assert.assertNotNull(configRuleSession.findElementByName("FS.22402 Справка РПП п.8 Редактор"));
            configRuleSession.findElementByClassName("Button").click();
        }

        @Test
        public void buttonTest() {
           // Проверка что открывается область "Тест" по нажатию кнопки "Тест"
            configRuleSession.findElementByName("rules_ILService");
            configRuleSession.findElementByName("Тест").click();
            Assert.assertNotNull(configRuleSession.findElementByName("Пассажир"));
            configRuleSession.findElementByAccessibilityId("BrowseBack").click();
        }

        @Test
        public void testTabs() {
           // Проверка перекчюение между вкладками
            configRuleSession.findElementByName("rules_набор правил по описанию Табакова 1.3").click();
            configRuleSession.findElementByAccessibilityId("b_view").click();
            configRuleSession.findElementByName("Литеры").click();
            configRuleSession.findElementByName("Страны").click();
            configRuleSession.findElementByName("Правила").click();
            configRuleSession.findElementByName("Назад").click();
        }

        @Test
        public void addLitera() {
           configRuleSession.findElementByName("rules_набор правил по описанию Табакова 1.3").click();
           configRuleSession.findElementByAccessibilityId("b_edit").click();
           configRuleSession.findElementByName("Литеры").click();
           configRuleSession.findElementByName("Добавить").click();
           configRuleSession.findElementByAccessibilityId("tb_Name").click();
           configRuleSession.findElementByAccessibilityId("tb_Name").sendKeys("ПР");
           configRuleSession.findElementByAccessibilityId("Weight").click();
           configRuleSession.findElementByAccessibilityId("Weight").sendKeys("0");
           configRuleSession.findElementByName("Сохранить").click();
           configRuleSession.findElementByName("Назад").click();
        }

        @Test
        public void addKS() {
           configRuleSession.findElementByName("rules_набор правил по описанию Табакова 1.3").click();
           configRuleSession.findElementByName("Тест").click();
           configRuleSession.findElementByAccessibilityId("mi_db").click();
           configRuleSession.findElementByName("Локальный файл").click();
           configRuleSession.findElementByName("список.csv").click();
           configRuleSession.findElementByName("Открыть").click();
           Assert.assertNotNull(configRuleSession.findElementByClassName("ListView"));
           configRuleSession.findElementByName("Назад").click();
        }

        /*@Test()
        public void pressTimeAndDateButton(){
            notepadSession.findElementByName("Правка").click();
            notepadSession.findElementByAccessibilityId("26").click();
            Assert.assertNotNull(notepadSession.findElementByClassName("Правка"));
            notepadSession.findElementByClassName("Правка").clear();
        }*/
    }