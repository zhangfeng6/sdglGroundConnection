package com.dyhc.sdglgroundconnection.service.impl;

import com.dyhc.sdglgroundconnection.mapper.*;
import com.dyhc.sdglgroundconnection.parameterentity.DispatchParameter;
import com.dyhc.sdglgroundconnection.pojo.*;
import com.dyhc.sdglgroundconnection.pojo.Dispatch;
import com.dyhc.sdglgroundconnection.pojo.Dispatchhotel;
import com.dyhc.sdglgroundconnection.pojo.Travel;
import com.dyhc.sdglgroundconnection.pojo.Reportdetail;
import com.dyhc.sdglgroundconnection.pojo.Guideschedule;
import com.dyhc.sdglgroundconnection.service.DispatchService;
import com.dyhc.sdglgroundconnection.service.ReportdetailService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 调度业务实现
 **/
@Service
@Transactional
public class DispatchServiceImpl implements DispatchService {

    @Autowired
    private DispatchMapper dispatchMapper;

    //调度酒店表对象
    @Autowired
    private DispatchhotelMapper dispatchhotelMapper;

    @Autowired
    private  DispatchhotelServiceImpl dispatchhotelService;

    @Autowired
    private DictionariesMapper dictionariesMapper;

    @Autowired
    private TravelMapper travelMappere;

    @Autowired
    private TemplateMapper templateMapper;

    @Autowired
    private ScenicspotMapper scenicspotMapper;

    @Autowired
    private ShoppingMapper shoppingMapper;

    @Autowired
    private GuideMapper guideMapper;

    @Autowired
    private HotelMapper hotelMapper;

    @Autowired
    private RestaurantMapper restaurantMapper;

    @Autowired
    private CarrentalMapper carrentalMapper;

    @Autowired
    private GuidescheduleMapper guidescheduleMapper;

    @Autowired
    private ReportdetailService reportdetailService;

    //报价用车表对象
    @Autowired
    private OffercarMapper offercarMapper;

    //报价表
    @Autowired
    private OfferMapper offerMapper;
    //报价模板信息表
    @Autowired
    private OfferlineMapper offerlineMapper;
    //报价酒店信息表
    @Autowired
    private OfferHotelMapper offerHotelMapper;
    //报价餐厅信息表
    @Autowired
    private OfferrestaurantMapper offerrestaurantMapper;
    //报价其他表
    @Autowired
    private OfferotherMapper offerotherMapper;
    //报价景点表
    @Autowired
    private OfferscenicMapper offerscenicMapper;
    //车辆类型表
    @Autowired
    private VehicleTypeMapper vehicleTypeMapper;
    //餐厅类型表
    @Autowired
    private MealTypeMapper mealTypeMapper;
    //接团信息
    @Autowired
    private ClusterMapper clusterMapper;
    //调度导游表
    @Autowired
    private DisguideMapper disguideMapper;
    //调度用车表
    @Autowired
    private DiscarMapper discarMapper;
       //调度其他表
    @Autowired
    private DisotherMapper disotherMapper;
    //调度线路信息表
    @Autowired
    private HoteroomTypeMapper hoteroomTypeMapper;
    //调度景点表
    @Autowired
    private DisattrMapper disattrMapper;
    //调度购物表
    @Autowired
    private DisshoppMapper disshoppMapper;
    //调度餐厅表
    @Autowired
    private DisrestaurantMapper disrestaurantMapper;

