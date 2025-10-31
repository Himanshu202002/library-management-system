package com.libraryManagementSystem.Library.Management.System.Controller;

import com.libraryManagementSystem.Library.Management.System.Entity.Member;
import com.libraryManagementSystem.Library.Management.System.Service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/members")
@CrossOrigin(origins = "*")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    //Get all members
    @GetMapping
    public ResponseEntity<List<Member>> getAllMembers(){
        return ResponseEntity.ok(memberService.getAllMembers());
    }

    //Get members By ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Member>> getMemberById(@PathVariable String id){
        return ResponseEntity.ok(memberService.getMemberById(id));
    }

    //Register or update member
    @PostMapping
    public ResponseEntity<Member> saveMember(@RequestBody Member member){
        return ResponseEntity.ok(memberService.saveMember(member));
    }

    //Delete Member
    @DeleteMapping
    public ResponseEntity<String> deleteMember(@PathVariable String id){
        memberService.deleteMember(id);
        return ResponseEntity.ok("Deleted Successfully");
    }
}
