package com.example.mall.controller;

import com.example.mall.entity.ProductComments;
import com.example.mall.service.ProductCommentsService;
import com.example.mall.service.ProductService;
import com.example.mall.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/product")
@Api(value = "提供商品信息相关的接口",tags = "商品管理")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductCommentsService productCommontsService;

    @ApiOperation("商品基本信息查询接口")
    @GetMapping("/detail-info/{pid}")
    public ResultVO getProductBasicInfo(@PathVariable("pid") String pid){
        return productService.getProductBasicInfo(pid);
}

    @GetMapping("/imgs/{pid}")
    public ResultVO getProductImgs(@PathVariable("pid") String pid){
        return productService.getProductImgById(pid);
    }

    @ApiOperation("商品参数信息查询接口")
    @GetMapping("/detail-params/{pid}")
    public ResultVO getProductParams(@PathVariable("pid") String pid){
        return productService.getProductParamsById(pid);
    }

    @ApiOperation("商品评论信息查询接口")
    @GetMapping("/detail-comments/{pid}")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "int",name = "pageNum", value = "当前页码",required = true),
            @ApiImplicitParam(dataType = "int",name = "limit", value = "每页显示条数",required = true)
    })
    public ResultVO getProductComments(@PathVariable("pid") String pid,int pageNum,int limit){
        return productCommontsService.listCommentsByProductId(pid,pageNum,limit);
    }

    @PostMapping("/addcomment")
    public ResultVO addProductComment(@RequestBody ProductComments productComments){
        if(productComments.getCommId()==null){
            productComments.setCommId(String.valueOf(System.currentTimeMillis()));
        }
        return productCommontsService.insertProductComment(productComments);
    }

    @ApiOperation("商品评价统计查询接口")
    @GetMapping("/detail-commentscount/{pid}")
    public ResultVO getProductCommontsCount(@PathVariable("pid") String pid){
        return productCommontsService.getCommentsCountByProductId(pid);
    }

    @ApiOperation("根据类别查询商品接口")
    @GetMapping("/listbycid/{cid}")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "int",name = "pageNum", value = "当前页码",required = true),
            @ApiImplicitParam(dataType = "int",name = "limit", value = "每页显示条数",required = true)
    })
    public ResultVO getProductsByCategoryId(@PathVariable("cid") int cid,int pageNum,int limit){
        return productService.getProductsByCategoryId(cid,pageNum,limit);
    }

    @ApiOperation("根据类别查询商品品牌接口")
    @GetMapping("/listbrands/{cid}")
    public ResultVO getBrandsByCategoryId(@PathVariable("cid") int cid){
        return productService.listBrands(cid);
    }

    @ApiOperation("根据关键字查询商品接口")
    @GetMapping("/listbykeyword")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "string",name = "keyword", value = "搜索关键字",required = true),
            @ApiImplicitParam(dataType = "int",name = "pageNum", value = "当前页码",required = true),
            @ApiImplicitParam(dataType = "int",name = "limit", value = "每页显示条数",required = true)
    })
    public ResultVO searchProducts(String keyword,int pageNum,int limit){
        return productService.searchProduct(keyword,pageNum,limit);
    }

    @ApiOperation("根据关键字查询商品品牌接口")
    @GetMapping("/listbrands-keyword")
    @ApiImplicitParam(dataType = "string",name = "keyword", value = "搜索关键字",required = true)
    public ResultVO getBrandsByKeyword(String keyword){
        return productService.listBrands(keyword);
    }

}