    /**
     * 根据调度id获取调度的相关数据
     * @param dispatchId
     * @return
     * @throws Exception
     */
    @Override
    public Map<String, Object> getDispatchinfoById(Integer dispatchId) throws Exception {
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("dispatch",dispatchMapper.selectByPrimaryKey(dispatchId));
        map.put("disguide",disguideMapper.getDisguideByDid(dispatchId));
        map.put("cluster",clusterMapper.getClusterByDid(dispatchId));
        map.put("discar",discarMapper.getDiscarByDid(dispatchId));
        map.put("disother",disotherMapper.getDisotherByDid(dispatchId));
        map.put("dispatchhote",dispatchhotelMapper.listDispatchhotelByDid(dispatchId));
        map.put("hoteroomType",hoteroomTypeMapper.listHoteroomTypeByDid(dispatchId));
        map.put("disattr",disattrMapper.listDisattrByDid(dispatchId));
        map.put("disshopp",disshoppMapper.listDisshoppByDid(dispatchId));
        map.put("disrestaurant",disrestaurantMapper.listDisrestaurantByDid(dispatchId));
        return map;
    }

    @Override
    @Transactional
    public int updateDispatch(DispatchParameter dispatchParameter) throws Exception {
        Integer userId=1;
        try{
            //调度表对象
            Dispatch dispatch=dispatchParameter.getDispatch();
            //调度导游表对象
            Disguide disguide=dispatchParameter.getDisguide();
            //接团信息表对象
            Cluster cluster=dispatchParameter.getCluster();
            //调度用车表对象
            Discar discar=dispatchParameter.getDiscar();
            //调度其他表对象
            Disother disother=dispatchParameter.getDisother();
            //调度酒店表集合
            List<Dispatchhotel> dispatchhotelList=dispatchParameter.getDispatchhotelList();
            //调度线路信息集合
            List<HoteroomType> hoteroomTypeList=dispatchParameter.getHoteroomTypeList();
            //调度景点信息集合
            List<Disattr> disattrList=dispatchParameter.getDisattrList();
            //调度购物地集合
            List<Disshopp> disshoppList=dispatchParameter.getDisshoppList();
            //调度餐厅表集合
            List<Disrestaurant> disrestaurantList=dispatchParameter.getDisrestaurantList();
            dispatch.setModifier(userId);
            dispatch.setModifiedData(new Date());
            dispatchMapper.updateByPrimaryKeySelective(dispatch);
            disguide.setUpdateBy(userId);
            disguide.setUpdateDate(new Date());
            disguideMapper.updateByPrimaryKeySelective(disguide);
            cluster.setDispatchId(dispatch.getDispatchId());
            cluster.setUpdateBy(userId);
            cluster.setUpadateDate(new Date());
            clusterMapper.updateByPrimaryKeySelective(cluster);
            discar.setUpdateBy(userId);
            discar.setUpdateDate(new Date());
            discarMapper.updateByPrimaryKeySelective(discar);
            disother.setUpdateBy(userId);
            disother.setUpdateDate(new Date());
            disotherMapper.updateByPrimaryKeySelective(disother);
            for (Disattr d:disattrList) {
                d.setOfferId(dispatch.getDispatchId());
                d.setBuynum(dispatch.getNum());
                d.setStatus(0);
                d.setCreateBy(userId);
                d.setCreateDate(new Date());
            }
            disattrMapper.removeDisattrByDid(dispatch.getDispatchId());
            disattrMapper.insertList(disattrList);
            for (Dispatchhotel hotel:dispatchhotelList) {
                hotel.setModifier(userId);
                hotel.setModifiedData(new Date());
                dispatchhotelMapper.updateByPrimaryKeySelective(hotel);
            }
            for (HoteroomType h:hoteroomTypeList) {
                System.out.println("..."+h.getXingcheng());
                h.setUpdateBy(userId);
                h.setUpdateDate(new Date());
                hoteroomTypeMapper.updateByPrimaryKeySelective(h);
            }
            for (Disshopp s:disshoppList) {
                s.setUpDate(new Date());
                s.setUpdateBy(userId);
                disshoppMapper.updateByPrimaryKeySelective(s);
            }
            for (Disrestaurant r:disrestaurantList) {
                r.setUpDate(new Date());
                r.setUpdateBy(userId);
                disrestaurantMapper.updateByPrimaryKeySelective(r);
            }
            return 1;
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return 0;

        }
    }

