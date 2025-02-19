package net.diaowen.common.base.service;

import java.util.List;

import net.diaowen.common.base.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.diaowen.common.base.dao.UserDao;
import net.diaowen.common.exception.ServiceException;
import net.diaowen.common.plugs.security.ShiroDbRealm;
import net.diaowen.common.utils.security.DigestUtils;

/**
 *
 *
 */
@Service
public class AccountManager {

	private static Logger logger = LoggerFactory.getLogger(AccountManager.class);

	@Autowired
	private UserDao userDao;

//	@Autowired
//	private NotifyMessageProducer notifyMessageProducer;

	private ShiroDbRealm shiroRealm;

	/**
	 When saving a user, send a user modification notification message. The message recipient will asynchronously handle the time-consuming task of sending notification emails.

	 If there is an attempt to modify a superuser, retrieve the current operator user, print their information, and then throw an exception.
	 *
	 */
	@Transactional
	public void saveUser(User user) {
		if (isSupervisor(user)) {
			logger.warn("personnel {} change admin account", SecurityUtils.getSubject()
					.getPrincipal());
			throw new ServiceException("can not change admin account");
		}
		//判断是否有重复用户
		String shaPassword = DigestUtils.sha1Hex(user.getPlainPassword());
		user.setShaPassword(shaPassword);
		boolean bool=user.getId()==null?true:false;
		userDao.save(user);
		if (shiroRealm != null) {
			shiroRealm.clearCachedAuthorizationInfo(user.getLoginName());
		}
		/*if(bool){
//			Email email=new Email();
//			sendNotifyMessage(email);	使用jms辅助 发送邮件
			simpleMailService.sendRegisterMailByAsync(user);
		}*/
	}

	@Transactional
	public void saveUp(User user){
		if (isSupervisor(user)) {
			logger.warn("personnel {} change admin account", SecurityUtils.getSubject().getPrincipal());
			throw new ServiceException("can not change admin account");
		}
		userDao.save(user);
	}

	@Transactional
	public boolean updatePwd(String curpwd, String newPwd) {
		User user = getCurUser();
		if(user!=null){
			if(curpwd!=null && newPwd!=null){
				String curShaPassword = DigestUtils.sha1Hex(curpwd);
				if(user.getShaPassword().equals(curShaPassword)){
					String shaPassword = DigestUtils.sha1Hex(newPwd);
					user.setShaPassword(shaPassword);
					userDao.save(user);
					return true;
				}
			}
		}
		return false;
	}
	/*public User getByUid(String userSource,String uid){
		Criterion cri1=Restrictions.eq("thirdSource", userSource);
		Criterion cri2=Restrictions.eq("thirdUid", uid);
		return userDao.findUnique(cri1,cri2);
	}*/
	//新注册用户，注册后
//	private void sendNotifyMessage(Email email) {
//		notifyMessageProducer.sendQueue(email);
//	}



	private boolean isSupervisor(User user) {
//		return (user.getId() != null && user.getId() == 1L);
		return false;
	}

	@Transactional(readOnly = true)
	public User getUser(String id) {
		return userDao.get(id);
	}


	@Transactional(readOnly = true)
	public User findUserByLoginName(String loginName) {
		return userDao.findUniqueBy("loginName", loginName);
	}

	@Transactional(readOnly = true)
	public User findUserByLoginNameOrEmail(String loginName) {
		User user = null;
		if(loginName!=null){
			user = userDao.findUniqueBy("loginName", loginName);
			if(user==null && loginName.contains("@")){
				//是邮箱账号
				user = userDao.findUniqueBy("email", loginName);
			}
		}
		return user;
	}

	/*验证邮箱是否存在*/
	@Transactional(readOnly = true)
	public User findUserByEmail(String email){
		List<User> users=userDao.findBy("email", email);
		if(users!=null && users.size()>0){
			return users.get(0);
		}
		return null;
	}


	@Transactional(readOnly = true)
	public boolean isLoginNameUnique(String newLoginName, String oldLoginName) {
		return userDao.isPropertyUnique("loginName", newLoginName, oldLoginName);
	}


	public User getCurUser(){
		Subject subject=SecurityUtils.getSubject();

		if(subject!=null){
			Object principal=subject.getPrincipal();
			if(principal!=null){
				User user = findUserByLoginName(principal.toString());
				return user;
			}
		}
		return null;
	}



}
