package com.automation.pages.campaign;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.MouseButton;
import com.automation.base.BasePage;
import com.automation.pages.components.CampaignCommonComponent;
import com.automation.pages.components.MenuComponent;
import com.automation.utils.TableSelectionManager;

public class WhatsAppCampaignPage extends BasePage {

    private final TableSelectionManager tableSelectionManager;
    private final MenuComponent menu;
    private final CampaignCommonComponent campaignCommonComponent;

    public WhatsAppCampaignPage(Page page) {
        super(page);
        this.tableSelectionManager = new TableSelectionManager(page);
        this.campaignCommonComponent = new CampaignCommonComponent(page);
        this.menu = new MenuComponent(page);
    }

    private String wabaNumberDropdown = ".wa-business-number";
    private String chooseWabaNumber = "xpath=//span[normalize-space()='+91-8448098743 (TestDG)']";
    private String importContactsButton = "xpath=//button[normalize-space()='Import Contacts']";
    private String contactsListTab = "xpath=//span[contains(@class,'mdc-tab__text-label') and normalize-space()='Lists']";
    private String contactsListSearchInput = "xpath=//input[@placeholder='Search List']";
    private String contactsListGoButton = "xpath=//button[normalize-space()='Go']";
    private String contactsImportButton = "xpath=//button[contains(@class,'process-file') and normalize-space()='Import']";
    private String chooseTemplateButton = "xpath=//button[contains(@class,'btn-design') and normalize-space()='Choose Template']";
    private String searchTemplate = "xpath=//input[contains(@class,'filter-search')]";
    private String templateSaveButton = "button.import-btn.btn-design";
    private String selectLanguageDropdown = "xpath=//span[contains(@class,'ellipsis-text') and normalize-space()='Select']";
    private String selectEnglishOption = "xpath=//div[contains(@class,'drop-item')]//span[normalize-space()='English']";
    private String variable = "xpath=(//a[contains(@class,'variable-text')])[1]";
    private String personaliseText = "xpath=//span[normalize-space()='Personalise']";
    private String allVariableText = "xpath=//span[normalize-space()='All Variables']";
    private String variableInputBox = "xpath=//input[@placeholder='Static text goes here']";
    private String saveButton = "xpath=//button[normalize-space()='Save' and not(contains(@class,'import-btn'))]";
    private String campaignSendButton = "button.btn-design.btn-send";
    private String campaignSendNowButton = "xpath=//button[@type='button' and normalize-space()='Send Now']";

    public void clickOnWabaMenu() {
        menu.navigate("WhatsApp");
    }

    public void clickOnCampaignsSubMenu() {
        menu.navigate("WhatsApp", "Campaigns");
    }

    public void clickOnCreateCampaignButton() {
        campaignCommonComponent.clickOnCreateCampaignButton();
    }

    public void enterCampaignName(String campaignName) {
        campaignCommonComponent.enterCampaignName(campaignName);
    }

    public void selectCampaignCategory(String categoryText) {
        campaignCommonComponent.selectCampaignCategory(categoryText);
    }

    public void selectWhatsappBusinessNumber() {
        click(wabaNumberDropdown);
        click(chooseWabaNumber);
    }

    public void importContactsList(String listName, String contactListName) {
        click(importContactsButton);
        click(contactsListTab);
        type(contactsListSearchInput, listName);
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

    public void selectLanguage() {
        click(selectLanguageDropdown);
        click(selectEnglishOption);
    }

    public void variablePersonalisation(String value) {
        // Right-click the variable
        locator(variable).click(new Locator.ClickOptions().setButton(MouseButton.RIGHT));
        // Hover over 'Personalise'
        locator(personaliseText).hover();
        // Click 'All Variables'
        locator(allVariableText).click();
        // Fill the input and save
        type(variableInputBox, value);
        click(saveButton);
    }

    public void clickOnSendButton() {
        click(campaignSendButton);
    }

    public void clickOnSendNowButton() {
        click(campaignSendNowButton);
    }
}