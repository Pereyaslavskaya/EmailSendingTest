package helpers;

public class LoginPageSelectors {

    public static final String LOGIN_FIELD ="//input[@name='Login' and @placeholder='Логин']";
    public static final String DOMAIN_SELECT = "//div[@class='domain-select']";
    public static final String SELECT_OPTION = "//div[@role='combobox' and @aria-activedescendant='react-select-2--option-0']";
    public static final String PASSWORD_FIELD = "//input[@name='Password' and @placeholder='Пароль'] ";
    public static final String SAVEAUTH = "//input[@name='saveauth']";
    public static final String SUBMIT_BUTTON="//button[@data-test-id='submit-button']";
    public static final String FRAME ="//iframe[contains(@class,ag-popup__frame__layout__iframe) and contains(@src,'https://account.mail.ru')]";


}
