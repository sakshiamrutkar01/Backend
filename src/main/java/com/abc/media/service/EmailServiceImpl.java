//@Service
//public class PasswordResetTokenServiceImpl implements PasswordResetTokenService {
//
//  @Autowired
//  private PasswordResetTokenRepository passwordResetTokenRepository;
//
//  @Override
//  public PasswordResetToken save(PasswordResetToken passwordResetToken) {
//    return passwordResetTokenRepository.save(passwordResetToken);
//  }
//}
//
//@Service
//public interface EmailService {
//  void sendPasswordResetEmail(String email, String token);
//}
//
//@Service
//public class EmailServiceImpl implements EmailService {
//
//  @Autowired
//  private JavaMailSender javaMailSender;
//
//  @Override
//  public void sendPasswordResetEmail(String email, String token) {
//    String resetUrl = "https://example.com/reset-password?token=" + token;
//    String body = "To reset your password, please click on the following link: " + resetUrl;
//    SimpleMailMessage message = new SimpleMailMessage();
//    message.setTo(email);
//    message.setSubject("Password Reset Request");
//    message.setText(body);
//    javaMailSender.send(message);
//  }
//}

