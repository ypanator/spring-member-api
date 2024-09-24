package api.members.members_api.rest;

import org.springframework.web.bind.annotation.RestController;

import api.members.members_api.entity.Member;
import api.members.members_api.service.MemberService;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/member")
public class MembersController {

    private final MemberService memberService;
    
    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Member member) {
        memberService.save(member);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<Member>> getAll() {
        List<Member> members = memberService.getAll();
        return ResponseEntity.ok(members);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Member> getByName(@PathVariable String name) {
        Member member = memberService.getByName(name);
        return ResponseEntity.ok(member);
    }
    

    @PutMapping("/{name}")
    public ResponseEntity<Member> update(@PathVariable String name, @RequestBody Member member) {
        Member updatedMember = memberService.update(member, name);        
        return ResponseEntity.ok(updatedMember);
    }
    
    @DeleteMapping("/{name}")
    public ResponseEntity<Void> delete(@PathVariable String name) {
        memberService.delete(name);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}