package com.dyhc.sdglgroundconnection.service.impl;

import com.dyhc.sdglgroundconnection.mapper.TemplateHotelMapper;
import com.dyhc.sdglgroundconnection.mapper.TemplateMapper;
import com.dyhc.sdglgroundconnection.mapper.TemplateScenicspotMapper;
import com.dyhc.sdglgroundconnection.parameterentity.TemplateParameter;
import com.dyhc.sdglgroundconnection.pojo.Template;
import com.dyhc.sdglgroundconnection.pojo.TemplateHotel;
import com.dyhc.sdglgroundconnection.pojo.TemplateScenicspot;
import com.dyhc.sdglgroundconnection.service.TemplateService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.sql.Timestamp;
import java.util.*;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 模板业务实现
 **/
@Service
@Transactional
public class TemplateServiceImpl implements TemplateService {

    @Autowired
    private TemplateMapper templateMapper;

    @Autowired
    private TemplateScenicspotMapper templateScenicspotMapper;

    @Autowired
    private TemplateHotelMapper templateHotelMapper;

    /**
     * 查询模板信息   张枫
     * @param tempName  模板名称
     * @param userName  创建人名称
     * @param pageNo    当前页
     * @param pageSize  每页显示量
     * @return
     * @throws Exception
     */
    @Override
    public PageInfo<Template> listtemplate(String tempName, String userName, Integer pageNo, Integer pageSize) throws Exception {
        PageHelper.startPage(pageNo, pageSize);
        List<Template> listtemplate = templateMapper.listtemplate(tempName, userName);
        PageInfo<Template> pageInfo=new PageInfo<Template>(listtemplate);
        return pageInfo;
    }

    @Override
    public Template gettemplateByName(String templateName) throws Exception {
        return templateMapper.gettemplateByName(templateName);
    }

