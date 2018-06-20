package com.oasisaac.gapsytest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oasisaac.gapsytest.model.Note;


@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

}
