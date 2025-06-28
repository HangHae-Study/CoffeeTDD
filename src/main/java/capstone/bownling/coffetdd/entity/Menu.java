package capstone.bownling.coffetdd.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long menuId;//메뉴 ID

    private String menuNm; //메뉴 이름
    private Long menuPrice; // 메뉴 가격(결제 포인트)

    @Builder
    public Menu(long menuId, String menuNm, Long menuPrice) {
        this.menuId = menuId;
        this.menuNm = menuNm;
        this.menuPrice = menuPrice;
    }
}
