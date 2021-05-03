
import java.util.HashMap;
import java.util.Map;

import spring5_basic_study.di.Member;

public class MemberDao {
	private static long nxtId=0;
	
	private Map<String, Member>map = new HashMap<>();
	
	public Member selectByEmail(String email) {
		return map.get(email);
	}
		public void insert(Member member) {
			member.setId(++nxtId);
			map.put(member.getEmail(),member);
		
	}
		public void update(Member member) {
			map.put(member.getEmail(), member);
		}

}
