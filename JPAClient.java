package com.rubypaper;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.rubypaper.domain.Board2;

public class JPAClient {
   public static void main(String[] args) {
      // EntityManager 생성
      EntityManagerFactory emf = 
Persistence.createEntityManagerFactory("chapter04");
      EntityManager em = emf.createEntityManager();
      
      // Transaction 생성
      EntityTransaction tx = em.getTransaction();
      
      try {
         // Transaction 시작
         tx.begin();

         // 수정할 게시글 조회
   //      Board2 board = em.find(Board2.class, 1);
      //   System.out.println("==>"+searchBoard.toString());
         Board2 board=new Board2();
         board.setTitle("JPA제목");
         board.setWriter("관리자");
         board.setContent("JPA 글등록");
         board.setCreateDate(new Date());
         board.setCnt(0);
         em.persist(board);
         // Transaction commit
         tx.commit();   

      } catch (Exception e) {
         e.printStackTrace();         
          //Transaction rollback
         tx.rollback();
      } finally {
         em.close();
         emf.close();
      }      
   }
}