package com.libraryManagementSystem.Library.Management.System.Repository;

import com.libraryManagementSystem.Library.Management.System.Entity.IssueRecord;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssueRepository extends MongoRepository<IssueRecord, String > {
    List<IssueRecord> findByBookId(String bookId);
    List<IssueRecord> findByMemberId(String memberId);
}
