package com.plateer.todo.product.domain;

import com.plateer.todo.common.domain.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tbl_fancy")
@EqualsAndHashCode(callSuper=false, of="fno")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Fancy extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fno;

    @ManyToOne
    private Product product;

    private String fwriter;
}



