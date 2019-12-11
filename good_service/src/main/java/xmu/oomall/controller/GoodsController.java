///**
// * @author xingzhou
// * @date 2019/12/7 23:47
// * @version 1.0
// */
//
//package xmu.oomall.controller;
//
//import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import xmu.oomall.domain.Brand;
//import xmu.oomall.domain.Goods;
//import xmu.oomall.domain.GoodsCategory;
//import xmu.oomall.service.BrandService;
//import xmu.oomall.service.GoodsCategoryService;
//import xmu.oomall.service.GoodsService;
//import xmu.oomall.util.ResponseUtil;
//
//import javax.validation.constraints.NotNull;
//import java.util.List;
//
//@RestController
//@RequestMapping("/")
//public class GoodsController {
//
//@Autowired
//private GoodsCategoryService goodsCategoryService;
//@Autowired
//private GoodsService goodsService;
//@Autowired
//private BrandService brandService;
//    @GetMapping("/admins/brands")
//    @ApiOperation(value="根据条件搜索品牌/list")
//    public Object listBrandByCodition(String id, String name,
//                                      @RequestParam(defaultValue = "1") Integer page,
//                                      @RequestParam(defaultValue = "10") Integer limit
////                                      @Sort @RequestParam(defaultValue = "add_time") String sort,
////                                      @Order @RequestParam(defaultValue = "desc") String order
//    ) {
//        List<Brand> brandList= brandService.findBrandListByIdAndName(id,name,page,limit);
//        return ResponseUtil.ok(brandList);
//    };
//
//    @PostMapping("/brands")
//    @ApiOperation(value = "创建一个品牌/create")
//    public Object addBrand(@RequestBody Brand brand){
//        int ret=brandService.addBrand(brand);
//        if(ret==1) {
//            return ResponseUtil.ok();
//        }
//        return ResponseUtil.fail();
//    };
//
//    @GetMapping("/brands/{id}")
//    @ApiOperation(value="查看单个品牌信息/read")
//    public Object getBrandById(@PathVariable Integer id){
//        Brand brand= brandService.findBrandById(id);
//        if(brand!=null){
//            return ResponseUtil.ok(brand);
//        }
//        return  ResponseUtil.fail();
//    };
//
//
//    @PutMapping("/brands/{id}")
//    @ApiOperation(value="修改单个品牌的信息/update")
//    public Object updateBrandById(@PathVariable Integer id,@RequestBody Brand brand){
//        int ret= brandService.updateBrandById(id,brand);
//        if(ret==0){
//            return ResponseUtil.fail();
//        }
//        return ResponseUtil.ok();
//    };
//
//
//    @DeleteMapping("/brands/{id}")
//    @ApiOperation(value = "删除一个品牌/delete")
//    public Object deleteBrandById(@RequestBody Brand brand){
//        int id=brand.getId();
//        int ret= brandService.deleteBrandById(id);
//        if(ret==1){
//            return ResponseUtil.ok();
//        }
//        return ResponseUtil.fail();
//    };
//
//
//
//    @GetMapping("/categories")
//    @ApiOperation("查看所有的分类/list")
//    public Object listGoodsCategory()
//    {
//        List<GoodsCategory> goodsCategoryList=goodsCategoryService.findGoodsCategoryList();
//        if(goodsCategoryList.size()!=0)
//        {
//            Object object = ResponseUtil.ok(goodsCategoryList);
//            return object;
//        }
//        else
//        {
//            Object object= ResponseUtil.fail();
//            return object;
//        }
//    };
//
//
//
//    @PostMapping("/categories")
//    @ApiOperation(value="新建一个分类/create")
//    public Object addGoodsCategory(@RequestBody GoodsCategory goodsCategory)
//    {
//        if(goodsCategoryService.CreateGoodsCategory(goodsCategory)==1)
//        {
//            Object object = ResponseUtil.ok(goodsCategory);
//            return object;
//        }
//        else
//        {
//            Object object= ResponseUtil.fail();
//            return object;
//        }
//    };
//
//    @GetMapping("/categories/{id}")
//    @ApiOperation(value="查看单个分类信息/read")
//    public Object getGoodsCategoryById(@NotNull Integer id)
//    {
//        GoodsCategory goodsCategory=goodsCategoryService.findGoodsCategoryById(id);
//        if(goodsCategory!=null)
//        {
//            Object object = ResponseUtil.ok(goodsCategory);
//            return object;
//        }
//        else
//        {
//            Object object= ResponseUtil.fail();
//            return object;
//        }
//    };
//
//
//
//    @PutMapping("/categories/{id}")
//    @ApiOperation(value="修改分类信息/update")
//    public Object updateGoodsCategoryById(@PathVariable Integer id,@RequestBody GoodsCategory goodsCategory)
//    {
//        if(goodsCategoryService.updateGoodsCategory(goodsCategory)==1)
//        {
//            Object object = ResponseUtil.ok(goodsCategory);
//            return object;
//        }
//        else
//        {
//            Object object= ResponseUtil.fail();
//            return object;
//        }
//    };
//
//
//
//    @DeleteMapping("/categories/{id}")
//    @ApiOperation(value="删除单个分类/delete")
//    public Object deleteGoodsCategory(@PathVariable Integer id,@RequestBody GoodsCategory goodsCategory)
//    {
//        if(goodsCategoryService.deleteGoodsCategory(id)==1)
//        {
//            Object object = ResponseUtil.ok(goodsCategory);
//            return object;
//        }
//        else
//        {
//            Object object= ResponseUtil.fail();
//            return object;
//        }
//    };
//
//    @GetMapping("/categories/l1")
//    @ApiOperation(value="查看所有一级分类/l1")
//    public Object listOneLevelGoodsCategory()
//    {
//        List<GoodsCategory> goodsCategoryList=goodsCategoryService.findOneLevelGoodsCategoryList();
//        if(goodsCategoryList.size()!=0)
//        {
//            Object object = ResponseUtil.ok(goodsCategoryList);
//            return object;
//        }
//        else
//        {
//            Object object= ResponseUtil.fail();
//            return object;
//        }
//    };
//
//
//    /**
//     * 查询商品
//     *
//     * @param goodsSn
//     * @param name
////     * @param page
////     * @param limit
////     * @param sort
////     * @param order
//     * @return
//     */
//    @GetMapping("/goods")
//    @ApiOperation(value = "获取商品列表/list", notes = "获取商品列表")
//    public Object listGoods(String goodsSn, String name
////                            @RequestParam(defaultValue = "1") Integer page,
////                            @RequestParam(defaultValue = "10") Integer limit,
////                            @Sort @RequestParam(defaultValue = "add_time") String sort,
////                            @Order @RequestParam(defaultValue = "desc") String order
//    )
//    {
//        List<Goods> goods=goodsService.findGoodsList(goodsSn, name);
//        if(goods.size()!=0)
//        {
//            Object object = ResponseUtil.ok(goods);
//            return object;
//        }
//        else
//        {
//            Object object= ResponseUtil.fail();
//            return object;
//        }
//    };
//
//
//
//    /**
//     * 编辑商品
//     *
//     * @param goods
//     * @return
//     */
//    @PutMapping("/goods/{id}")
//    @ApiOperation(value = "根据id更新商品信息/update", notes = "根据id更新商品信息")
//    public Object updateGoodsById(@PathVariable Integer id,@RequestBody Goods goods)
//    {
//        goods.setId(id);
//        if(goodsService.updateGoods(goods)==1)
//        {
//            Object object = ResponseUtil.ok(goods);
//            return object;
//        }
//        else
//        {
//            Object object= ResponseUtil.fail();
//            return object;
//        }
//    };
//
//    /**
//     * 删除商品
//     *
//     * @param id
//     * @return
//     */
//    @DeleteMapping("/goods/{id}")
//    @ApiOperation(value = "根据id删除商品信息/delete", notes = "根据id删除商品信息")
//    public Object deleteGoodsById(@PathVariable Integer id)
//    {
//        Goods goods=goodsService.findGoodsById(id);
//        if(goodsService.deleteGoodsById(id)==1)
//        {
//            Object object = ResponseUtil.ok(goods);
//            return object;
//        }
//        else
//        {
//            Object object= ResponseUtil.fail();
//            return object;
//        }
//    };
//
//    /**
//     * 添加商品
//     *
//     * @param goods
//     * @return
//     */
//    @PostMapping("/goods")
//    @ApiOperation(value = "新建/上架一个商品/create", notes = "新建/上架一个商品")
//    public Object addGoods(@RequestBody Goods goods)
//    {
//        if(goodsService.addGoods(goods)==1)
//        {
//            Object object = ResponseUtil.ok(goods);
//            return object;
//        }
//        else
//        {
//            Object object= ResponseUtil.fail();
//            return object;
//        }
//    };
//
//    /**
//     * 商品详情
//     *
//     * @param id
//     * @return
//     */
//    @GetMapping("/goods/{id}")
//    @ApiOperation(value = "根据id获取某个商品/detail", notes = "根据id获取某个商品")
//    public Object getGoodsById(@NotNull Integer id)
//    {
//        Goods goods=goodsService.findGoodsById(id);
//        if(goods!=null)
//        {
//            Object object = ResponseUtil.ok(goods);
//            return object;
//        }
//        else
//        {
//            Object object= ResponseUtil.fail();
//            return object;
//        }
//    };
//
//    //--------------user
//    /**
//     * 品牌列表
//     *
//     * @param page 分页页数
//     * @param limit 分页大小
//     * @return 品牌列表
//     */
//    @GetMapping("/brands")
//    @ApiOperation(value="查看所有品牌 /list")
//    public Object listBrand(@RequestParam(defaultValue = "1") Integer page,
//                            @RequestParam(defaultValue = "10") Integer limit
////                            @Sort @RequestParam(defaultValue = "add_time") String sort,
////                            @Order @RequestParam(defaultValue = "desc") String order
//    )
//    {
//        List<Brand> brandList= brandService.findBrandList(page,limit);
//        return ResponseUtil.ok(brandList);
//    };
//
//    @GetMapping("/categories/l2")
//    @ApiOperation(value = "获取二级种类/getsecondgoodsCategory", notes = "获取二级种类")
//    public Object listSecondLevelGoodsCategory()
//    {
//        List<GoodsCategory> goodsCategoryList=goodsCategoryService.findSecondLevelGoodsCategoryList();
//        if(goodsCategoryList.size()!=0)
//        {
//            Object object = ResponseUtil.ok(goodsCategoryList);
//            return object;
//        }
//        else
//        {
//            Object object= ResponseUtil.fail();
//            return object;
//        }
//    };
//
//    /**
//     * 当前分类栏目
//     *
//     * @param id 分类类目ID
//     * @return 当前分类栏目
//     */
//    @GetMapping("categories/l1/{id}/l2")
//    @ApiOperation(value = "获取当前一级分类下的二级分类 /current", notes = "获取分类栏目")
//    public Object listSecondLevelGoodsCategoryById(@NotNull Integer id)
//    {
//        List<GoodsCategory> goodsCategoryList=goodsCategoryService.findSecondLevelGoodsCategoryListById(id);
//        if(goodsCategoryList.size()!=0)
//        {
//            Object object =ResponseUtil.ok(goodsCategoryList);
//            return object;
//        }
//        else
//        {
//            Object object= ResponseUtil.fail();
//            return object;
//        }
//    };
//
//    /**
//     * 商品详情
//     * <p>
//     * 用户可以不登录。
//     * 如果用户登录，则记录用户足迹以及返回用户收藏信息。
//     *
//     * @param userId 用户ID
//     * @param id     商品ID
//     * @return 商品详情
//     */
//    @GetMapping("/goods")
//    @ApiOperation(value = "获取商品信息列表/detail", notes = "获取商品信息列表")
//    public Object getGoodsById( Integer userId, @NotNull Integer id)
//    {
//        Goods goods=goodsService.findGoodsById(userId,id);
//        if(goods!=null)
//        {
//            Object object = ResponseUtil.ok(goods);
//            return object;
//        }
//        else
//        {
//            Object object= ResponseUtil.fail();
//            return object;
//        }
//    };
//
//
//
//    /**
//     * 根据条件搜素商品
//     * <p>
//     * 1. 这里的前五个参数都是可选的，甚至都是空
//     * 2. 用户是可选登录，如果登录，则记录用户的搜索关键字
//     *
//     * @param goodsCategoryId 分类类目ID，可选
//     * @param brandId    品牌商ID，可选
//     * @param keyword    关键字，可选
//     * @param isNew      是否新品，可选
//     * @param isHot      是否热买，可选
////     * @param userId     用户ID
////     * @param page       分页页数
////     * @param limit       分页大小
////     * @param sort       排序方式，支持"add_time", "retail_price"或"name"
////     * @param order      排序类型，顺序或者降序
//     * @return 根据条件搜素的商品详情
//     */
//    @GetMapping("/goods/searchinformation")
//    @ApiOperation(value = "根据条件搜素商品/list", notes = "根据条件搜素商品")
//    public Object listGoodsBySearchInfo(
//            Integer goodsCategoryId,
//            Integer brandId,
//            String keyword,
//            Boolean isNew,
//            Boolean isHot
////            @LoginUser Integer userId,
////            @RequestParam(defaultValue = "1") Integer page,
////            @RequestParam(defaultValue = "10") Integer limit,
////            @Sort(accepts = {"add_time", "retail_price", "name"}) @RequestParam(defaultValue = "add_time") String sort,
////            @Order @RequestParam(defaultValue = "desc") String order
//    )
//    {
//        List<Goods> goods=goodsService.findGoodsListBySearchInfo(goodsCategoryId, brandId,keyword,isNew,isHot);
//        if(goods.size()!=0)
//        {
//            Object object = ResponseUtil.ok(goods);
//            return object;
//        }
//        else
//        {
//            Object object= ResponseUtil.fail();
//            return object;
//        }
//    };
//
//
//
//    /**
//     * 商品详情页面“大家都在看”推荐商品
//     *
//     * @param id, 商品ID
//     * @return 商品详情页面推荐商品
//     */
//    @GetMapping("/recommendedGoods")
//    @ApiOperation(value = "查看推荐商品/related", notes = "查看推荐商品")
//    public Object getRecommendedGoods(@NotNull Integer id)
//    {
//        Goods goods=goodsService.findRecommendedGoods(id);
//        if(goods!=null)
//        {
//            Object object = ResponseUtil.ok(goods);
//            return object;
//        }
//        else
//        {
//            Object object= ResponseUtil.fail();
//            return object;
//        }
//    };
//
//    /**
//     * 在售的商品总数
//     *
//     * @return 在售的商品总数
//     */
//    @GetMapping("/goodsCounts")
//    @ApiOperation(value = "查看在售的商品总数/count", notes = "查看在售的商品总数")
//    public Object getGoodsCounts()
//    {
//        Integer count=goodsService.findGoodsCounts();
//        Object object = ResponseUtil.ok(count);
//        return object;
//    };
//
//}