package capstone.bownling.coffetdd.service;

import capstone.bownling.coffetdd.MenuResponse;
import capstone.bownling.coffetdd.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;

    public List<MenuResponse> getMenuList() {

        return menuRepository.findAll().stream().map(menu -> new MenuResponse(
                menu.getMenuId(),
                menu.getMenuNm(),
                menu.getMenuPrice()
        )).toList();

        /*
        테스트 코드 동작 Green 용
        return List.of(
                new MenuResponse(1L, "아이스 아메리카노", 15L),
                new MenuResponse(2L, "카페 라떼", 12L),
                new MenuResponse(3L, "아이스티", 11L)
        );*/
    }

}
