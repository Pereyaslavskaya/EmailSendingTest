package tests;


import com.tngtech.java.junit.dataprovider.DataProvider;


public class DataProviders {


    @DataProvider
    public static Object[][] SigninInMailBoxAndSendEmailsToValidEmailLogins(){
        return new Object[][]{
                {"ira.test.00","@mail.ru","tteesstt00","ira.test.00@mail.ru"},
                {"ira.test.00","@mail.ru","tteesstt00","ira.test.11@mail.ru"},
        };
    }

    @DataProvider
    public static Object[][] SigninByLinkAndSendEmailsToValidEmailLogins(){
        return new Object[][]{
                {"ira.test.00","tteesstt00","ira.test.00@mail.ru"},
                {"ira.test.00","tteesstt00","ira.test.11@mail.ru"},
        };
    }

    @DataProvider
    public static Object[][] SigninInMailBoxAndSendEmailsToInvalidEmailLogins(){
        return new Object[][]{
                {"ira.test.00","@mail.ru","tteesstt00",""},
                {"ira.test.00","@mail.ru","tteesstt00","test@test"},
        };
    }


}
