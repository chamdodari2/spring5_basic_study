package spring5_basic_study.di;

public class Assembler {

	private MemberDao memberDao;
	private MemberRegisterService regSvc;
	private ChangePasswordService pwdSvc;

	public Assembler() {
		memberDao = new MemberDao();
		regSvc = new MemberRegisterService(memberDao);
		pwdSvc = new ChangePasswordService();
		pwdSvc.setMemberDao(memberDao);
	}

	public MemberDao getMemberDao() {
		return memberDao;
	}

	public MemberRegisterService getMemberRegisterService() {
		// TODO Auto-generated method stub
		return regSvc;
	}

	public ChangePasswordService getChangePasswordService() {
		// TODO Auto-generated method stub
		return pwdSvc;
	}
	}

