package com.lambert.dalgen.mybatis.repository;

import com.lambert.config.DalgenProperties;
import com.lambert.dalgen.mybatis.enums.MultiplicityEnum;
import com.lambert.dalgen.mybatis.enums.ParamTypeEnum;
import com.lambert.dalgen.mybatis.enums.TypeMapEnum;
import com.lambert.dalgen.mybatis.model.config.CfColumn;
import com.lambert.dalgen.mybatis.model.config.CfOperation;
import com.lambert.dalgen.mybatis.model.config.CfTable;
import com.lambert.dalgen.mybatis.model.java.*;
import com.lambert.dalgen.mybatis.model.java.domapper.DOMapperMethod;
import com.lambert.dalgen.mybatis.model.java.domapper.DOMapperMethodParam;
import com.lambert.dalgen.utils.ConfigUtil;
import com.lambert.dalgen.utils.StringDalUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lambert
 * @version $Id: XmlMapperRepository.java, v 0.1 2019年05月25日 5:52 PM lambert Exp $
 */
public class XmlMapperRepository {

    private static final String RESULT_MANY       = "List<{0}>";

    public XmlMapper gain(CfTable cfTable){
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.setCfTable(cfTable);
        //`1
        preDo(xmlMapper,cfTable);

        Map<String, ResultMap> resultMaps = new HashMap<String, ResultMap>();
        preDOMapper(xmlMapper,cfTable);

        return xmlMapper;
    }

    private void preDo(XmlMapper xmlMapper,CfTable cfTable){
        DO doClass = new DO();
        doClass.setClassName(cfTable.getJavaName() + "DO");
        doClass.setPackageName(DalgenProperties.getDOPackageName());

        doClass.setClassPath(DalgenProperties.getDODirectory());

        doClass.setDesc(cfTable.getRemark());

        for (CfColumn column : cfTable.getColumns()) {
            //提出不需要在DO中出现的字段
            Filelds filelds = new Filelds();
            filelds.setName(column.getJavaName());
            filelds.setDesc(column.getRemark());
            filelds.setJavaType(getClassAndImport(doClass, column.getJavaType()));
            doClass.addFields(filelds);
        }
        xmlMapper.setDoClass(doClass);
    }

    private void preDOMapper(XmlMapper xmlMapper,CfTable cfTable){

        DO doClass = xmlMapper.getDoClass();

        DOMapper doMapper = new DOMapper();
        doMapper.setClassName(doClass.getClassName() + "Mapper");
        doMapper.setPackageName(DalgenProperties.getDOMapperPackageName());
        doMapper.setClassPath(DalgenProperties.getDOMapperDirectory());
        doMapper.setDesc(cfTable.getRemark());
        doMapper.setTableName(cfTable.getSqlname());

        Map<String, String> columnTypeMap = new HashMap<String, String>();
        Map<String, String> columnDescMap = new HashMap<String, String>();

        //
        for (CfColumn column : cfTable.getColumns()) {
            columnTypeMap.put(column.getJavaName(), column.getJavaType());
            columnDescMap.put(column.getJavaName(), column.getRemark());
        }

        //配置方法
        for (CfOperation operation : cfTable.getOperations()) {
            //if (operation.getMultiplicity() == MultiplicityEnum.paging) {//分页
            //     prePagingMethod(cfTable, doClass, doMapper, columnTypeMap,
            //            columnDescMap, operation);
            //} else {
            //    preMethod(doClass, doMapper, operation, columnTypeMap);
            //}
            preMethod(doClass, doMapper, operation, columnTypeMap);
        }



        xmlMapper.setDoMapper(doMapper);
    }
    private void prePagingMethod(CfTable cfTable, DO doClass,
                                 DOMapper doMapper,
                                 Map<String, String> columnTypeMap,
                                 Map<String, String> columnDescMap, CfOperation operation) {

        DOMapperMethod pagingResultMethod = new DOMapperMethod();

        //方法名
        pagingResultMethod.setName(operation.getName() + "Result");

        pagingResultMethod.setPagingName(operation.getName());
        //描述
        pagingResultMethod.setDesc(operation.getRemark());
        pagingResultMethod.setSql(operation.getSqlDesc());
        //是否为分页
        pagingResultMethod.setPagingFlag("true");

//        Paging paging = new Paging();
//        paging.setClassName(StringDalUtil.upperFirst(operation.getPaging()) + "Page");
//        paging.setPackageName("paging");
//        paging.setClassPath("paging");
//        paging.setBasePackageName("paging");
//        paging.setBaseClassPath("paging");
//        getClassAndImport(paging, paging.getBasePackageName() + ".BasePage");
//        paging.setDesc(StringDalUtil.join(cfTable.getSqlname(), cfTable.getRemark()));
//        paging.setTableName(cfTable.getSqlname());
//
//        String pagingResultType = operationResultType(doClass, paging, operation);
//
//        paging.setResultType(pagingResultType);
//        List<DOMapperMethodParam> params = preMethodParams(paging, operation, columnTypeMap);
//        for (DOMapperMethodParam param : params) {
//            Filelds filelds = new Filelds();
//            filelds.setName(param.getParam());
//            filelds.setJavaType(param.getParamType());
//            filelds.setDesc(columnDescMap.get(param.getParam()));
//            paging.addFields(filelds);
//        }

        /*******************************************/
        //paging import到doMapper
        //getClassAndImport(doMapper, paging.getPackageName() + "." + paging.getClassName());
        //添加返回集合对象引用
        getClassAndImport(doMapper, "java.util.List");
        //方法返回结果

        //DOMapperMethodParam pagingParam = new DOMapperMethodParam(StringDalUtil.lowerFirst(operation.getPaging()));
        //pagingResultMethod.addParam(pagingParam);


        //设置参数
        pagingResultMethod.addParam(new DOMapperMethodParam(
                getClassAndImport(doMapper,doClass.getPackageName() + "." + doClass.getClassName())
                , "entity"));
        //返回类型
        String resultType = operationResultType(doClass, doMapper, operation);

        //设置返回类型
        pagingResultMethod.setReturnClass("List<" + resultType + ">");

        //设置查询总条数方法
        try {
            DOMapperMethod pagingCountMethod = (DOMapperMethod) BeanUtils.cloneBean(pagingResultMethod);
            pagingCountMethod.setName(operation.getName() + "Count");
            pagingCountMethod.setReturnClass("int");
            doMapper.addMothed(pagingCountMethod);
        } catch (Exception e) {
            //LOG.error("", e);
        }

        doMapper.addMothed(pagingResultMethod);

    }

