package net.diaowen.dwsurvey.service;

import net.diaowen.dwsurvey.entity.ImportError;

/**
 * 导入错误记录
 * @author ymx
 *
 * 
 * http://dwsurvey.net
 */
public interface ImportErrorManager {

    void save(ImportError importError);

}
