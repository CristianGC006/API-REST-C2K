package com.C2KProyect.Api_Rest_C2K.repositories;

import com.C2KProyect.Api_Rest_C2K.models.Branch;
import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBranchRepository extends JpaRepository<Branch,Integer> {
}
