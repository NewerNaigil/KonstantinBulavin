package ru.training.at.hw7;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.training.at.hw7.entities.MetalAndColorsData;
import ru.training.at.hw7.entities.User;

public class JdiMetalsAndColorsFormTest extends JdiAbstractTest {

    @Test
    public void loginTest() {
        JdiSite.open();
        JdiSite.login(User.ROMAN);
        String actualFullName = JdiSite.getTextUserName();

        JdiSite.jdiHomePage.getUserName().is().text(User.ROMAN.getFullName());
    }

    @Test
    public void mtTest() {
        JdiSite.headerSection.headMenu.select("Metals & Colors");

    }

    @DataProvider(name = "TestData")
    public static Object[][] getJson() {

        Gson gson = new Gson();

        try {
            JsonObject jsonObject =
                JsonParser.parseReader(new FileReader("src/main/resources/JDI_ex8_metalsColorsDataSet.json"))
                          .getAsJsonObject();

            List<MetalAndColorsData> metalAndColorsData = jsonObject.keySet().stream()
                                                                    .map(key -> gson.fromJson(jsonObject.get(key),
                                                                        MetalAndColorsData.class))
                                                                    .collect(Collectors.toList());

            return metalAndColorsData.stream()
                                     .map(x -> new MetalAndColorsData[] {x})
                                     .toArray(MetalAndColorsData[][]::new);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Test(dataProvider = "TestData")
    public void demoTest(MetalAndColorsData metalAndColorsData) {
        System.out.println(metalAndColorsData.color);
    }
}
