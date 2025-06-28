package capstone.bownling.coffetdd;

public class MenuResponse{
    private Long menuId;
    private String menuNm;
    private Long menuPrice;

    public MenuResponse(Long id, String nm, Long mp){
        this.menuId = id;
        this.menuNm = nm;
        this.menuPrice = mp;
    }

    public Long getMenuId(){
        return this.menuId;
    }

    public String getMenuName(){
        return this.menuNm;
    }

    public Long getMenuPrice(){
        return this.menuPrice;
    }
}
