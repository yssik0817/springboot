package kr.co.sol.board.persistence;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import kr.co.sol.board.dto.Board2;

public interface BoardRepository extends CrudRepository<Board2,Integer> {

    List<Board2> findByTitle(String searchKeyword);
    List<Board2> findByContentContaining(String searchKeyword);
    List<Board2> findByTitleContainingOrContentContaining(String title, String content);
    List<Board2> findByTitleContainingOrderBySeqDesc(String searchKeyword);
    //List<Board2> findByTitleContaining(String searchKeyword, Pageable paging);
    Page<Board2> findByTitleContaining(String searchKeyword, Pageable paging);
    
   /*
    * @Query("SELECT b FROM Board2 b WHERE b.title like %?1% ORDER BY b.seq DESC")
    * List<Board2> queryAnnotationTest1(String searchkeyword);
    */
    
    @Query("SELECT b FROM Board2 b WHERE b.title like %:searchKeyword% ORDER BY b.seq DESC")
    List<Board2> queryAnnotationTest1(@Param("searchKeyword") String searchKeyword);
    
    @Query("SELECT b.seq, b.title, b.writer, b.createDate FROM Board2 b WHERE b.title like %?1% ORDER BY b.seq DESC")
    List<Object[]> queryAnnotationTest2(@Param("searchKeyword") String searchKeyword);
    
    @Query(value="SELECT seq, title, writer, createDate FROM Board2 b WHERE title like '%'||?1||'%' ORDER BY seq DESC", nativeQuery=true)
    List<Object[]> queryAnnotationTest3(@Param("searchKeyword") String searchKeyword);
    
    @Query(value="SELECT b FROM Board2 b ORDER BY b.seq DESC")
    List<Board2> queryAnnotationTest4(Pageable paging);
}




