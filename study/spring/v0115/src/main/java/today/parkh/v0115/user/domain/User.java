package today.parkh.v0115.user.domain;

import lombok.*;
import today.parkh.v0115.common.domain.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_user") // DB 안 꼬이게 하려면 이게 낫더라...
@EqualsAndHashCode(of = "uid", callSuper = true)
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User extends BaseEntity {

    @Id
    @GeneratedValue
    private Long uid;

    private String name;
}
