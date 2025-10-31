package com.libraryManagementSystem.Library.Management.System.Repository;

import com.libraryManagementSystem.Library.Management.System.Entity.Member;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends MongoRepository<Member, String> {
}