    /**
     * 根据参数类的数据进行新增调度及调度相关信息
     * @param dispatchParameter
     * @return
     * @throws Exception
     */
    @Override
    @Transactional()
    public int saveDispatch(DispatchParameter dispatchParameter)throws Exception {
        try{
            //调度表对象
             Dispatch dispatch=dispatchParameter.getDispatch();
            //调度导游表对象
             Disguide disguide=dispatchParameter.getDisguide();
            //接团信息表对象
             Cluster cluster=dispatchParameter.getCluster();
            //调度用车表对象
             Discar discar=dispatchParameter.getDiscar();
            //调度其他表对象
             Disother disother=dispatchParameter.getDisother();
            //调度酒店表集合
             List<Dispatchhotel> dispatchhotelList=dispatchParameter.getDispatchhotelList();
            //调度线路信息集合
             List<HoteroomType> hoteroomTypeList=dispatchParameter.getHoteroomTypeList();
            //调度景点信息集合
             List<Disattr> disattrList=dispatchParameter.getDisattrList();
            //调度购物地集合
             List<Disshopp> disshoppList=dispatchParameter.getDisshoppList();
            //调度餐厅表集合
             List<Disrestaurant> disrestaurantList=dispatchParameter.getDisrestaurantList();
            Date date=new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            String Tuan="STS-"+sdf.format(date);
            dispatch.setGroundConnectionNumber(Tuan);
            dispatch.setState(1);
            dispatch.setWhetherDel(0);
            dispatch.setCreater(1);
            dispatch.setCreationDate(new Date());
            dispatchMapper.insert(dispatch);
            Dispatch infoId=dispatchMapper.getsavedispatchId();
            disguide.setOfferId(infoId.getDispatchId());
            disguide.setStatus(0);
            disguide.setCreateBy(1);
            disguide.setCreateDate(new Date());
            disguideMapper.insert(disguide);
            cluster.setDispatchId(infoId.getDispatchId());
            cluster.setWhetherDel(0);
            cluster.setCreateBy(1);
            cluster.setCreateDate(new Date());
            clusterMapper.insert(cluster);
            discar.setOfferId(infoId.getDispatchId());
            discar.setStatus(0);
            discar.setCreateBy(1);
            discar.setCreateDate(new Date());
            discarMapper.insert(discar);
            disother.setOfferId(infoId.getDispatchId());
            disother.setCreateBy(1);
            disother.setCreateDate(new Date());
            disother.setStatus(0);
            disotherMapper.insert(disother);

            for (Disattr d:disattrList) {
                d.setOfferId(infoId.getDispatchId());
                d.setBuynum(dispatch.getNum());
                d.setStatus(0);
                d.setCreateBy(1);
                d.setCreateDate(new Date());
            }
            disattrMapper.insertList(disattrList);
            for (Dispatchhotel hotel:dispatchhotelList) {
                hotel.setOfferId(infoId.getDispatchId());
                hotel.setWhetherDel(0);
                hotel.setCreater(1);
                hotel.setCreationDate(new Date());
            }
            dispatchhotelMapper.insertList(dispatchhotelList);
            for (HoteroomType h:hoteroomTypeList) {
                h.setOfferId(infoId.getDispatchId());
                h.setStatus(0);
                h.setCreateBy(1);
                h.setCreateDate(new Date());
            }
            hoteroomTypeMapper.insertList(hoteroomTypeList);
            for (Disshopp s:disshoppList) {
                s.setOfferId(infoId.getDispatchId());
                s.setStatus(0);
                s.setCreateBy(1);
                s.setCreateDate(new Date());
            }
            disshoppMapper.insertList(disshoppList);
            for (Disrestaurant r:disrestaurantList) {
                r.setOfferId(infoId.getDispatchId());
                r.setStatus(0);
                r.setCreateBy(1);
                r.setCreateDate(new Date());
            }
            disrestaurantMapper.insertList(disrestaurantList);
            Offer offer=new Offer();
            offer.setOfferId(dispatchParameter.getOfferId());
            offer.setWhetherDel(4);
            offerMapper.updateByPrimaryKeySelective(offer);
            return 1;
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return 0;
        }
    }
    /**
     * 根据报价表id获取该报价的所有信息到调度页面展示
     * @param oid
     * @return
     * @throws Exception
     */
    @Override
    public Map<String, Object> getofferinfoById(Integer oid) throws Exception {
        Map<String,Object> map=new HashMap<String,Object>();
        Offercar offercar=offercarMapper.selectOffercarByOfferId(oid);
        Dictionaries dictionaries=dictionariesMapper.selectByPrimaryKey(offercar.getDictionariesId());
        map.put("car",dictionaries.getValueId());
        map.put("offer",offerMapper.selectOfferByOfferId(oid));
        map.put("line",offerlineMapper.selectOfferlineByOfferId(oid));
        map.put("hotel",offerHotelMapper.selectOfferHotelByOfferId(oid));
        List<Offerrestaurant> offerrestaurant=offerrestaurantMapper.selectOfferRestaurantByOfferId(oid);
        List<Dictionaries> wan = new ArrayList<>();
        List<Dictionaries> wu = new ArrayList<>();
        for (Offerrestaurant offerrestaurant1: offerrestaurant) {
            Integer house = offerrestaurant1.getHavemealsdate();
            Dictionaries dictionaries1=dictionariesMapper.selectByPrimaryKey(offerrestaurant1.getDictionariesId());
            if (house==2){
                wu.add(dictionaries1);
            }
            if (house==3){
                wan.add(dictionaries1);
            }
        }
        map.put("wu",wu);
        map.put("wan",wan);
        map.put("other",offerotherMapper.selectOfferotherByOfferId(oid));
        map.put("scenic",offerscenicMapper.selectOfferscenicByOfferId(oid));
        return map;
    }

