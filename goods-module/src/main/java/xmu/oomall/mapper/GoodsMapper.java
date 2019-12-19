package xmu.oomall.mapper;


import org.apache.ibatis.annotations.Mapper;
import xmu.oomall.domain.Goods;
import xmu.oomall.domain.GoodsPo;

import java.util.List;

/**
 * @author lianh
 * @date 2019/12/07
 */
@Mapper
public interface GoodsMapper {

    /**
     * @param goodsSn
     * @param name
     * @return 商品列表(包括下架的）
     */
    List<GoodsPo> adminFindGoodsList(String goodsSn, String name);

    /**
     * @param id
     * @return 商品信息(包括下架的）
     */
    GoodsPo adminFindGoodsById(Integer id);

    /**
     * @param goodsPo
     * @return 更新后的商品
     */
    GoodsPo updateGoods(GoodsPo goodsPo);

    /**
     * @param id
     * @return 返回操作结果
     */
    int deleteGoods(Integer id);

    /**
     * @param goodsPo
     * @return 新增的商品
     */
    GoodsPo addGoods(GoodsPo goodsPo);

    /**
     * @param id
     * @return 商品信息(不包括下架的）
     */
    GoodsPo userFindGoodsById(Integer id);

    /**
     * @param name
     * @return 商品列表(不包括下架的）
     */
    List<GoodsPo> userFindGoodsList(String name);

}