    private void preMethod(DO doClass, DOMapper doMapper,
                           CfOperation operation, Map<String, String> columnMap) {

        DOMapperMethod method = new DOMapperMethod();
        method.setName(operation.getName());
        method.setDesc(operation.getRemark());
        method.setSql(operation.getSqlDesc());
        preMethodParam(doClass, doMapper, operation, method, columnMap);
        String resultType = operationResultType(doClass, doMapper, operation);
        method.setReturnClass(resultType);
        doMapper.addMothed(method);

    }

    private void preMethodParam(DO doClass, Base doMapper, CfOperation operation,
                                DOMapperMethod method, Map<String, String> columnMap) {

        if (operation.getParamType() == ParamTypeEnum.object) {
            method.addParam(new DOMapperMethodParam(
                    getClassAndImport(doMapper,
                    doClass.getPackageName() + "." + doClass.getClassName()), "entity"));
        } else {
            method.setParams(preMethodParams(doMapper, operation, columnMap));
        }
    }

    private List<DOMapperMethodParam> preMethodParams(Base doMapper, CfOperation operation,
                                                      Map<String, String> columnMap) {
        List<DOMapperMethodParam> params = new ArrayList<DOMapperMethodParam>();

        if (operation.getParamType() == ParamTypeEnum.extra) {

            for (Map.Entry pm : operation.getExtraParams().entrySet()) {
                String pmName = (String) pm.getKey();
                String pmType = (String) pm.getValue();

                DOMapperMethodParam methodParam = new DOMapperMethodParam(getClassAndImport(doMapper,pmType), pmName);


                params.add(methodParam);
            }

        }else{
            for (Map.Entry pm : operation.getPrimitiveParams().entrySet()) {
                String pmName = (String) pm.getKey();
                String pmType = (String) pm.getValue();
                //如果是DO中的属性 则不需要在处理
                String columnType = columnMap.get(pmName);

                TypeMapEnum typeMapEnum = TypeMapEnum.getByJdbcTypeWithOther(pmType);

                String paramValType = StringUtils.isBlank(columnType) ? (typeMapEnum == TypeMapEnum.OTHER ? pmType
                        : typeMapEnum.getJavaType())
                        : columnType;

                String custJavaType = ConfigUtil.getConfig().getTypeMap().get(paramValType);

                String paramType = getClassAndImport(doMapper, custJavaType == null ? paramValType
                        : custJavaType);

                String foreachName = operation.getPrimitiveForeachParams().get(pmName);
                DOMapperMethodParam methodParam;
                if (StringUtils.isBlank(foreachName)) {
                    methodParam = new DOMapperMethodParam(paramType, pmName);
                } else {
                    getClassAndImport(doMapper, "java.util.List");
                    methodParam = new DOMapperMethodParam("List<" + paramType + ">", foreachName);
                }
                params.add(methodParam);
            }
        }

        return params;
    }

    private String operationResultType(DO doClass, Base base, CfOperation operation) {

        if (StringUtils.startsWithIgnoreCase(operation.getName(), "insert")
                || StringUtils.startsWithIgnoreCase(operation.getName(), "update")
                || StringUtils.startsWithIgnoreCase(operation.getName(), "delete")) {
            return "Long";
        }
        //返回类不为null
        String resultType;
        if (!StringUtils.isBlank(operation.getResultType())) {
            resultType = getClassAndImport(base, operation.getResultType());
        }  else {
            resultType = getClassAndImport(base,
                    doClass.getPackageName() + "." + doClass.getClassName());
        }

        //返回一行
        if (MultiplicityEnum.many == operation.getMultiplicity()) {
            base.addImport("java.util.List");
            return MessageFormat.format(RESULT_MANY, resultType);
        }
        return resultType;
    }

    /**
     * 获取类，并添加引用
     * @param base
     * @param classType
     * @return
     */
    private String getClassAndImport(Base base, String classType) {
        Validate.notEmpty(classType,
                "DalgenLoader.getClassAndImport error classType 不能为 null Base=" + base);
        int lastIdx = StringUtils.lastIndexOf(classType, ".");
        if (lastIdx > 0) {
            base.addImport(classType);
        }
        //返回方法
        return StringUtils.substring(classType, lastIdx + 1);
    }
}
