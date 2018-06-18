package tests;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DataProviderRunner.class)
public class Tests extends  TestBase {


  @Test
  @UseDataProvider(value = "SigninInMailBoxAndSendEmailsToValidEmailLogins", location = DataProviders.class)
    public void loginInMailBoxAndSendEmptyMailToValidLogin(String login,String domain,String password,String toWhom){
      application.getMainPage().open().SignOutIfNecessary().SignInInMailBox(login,domain,password);
      application.getEmailPageMessages().createNewMessage();
      application.getEmailPageCompose().sendEmptyLetter(toWhom);
      Assert.assertTrue(application.getEmailPageSendMS().mailSentTitle().equals("Ваше письмо отправлено. Перейти во Входящие"));
  }

  @Test
  @UseDataProvider(value = "SigninInMailBoxAndSendEmailsToValidEmailLogins", location = DataProviders.class)
    public void loginInMailBoxAndSendMailToValidLogin(String login,String domain,String password,String toWhom){
    application.getMainPage().open().SignOutIfNecessary().SignInInMailBox(login,domain,password);
    application.getEmailPageMessages().createNewMessage();
    application.getEmailPageCompose().sendLetter(toWhom);
    Assert.assertTrue(application.getEmailPageSendMS().mailSentTitle().equals("Ваше письмо отправлено. Перейти во Входящие"));
  }

  @Test
  @UseDataProvider(value = "SigninByLinkAndSendEmailsToValidEmailLogins", location = DataProviders.class)
  public void loginByMailLinkAndSendEmptyMailToValidLogin(String login,String password,String toWhom){
    application.getMainPage().open().SignOutIfNecessary().enterToMailByMailLink().SigninByLink(login,password);
    application.getEmailPageMessages().createNewMessage();
    application.getEmailPageCompose().sendEmptyLetter(toWhom);
    Assert.assertTrue(application.getEmailPageSendMS().mailSentTitle().equals("Ваше письмо отправлено. Перейти во Входящие"));
  }


  @Test
  @UseDataProvider(value = "SigninByLinkAndSendEmailsToValidEmailLogins", location = DataProviders.class)
  public void loginByEntranceLinkAndSendMailToValidLogin(String login,String password,String toWhom){
    application.getMainPage().open().SignOutIfNecessary().enterToMailByEntranceLink().SigninByLink(login,password);
    application.getEmailPageMessages().createNewMessage();
    application.getEmailPageCompose().sendLetter(toWhom);
    Assert.assertTrue(application.getEmailPageSendMS().mailSentTitle().equals("Ваше письмо отправлено. Перейти во Входящие"));
  }

  @Test
  @UseDataProvider(value = "SigninInMailBoxAndSendEmailsToInvalidEmailLogins", location = DataProviders.class)
  public void loginInMailBoxAndSendMailToInvalidLogin(String login,String domain,String password,String toWhom){
    application.getMainPage().open().SignOutIfNecessary().SignInInMailBox(login,domain,password);
    application.getEmailPageMessages().createNewMessage();
    application.getEmailPageCompose().sendLetterInvalidAddress(toWhom);
    Assert.assertFalse(application.getEmailPageSendMS().isOnThisPage());
  }





}
