package mylab.notification.di.annot;

import mylab.notification.di.annot.config.NotificationConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = NotificationConfig.class)
public class NotificationConfigTest {
    @Autowired
    private NotificationManager notificationManager;

    @Test
    public void testNotification() {
        // 정상적인 NotificationManager 생성 확인
        assertNotNull(notificationManager);

        // email 서비스 검증
        NotificationService email = notificationManager.getEmailService();
        assertTrue(email instanceof EmailNotificationService);
        assertEquals("smtp.gmail.com", ((EmailNotificationService) email).getSmtpServer());
        assertEquals(587, ((EmailNotificationService)email).getPort());

        // sms 서비스 검증
        NotificationService sms = notificationManager.getSmsService();
        assertTrue(sms instanceof SmsNotificationService);
        assertEquals("SKT", ((SmsNotificationService)email).getProvider());

        email.sendNotification("emailNotificationService Test");
        sms.sendNotification("smsNotificationService Test");
    }
}
