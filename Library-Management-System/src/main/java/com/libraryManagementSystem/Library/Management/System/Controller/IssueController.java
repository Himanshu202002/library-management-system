package com.libraryManagementSystem.Library.Management.System.Controller;

import com.libraryManagementSystem.Library.Management.System.Entity.IssueRecord;
import com.libraryManagementSystem.Library.Management.System.Entity.Member;
import com.libraryManagementSystem.Library.Management.System.Service.IssueService;
import org.apache.tomcat.jni.Library;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.DocFlavor;
import java.util.List;

@RestController
@RequestMapping("/api/issues")
@CrossOrigin(origins = "*")
public class IssueController {

    private final IssueService issueService;

    public IssueController(IssueService issueService) {
        this.issueService = issueService;
    }

    //Issue a Book
    @PostMapping
    public ResponseEntity<IssueRecord> issueBook(@RequestBody IssueRecord issueRecord){
        IssueRecord issued= issueService.issueBook(issueRecord);
        if (issued==null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(issued);
    }

    //Return a book
    @PutMapping("/return/{issueId}")
    public ResponseEntity<IssueRecord> returnBook(@PathVariable String issueId){
        IssueRecord returned =issueService.returnBook(issueId);
        if (returned==null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(returned);
    }

    //Get All issued Books
    @GetMapping
    public ResponseEntity<List<IssueRecord>> getAllIssuedBooks(){
        return ResponseEntity.ok(issueService.getAllIssuedBooks());
    }

    //Get Books by members
    @GetMapping("/member/{memberId}")
    public ResponseEntity<List<IssueRecord>> getIssuedByMembers(@PathVariable String memberId){
        return ResponseEntity.ok(issueService.getIssuedByMembers(memberId));
    }
}
