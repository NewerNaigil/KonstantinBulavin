package ru.training.at.hw7;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.training.at.hw7.entities.MetalAndColorsData;

public class JdiMetalsAndColorsFormTest extends JdiAbstractTest {

    @DataProvider(name = "TestData")
    public static Object[][] getJson() {

        Gson gson = new Gson();

        try {
            JsonObject jsonObject =
                JsonParser.parseReader(new FileReader("src/main/resources/JDI_ex8_metalsColorsDataSet.json"))
                          .getAsJsonObject();

            List<MetalAndColorsData> metalAndColorsData = new ArrayList<>();
            for (String key : jsonObject.keySet()) {
                MetalAndColorsData andColorsData = gson.fromJson(jsonObject.get(key),
                    MetalAndColorsData.class);
                metalAndColorsData.add(andColorsData);
            }

            List<MetalAndColorsData[]> list = new ArrayList<>();
            for (MetalAndColorsData x : metalAndColorsData) {
                MetalAndColorsData[] andColorsData = new MetalAndColorsData[] {x};
                list.add(andColorsData);
            }
            return list.toArray(new MetalAndColorsData[0][]);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Test(dataProvider = "TestData")
    public void demoTest(MetalAndColorsData metalAndColorsData) {


        JdiSite.headerSection.headMenu.select("Metals & Colors");

        JdiSite.metalAndColorsPage.metalAndColorsForm.fillForm(metalAndColorsData);
        JdiSite.metalAndColorsPage.metalAndColorsForm.clickSubmitButton();


    }
}
