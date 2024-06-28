package com.example.hotel_arcana.notice.dto;

import lombok.*;

import java.util.List;

@Getter
@ToString
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageResponseDTO<E> {
  private PageRequestDTO pageRequestDTO; // 페이징 요청 정보를 담는 객체
  private int page;
  private int size;
  private int total;

  private int start;
  private int end;

  private boolean prev;
  private boolean next;
  private List<E> dtoList;

  @Builder(builderMethodName = "withAll")
  public PageResponseDTO(PageRequestDTO pageRequestDTO, List<E> dtoList, int total) {
    if(total <= 0){
      return;
    }
    this.page = pageRequestDTO.getPage();
    this.size = pageRequestDTO.getSize();
    this.total = total;
    this.dtoList = dtoList;
    this.end = (int)(Math.ceil(this.page/10.0))*10;
    this.start = this.end-9;
    int last = (int)(Math.ceil((total/(double)size)));
    this.end = end>last?last:end;
    this.prev= this.start>1;
    this.next = total > this.end * this.size;
  }

}

