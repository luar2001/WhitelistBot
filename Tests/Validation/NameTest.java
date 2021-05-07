package Validation;


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
     * Test for the nameValidation method.
     * this method should check an incoming string if it adheres to minecraft naming standards
     *
     * @link https://help.minecraft.net/hc/en-us/articles/360034636712-Minecraft-Usernames Minecraft username ruels
     */
    @Test
    final void nameValidationTest() {

        //should be true
        assertTrue(Name.nameValidation("testName"));
        assertTrue(Name.nameValidation("t3l")); //3 character long name
        assertTrue(Name.nameValidation("16chaRacTer_Long")); //16 leather long name with numbers, uppercase characters and underscore
        //should be false
        assertFalse(Name.nameValidation("")); //can't be blank
        assertFalse(Name.nameValidation("test name")); // Can't have space
        assertFalse(Name.nameValidation(null)); // can't be null
        assertFalse(Name.nameValidation("t")); //can't be 1 character
        assertFalse(Name.nameValidation("tt")); // can't be 2 characters
        assertFalse(Name.nameValidation("17characters_Long")); // can't be more then 17 characters long
        //the only allowed special character is _ (underscore)
        assertFalse(Name.nameValidation("&@&``@%~%~#$~`~%^"));
        assertFalse(Name.nameValidation("`^`^%&^`^%&#~~@`%$"));
        assertFalse(Name.nameValidation(">=<=+!<?*=*=?>?"));
        assertFalse(Name.nameValidation("___-\\-////\\___\\|"));
        assertFalse(Name.nameValidation("'\"'\"'\"\"'\"'\"''\"'"));
        assertFalse(Name.nameValidation(".,:..;....,:.:."));
        assertFalse(Name.nameValidation("ÒìÙç¹²ý¼ÏñÅÙÜ¸Ä"));
        assertFalse(Name.nameValidation("R='\\)6r$]Ì-¸À£;"));

    }



}
