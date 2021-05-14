package Validation;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
 * Created by Lukas Aronsson
 * Date: 07/05/2021
 * Time: 21:33
 * Project: WhitelistBot
 * Copyright: MIT
 */

/**
 * tests for the Name class in the validation package
 * the Name class should handle minecraft username validation
 */
public class NameTest {

    /**
     * Test for the nameValidationJava method.
     * this method should check an incoming string if it adheres to minecraft Java edition naming standards
     *
     * @link https://help.minecraft.net/hc/en-us/articles/360034636712-Minecraft-Usernames Minecraft username ruels
     */
    @DisplayName("Testing Name validation for Minecraft Java Usernames")
    @Test
    final void nameValidationJavaTest() {

        //should be true
        assertTrue(Name.nameValidationJava("testName"));
        assertTrue(Name.nameValidationJava("t3l")); //3 character long name
        assertTrue(Name.nameValidationJava("16chaRacTer_Long")); //16 leather long name with numbers, uppercase characters and underscore
        //should be false
        assertFalse(Name.nameValidationJava("")); //can't be blank
        assertFalse(Name.nameValidationJava("test name")); // Can't have space
        assertFalse(Name.nameValidationJava(null)); // can't be null
        assertFalse(Name.nameValidationJava("t")); //can't be 1 character
        assertFalse(Name.nameValidationJava("tt")); // can't be 2 characters
        assertFalse(Name.nameValidationJava("17characters_Long")); // can't be more then 17 characters long
        //the only allowed special character is _ (underscore)
        assertFalse(Name.nameValidationJava("&@&``@%~%~#$~`~%^"));
        assertFalse(Name.nameValidationJava("`^`^%&^`^%&#~~@`%$"));
        assertFalse(Name.nameValidationJava(">=<=+!<?*=*=?>?"));
        assertFalse(Name.nameValidationJava("___-\\-////\\___\\|"));
        assertFalse(Name.nameValidationJava("'\"'\"'\"\"'\"'\"''\"'"));
        assertFalse(Name.nameValidationJava(".,:..;....,:.:."));
        assertFalse(Name.nameValidationJava("ÒìÙç¹²ý¼ÏñÅÙÜ¸Ä"));
        assertFalse(Name.nameValidationJava("R='\\)6r$]Ì-¸À£;"));

    }

    /**
     * Test for the nameValidationBedrock method.
     * this method should check an incoming string if it adheres to minecraft Bedrock edition naming standards
     * <p>
     * Minecraft Bedrock edition uses XBOX gamertag's for its username
     * <p>
     * TODO: figure out if you need to type the #334 when the username has it ?
     *
     * @link https://support.xbox.com/en-US/help/account-profile/profile/gamertag-update-faq
     * @link https://www.thesixthaxis.com/2019/06/18/xbox-gamertags-duplicate-id-alphabets-cyrillic-japanese-chinese/
     */
    @Disabled
    @DisplayName("Testing Name validation for Minecraft Bedrock Usernames")
    @Test
    final void nameValidationBedrock() {
        //should be true
        assertTrue(Name.nameValidationJava("test_Name")); //allows underscore
        assertTrue(Name.nameValidationJava("13 Characters")); //13 leather long name with numbers, uppercase characters and it can have " " (white-space)
        assertTrue(Name.nameValidationJava("t3l")); //3 character long name
        assertTrue(Name.nameValidationJava("")); // can't be more then 17 characters long
        //test Hangul here
        //test Katakana Here
        //Test Hiragana Here
        //test CJK Symbols for languages in China, Japan, and Korea here
        //test Bengali Here
        //test Devanagari here
        //test Cyrillic here
        //test Thai here

        //should be false
        assertFalse(Name.nameValidationJava("")); //can't be blank
        assertFalse(Name.nameValidationJava(null)); // can't be null
        assertFalse(Name.nameValidationJava("t")); //can't be 1 character
        assertFalse(Name.nameValidationJava("tt")); // can't be 2 characters
        assertFalse(Name.nameValidationJava("17characters_Long")); // can't be more then 17 characters long
    }

}
