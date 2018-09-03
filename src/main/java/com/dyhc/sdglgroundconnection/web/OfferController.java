package com.dyhc.sdglgroundconnection.web;

import com.dyhc.sdglgroundconnection.pojo.*;
import com.dyhc.sdglgroundconnection.service.*;
import com.dyhc.sdglgroundconnection.utils.LogNotes;
import com.dyhc.sdglgroundconnection.utils.ReponseResult;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 报价酒店 控制层
 **/
@RestController
@RequestMapping("Offer")
public class OfferController {

    // 日志对象
    private Logger logger = LoggerFactory.getLogger(OfferController.class);

    @Autowired
    private OfferService offerService;
    @Autowired
    private OffercarService offercarService;
    @Autowired
    private OfferHotelService offerHotelService;
    @Autowired
    private OfferlineService offerlineService;
    @Autowired
    private OfferotherService offerotherService;
    @Autowired
    private OfferrestaurantService offerrestaurantService;
    @Autowired
    private OfferscenicService offerscenicService;
    @Autowired
    private TravelService travelService;
    @Autowired
    private TemplateService templateService;
    @Autowired
    private HotelService hotelService;
    @Autowired
    private DictionariesService dictionariesService;


    /**
     * 赵伟伟
     * 查询报价单
     * @param
     * @return
     */
    @RequestMapping("/selectOffer")
    public ReponseResult selectOffer(@RequestParam("page") Integer pageNo, @RequestParam("limit") Integer pageSize,String travelName) {
        try {
            PageInfo<Offer> pageInfo = offerService.selectOffer(pageNo,pageSize,travelName);
            ReponseResult<List> data = ReponseResult.ok(pageInfo.getList(), pageInfo.getTotal(), "分页获取报价单成功！");
            logger.info(" method:selectOffer  分页获取报价单成功！");
            return data;
        } catch (Exception e) {
            logger.error(" method:selectOffer  获取报价单数据失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }





    /**
     * 赵伟伟
     * 查询报价单
     * @param
     * @return
     */
    @RequestMapping("/showQuotation")
    public ReponseResult showQuotation(HttpServletRequest request) {
        try {
            HttpSession session = request.getSession();
            List allList = (List)session.getAttribute("allList");
            ReponseResult<Object> data = ReponseResult.ok(allList, "获取报价单成功！");
            logger.info(" method:selectOffer  获取报价单成功！");
            return data;
        } catch (Exception e) {
            logger.error(" method:selectOffer  获取报价单数据失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }





    /**
     * 赵伟伟
     * 获取报价信息
     * @param
     * @return
     */
    @RequestMapping("/quotation")
    public ReponseResult quotation(HttpServletRequest request) {


        try {
            HttpSession session = request.getSession();
            String zuid = request.getParameter("zuid");
            String number = request.getParameter("number");
            String travelStartTime = request.getParameter("travelStartTime");
            String travelEndTime = request.getParameter("travelEndTime");
            String jiage = request.getParameter("jiage");
            String wu = request.getParameter("wu");
            String ctypeId = request.getParameter("ctypeId");
            String remarks = request.getParameter("remarks");
            String[] tripList = request.getParameterValues("tripList");
            String xiaofei = request.getParameter("xiaofei");



            Dictionaries dictionaries = offercarService.selectOffercarById(Integer.parseInt(ctypeId));
            Travel travel = travelService.selectTravelById(Integer.parseInt(zuid));
            List allList = new ArrayList<>();
            allList.add(number);
            allList.add(travelStartTime);
            allList.add(travelEndTime);
            allList.add(jiage);
            allList.add(wu);
            allList.add(dictionaries);
            allList.add(travel);
            allList.add(remarks);
            allList.add(tripList);
            allList.add(xiaofei);
            session.setAttribute("allList",allList);
            ReponseResult<Object> data = ReponseResult.err("查询成功！");
            return data;
        }catch (Exception e){
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("查询失败！");
            return err;
        }
    }











    /**
     * 赵伟伟
     * 获取报价单信息
     * @param
     * @return
     */
    @RequestMapping("/Confirmation")
    public ReponseResult Confirmation(HttpServletRequest request) {


        try {
            HttpSession session = request.getSession();
            String[] tripList = request.getParameterValues("tripList");
            String[] xdateList = request.getParameterValues("xdateList");
            String[] xianluList = request.getParameterValues("xianluList");
            String[] wucList = request.getParameterValues("wucList");
            String[] wucbList = request.getParameterValues("wucbList");
            String[] wubjList = request.getParameterValues("wubjList");
            String[] wancList = request.getParameterValues("wancList");
            String[] wancbList = request.getParameterValues("wancbList");
            String[] wanbjList = request.getParameterValues("wanbjList");
            String[] jiudianList = request.getParameterValues("jiudianList");
            String jiedai = request.getParameter("jiedai");
            String zuId = request.getParameter("travelId");
            String travelStartTime = request.getParameter("travelStartTime");
            String travelEndTime = request.getParameter("travelEndTime");
            String number = request.getParameter("number");

            Travel travel = travelService.selectTravelById(Integer.parseInt(zuId));
            List<Hotel> hotelList = new ArrayList<>();
            List<Dictionaries> dicList1 = new ArrayList<>();
            List<Dictionaries> dicList2 = new ArrayList<>();
            List<Template> templatesList = new ArrayList<>();
            for (int i=0;i<jiudianList.length;i++){
                Integer hotelId = Integer.parseInt(jiudianList[i]);
                hotelList.add(hotelService.getHotelById(hotelId));
            }
            for (int i=0;i<wucList.length;i++){
                dicList1.add(dictionariesService.selectByDictionariesId(Integer.parseInt(wucList[i])));
            }
            for (int i=0;i<wancList.length;i++){
                dicList2.add(dictionariesService.selectByDictionariesId(Integer.parseInt(wancList[i])));
            }
            for (int i=0;i<xianluList.length;i++){
                templatesList.add(templateService.selecctNameById(Integer.parseInt(xianluList[i])));
            }
            List allList = new ArrayList<>();
            allList.add(tripList);
            allList.add(xdateList);
            allList.add(dicList1);
            allList.add(wucbList);
            allList.add(wubjList);
            allList.add(dicList2);
            allList.add(wancbList);
            allList.add(wanbjList);
            allList.add(jiedai);
            allList.add(hotelList);
            allList.add(templatesList);
            allList.add(travel);
            allList.add(travelStartTime);
            allList.add(travelEndTime);
            allList.add(number);
            session.setAttribute("allList",allList);
            ReponseResult<Object> data = ReponseResult.err("查询成功！");
            return data;
        }catch (Exception e){
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("查询失败！");
            return err;
        }
    }




    /**
     * 赵伟伟
     * @param
     * @return
     */
    @RequestMapping("/insertOffer")
    @LogNotes(operationType="报价单",content="新增")
    public ReponseResult insertOffer(HttpServletRequest request) {
        String[] tripList = request.getParameterValues("tripList");
        String[] xdateList = request.getParameterValues("xdateList");
        String[] xianluList = request.getParameterValues("xianluList");
        String[] wucList = request.getParameterValues("wucList");
        String[] wucbList = request.getParameterValues("wucbList");
        String[] wubjList = request.getParameterValues("wubjList");
        String[] wancList = request.getParameterValues("wancList");
        String[] wancbList = request.getParameterValues("wancbList");
        String[] wanbjList = request.getParameterValues("wanbjList");
        String[] jiudianList = request.getParameterValues("jiudianList");
        String[] jcostPrice = request.getParameterValues("jcostPrice");
        String[] joffer = request.getParameterValues("joffer");
        String[] jingdianList = request.getParameterValues("jingdianList");
        String[] jdcostPriceList = request.getParameterValues("jdcostPriceList");
        String[] jdofferList = request.getParameterValues("jdofferList");
        String travelId = request.getParameter("travelId");
        String number = request.getParameter("number");
        String remarks = request.getParameter("remarks");
        String travelStartTime = request.getParameter("travelStartTime");
        String travelEndTime = request.getParameter("travelEndTime");
        String qcostPrice = request.getParameter("qcostPrice");
        String qoffer = request.getParameter("qoffer");
        String ctypeId = request.getParameter("ctypeId");
        String ccostPrice = request.getParameter("ccostPrice");
        String coffer = request.getParameter("coffer");
        String des = request.getParameter("des");
        String jiedai = request.getParameter("jiedai");
        String xiaofei = request.getParameter("xiaofei");


        Offer offer = new Offer();
        Offercar offercar = new Offercar();
        Offerline offerline= new Offerline();
        OfferHotel offerHotel = new OfferHotel();
        Offerrestaurant offerrestaurant = new Offerrestaurant();
        Offerrestaurant offerrestaurant1 = new Offerrestaurant();
        Offerscenic offerscenic = new Offerscenic();
        Offerother offerother = new Offerother();
        Double zongjia = 0.0;
        Double zongjia1 = 0.0;
        try {



            for (int z=0;z<xdateList.length;z++){
                zongjia+=Double.parseDouble(wubjList[z]);
                zongjia+=Double.parseDouble(wanbjList[z]);
                zongjia+=Double.parseDouble(joffer[z]);

                zongjia1+=Double.parseDouble(wucbList[z]);
                zongjia1+=Double.parseDouble(wancbList[z]);
                zongjia1+=Double.parseDouble(jcostPrice[z]);

                String[] jd = jingdianList[z].split(",");
                String[] jdo = jdofferList[z].split(",");
                String[] jdc = jdcostPriceList[z].split(",");
                for (int j=0;j<jd.length;j++){
                    zongjia += Double.parseDouble(jdo[j]);
                    zongjia1 += Double.parseDouble(jdc[j]);
                }
            }


            //获取报价单
            Travel travel = travelService.selectTravelById(Integer.parseInt(travelId));
            //String str=travel.getTravelName().substring(0,travel.getTravelName().length()-3);
            Timestamp ts = new Timestamp(System.currentTimeMillis());
            offer.setTourist(travel.getTravelName());
            offer.setOffer(zongjia);
            offer.setCostPrice(zongjia1);
            offer.setTravelId(Integer.parseInt(travelId));
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = format1.parse(travelStartTime);
            SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String sdate=format2.format(date);
            Timestamp fTimestamp=Timestamp.valueOf(sdate);
            offer.setTravelStartTime(fTimestamp);
            SimpleDateFormat format3 = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date1 = format3.parse(travelEndTime);
            SimpleDateFormat format4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String sdate1=format4.format(date1);
            Timestamp fTimestamp1=Timestamp.valueOf(sdate1);
            offer.setTravelEndTime(fTimestamp1);
            offer.setNumber(Integer.parseInt(number));
            offer.setTrip(tripList[0]);
            offer.setRemarks(remarks);
            offer.setReception(jiedai);
            offer.setNotcontain(xiaofei);
            offerService.insertOffer(offer);







            for (int i=0;i<xdateList.length;i++){


                //线路报价
                offerline.setOfferId(offer.getOfferId());
                String mu="";

                boolean is = true;
                try {
                    Integer.parseInt(xianluList[i]);
                    is = false;
                } catch (NumberFormatException e) {
                    is = true;
                }

                if(is){
                    mu = xianluList[i];
                }else{
                    Template template = templateService.selecctNameById(Integer.parseInt(xianluList[i]));
                    mu = template.getTemplateName();
                }

                offerline.setLineArriveName(mu);
                offerline.setTravelContent(tripList[i]);
                java.util.Date date11 = format1.parse(xdateList[i]);
                offerline.setDate(date11);
                offerline.setHowmanydays(i+1);



                //酒店报价
                offerHotel.setHotelId(Integer.parseInt(jiudianList[i]));
                offerHotel.setOfferId(offer.getOfferId());
                offerHotel.setCostPrice(Double.parseDouble(jcostPrice[i]));
                offerHotel.setOffer(Double.parseDouble(joffer[i]));
                offerHotel.setHowmanydays(i+1);


                //午餐报价
                offerrestaurant.setOfferId(offer.getOfferId());
                offerrestaurant.setDictionariesId(Integer.parseInt(wucList[i]));
                offerrestaurant.setCostPrice(Double.parseDouble(wucbList[i]));
                offerrestaurant.setOffer(Double.parseDouble(wubjList[i]));
                SimpleDateFormat format5 = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date date2 = format5.parse(xdateList[i]);
                SimpleDateFormat format6 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String sdate2=format6.format(date2);
                Timestamp fTimestamp2=Timestamp.valueOf(sdate2);
                offerrestaurant.setDate(fTimestamp2);
                offerrestaurant.setHavemealsdate(2);
                offerrestaurant.setHowmanydays(i+1);



                //晚餐报价
                offerrestaurant1.setOfferId(offer.getOfferId());
                offerrestaurant1.setDictionariesId(Integer.parseInt(wancList[i]));
                offerrestaurant1.setCostPrice(Double.parseDouble(wancbList[i]));
                offerrestaurant1.setOffer(Double.parseDouble(wanbjList[i]));
                offerrestaurant1.setDate(fTimestamp2);
                offerrestaurant1.setHavemealsdate(3);
                offerrestaurant1.setHowmanydays(i+1);


                //景点
                String[] jdo = jdofferList[i].split(",");
                String[] jdc = jdcostPriceList[i].split(",");
                String[] jd = jingdianList[i].split(",");

                for (int j=0;j<jd.length;j++){
                    offerscenic.setScenicSpotId(Integer.parseInt(jd[j]));
                    offerscenic.setOfferId(offer.getOfferId());
                    offerscenic.setCostPrice(Double.parseDouble(jdc[j]));
                    offerscenic.setOffer(Double.parseDouble(jdo[j]));
                    offerscenic.setHowmanydays(i+1);
                    offerscenicService.insertOfferscenic(offerscenic);
                }



                offerHotelService.insertOfferHotel(offerHotel);
                offerlineService.insertOfferline(offerline);
                offerrestaurantService.insertOfferrestaurant(offerrestaurant);
                offerrestaurantService.insertOfferrestaurant(offerrestaurant1);
            }
            zongjia+=Double.parseDouble(qoffer);
            zongjia+=Double.parseDouble(coffer);


            //获取汽车报价
            offercar.setTypeId(Integer.parseInt(ctypeId));
            offercar.setCostPrice(Double.parseDouble(ccostPrice));
            offercar.setOffer(Double.parseDouble(coffer));
            offercar.setOfferId(offer.getOfferId());


            //其他报价
            offerother.setOfferId(offer.getOfferId());
            offerother.setCostPrice(Double.parseDouble(qcostPrice));
            offerother.setOffer(Double.parseDouble(qoffer));
            offerother.setRemarks(remarks);


            offercarService.insertOffercar(offercar);
            offerotherService.insertOfferother(offerother);
            ReponseResult<Object> data = ReponseResult.ok("新增报价单成功！");
            logger.info(" method:insertOffer  新增报价单成功！");
            return data;
        } catch (Exception e) {
            logger.error(" method:insertOffer  新增报价单数据失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }


    /**
     * 赵伟伟
     * 查询报价单
     * @param offerId
     * @return
     */
    @RequestMapping("/selectOfferByOfferId")
    public ReponseResult selectOfferByOfferId(@RequestParam("offerId") Integer offerId) {
        try {
            Offer offer = offerService.selectOfferByOfferId(offerId);
            ReponseResult<Object> data = ReponseResult.ok(offer, "获取报价单成功！");
            logger.info(" method:selectOfferByOfferId  获取报价单成功！");
            return data;
        } catch (Exception e) {
            logger.error(" method:selectOfferByOfferId  报价单数据失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }


    /**
     * 赵伟伟
     * 查询确认书
     * @param
     * @return
     */
    @RequestMapping("/showConfirmation")
    public ReponseResult showConfirmation(HttpServletRequest request) {
        try {
            HttpSession session = request.getSession();
            List allList = (List)session.getAttribute("allList");
            ReponseResult<Object> data = ReponseResult.ok(allList, "获取确认书成功！");
            logger.info(" method:selectOffer  获取确认书成功！");
            return data;
        } catch (Exception e) {
            logger.error(" method:selectOffer  获取确认书数据失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }

    /**
     * 赵伟伟
     * 确认成团
     * @param
     * @return
     */

    @RequestMapping("/que")
    @LogNotes(operationType="报价信息",content="修改")
    public ReponseResult que(Integer offerId) {
        try {
            int a = offerService.queren(offerId);
            ReponseResult<Object> data = ReponseResult.ok("确认成团成功！");
            logger.info(" method:selectOffer  确认成团成功！");
            return data;
        } catch (Exception e) {
            logger.error(" method:selectOffer  确认成团失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }
}
