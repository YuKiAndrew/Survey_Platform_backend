package net.diaowen.common.plugs.email;

import net.diaowen.common.base.entity.User;

public interface MailService {
    

    public boolean sendMail(String to, String title, String content);

    public boolean sendRegisterMailByAsync(User user);

    public boolean sendFindPwdMailByAsync(User user);

    public String sendSurveyInviteMail(final String dwSubject, final String substitutionVars);
    
}
