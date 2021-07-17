package ru.training.at.hw7;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.training.at.hw7.config.TextConstants;
import ru.training.at.hw7.entities.MetalAndColorsData;

public class JdiMetalsAndColorsFormTest extends JdiAbstractTest {

    @DataProvider(name = "TestData")
    public static Object[][] getJson(ITestContext context) {

        Gson gson = new Gson();
        String jsonPath = context.getAttribute("jsonPath").toString();

        try {
            JsonObject jsonObject =
                JsonParser.parseReader(new FileReader(jsonPath))
                          .getAsJsonObject();

            List<MetalAndColorsData[]> list = new ArrayList<>();
            for (String key : jsonObject.keySet()) {
                MetalAndColorsData entity = gson.fromJson(jsonObject.get(key), MetalAndColorsData.class);
                list.add(new MetalAndColorsData[] {entity});
            }
            return list.toArray(new MetalAndColorsData[0][]);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Test(dataProvider = "TestData")
    public void demoTest(MetalAndColorsData metalAndColorsData) {

        JdiSite.headerSection.headMenu.select(TextConstants.METAL_COLORS);
        JdiSite.metalAndColorsPage.metalAndColorsForm.fillForm(metalAndColorsData);
        JdiSite.metalAndColorsPage.metalAndColorsForm.clickSubmitButton();

        List<String> actual = JdiSite.metalAndColorsPage.rightSideResultSection.getLogsListText();
        List<String> expected = metalAndColorsData.getExpectedData();

        Assert.assertEquals(actual, expected);
    }
}
