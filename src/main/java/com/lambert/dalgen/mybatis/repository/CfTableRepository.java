package com.lambert.dalgen.mybatis.repository;

import com.lambert.dalgen.mybatis.enums.MultiplicityEnum;
import com.lambert.dalgen.mybatis.enums.ParamTypeEnum;
import com.lambert.dalgen.mybatis.model.config.CfColumn;
import com.lambert.dalgen.mybatis.model.config.CfOperation;
import com.lambert.dalgen.mybatis.model.config.CfTable;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lambert
 * @version $Id: CfTableRepository.java, v 0.1 2019年05月25日 4:57 PM lambert Exp $
 */
public class CfTableRepository {

    private static final Pattern STAR_BRACKET            = Pattern.compile("\\((\\s*\\*\\s*)\\)");
    private static final Pattern PARAM_PATTERN           = Pattern.compile("#\\{(.*?)\\}");

    public CfTable gainCfTable() throws DocumentException {

        File tableFile = new File("uums-sys-app.xml");


        SAXReader saxReader = new SAXReader();
        saxReader.setEntityResolver(new IgnoreDTDEntityResolver()); // ignore dtd
        Document document = saxReader.read(tableFile);
        Element table = document.getRootElement();

        CfTable cfTable = new CfTable();
        cfTable.setSqlname(attr(table, "sqlname"));
        cfTable.setPhysicalName(attr(table, "physicalName"));
        cfTable.setRemark(attr(table, "remark"));
        cfTable.setSequence(attr(table, "sequence"));
        cfTable.setJavaName(attr(table, "javaName"));

        fillColumns(cfTable,table);

        fillOperation(cfTable,table);

        return cfTable;
    }

    private void fillOperation(CfTable cfTable, Element table) {
        List<Element> elements = table.elements("operation");
        for (Element e : elements) {
            CfOperation cfOperation = new CfOperation();

            cfOperation.setRemark(attr(e, "remark"));
            cfOperation.setName(attr(e, "name"));
            cfOperation.setMultiplicity(MultiplicityEnum.getByCode(attr(e, "multiplicity")));
            cfOperation.setPaging(attr(e, "paging"));

            if (cfOperation.getMultiplicity() == MultiplicityEnum.paging) {
                Validate.notEmpty(cfOperation.getPaging(), "需要设置paging,用来生成分页类");
            }
            cfOperation.setParamType(ParamTypeEnum.getByCode(attr(e, "paramType")));
            cfOperation.setResultMap(attr(e, "resultmap"));
            cfOperation.setResultType(attr(e, "resulttype"));



            setCfOperationCdata(cfTable, e, cfOperation);
            fillOperationParams(e, cfOperation);
            cfTable.addOperation(cfOperation);
        }

    }

    private void setCfOperationCdata(CfTable cfTable, Element e, CfOperation cfOperation) {
        String cXml = e.asXML();
        String[] lines = StringUtils.split(cXml, "\n");
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < lines.length - 1; i++) {
            if (i > 1) {
                sb.append("\n");
            }
            sb.append(lines[i]);
        }

        String cdata = sb.toString();

        String text = e.getTextTrim();
        if (StringUtils.indexOf(text, "*") > 0) {
            Matcher m = STAR_BRACKET.matcher(text);
            if (!m.find()) {
                cdata = StringUtils.replace(cdata, "*", "<include refid=\"Base_Column_List\" />");
            }
        }

        cfOperation.setCdata(cdata);
    }
    private void fillOperationParams(Element e, CfOperation cfOperation) {
        if (cfOperation.getParamType() != ParamTypeEnum.primitive) {
            return;
        }

        //取出foreach 用来判断是否有List参数
        List<Element> items = e.elements();

        if (CollectionUtils.isNotEmpty(items)) {
            for (Element item : items) {
                List<Element> ies = item.elements();
                if (CollectionUtils.isNotEmpty(ies)) {
                    for (Element ie : ies) {
                        if (StringUtils.endsWithIgnoreCase(ie.getName(), "foreach")) {
                            String collName = ie.attributeValue("collection");
                            String itemName = ie.attributeValue("item");
                            Validate.notEmpty(collName,
                                    "foreach 元素设置错误 table=" + cfOperation.getName());
                            Validate.notEmpty(itemName,
                                    "foreach 元素设置错误 table=" + cfOperation.getName());
                            cfOperation.addPrimitiveForeachParam(itemName, collName);
                        }
                    }
                } //找到List参数
                else if (StringUtils.endsWithIgnoreCase(item.getName(), "foreach")) {
                    String collName = item.attributeValue("collection");
                    String itemName = item.attributeValue("item");
                    Validate.notEmpty(collName, "foreach 元素设置错误 table=" + cfOperation.getName());
                    Validate.notEmpty(itemName, "foreach 元素设置错误 table=" + cfOperation.getName());
                    cfOperation.addPrimitiveForeachParam(itemName, collName);
                }
            }
        }

        Matcher m = PARAM_PATTERN.matcher(e.asXML());
        List<String> params = new ArrayList<String>();
        while (m.find()) {
            params.add(m.group(1));
        }
        for (String p : params) {
            String attr = null;
            String type = null;
            for (String s : StringUtils.split(p, ",")) {
                if (s.contains("=")) {
                    if (StringUtils.startsWithIgnoreCase(s, "javaType")
                            || StringUtils.startsWithIgnoreCase(s, "jdbcType")) {
                        type = StringUtils.split(s, "=")[1].trim();
                    }
                } else {
                    attr = StringUtils.trim(s);
                }
            }
            cfOperation.addPrimitiveParam(attr, type);
        }

    }

    private void fillColumns(CfTable cfTable, Element table) {
        List<Element> elements = table.elements("column");
        for (Element e : elements) {
            CfColumn cfColumn = new CfColumn();
            cfColumn.setName(attr(e, "name"));
            cfColumn.setSqlType(attr(e, "sqlType"));
            cfColumn.setJavaName(attr(e, "javaName"));
            cfColumn.setJavaType(attr(e, "javaType"));
            cfColumn.setRemark(attr(e, "remark"));
            cfTable.addColumn(cfColumn);
        }
    }
    private String attr(Element e, String attr) {
        if (e == null || attr == null) {
            return null;
        }
        Attribute attribute = e.attribute(attr);
        if (attribute == null) {
            return null;
        } else {
            return attribute.getText();
        }
    }
}
