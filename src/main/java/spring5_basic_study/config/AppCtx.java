package spring5_basic_study.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring5_basic_study.di.ChangePasswordService;
import spring5_basic_study.di.MemberDao;
import spring5_basic_study.di.MemberInfoPrinter;
import spring5_basic_study.di.MemberListPrinter;
import spring5_basic_study.di.MemberPrinter;
import spring5_basic_study.di.MemberRegisterService;
import spring5_basic_study.di.VersionPrinter;

@Configuration
public class AppCtx {

	
	@Autowired
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	
	@Autowired
	public MemberPrinter memberPrinter() {  //dㅒ랑 멤버리스트프린터도 입력
		return new MemberPrinter();
	}

	@Bean
	public MemberListPrinter listPrinter() {
		return new MemberListPrinter(/* memberDao(), memberPrinter() */);
	}
	@Bean
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter infoPrinter=new MemberInfoPrinter();
	//	infoPrinter.setMemberDao(memberDao());
	//	infoPrinter.setPrinter(memberPrinter());
		return infoPrinter;
	}
	@Bean
	public VersionPrinter vertionPrinter() {
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(5);
		versionPrinter.setMinorVersion(0);
		return versionPrinter;
	}
	
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao());
	}
	@Bean
	public ChangePasswordService changePwdSvc() {
		ChangePasswordService pwdSvc = new ChangePasswordService();
		pwdSvc.setMemberDao(memberDao());
		return pwdSvc;
	}
}
