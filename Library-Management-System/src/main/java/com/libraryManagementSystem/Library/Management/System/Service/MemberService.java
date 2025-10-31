package com.libraryManagementSystem.Library.Management.System.Service;

import com.libraryManagementSystem.Library.Management.System.Entity.Member;
import com.libraryManagementSystem.Library.Management.System.Repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;
    
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member saveMember(Member member){
        return memberRepository.save(member);
    }

    public List<Member> getAllMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> getMemberById(String id){
        return memberRepository.findById(id);
    }

    public void deleteMember(String id){
        memberRepository.deleteById(id);
    }
}
