/*
 * @created 28/09/2021 - 5:36 PM
 * @author vanha
 */

package com.h2s.security.repository;

import com.h2s.security.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
}
