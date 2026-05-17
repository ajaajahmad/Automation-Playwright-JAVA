package com.automation.base;

import java.util.List;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import com.automation.utils.LogUtils;

public class BasePage {

    protected final Page page;
    protected static LogUtils log;

    public BasePage(Page page) {
        this.page = page;
        BasePage.log = new LogUtils();
    }

    protected Locator locator(String selector) {
        return page.locator(selector);
    }

    protected void click(String selector) {
        locator(selector).click();
    }

    protected void type(String selector, String text) {
        locator(selector).fill(text);
    }

    protected void typeAndEnter(String selector, String text) {
        Locator l = locator(selector);
        l.fill(text);
        l.press("Enter");
    }

    protected String getText(String selector) {
        return locator(selector).textContent();
    }

    protected boolean isElementPresent(String selector) {
        return locator(selector).isVisible();
    }

    protected List<String> getAllTexts(String selector) {
        return locator(selector).allTextContents();
    }
}