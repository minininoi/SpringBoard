package portfolio.springboard.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass //상위 클래스 호환되는 공통 속성
@Getter @Setter
@EntityListeners(AuditingEntityListener.class) //등록일, 수정일을 위한 이벤트 리스너
public abstract class BaseEntity {

    @CreatedDate //생성일
    @Column(updatable = false) //추가시에만 생성되도록 통제
    private LocalDateTime createAt; // 최신순으로 정렬 할 수 있도록 인덱스

    @LastModifiedDate //수정일
    @Column(insertable = false) //수정시에만 변경되도록 통제
    private LocalDateTime modifiedAt;
}