    @Override
    @Transactional()
    public int savetemplate(TemplateParameter template) throws Exception {
        try {
            Timestamp d = new Timestamp(System.currentTimeMillis());
            //模板对象
            Template tem=new Template();
            tem.setTemplateName(template.getTemplateName());
            tem.setTemplateContent(template.getTemplateContent());
            Template gettem=null;
            if(template.getMid()!=null&&template.getMid()!=0){
                tem.setTemplateId(template.getMid());
                tem.setModifier(1);
                tem.setModifiedData(d);
            }else{
                tem.setCreater(1);
                tem.setCreationDate(d);
                tem.setWhetherDel(0);
                templateMapper.insert(tem);
                 gettem=templateMapper.gettemplateByName(template.getTemplateName());
            }
            //模板酒店对象


            TemplateHotel temhotel=new TemplateHotel();
            if(template.getMid()!=null&&template.getMid()!=0){
                temhotel.setTemplateId(template.getMid());
                temhotel.setModifier(1);
                temhotel.setModifiedData(d);
            }else{
                temhotel.setTemplateId(gettem.getTemplateId());
                temhotel.setCreater(1);
                temhotel.setCreationDate(d);
                temhotel.setWhetherDel(0);
            }
            temhotel.setHotelId(template.getHotelId());
            temhotel.setCostPrice(template.getCostprice());
            temhotel.setOffer(template.getOffer());

            List<TemplateScenicspot> temlist=new ArrayList<TemplateScenicspot>();
            //模板景点对象
            if(template.getCostprice1()!=0){
                TemplateScenicspot temscenicspot=new TemplateScenicspot();
                temscenicspot.setScenicSpotId(template.getScenicSpotId1());
                temscenicspot.setCostPrice(template.getCostprice1());
                temscenicspot.setOffer(template.getOffer1());
                if(template.getMid()!=null&&template.getMid()!=0){
                    temscenicspot.setTemplateId(template.getMid());
                    temscenicspot.setModifier(1);
                    temscenicspot.setModifiedData(d);
                }else{
                    temscenicspot.setTemplateId(gettem.getTemplateId());
                    temscenicspot.setCreater(1);
                    temscenicspot.setCreationDate(d);
                    temscenicspot.setWhetherDel(0);
                }
                temlist.add(temscenicspot);
            }
            if(template.getCostprice2()!=0){
                TemplateScenicspot temscenicspot=new TemplateScenicspot();
                temscenicspot.setScenicSpotId(template.getScenicSpotId2());
                temscenicspot.setCostPrice(template.getCostprice2());
                temscenicspot.setOffer(template.getOffer2());
                if(template.getMid()!=null&&template.getMid()!=0){
                    temscenicspot.setTemplateId(template.getMid());
                    temscenicspot.setModifier(1);
                    temscenicspot.setModifiedData(d);
                }else{
                    temscenicspot.setTemplateId(gettem.getTemplateId());
                    temscenicspot.setCreater(1);
                    temscenicspot.setCreationDate(d);
                    temscenicspot.setWhetherDel(0);
                }
                temlist.add(temscenicspot);
            }
            if(template.getCostprice3()!=0){
                TemplateScenicspot temscenicspot=new TemplateScenicspot();
                temscenicspot.setScenicSpotId(template.getScenicSpotId3());
                temscenicspot.setCostPrice(template.getCostprice3());
                temscenicspot.setOffer(template.getOffer3());
                if(template.getMid()!=null&&template.getMid()!=0){
                    temscenicspot.setTemplateId(template.getMid());
                    temscenicspot.setModifier(1);
                    temscenicspot.setModifiedData(d);
                }else{
                    temscenicspot.setTemplateId(gettem.getTemplateId());
                    temscenicspot.setCreater(1);
                    temscenicspot.setCreationDate(d);
                    temscenicspot.setWhetherDel(0);
                }
                temlist.add(temscenicspot);
            }
            if(template.getCostprice4()!=0){
                TemplateScenicspot temscenicspot=new TemplateScenicspot();

                temscenicspot.setScenicSpotId(template.getScenicSpotId4());
                temscenicspot.setCostPrice(template.getCostprice4());
                temscenicspot.setOffer(template.getOffer5());
                if(template.getMid()!=null&&template.getMid()!=0){
                    temscenicspot.setTemplateId(template.getMid());
                    temscenicspot.setModifier(1);
                    temscenicspot.setModifiedData(d);
                }else{
                    temscenicspot.setTemplateId(gettem.getTemplateId());
                    temscenicspot.setCreater(1);
                    temscenicspot.setCreationDate(d);
                    temscenicspot.setWhetherDel(0);
                }
                temlist.add(temscenicspot);
            }
            if(template.getCostprice5()!=0){
                TemplateScenicspot temscenicspot=new TemplateScenicspot();
                temscenicspot.setScenicSpotId(template.getScenicSpotId5());
                temscenicspot.setCostPrice(template.getCostprice5());
                temscenicspot.setOffer(template.getOffer5());
                if(template.getMid()!=null&&template.getMid()!=0){
                    temscenicspot.setTemplateId(template.getMid());
                    temscenicspot.setModifier(1);
                    temscenicspot.setModifiedData(d);
                }else{
                    temscenicspot.setTemplateId(gettem.getTemplateId());
                    temscenicspot.setCreater(1);
                    temscenicspot.setCreationDate(d);
                    temscenicspot.setWhetherDel(0);
                }
                temlist.add(temscenicspot);
            }

            if(template.getMid()!=null&&template.getMid()!=0){
                System.out.println("..."+temhotel.getHotelId()+"...");
                templateMapper.updateByPrimaryKeySelective(tem);
                templateHotelMapper.updatetemhotel(temhotel);
                templateScenicspotMapper.removescenicspot(template.getMid());
                templateScenicspotMapper.insertList(temlist);
            }else{

                templateHotelMapper.insert(temhotel);
                templateScenicspotMapper.insertList(temlist);
            }
            return 1;
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<Template> selectTemplate() throws Exception {
        List<Template> list = templateMapper.selectTemplate();
        return list;
    }

    @Override
    public Template selectTemplateAll(int templateId)throws Exception {
        Template t = templateMapper.selectTemplateAll(templateId);
        t.setScenicspotsList(templateMapper.selectscenicSpotById(t.getTemplateId()));
        return t;
    }

    @Override
    public Template selecctNameById(int templateId)throws Exception {
        return templateMapper.selecctNameById(templateId);
    }
    /**
     * 根据模板信息表的主键id进行查询
     * @param tid   模板对象主键id
     * @return   返回符合条件的线路对象
     * @throws Exception  抛出异常
     */
    @Override
    public Map<String,Object> gettemplateById(Integer tid) throws Exception {
        Map<String,Object> map=new HashMap<String,Object>();
        //创建参数类对象
        TemplateParameter templateParameter=new TemplateParameter();
        //根据id查询线路模板对象
        Template template=templateMapper.selectByPrimaryKey(tid);
        //数据填充
        templateParameter.setTemplateName(template.getTemplateName());
        templateParameter.setTemplateContent(template.getTemplateContent());
        TemplateHotel hotelpm=new TemplateHotel();
        hotelpm.setTemplateId(tid);
        TemplateHotel temhotel=templateHotelMapper.gettemplatehotelbytemid(tid);
        templateParameter.setHotelId(temhotel.getHotelId());
        templateParameter.setCostprice(temhotel.getCostPrice());
        templateParameter.setOffer(temhotel.getOffer());
        List<TemplateScenicspot> temscenicspot=templateScenicspotMapper.listscenicspot(tid);
        map.put("parameter",templateParameter);
        map.put("scenicspot",temscenicspot);
        return map;
    }

    /**
     * 修改模板信息表中的数据
     * @param template  模板对象
     * @return
     * @throws Exception
     */
    @Override
    public int updatetemplate(Template template) throws Exception {
        return templateMapper.updateByPrimaryKeySelective(template);
    }

    /**
     * 删除线路模板信息
     * @param mid
     * @return
     * @throws Exception
     */
    @Override
    public int removetemplate(Integer mid) throws Exception {
        try {
            templateMapper.deleteByPrimaryKey(mid);
            templateHotelMapper.removehotel(mid);
            templateScenicspotMapper.removescenicspot(mid);
            return 1;
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<Template> listtemplateall()throws Exception {
        return templateMapper.selectAll();
    }

    /**
     * 查看路线
     * @param dispatchId
     * @return
     */
    @Override
    public Template listTemplate(Integer dispatchId)throws Exception {
        return templateMapper.listTemplate(dispatchId);
    }

}
