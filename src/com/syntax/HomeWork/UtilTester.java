package com.syntax.HomeWork;

import com.syntax.Util.Util;

public class UtilTester {
    public static void main(String[] args) {
        Util.openBrowser("https://www.google.com/");
        Util.quitBrowser();
        Util.openBrowser("https://www.google.com/");
        Util.closeBrowser();
    }
}

