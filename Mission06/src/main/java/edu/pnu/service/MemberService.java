package edu.pnu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import edu.pnu.domain.Member;
import edu.pnu.persistence.MemberRepository;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class MemberService {
	
	@Autowired
	private final MemberRepository memberRepo;

	public List<Member> getAllMember() {
	return memberRepo.findAll();
	}

	public Member getMemberById(String username) {
		return memberRepo.findById(username).get();
		}

	public Member addMember(Member member) {
		return memberRepo.save(member);
	}

	public Member updateMember(Member member) {
		Member m = memberRepo.findById(member.getUsername()).get();
		m.update(member);
		return memberRepo.save(m);
	}

	public Member deletMember(@PathVariable String username) {
		Member m = memberRepo.findById(username).get();
		memberRepo.deleteById(username);
		return m;
		
	}
}
