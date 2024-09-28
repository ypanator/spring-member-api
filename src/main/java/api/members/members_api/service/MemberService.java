package api.members.members_api.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import api.members.members_api.entity.Member;
import api.members.members_api.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

@Service @RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public int save(Member member) {
        return memberRepository.save(member).getId();
    }
    
    public List<Member> getAll() {
        return memberRepository.findAll();
    }

    public Member getById(int id) {
        return memberRepository.findById(id).get();
    }

    @Transactional
    public Member update(Member newMember, int id) {
        Member storedMember = memberRepository.findById(id).get();

        storedMember.setFirstName(newMember.getFirstName());
        storedMember.setLastName(newMember.getLastName());

        memberRepository.save(storedMember);
        return storedMember;
    }

    @Transactional
    public void delete(int id) {
        memberRepository.deleteById(id);
    }
}