    /**
     * 根据条件查询调度信息 并分页返回
     * @param pageNo        当前页数
     * @param pageSize      每页显示量
     * @param djsth         地接社团号
     * @param dyname        导游名称
     * @param state         调度信息状态
     * @return
     * @throws Exception
     */
    @Override
    public PageInfo<Dispatch> listDispatch(Integer pageNo, Integer pageSize, String djsth, String dyname, Integer state) throws Exception {
        PageHelper.startPage(pageNo,pageSize);
        PageInfo<Dispatch> pageInfo=new PageInfo<Dispatch>(dispatchMapper.listdispatch(djsth, dyname, state));
        return pageInfo;
    }

    /**
     * 获取信息资源
     * @return
     * @throws Exception
     */
    @Override
    public Map<String, Object> getresource() throws Exception {
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("travel",travelMappere.listNoDelTravel());
        map.put("template",templateMapper.selectAll());
        map.put("scenicspot",scenicspotMapper.listNoDelScenicspot());
        map.put("shopping",shoppingMapper.listNoDelShopping());
        map.put("guide",guideMapper.listNoDelGuide());
        map.put("vehicle",dictionariesMapper.listdictionarieslBycode("VEHICLE"));
        map.put("traffic",dictionariesMapper.listdictionarieslBycode("TRAFFIC"));
        map.put("theroom",dictionariesMapper.listdictionarieslBycode("THEROOM"));
        map.put("diet",dictionariesMapper.listdictionarieslBycode("DIET"));
        return map;
    }

    @Override
    public List listinfoByvalueId(String type, Integer valueId) throws Exception {
        List list=null;
        if(type.equals("hoteltype")){
            list= hotelMapper.listhotelByvalueId(valueId);
        }else if(type.equals("fantype")){
            list=mealTypeMapper.listinfoByvalueId(valueId);
        }else if(type.equals("cartype")){
            list=vehicleTypeMapper.listinfoByvalueId(valueId);
        }
        return list;
    }

