package com.example.ContentManagement.repository;

import com.example.ContentManagement.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
