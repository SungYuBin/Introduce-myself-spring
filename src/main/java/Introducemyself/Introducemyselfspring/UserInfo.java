package Introducemyself.Introducemyselfspring;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name="userinfo")
public class UserInfo {

    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY) // mysql의 AUTO_INCREMENT를 그대로 사용 private Long id;
    @Column(name = "idx")
    private int idx;

    @Column(name = "id")
    private String id;

    @Column(name ="pw", nullable = false)
    private String pw;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private String age;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "salt_id")
    private Salt salt;
    //private String salt;


}
