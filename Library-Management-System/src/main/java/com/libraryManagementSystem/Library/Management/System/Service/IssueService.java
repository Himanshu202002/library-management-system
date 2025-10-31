package com.libraryManagementSystem.Library.Management.System.Service;

import com.libraryManagementSystem.Library.Management.System.Entity.Book;
import com.libraryManagementSystem.Library.Management.System.Entity.IssueRecord;
import com.libraryManagementSystem.Library.Management.System.Repository.BookRepository;
import com.libraryManagementSystem.Library.Management.System.Repository.IssueRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class IssueService {
    private final IssueRepository issueRepository;
    private final BookRepository bookRepository;

    public IssueService(IssueRepository issueRepository, BookRepository bookRepository) {
        this.issueRepository = issueRepository;
        this.bookRepository= bookRepository;
    }

    //Issue a Book
    public IssueRecord issueBook(IssueRecord issueRecord){
        Optional<Book> bookOptional= bookRepository.findById(issueRecord.getBookId());
        if (bookOptional.isPresent()){
            Book book= bookOptional.get();
            if (book.getAvailableCopies()>0){
                book.setAvailableCopies(book.getAvailableCopies()-1);
                if (book.getAvailableCopies()==0){
                    book.setAvailable(false);
                }
                bookRepository.save(book);
                issueRecord.setDueDate(LocalDate.now().plusDays(15));
                return issueRepository.save(issueRecord);
            }
        }
        return null;
    }

    //Return a Book

    public IssueRecord returnBook(String issueId){
        Optional<IssueRecord> issueRecordOptional= issueRepository.findById(issueId);
        if (issueRecordOptional.isPresent()){
            IssueRecord issue = issueRecordOptional.get();
            if (!issue.isReturned()){
                issue.setReturned(true);
                issue.setReturnDate(LocalDate.now());

                Optional <Book> bookOptional= bookRepository.findById(issue.getBookId());
                bookOptional.ifPresent(book ->{
                    book.setAvailableCopies(book.getAvailableCopies()+1);
                    book.setAvailable(true);
                    bookRepository.save(book);
                });
                return issueRepository.save(issue);
            }
        }
        return null;
    }

    //Get all issued Records
    public List<IssueRecord> getAllIssuedBooks(){
        return issueRepository.findAll();
    }

    //Get issued books by Members
    public List<IssueRecord> getIssuedByMembers(String memberId){
        return issueRepository.findByMemberId(memberId);
    }
}
