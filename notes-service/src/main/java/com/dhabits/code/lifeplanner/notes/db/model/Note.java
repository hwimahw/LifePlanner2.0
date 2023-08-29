//package com.dhabits.code.lifeplanner.notes.db.model;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Table;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Entity
//@Table(name = "folder", schema = "notes")
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//public class Note {
//
//    @Column(name = "name")
//    private String name;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "folder_id")
//    private Folder folder;
//}
