/*
 * ��¼�߼����ʵ�ֽӿ�
 * 2019/07/10
 * ��˶
 */
package nju.sofware.service;

import nju.sofware.data.dataobject.Useraccount;

public interface LoginService {
	Useraccount valUser(String username,String password) throws Exception;
}
