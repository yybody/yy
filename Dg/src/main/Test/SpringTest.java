import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.yy.DAO.GoodsMapper;
import com.yy.DAO.Menu2Mapper;
import com.yy.DAO.UsersMapper;
import com.yy.POJO.*;
import com.yy.Service.payService;
import com.yy.Util.jsonUtil;
import com.yy.ex.payEx;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author 袁毅
 * @date 2018/11/14 0014-下午 2:44
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:Static/applicationContext.xml"})
public class SpringTest {
    @Autowired
    SqlSessionTemplate sessionTemplate;
    String password = null;

    @Test
    public void tist() {
        String name = "MD5";
        Object object1 = "123456";
        //盐子
        Object salt = ByteSource.Util.bytes("admin");
        //加密次数
        int a = 1024;
        Object result = new SimpleHash(name, object1, salt, a);
        password = result.toString();
        System.out.println(password);
    }
 @Test
      public void test01(){
          GoodsMapper goodsMapper = sessionTemplate.getMapper(GoodsMapper.class);
          for (int i=1;i<=100;i++){

              goodsMapper.insertSelective(new Goods(null,"经典铜锣烧"+i,11,Float.parseFloat("23.00"),"盒",Float.parseFloat("1.00"),"在本商场直接购买，运费为一件商品1元，若在附近商家购买按每公里1元","中国",100,"中国制造","../images/dan3.jpg",1,null));
          }

      }

   /*   @Test
      public  void  test02(){
         User user = userMapper.selectByName("admin");
          System.out.println(user.getPassword());
      }
    @Autowired
    UsersMapper usersMapper;
*/

    @Test
    public void test02() {
        /*Menu1 menu1 = new Menu1(1);
        Gson s = new Gson();
        String json = s.toJson(Shopcar.getShopCar());
        System.out.println(s.fromJson("",new ArrayList<BuyerItem>().getClass()));
        //Shopcar.getShopCar() = s.fromJson("",new ArrayList<BuyerItem>().getClass());b*/


        Gson g = new Gson();

        BuyerItem buyerItem = new BuyerItem();
        buyerItem.setAmount(10);
        buyerItem.setGoods(new Goods(1, "aa", Float.parseFloat("45"), Float.parseFloat("45")));
        Shopcar s = new Shopcar();
        Shopcar.addCar(buyerItem);
        Shopcar.addCar(buyerItem);
        String json = g.toJson(Shopcar.getShopCar());
        System.out.println(json + "=====json");
        List<BuyerItem> b = g.fromJson(json, new ArrayList<BuyerItem>().getClass());
        for (BuyerItem o : b) {
            System.out.println(o.getAmount());
        }
        System.out.println(b.getClass() + "=========B");
    }


    @Test
    public void test03() {
        //   Gson g = new Gson();
        Goods goods = new Goods(1, "aa", Float.parseFloat("45"), Float.parseFloat("45"));
        BuyerItem buyerItem = new BuyerItem();
        buyerItem.setAmount(10);
        buyerItem.setGoods(new Goods(1, "aa", Float.parseFloat("45"), Float.parseFloat("45")));
        Shopcar s1 = new Shopcar();
        Shopcar.addCar(buyerItem);
        Shopcar.addCar(buyerItem);
        List<BuyerItem> list = new ArrayList<>();
        list = Shopcar.getShopCar();

        JSONArray j1 = JSONArray.fromObject(list);
       /* String str = j1.toString();
        System.out.println("我的"+JSONArray.fromObject(str));
        BuyerItem[] buyerItems = (BuyerItem[]) JSONArray.toArray(j1,BuyerItem.class);
        for (BuyerItem b :buyerItems
                ){System.out.println(b.getAmount());}*/
        //jsonUtil.jsons(j1);


        JSONObject j = JSONObject.fromObject(goods);
        System.out.println(j.get("gid"));
        String s = j.toString();
        Goods goods1 = (Goods) JSONObject.toBean(j, Goods.class);
        System.out.println(goods1.getGname());


    }

    @Test
    public void test04() {


        BuyerItem buyerItem = new BuyerItem();
        buyerItem.setAmount(10);
        buyerItem.setGoods(new Goods(1, "aa", Float.parseFloat("45"), Float.parseFloat("45")));
        BuyerItem buyerItem3 = new BuyerItem();
        buyerItem.setAmount(10);
        buyerItem.setGoods(new Goods(1, "aa", Float.parseFloat("45"), Float.parseFloat("45")));
        BuyerItem buyerItem2 = new BuyerItem();
        buyerItem.setAmount(10);
        buyerItem.setGoods(new Goods(1, "a", Float.parseFloat("45"), Float.parseFloat("45")));
        List<BuyerItem> list = new ArrayList<>();
        list.add(buyerItem);
        list.add(buyerItem2);
        System.out.println(list.contains(buyerItem));

    }

    @Autowired
    Menu2Mapper menu2Mapper;


    @Autowired
    GoodsMapper goodsMapper;

    @Test
    public void test05() {

        List<Menu2> list = menu2Mapper.selectByPrimaryKey2(1);
        List<Goods> goodsList = new ArrayList<>();

        for (Menu2 m : list) {
            //设置条件类
            GoodsExample g = new GoodsExample();
            GoodsExample.Criteria criteria = g.createCriteria();
            criteria.andM2idEqualTo(m.getM2id());
            //按条件查询的商品
            goodsList.addAll(goodsMapper.selectByExample(g));


        }
        for (Goods g : goodsList) {
            System.out.println(g.getM2id());
        }


    }
    @Autowired
    payService payService;


    @Test
    public void a(){

goodsMapper.selectByPrimaryKey(1);

    }
}
