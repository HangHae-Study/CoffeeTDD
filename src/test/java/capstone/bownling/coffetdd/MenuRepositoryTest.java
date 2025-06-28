package capstone.bownling.coffetdd;

import capstone.bownling.coffetdd.entity.Menu;
import capstone.bownling.coffetdd.repository.MenuRepository;
import capstone.bownling.coffetdd.service.MenuService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.stereotype.Service;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class MenuRepositoryTest {
    @Mock
    private MenuRepository menuRepository;

    @InjectMocks
    private MenuService menuService;

    @Test
    void 메뉴_목록을_조회한다_Mock의존_01 () {
        // 기존 동작 방식을 먼저 알고 있기 때문에, 구현을 먼저 숙지한채로 작성한 코드 (Test Last Development)
        // 로직에 대한 관심보다 기반 데이터 설정에 대한 관심이 훨씬 많고, 그에 대한 목킹이 대부분. 이미 구현된 메서드에 대해 테스트를 작성
        var menuList = List.of(
                Menu.builder().menuId(1L).menuNm("아이스 아메리카노").menuPrice(15L).build(),
                Menu.builder().menuId(2L).menuNm("카페 라떼").menuPrice(12L).build(),
                Menu.builder().menuId(3L).menuNm("아이스티").menuPrice(11L).build()
        );

        given(menuRepository.findAll()).willReturn(menuList);

        var result = menuRepository.findAll();
        assertThat(result).hasSize(3);
        assertThat(result.get(0).getMenuNm()).isEqualTo("아이스 아메리카노");
        assertThat(result.get(1).getMenuPrice()).isEqualTo(12L);
    }


    @Test
    void 메뉴목록_조회시_메뉴정보리스트를_반환한다_RedTest() {
        // when
        List<MenuResponse> result = menuService.getMenuList();

        // then
        assertThat(result).hasSize(3);
        assertThat(result.get(0).getMenuName()).isEqualTo("아이스 아메리카노");
        assertThat(result.get(0).getMenuPrice()).isEqualTo(15L);
    }

}