    /**
     * 调度表的信息：贾晓亮
     * @param dispatchId
     * @return
     */
    public  Dispatch dispatchSelectAll(Integer dispatchId)throws Exception{
        Dispatch dispatch=null;
        try {
            dispatch =dispatchMapper.dispatchSelectAll(dispatchId);
            Travel travel =travelMappere.selectTravelById(dispatch.getGroupNumber());
            String A ="";
            if (travel.getTravelName()==null){
                A="无组团名称";
                travel.setTravelName(A);
            }
            dispatch.setTravel(travel);
            List<Dispatchhotel> dispatchhotels =dispatchhotelService.dispatchhotelSelectAll(dispatchId);
            /* dispatchhotelMapper.dispatchhotelSelectAll(dispatchId);*/
            dispatch.setDispatchhotel(dispatchhotels);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dispatch;
    }

    @Override
    public Dispatch getDispatchByguideId(Integer guideId)throws Exception {
        return dispatchMapper.getDispatchByguideId(guideId);
    }

    /**
     * 分页查看调度信息
     * @param pageNo
     * @param pageSize
     * @param guideName
     * @param groundConnectionNumber
     * @return
     */
    @Override
    public PageInfo<Dispatch> ListDispatchLike(Integer pageNo, Integer pageSize, String guideName, String groundConnectionNumber)throws Exception {
        PageHelper.startPage(pageNo,pageSize,true);
        PageInfo<Dispatch> dispatch=new PageInfo<>(dispatchMapper.getDispatchLike(guideName,groundConnectionNumber));
        return dispatch;
    }

    @Override
    @Transactional()
    public int updatestateById(Integer did, Integer gid, String travelStartTime, String travelEndTime) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date begin=sdf.parse(travelStartTime);
        Date end=sdf.parse(travelEndTime);
        try {
            List<Date> list=getBetweenDates(begin,end);
            for (Date day:list) {
                String date=sdf.format(day);
                String[] array=date.split("-");
                Guideschedule guideschedule=new Guideschedule();
                guideschedule.setGuideId(gid);
                guideschedule.setArrangetype(2);
                guideschedule.setWhetherDel(0);
                guideschedule.setCreateBy(1);
                guideschedule.setCreateDate(new Date());
                guideschedule.setArrangeyear(array[0]);
                guideschedule.setArrangemonth(array[1]);
                guideschedule.setArrangeday(array[2]);
                guidescheduleMapper.insert(guideschedule);
            }
            dispatchMapper.updateDispatchstate(did);
            return 1;
        }catch(Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 获取两个日期之间的所有日期（yyyy-MM-dd）
     * @Description TODO
     * @param begin
     * @param end
     * @return
     */
    public List<Date> getBetweenDates(Date begin, Date end)throws Exception {
        List<Date> result = new ArrayList<Date>();
        Calendar tempStart = Calendar.getInstance();
        tempStart.setTime(begin);
        while(begin.getTime()<=end.getTime()){
            result.add(tempStart.getTime());
            tempStart.add(Calendar.DAY_OF_YEAR, 1);
            begin = tempStart.getTime();
        }
        return result;
    }

    @Override
    public Dispatch getDispatchById(Integer reportDetailId) throws Exception {
        Reportdetail reportdetail=reportdetailService.getReportdetailById(reportDetailId);
        return dispatchMapper.selectByPrimaryKey(reportdetail.getDispatchId());
    }


     /**
     * 查看车辆联系人
     * @param dispatchId
     * @return
     */
    @Override
    public  Dispatch dispatch(Integer dispatchId)throws Exception {
        return dispatchMapper.dispatch(dispatchId);
    }

    public Dispatch listDispatch(Integer dispatchId)throws Exception {
        return dispatchMapper.listDispatch(dispatchId);
    }

    /**
     * 接团信息
     * @param dispatchId
     * @return
     */
    @Override
    public Cluster ClusterById(Integer dispatchId)throws Exception  {
        return clusterMapper.ClusterById(dispatchId);
    }

}
