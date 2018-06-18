package helpers;

public class EmailPageComposeSelectors {

    public static final String TO_WHOM="textarea.js-input.compose__labels__input";
    public static final String COMPOSE_FRAME ="td.mceIframeContainer.mceFirst.mceLast>iframe";
    public static final String LETTER_BODY = "body#tinymce";
    public static final String CONFERM_EMPTY ="//div[@class='is-compose-empty_in']/descendant::button";
    public static final String SEND =  "//*[contains(@data-shortcut-title,'Ctrl+Enter')]";
    //public static final String COMPOSE_TO ="//div[@data-bem='label-input' and @data-blockid='compose_to']";
    public static final String SUBJECT = "//input[@class='b-input']";
}
