package lombok;

import java.time.LocalDateTime;
//JavaBeans
@Getter //automatycznie dodaje gettery
@Setter // dodaje settery do kodu
@NoArgsConstructor //konstruktor bezargumentowy
@AllArgsConstructor // konstruktory z wszystkimi argumentami
@ToString // automatycznie dodaje metodę toString
@EqualsAndHashCode // automatycznei dodaje metodę equals &hasCode
public class User {
    private int userId;
    private String email;
    private String password;
    private LocalDateTime registrationDateTima;
    private boolean status;
    private boolean removed;

}
