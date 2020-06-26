package kr.co.sol.board.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@ToString
@Entity
public class Board2 {
	@Id 
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "bd2_seq")
	@SequenceGenerator(name="bd2_seq",sequenceName="BD2_SEQ",initialValue=1, allocationSize =1)
	private int seq;
	private String title;
	private String writer;
	private String content;
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date createDate;
	private int cnt;
} 

