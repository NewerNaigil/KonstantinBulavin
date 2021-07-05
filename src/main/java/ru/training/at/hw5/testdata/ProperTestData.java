package ru.training.at.hw5.testdata;

import java.util.List;
import java.util.Set;

public class ProperTestData {

    public static final Set<String> HEADER_SELECTOR_ITEMS_SET =
        Set.of("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");

    public static final Set<String> TEXT_UNDER_ICON_SET =
        Set.of("To include good practices\nand ideas from successful\nEPAM project",
            "To be multiplatform",
            "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more" + "…",
            "To be flexible and\ncustomizable");

    public static final Set<String> TEXT_LEFT_SECTION_SET =
        Set.of("Home", "Contact form", "Service", "Metals & Colors", "Elements packs");

    public static final Set<String> LOGS =
        Set.of("Colors: value changed to Yellow", "metal: value changed to Selen", "Wind: condition changed to true",
            "Water: condition changed to true", "Vip: condition changed to true");

    public static final List<String> USER_TABLE_NUMRESR =
        List.of("1", "2", "3", "4", "5", "6");

    public static final List<String> USER_TABLE_USERS =
        List.of("Roman", "Sergey Ivan", "Vladzimir", "Helen Bennett", "Yoshi Tannamuri", "Giovanni Rovelli");

    public static final List<String> USER_TABLE_DESCRIPTION =
        List.of("Description", "Wolverine", "Spider man", "Punisher", "Captain America some description",
            "Cyclope some description", "Hulksome description");
}
