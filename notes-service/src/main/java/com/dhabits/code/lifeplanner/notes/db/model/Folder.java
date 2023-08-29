//package com.dhabits.code.lifeplanner.notes.db.model;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
//import jakarta.persistence.OneToMany;
//import jakarta.persistence.Table;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.util.*;
//
//@Entity
//@Table(name = "folder", schema = "notes")
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//public class Folder {
//
//    @Column(name = "name")
//    private String name;
//
//    @OneToMany(mappedBy = "folder", fetch = FetchType.LAZY)
//    private List<Note> notes;
//    {
//        HashSet
//    }
//}
