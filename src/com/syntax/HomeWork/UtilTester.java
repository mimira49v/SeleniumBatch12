package com.syntax.HomeWork;

import com.syntax.Util.Util;

public class UtilTester {
    public static void main(String[] args) {
       Util c =new Util();
       c.openBrowser("https://www.google.com/");
       c.quitBrowser();
       c.openBrowser("https://www.google.com/");
       c.closeBrowser();
    }
}

