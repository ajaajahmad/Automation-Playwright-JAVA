package com.automation.pages.campaign;

import com.microsoft.playwright.Page;
import com.automation.base.BasePage;
import com.automation.pages.components.CampaignCommonComponent;
import com.automation.utils.TableSelectionManager;

public class SmsCampaignPage extends BasePage {

    private final TableSelectionManager tableSelectionManager;
    private final CampaignCommonComponent campaignCommonComponent;

    public SmsCampaignPage(Page page) {
        super(page);
        this.tableSelectionManager = new TableSelectionManager(page);
        this.campaignCommonComponent = new CampaignCommonComponent(page);
    }

    // ================= LOCATORS =================

    private String smsMenu = "//div[contains(@class, 'menu-event') and .//span[contains(@class, 'icon-Menu_SMS')]]";

    private String campaignsElement = "//span[normalize-space()='Campaigns']";

    private String campaignsDltPopup = "//button[contains(text(),'OK')]";

    private String createCampaign = "//button[@class='btn btn-design btn-send ng-star-inserted']//span[contains(text(),'Create Campaign')]";

    private String campaignType = "//input[@value='Personalised']";

    private String importContacts = "//button[contains(text(),'Import Contacts')]";

    private String contactsListTab = "//span[@class='mdc-tab__text-label'][contains(text(),'Lists')]";

    private String contactsListSearchInput = "//input[@placeholder='Search List']";

    private String contactsListGoButton = "//button[contains(text(),'Go')]";

    private String contactsImportButton = "//button[contains(@class,'process-file') and contains(normalize-space(),'Import')]";

    private String chooseTemplateButton = "//button[contains(@class,'btn-design') and contains(text(),'Choose Template')]";

    private String searchTemplate = "//input[contains(@class,'filter-search')]";

    private String templateSaveButton = "button.import-btn.btn-design";

    private String campaignSendButton = "button.btn-design.btn-send";

    private String campaignSendNowButton = "//button[@type='button' and contains(normalize-space(.),'Send Now')]";

    // ================= ACTIONS =================

    public void clickOnSmsMenu() {
        click(smsMenu);
    }

    public void clickOnCampaignsSubMenu() {
        // The original used a relative locator which is fragile. A direct locator is better.
        click(campaignsElement);
    }

    public void acknowledgeDltPopupWindow() {
        click(campaignsDltPopup);
    }

    public void clickOnCreateCampaignButton() {
        click(createCampaign);
    }

    public void enterCampaignName(String campaignName) {
        campaignCommonComponent.enterCampaignName(campaignName);
    }

    public void selectCampaignCategory(String categoryText) {
        campaignCommonComponent.selectCampaignCategory(categoryText);
    }

    public void selectCampaignType() {
        click(campaignType);
    }

    public void clickOnImportContacts() {
        click(importContacts);
    }

    public void clickOnListTab() {
        click(contactsListTab);
    }

    public void searchContactList(String listName) {
        type(contactsListSearchInput, listName);
    }

    public void selectContactList(String contactListName) {
        tableSelectionManager.selectContactListByName(contactListName);
    }

    public void clickOnGoButton() {
        click(contactsListGoButton);
    }

    public void clickOnImportButton() {
        click(contactsImportButton);
    }

    public void clickOnChooseTemplate() {
        click(chooseTemplateButton);
    }

    public void searchTemplate(String templateName) {
        typeAndEnter(searchTemplate, templateName);
    }

    public void selectTemplate(String templateName) {
        tableSelectionManager.selectTemplateByName(templateName);
    }

    public void clickOnSaveButton() {
        click(templateSaveButton);
    }

    public void clickOnSendButton() {
        click(campaignSendButton);
    }

    public void clickOnSendNowButton() {
        click(campaignSendNowButton);
    }
}