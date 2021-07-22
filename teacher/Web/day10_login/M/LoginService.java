package login.mvc.model;

import mvc.domain.Member;
import static login.mvc.model.LoginConst.*;

public class LoginService {
	private LoginDAO dao;
	
	//SingleTon Object Model - start!! 
	private static final LoginService instance = new LoginService();
	private LoginService() {
		dao = new LoginDAO();
	}
	public static LoginService getInstance() {
		return instance;
	}
	//SingleTon Object Model - end!! 
	
	public Member getMemberS(String email) {
		Member m = dao.getMember(email);
		m.setPwd("");
		
        return m;
	}
	
	public int check(String email, String pwd) {
		//Member m = getMemberS(email); //PWD 제외
		Member m = dao.getMember(email); //PWD 포함 
		if(m == null) {
			return NO_ID; //그런 email을 가진 회원이 없는 경우 
		}else {
			String dbPwd = m.getPwd();
			if(dbPwd != null) dbPwd = dbPwd.trim();
			
			if(!dbPwd.equals(pwd)) {
				return NO_PWD; //email의 회원은 존재하나 비번이 다른 경우 
			}else {
				return YES_ID_PWD; //email과 pwd가 맞음 
			}
		}
	}
}
